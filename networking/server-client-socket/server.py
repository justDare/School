#import socket module
from socket import *
import sys 

#Prepare a server socket
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(("10.0.0.1", 9000))
serverSocket.listen(1)

while True:
    #Establish the connection
    print('Ready to serve...')
    connectionSocket, addr =  serverSocket.accept()
    print "connection receieved from ", addr
            
    try:
	# get message from client to specify file 
        message = connectionSocket.recv(1024)        
        filename = message.split()[1]              
        f = open(filename) 

        outputdata = f.read()              
        #Send one HTTP header line into socket
        connectionSocket.send("HTTP/1.1 200 OK\r\n\r\n")

        #Send the content of the requested file to the client
        for i in range(0, len(outputdata)):           
            connectionSocket.send(outputdata[i].encode())
        connectionSocket.send("\r\n".encode())
        
        connectionSocket.close()
    except IOError:
        #Send response message for file not found
        connectionSocket.send("HTTP/1.1 404 Not Found\r\n\r\n")
        connectionSocket.close()

serverSocket.close()
sys.exit() 
