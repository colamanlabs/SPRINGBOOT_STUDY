  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.2.2)[0;39m

Starting SpringbootStudy0003Application using Java 17 with PID 2756 (C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0003\target\classes started by colaman in C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0003)
No active profile set, falling back to 1 default profile: "default"
Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
LiveReload server is running on port 35729
Started SpringbootStudy0003Application in 0.934 seconds (process running for 1.683)
[SpringbootStudy0002Application/init] BEGIN
[MySimpleServer/acceptSocket] serverSocket.accept() ready
[MySimpleServer/acceptSocket] serverSocket.accept() OK
[MySimpleServer/initServer] socket:[Socket[addr=/127.0.0.1,port=4976,localport=9999]]
[MySimpleServerHandler/MySimpleServerHandler] socket:[Socket[addr=/127.0.0.1,port=4976,localport=9999]]
[MySimpleServerHandler/MySimpleServerHandler] isRun:[true]
[MySimpleServer/initServer] thrHandler.start() OK
[MySimpleServer/acceptSocket] serverSocket.accept() ready
[MySimpleServerHandler/run] BEGIN
[MySimpleServerHandler/run] isRun:[true]
[MySimpleServerHandler/run] strResponse:[length:[0005]	recvData:[hELLO]]
[MySimpleServerHandler/run] strResponse:[length:[0002]	recvData:[HI]]
[MySimpleServerHandler/run] strResponse:[length:[0030]	recvData:[HELLO SPRIONGSPRINGBOOT]]
[MySimpleServerHandler/run] strResponse:[length:[0008]	recvData:[SHUTDOWN]]
[MySimpleServerHandler/closeOutputStream] BEGIN
[MySimpleServerHandler/closeOutputStream] os:[java.io.BufferedOutputStream@4d517c82]
[MySimpleServerHandler/closeOutputStream] END
[MySimpleServerHandler/closeOutputStream] BEGIN
[MySimpleServerHandler/closeOutputStream] os:[java.net.Socket$SocketOutputStream@43968b58]
[MySimpleServerHandler/closeOutputStream] END
[MySimpleServerHandler/closeReader] BEGIN
[MySimpleServerHandler/closeReader] r:[java.io.BufferedReader@47a917f2]
[MySimpleServerHandler/closeReader] END
[MySimpleServerHandler/closeReader] BEGIN
[MySimpleServerHandler/closeReader] r:[java.io.InputStreamReader@2ab8163]
[MySimpleServerHandler/closeReader] END
[MySimpleServerHandler/closeInputStream] BEGIN
[MySimpleServerHandler/closeInputStream] is:[java.net.Socket$SocketInputStream@44d848d8]
[MySimpleServerHandler/closeInputStream] END
[MySimpleServerHandler/closeSocket] BEGIN
[MySimpleServerHandler/closeSocket] socket.close() OK
[MySimpleServerHandler/closeSocket] socket.isClosed():[true]
[MySimpleServerHandler/closeSocket] END
[MySimpleServerHandler/run] END


length:[0005]   recvData:[hELLO]
HI
length:[0002]   recvData:[HI]
HELLO SPRINGBOOT
length:[0030]   recvData:[HELLO SPRINGBOOT]
SHUTDOWN
length:[0008]   recvData:[SHUTDOWN]


호스트에 대한 연결을 잃었습니다.

C:\Users\colaman>


입력창은 백스페이스가 적용되었지만,
백스페이스 입력 자체도 데이터이므로, recvData 로 찍혔다.