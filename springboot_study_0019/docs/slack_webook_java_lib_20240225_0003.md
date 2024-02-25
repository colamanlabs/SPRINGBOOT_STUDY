###
### slack_webook_java_lib_20240225_0003.md
###
### Slack Incoming Weebhook 발송
### - Slack Java Library 활용
###
### 작성일 : 2024.02.25
###
###

```
package com.colamanlabs.springbootstudy.s0019;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@EnableBatchProcessing
@SpringBootApplication
@Slf4j
public class SpringbootStudy0019Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0019Application.class, args);
    }
    
    @Autowired
    private final SlackWebhookManager slackMgr = null;
    
    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception
    {
        log.info(String.format("[SpringbootStudy0019Application/init] BEGIN"));
        // slackMgr.apiTest1();
        
        String slackMsg = String.format("슬렉 웹훅 메세지 테스트 date:[%s]", new java.util.Date().toString());

        // slackMgr.apiTest2(slackMsg);
        slackMgr.apiTest3(slackMsg, true);
        log.info(String.format("[SpringbootStudy0019Application/init] END"));
    }
}

```

```
package com.colamanlabs.springbootstudy.s0019;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.api.ApiTestResponse;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SlackWebhookManager
{
    /*
     * https://slack.dev/java-slack-sdk/guides/web-api-client-setup
     */
    public void apiTest1() throws Exception
    {
        log.info(String.format("[SlackManager/apiTest1] BEGIN"));
        Slack slack = Slack.getInstance();
        ApiTestResponse response = slack.methods().apiTest(r -> r.foo("bar"));
        System.out.println(response);
        log.info(String.format("[SlackManager/apiTest1] END"));
    }
    
    @Value("${slack.token}")
    private String slackToken = null;
    
    @Value("${slack.channel}")
    private String slackChannel = null;
    
    public void apiTest2(String textToSend) throws Exception
    {
        
        log.info(String.format("[SlackManager/apiTest2] slackToken:[%s]", slackToken));
        log.info(String.format("[SlackManager/apiTest2] slackChannel:[%s]", slackChannel));
        log.info(String.format("[SlackManager/apiTest2] textToSend:[%s]", textToSend));
        
        Slack slack = Slack.getInstance();
        
        // Load an env variable
        // If the token is a bot token, it starts with `xoxb-` while if it's a user token, it starts with `xoxp-`
        // Initialize an API Methods client with the given token
        String token = slackToken;
        
        MethodsClient methods = slack.methods(token);
        
        // Build a request object
        ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel(slackChannel) // Use a channel ID `C1234567` is preferable
                .text(textToSend).build();
        
        // Get a response as a Java object
        ChatPostMessageResponse response = methods.chatPostMessage(request);
        log.info(String.format("[SlackManager/apiTest4] response:[%s]", response));
    }
    
    public void apiTest3(String textToSend, boolean isWrapMsg) throws Exception
    {
        
        log.info(String.format("[SlackManager/apiTest2] slackToken:[%s]", slackToken));
        log.info(String.format("[SlackManager/apiTest2] slackChannel:[%s]", slackChannel));
        log.info(String.format("[SlackManager/apiTest2] textToSend:[%s]", textToSend));
        log.info(String.format("[SlackManager/apiTest2] isWrapMsg:[%b]", isWrapMsg));
        
        if (isWrapMsg == true)
        {
            textToSend = "```" + textToSend + "```";
        }
        
        Slack slack = Slack.getInstance();
        
        // Load an env variable
        // If the token is a bot token, it starts with `xoxb-` while if it's a user token, it starts with `xoxp-`
        // Initialize an API Methods client with the given token
        String token = slackToken;
        
        MethodsClient methods = slack.methods(token);
        
        // Build a request object
        ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel(slackChannel) // Use a channel ID `C1234567` is preferable
                .text(textToSend).build();
        
        // Get a response as a Java object
        ChatPostMessageResponse response = methods.chatPostMessage(request);
        log.info(String.format("[SlackManager/apiTest4] response:[%s]", response));
    }
}

```