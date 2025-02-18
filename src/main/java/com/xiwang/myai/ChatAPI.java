package com.xiwang.myai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatAPI {

    private final ChatClient chatClient;

    @RequestMapping("chat")
    public String chat(@RequestParam(value = "message") String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }

}
