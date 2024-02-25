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
