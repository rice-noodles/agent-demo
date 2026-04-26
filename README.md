# Agent Demo

基于 LangChain4j + Spring Boot 构建的 AI Agent 演示项目，展示了如何使用 LangChain4j 实现具备聊天记忆功能的 AI 对话服务。

## 功能特性

- **基础对话** - 简单的 AI 对话接口
- **聊天记忆** - 支持多轮对话记忆
- **用户隔离** - 不同用户拥有独立的对话上下文
- **持久化存储** - 基于 Redis 实现聊天记忆持久化
- **模板提示词** - 支持系统提示词模板与变量注入

## 技术栈

| 技术 | 版本 |
|------|------|
| Java | 21 |
| Spring Boot | 3.4.1 |
| LangChain4j | 1.13.0 |
| MyBatis Plus | 3.5.11 |
| MySQL | - |
| Redis | - |
| Knife4j | 4.3.0 |

## 项目结构

```
src/main/java/com/noodles/agentdemo/
├── AgentDemoApplication.java     # 应用启动类
├── assistant/
│   ├── Assistant.java            # 基础对话接口
│   ├── MemoryChatAssistant.java  # 带记忆的对话接口
│   └── SeparateChatAssistant.java # 用户隔离对话接口
├── config/
│   ├── ChatConfig.java           # 聊天配置类
│   └── RedisConfig.java          # Redis 配置类
└── store/
    └── RedisChatMemoryStore.java # Redis 聊天记忆存储实现
```

## 快速开始

### 环境要求

- JDK 21+
- Maven 3.6+
- MySQL 8.0+
- Redis

### 配置

1. 修改 `src/main/resources/application.yml` 中的数据库和 Redis 配置：

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/demo
    username: root
    password: your_password
  data:
    redis:
      host: localhost
      port: 6379
```

2. 配置 AI 模型（支持 OpenAI 兼容接口）：

```yaml
langchain4j:
  open-ai:
    chat-model:
      base-url: https://api.openai.com/v1
      api-key: your_api_key
      model-name: gpt-4o-mini
```

### 运行

```bash
mvn spring-boot:run
```

服务启动后访问 API 文档：http://localhost:8080/doc.html

## 核心接口说明

### Assistant

最基础的对话接口，无记忆功能。

```java
@AiService
public interface Assistant {
    String chat(String message);
}
```

### MemoryChatAssistant

具备聊天记忆功能的对话接口，使用 `SingleSlotChatMemoryStore` 存储记忆。

```java
@AiService(chatMemory = "chatMemory")
public interface MemoryChatAssistant {
    @UserMessage("你比较调皮，你喜欢在回答的问题中添加一些表情符号。{{message}}")
    String chat(@V("message") String message);
}
```

### SeparateChatAssistant

支持用户隔离的对话接口，每个 `memoryId` 对应独立的对话上下文，记忆持久化到 Redis。

```java
@AiService(chatMemoryProvider = "chatMemoryProvider")
public interface SeparateChatAssistant {
    @SystemMessage(fromResource = "prompt/system-message-test.txt")
    String chat(@MemoryId String memoryId,
                @UserMessage String userMessage,
                @V("age") int age);
}
```

## 测试

```bash
mvn test
```

## License

MIT
