###
### slack_webook_java_lib_20240225_0002.md
###
### Slack Incoming Weebhook 발송
### - Slack Java Library 활용
###
### 작성일 : 2024.02.25
###
###


# 0. 사전 준비 사항
```
1) https://api.slack.com/apps 접속하고, "Feature > OAuth & Permissions" 선택한다.

2) OAuth & Permissions 페이지에서
- 중앙 상단 "OAuth Tokens for Your Workspace" 패널에 있는 "Bot User OAuth Token" 값을 미리 복사한다.
```



# 1. Slack SDK for Java 페이지 접속

https://slack.dev/java-slack-sdk/guides/web-api-basics

## 1.1 Slack SDK for Java 페이지 접속
```
구글에서 "slack java api" 로 검색한다.

https://slack.dev/java-slack-sdk/guides/web-api-basics

로 접속한다.
```


### 1.1.1 Slack SDK for Java 제공방식

```
Slack Java SDK 는 2가지 방식으로 제공된다.

-- 개발사 설명
Slack SDK for Java
Slack SDK for Java 는 Java와 같은 접근 방식으로 모든 Slack 플랫폼의 공개 기능을 지원하는 공식 SDK입니다. 이 SDK 는 모두 Java 로 쓰여져 있어 개발자는 이 SDK 를 Java 뿐만이 아니라 Kotlin, Groovy, Scala 라고 하는 JVM 언어에서도 이용할 수 있습니다.

이 SDK는 크게 나누어 주로 두 종류의 모듈을 제공하고 있습니다.

"Bolt️ for Java" 는 최신 Slack 앱을 간단한 API로 쉽게 개발할 수 있는 프레임워크입니다.
"Slack API 클라이언트" 는 Slack 앱을 보다 유연하게 개발하려는 경우에만 이를 통합하여 사용할 수 있습니다.

```

"Slack API Client" 를 선택한다.





### 1.1.2 API Client Installation

https://slack.dev/java-slack-sdk/guides/web-api-client-setup

```
개발사 페이지 설명을 참고한다.


API 클라이언트 설정
Slack API 클라이언트를 사용하는 첫 번째 단계는 Java 프로젝트에 slack-api-client를 설치하는 것입니다. 이 가이드에서는 Maven , Gradle을 사용할 때의 각 설정 절차와 이 프로젝트를 소스 코드에서 손쉽게 빌드할 때의 단계를 설명합니다.

전제 조건
사전에 OpenJDK 8 이상인 LTS 버전이 설치 되어 있어야 합니다. 서포트되고 있는 JDK 버젼을 이용하고 있는 한, 이 SDK 는 모든 OpenJDK 디스트리뷰션으로 동작할 것입니다.

Maven
Maven에서 라이브러리 설치를 시작합시다. slack-api-client는 단지 종속 라이브러리이므로 Maven 버전에 대해서는 특별히 지정하지 않습니다.

pom.xml
다음 XML 설정을 포함하는 것을 pom.xmlJava 프로젝트의 루트 디렉토리에 넣으십시오. 보시다시피, 매우 평범한 Maven 프로젝트입니다. 원하는 IDE에서 이 프로젝트를 로드할 때 특별한 설정이 필요하지 않습니다.
```

```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>awesome-slack-app</artifactId>
  <version>0.1-SNAPSHOT</version>
  <packaging>jar</packaging>
  <properties>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.source>1.8</maven.compiler.source>
  </properties>
  <dependencies>
    <dependency>
      <groupId>com.slack.api</groupId>
      <artifactId>slack-api-client</artifactId>
      <version>1.38.1</version>
    </dependency>
  </dependencies>
</project>
```


```
src/main/java/Example.java
실행 가능한 main 메소드를 가지는 Example 이라는 class를 새롭게 정의합시다. 이 샘플 코드가 전혀 실용적이지 않다는 것을 잘 알고 있습니다. 단, 이 프로젝트의 설정이 올바른지 확인하려면 이 코드를 복사하여 저장해 보세요.
```

```
import com.slack.api.Slack;
import com.slack.api.methods.response.api.ApiTestResponse;

public class Example {
  public static void main(String[] args) throws Exception {
    Slack slack = Slack.getInstance();
    ApiTestResponse response = slack.methods().apiTest(r -> r.foo("bar"));
    System.out.println(response);
  }
}

```


### 1.1.3 API Client Basics

#### 1.1.3.1 com.slack.api.Slack 클래스 인스턴스 초기화

```
import com.slack.api.Slack;

Slack slack = Slack.getInstance();
````



#### 1.1.3.2 메소드 호출

```
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

// Load an env variable
// If the token is a bot token, it starts with `xoxb-` while if it's a user token, it starts with `xoxp-`
String token = System.getenv("SLACK_TOKEN");

// Initialize an API Methods client with the given token
MethodsClient methods = slack.methods(token);

// Build a request object
ChatPostMessageRequest request = ChatPostMessageRequest.builder()
  .channel("#random") // Use a channel ID `C1234567` is preferable
  .text(":wave: Hi from a bot written in Java!")
  .build();

// Get a response as a Java object
ChatPostMessageResponse response = methods.chatPostMessage(request);
```



```
ChatPostMessageResponse response = slack.methods(token).chatPostMessage(ChatPostMessageRequest.builder()
  .channel("#random")
  .text(":wave: Hi from a bot written in Java!")
  .build());
```

동일 코드에 대한 람다 문법 적용
```
ChatPostMessageResponse response = slack.methods(token).chatPostMessage(req -> req
  .channel("#random")
  .text(":wave: Hi from a bot written in Java!"));
```  



#### 1.1.3.3 응답처리


```
import java.io.IOException;
import com.slack.api.methods.SlackApiException;

try {
  ChatPostMessageResponse response = slack.methods(token).chatPostMessage(req -> req
    .channel("C1234567")
    .text("Write one, post anywhere"));
  if (response.isOk()) {
    Message postedMessage = response.getMessage();
  } else {
    String errorCode = response.getError(); // e.g., "invalid_auth", "channel_not_found"
  }
} catch (SlackApiException requestFailure) {
  // Slack API responded with unsuccessful status code (= not 20x)  
} catch (IOException connectivityIssue) {
  // Throwing this exception indicates your app or Slack servers had a connectivity issue.
}
```








  

