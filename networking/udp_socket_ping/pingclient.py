from socket import *
import time
import datetime

# Create a UDP socket
clientSocket = socket(AF_INET, SOCK_DGRAM)

# set host and port number
host = "10.0.0.1"
port = 12000

# set counts for pings
pingCount = 0
totalPings = 10

# set timeout to 1 second
clientSocket.settimeout(1)

while pingCount <= totalPings:
    pingCount += 1
    sentTime = time.time()
    data = "ping " + str(pingCount) + " " + str(sentTime)
    clientSocket.sendto(data, (host, port))

    try:
        recieved, clientAddress = clientSocket.recvfrom(1024)
        RTT = ((time.time()) - sentTime)
        print("Response from server: ", data)
        print("RTT: ", RTT)
    except timeout:
        print "Request timeout."

print("Done.")
