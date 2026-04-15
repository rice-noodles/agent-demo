package com.noodles.agentdemo;

import com.noodles.agentdemo.assistant.MemoryChatAssistant;
import com.noodles.agentdemo.assistant.SeparateChatAssistant;
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
    public void chatMemoryAssistantTest() {
        String response1 = memoryChatAssistant.chat("你好，我是小龙虾。");
        System.out.println("Response 1: " + response1);

        String response2 = memoryChatAssistant.chat("我是谁？");
        System.out.println("Response 2: " + response2);
    }


    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void separateChatMemoryAssistantTest() {
        String response1 = separateChatAssistant.chat("TEST_MEMORY_ID", "你好，我是小龙虾");
        System.out.println("Response 1: " + response1);
        String response2 = separateChatAssistant.chat("TEST_MEMORY_ID", "我是谁？");
        System.out.println("Response 2: " + response2);

        //String response3 = separateChatAssistant.chat(2L, "我是谁？");
        // System.out.println("Response 3: " + response3);
    }

}
