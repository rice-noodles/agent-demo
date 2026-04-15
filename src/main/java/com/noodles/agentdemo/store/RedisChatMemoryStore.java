package com.noodles.agentdemo.store;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Noodles
 * @date 2026/4/15 22:48
 */
@Component
public class RedisChatMemoryStore implements ChatMemoryStore {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<ChatMessage> getMessages(Object o) {
        String message = (String) redisTemplate.opsForValue().get(o);
        if (message != null) {
            return ChatMessageDeserializer.messagesFromJson(message);
        }
        return List.of();
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        String message = ChatMessageSerializer.messagesToJson(list);
        redisTemplate.opsForValue().set(memoryId, message);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        redisTemplate.delete(memoryId);
    }
}
