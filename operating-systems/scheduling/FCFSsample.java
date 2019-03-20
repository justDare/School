import java.util.*;

public class FCFSsample {
    public static void main(String args[]) 
    {
		PriorityQueue readyQ = new PriorityQueue();
		ProcessControlBlock pcb;
		SampleReader sr;
		String sampleFile;
		int process, arrival, priority, burst;

		System.out.print("Sample File?  ");
		sampleFile = KeyboardIn.readLineWord();
		sr = new SampleReader(sampleFile);

		while(true) {
			
			process = -1;
			arrival = -1;
			priority = -1;
			burst = -1;
			
			process = sr.readProcess();
			if (process < 0)
				break;
			arrival = sr.readArrival();
			if (arrival < 0)
				break;
			priority = sr.readPriority();
			if (priority < 0)
				break;
			burst = sr.readBurst();
			if (burst < 0)
				break;

			pcb = new ProcessControlBlock(process, arrival, priority, burst);
			readyQ.putQueue(pcb, arrival);
				
        }
        
        int [] completions = new int[readyQ.noItems];
        int [] turnAround = new int[readyQ.noItems];
        int [] waitTime = new int[readyQ.noItems];

        // counters for minutes 
        int oneMinute = 0;
        int minuteCounter = 0;

        // counters for intervals -> to compute averages
        int totalTurnAround = 0;
        int totalWait = 0;
        int processCount = 0;

        // flags
        boolean startOneMinute = false;

        int processNum;
        int processArrival;
        int processPriority;
        int processBurst;

		while(!readyQ.isEmpty()) {

            // get entry off the queue
            pcb = (ProcessControlBlock)readyQ.getQueue();
            processNum = pcb.getProcessNo();
            processArrival = pcb.getArrivalTime();
            processBurst = pcb.getCpuBurstTime();

            //  first process has no wait time
            if (processNum == 0) 
                completions[0] = processArrival + processBurst;

            else 
                // if last process already completed
                if(processArrival > completions[processNum-1])
                    completions[processNum] = processArrival + processBurst;

                // else completed once last process is complete
                else
                    completions[processNum] = completions[processNum-1] + processBurst;

            // get values for current process
            turnAround[processNum] = completions[processNum] - processArrival;
            waitTime[processNum] = turnAround[processNum] - processBurst;

            // update totals
            totalTurnAround += turnAround[processNum];
            totalWait += waitTime[processNum];
            processCount ++;
     
            // print stats after the 10 minute(600000ms)mark
            if(completions[processNum] >= 600000 && !startOneMinute)  {
                
                System.out.println("10 minute mark");
                System.out.println("------------------------------------------------------------");
                System.out.println("Average turn around time for past 10 minutes: " + totalTurnAround/processCount);
                System.out.println("Average wait time for past 10 minutes: " + totalWait/processCount);
                System.out.println();

                // start printing each minute
                startOneMinute = true;

                minuteCounter = 10;

                // reset totals
                totalTurnAround = 0;
                totalWait = 0;
                processCount = 0;

                // remainder is added to minute counter
                oneMinute = completions[processNum] - 600000;
            
            // once one minute intervals begin
            } else if (startOneMinute) {
                
                // add to minute counter
                oneMinute += (completions[processNum] - completions[processNum-1]);

                // update totals
                totalTurnAround += turnAround[processNum];
                totalWait += waitTime[processNum];
                processCount += 1;

                // once minute is up, print stats and reset counter
                if(oneMinute >= 60000) {

                    minuteCounter ++;

                    System.out.println(minuteCounter + " minute mark");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Average turn around time for past 10 minutes: " +  totalTurnAround/processCount);
                    System.out.println("Average wait time for past 10 minutes: " +  totalWait/processCount);
                    System.out.println();

                    oneMinute = oneMinute - 60000;

                    // reset totals
                    totalTurnAround = 0;
                    totalWait = 0;
                    processCount = 0;
                }
            }
        }
    }
}
