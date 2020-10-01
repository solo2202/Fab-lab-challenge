from socket import *
# code to move tge robot
# host ip adress and port
HOST = "ip-address"
PORT = 9005

s = socket(AF_INET, SOCK_STREAM)
print("1")
s.bind((HOST, PORT))
print("2")
s.listen(1)
conn, addr = s.accept()
print(addr)
print "Connected by: ", addr
while True:
    data = conn.recv(1024)

    data.rstrip()

    if data == "u":
        GPIO.output(5, True)
        GPIO.output(6, False)
        GPIO.output(13, True)
        GPIO.output(19, False)
    elif data == 'l':
        GPIO.output(5, True)
        GPIO.output(6, False)
        GPIO.output(13, False)
        GPIO.output(19, True)
    elif data == 'r':
        GPIO.output(5, False)
        GPIO.output(6, True)
        GPIO.output(13, False)
        GPIO.output(19, True)
    elif data == 'd':
        GPIO.output(5, False)
        GPIO.output(6, True)
        GPIO.output(13, False)
        GPIO.output(19, True)
    else :
        GPIO.output(5, False)
        GPIO.output(6, False)
        GPIO.output(13, False)
        GPIO.output(19, False)

    print "Received: ", repr(data)
    reply = ("ok")
    conn.sendall(reply)
conn.close()
