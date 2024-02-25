###
### slack_webook_java_lib_20240225_0001.md
###
### Slack Incoming Weebhook 발송
### - Slack Java Library 활용
###
### 작성일 : 2024.02.25
###
###

# 1. Slack Incoming Webhook 등록

```
https://api.slack.com/apps 에 Slack Incoming Webhook 을 등록한다.

[참고 자료]
https://www.youtube.com/watch?v=5kOvRGfp-tU&list=PL9mWH7l2hU3ORz5myHZgjCulo-puXkXzW&index=2
``` 
## 1.1 앱 등록 

### 1.1.1 api.slack.com 접속 
https://api.slack.com/apps?new_classic_app=1

``` 
웹브라우져로 https://api.slack.com/apps?new_classic_app=1 에 접속한다.

Slack 로그인이 필요할 수 있다.
로그인을 요구하면 로그인한다. 

페이지 내에 레이어로 "Create a Slack App(Classic)" 페이지가 열린다. 

```

### 1.1.2 "Create a Slack App(Classic)"

```
#### App Name 
App Name 에는 앱의 이름을 넣는다.
Slack 에 등록할 앱 이름이다.

ex) 날씨앱
ex) 알림앱 
ex) ...

AppName : 알림앱

### Development Slack Workspace 
앱을 등록할 워크스페이스 이다.

Development Slack Workspace : **********

등록을 마치면 아래의 "Create App" 버튼을 선택한다.

"Basic Information" 페이지로 전환된다.
```



## 1.2 봇 등록 

Slack 봇을 등록한다.\
봇은 알림을 보내는 역할을 한다. 



### 1.2.1 봇 등록

```
1) "Basic Information" 페이지 에서 좌측 패널의 "Features" 아래 "App Home" 을 선택한다.

2) "App Home" 페이지에서 중앙 패널에 있는 "Add Legacy Bot User" 를 선택한다.
- "Add App Display Name" 창이 열린다.

3) "Add App Display Name" 창에서 봇 이름을 입력한다.
- Display Name(Bot Name) : 알림봇
- Default username : inform_bot
	- 반드시 영어로 입력한다.
	
4) 아래 "Add" 버튼을 선택한다.
- App Home 페이지로 전환된다.	
```
	
### 1.2.2 봇 권한부여
```
현재는 생성한 봇이 권한이 없어서, 채널의 글을 읽거나 보낼 수 없다.
읽기, 쓰기 권한을 부여한다. 


1) "App Home" 페이지 좌측 메뉴 Feature 아래 "OAuth & Permissions" 를 선택한다.

2) "OAuth & Permissions" 페이지 하단으로 내리면, 중앙에 "Scope" 패널이 나온다.

3) "OAuth & Permissions/Scope" 에 있는 "Add an OAuth Scope" 버튼을 선택해서 권한을 선택하고 부여한다.
- chat 입력 -> chat:write:bot
- history 입력 -> channels:history

4) "OAuth & Permissions" 페이지 상단으로 돌아온다. "OAuth Tokens for Your Workspace" 패널에 있는 "Install to Workspace" 버튼을 선택한다.

5) 페이지가 전환되고, "알림앱에서 ********** Slack 워크스페이스에 액세스하기 위해 권한을 요청합니다." 내용이 있다.
- 아래 "허용" 버튼을 선택한다. 
- 버튼을 선택하면, "OAuth & Permissions" 로 돌아온다.

6) "OAuth & Permissions" 의 최상단에 "OAuth Tokens for Your Workspace" 가 있고, 봇이 사용할 토큰 정보가 나온다.
- 권한 부여가 완료되었다.
```


## 2. Slack 앱에 봇을 등록 

```
1) Slack 을 실행한다.

2) 워크스페이스를 선택한다.

3) 채널에 만든 봇을 추가한다.
- 채널을 선택하고, 대화창에 초대한다. (@봇이름 입력, "@알림봇")
- 대화창에 봇이름을 입력하면
	- "대신 이 사용자를 추가하시겠습니까?" 레이어가 뜬다.
		- "채널에 추가" 버튼을 선택한다.
		- 채널에 추가 된 것을 확인한다. 		
```



## 3. 웹 훅 등록 
Slack 페이지로 돌아간다.\
좌측 패널에 "Feature" 아래 "Incoming Webhooks" 를 선택한다.

## 3.1 "Incoming Webhooks" 활성화

### 3.1.1 "Activate Incoming Webhooks" 활성화 
```
중앙 "Incoming Webhooks" 패널 아래 "Activate Incoming Webhooks" 메뉴가 있다.
OFF 상태이다. 라디오 버튼을 선택하고, "ON" 으로 전환한다.
```

### 3.1.2 "Webhook URLs for Your Workspace" URL 등록 

```
1) 아래 "Add New Webhook to Workspace" 버튼을 선택한다.

2) "알림앱에서 ********** Slack 워크스페이스에 액세스하기 위해 권한을 요청합니다." 페이지로 전환된다.

3) "알림앱은(는) 어디에 게시해야 합니까? 알림앱에는 앱으로 게시할 채널이 필요합니다." 
- 채널을 지정한다.
- "# labs_inform"

4) "허용" 버튼을 선택한다. 
- "Incoming Webhooks" 웹훅 페이지로 돌아온다.
-  아래 "Webhook URLs for Your Workspace" 에 웹 훅 URL 이 생성되어 있다.
```

### 3.1.3 웹 훅 URL 테스트

``` 
"Sample curl request to post to a channel:" 아래 copy 버튼을 선택한다.

cmd 를 실행시켜 cmd 창을 열고, curl 이 실행되는지 curl 을 입력한다.

C:\Users\colaman>curl
curl: try 'curl --help' for more information

C:\Users\colaman>


없으면 구글에서 curl 검색후 설치한다.
```

```
기본 샘플을 입력하면, windows cmd 창에서는 "invalid_payload" 에러가 난다.

C:\Users\colaman>curl -X POST -H 'Content-type: application/json' --data '{"text":"Hello, World!"}' https://hooks.slack.com/services/**********/**********/**********
curl: (6) Could not resolve host: application
invalid_payload
C:\Users\colaman>


[참고]
https://pacloud.tistory.com/2

[AS-IS]
curl -X POST -H 'Content-type: application/json' --data '{"text":"Hello, World!"}' https://hooks.slack.com/services/**********/**********/**********


샘플 명령어를 변경한다.
1) " 는 "" 로
2) ' 는 " 로


[TO-BE]
curl -X POST -H "Content-type: application/json" --data "{""text"":""Hello, World!""}" https://hooks.slack.com/services/**********/**********/**********


Slack 앱 채널에 보낸 샘플 메세지가 도착하는지 확인한다.
```
