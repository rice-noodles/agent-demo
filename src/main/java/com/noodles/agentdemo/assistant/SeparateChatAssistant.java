package com.noodles.agentdemo.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

/**
 * @author Noodles
 * @date 2026/4/13 23:17
 */
@AiService(
        chatMemoryProvider = "chatMemoryProvider"
)
public interface SeparateChatAssistant {

    /**
     * 用户隔离的聊天
     *
     * @param memoryId    聊天记忆 ID
     * @param userMessage 用户输入信息
     * @return 模型响应信息
     */
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);

}
