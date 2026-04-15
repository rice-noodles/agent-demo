package com.noodles.agentdemo.assistant;

import dev.langchain4j.service.spring.AiService;

/**
 * 1.聊天记忆存储在dev.langchain4j.memory.chat.SingleSlotChatMemoryStore的messages中。
 * 2.可以通过实现dev.langchain4j.store.memory.chat.ChatMemoryStore接口实现自定义的聊天记忆存储，可以通过这个接口实现持久化存储。
 *
 * @author Noodles
 * @date 2026/4/13 22:50
 */
@AiService(
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {

    /**
     * @param message 用户输入的信息
     * @return 大模型的输出结果
     */
    String chat(String message);

}
