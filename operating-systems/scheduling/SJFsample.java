public class SJFsample {
	public static void main(String args[]) {

		PriorityQueue readyQ = new PriorityQueue();
		ProcessControlBlock pcb;
		ProcessControlBlock pcbPrev = new ProcessControlBlock(0,0,0,0);
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
        int turnAround = 0;
		int waitTime = 0;

		System.out.println(readyQ.noItems);

		// counters for minutes 
		int oneMinute = 0;
		int minuteCounter = 0;

		// counters for intervals -> to compute averages
		int count, intervalCount;

		// flags
		boolean startOneMinute = false;

		int processNum = 0;
        int processArrival = 0;
        int processPriority = 0;
        int processBurst = 0;
	

		count = intervalCount = 0;
		while(!readyQ.isEmpty()) {

			// get entry off the queue
            pcb = (ProcessControlBlock)readyQ.getQueue();
            processNum = pcb.getProcessNo();
            processArrival = pcb.getArrivalTime();
			processBurst = pcb.getCpuBurstTime();

            //  first process has no wait time
            if (processNum == 0) {

				// get values for current process
				completions[count] = processArrival + processBurst;
				turnAround += completions[count] - processArrival;
				waitTime += (completions[count] - processArrival) - processBurst;

				count++;
				intervalCount++;

				System.out.println("completed " + completions[count-1]);
				System.out.println("turn: "+ turnAround);
				System.out.println("wait: " + waitTime);

			// second process can never be swapped with first 
			} else if (processNum == 1) {

				// store as the previous process
				pcbPrev = pcb;

			// all procceses after 0 and 1
			} else {

				// can only swap if the previous process has not started running yet, and if the new burst time is lower
				if (processArrival < completions[count-1] && processBurst < pcbPrev.cpuBurstTime) {
					
					completions[count] = completions[count-1] + processBurst;
					turnAround += (completions[count] - processArrival);
					waitTime += ((completions[count] - processArrival) - processBurst);

					// if last item is popped, execute the swapped process
					if(processNum == completions.length-1) {

						completions[count+1] = completions[count] + pcbPrev.cpuBurstTime;
						turnAround += (completions[count+1] - pcbPrev.arrivalTime);
						waitTime += ((completions[count+1] - processArrival) - pcbPrev.cpuBurstTime);

					}

					System.out.println("if");

				// else execute the previously popped
				} else {

					completions[count] = completions[count-1] + pcbPrev.cpuBurstTime;
					turnAround += (completions[count] - pcbPrev.arrivalTime);
					waitTime += ((completions[count] - processArrival) - pcbPrev.cpuBurstTime);

					pcbPrev = pcb;

					// if last item is popped, execute the swapped process
					if(processNum == completions.length-1) {

						completions[count+1] = completions[count] + processBurst;
						turnAround += (completions[count+1] - processArrival);
						waitTime += ((completions[count+1] - processArrival) - processBurst);

					}

					System.out.println("else:");

				}

				count++;
				intervalCount++;

				System.out.println("completed " + completions[count-1]);
				System.out.println("turn: "+ turnAround);
				System.out.println("wait: " + waitTime);

			}
			
			 // print stats after the 10 minute(600000ms)mark
			 if(completions[count] >= 600000 && !startOneMinute)  {
                
                System.out.println("10 minute mark");
                System.out.println("------------------------------------------------------------");
                System.out.println("Average turn around time for past 10 minutes: " + turnAround/intervalCount);
                System.out.println("Average wait time for past 10 minutes: " + waitTime/intervalCount);
                System.out.println();

                // start printing each minute
                startOneMinute = true;

                minuteCounter = 10;

                // reset totals
                turnAround = 0;
                waitTime= 0;
                intervalCount = 0;

                // remainder is added to minute counter
                oneMinute = completions[count] - 600000;
            
            // once one minute intervals begin
            } else if (startOneMinute) {
                
                // add to minute counter
				oneMinute += (completions[count] - completions[count-1]);
				
                // once minute is up, print stats and reset counter
                if(oneMinute >= 60000) {

                    minuteCounter++;

                    System.out.println(minuteCounter + " minute mark");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Average turn around time for past 10 minutes: " +  turnAround/intervalCount);
                    System.out.println("Average wait time for past 10 minutes: " +  waitTime/intervalCount);
                    System.out.println();

                    oneMinute = oneMinute - 60000;
                   

                    // reset totals
                    turnAround = 0;
                    waitTime = 0;
                    intervalCount = 0;
                }
			}

		}

	}
}
