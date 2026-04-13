package com.noodles.agentdemo;

import com.noodles.agentdemo.assistant.MemoryChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Noodles
 * @date 2026/4/13 22:59
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AiServiceChatTest {

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void chatMemeryAssistantTest() {
        String response1 = memoryChatAssistant.chat("你好，我是小龙虾。");
        System.out.println("Response 1: " + response1);

        String response2 = memoryChatAssistant.chat("我是谁？");
        System.out.println("Response 2: " + response2);
    }

}
