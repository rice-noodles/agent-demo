package com.noodles.agentdemo.assistant;

import dev.langchain4j.service.spring.AiService;

/**
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
