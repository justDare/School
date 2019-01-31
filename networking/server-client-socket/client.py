#import socket module
from socket import *
import sys

# create socket
clientSocket = socket(AF_INET, SOCK_STREAM)

# command line specifies host, port, and file requested from server
host = sys.argv[1]
port = int(sys.argv[2])
file_name = sys.argv[3]

# connect to server
clientSocket.connect((host,port))

print "connected to ", host

# GET request
HTTPmessage = "GET/HTTP/1.1 "+ file_name +"\r\n\r\n"
bytes = str.encode(HTTPmessage)
clientSocket.sendall(bytes)

print("Recieved response from server:\n")
data = clientSocket.recv(1024)
print(data)

clientSocket.close()






