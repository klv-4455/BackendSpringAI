package com.Project.SpringAI;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin("*")
public class OllamaController {

   // private AnthropicChatModel chatModel;
    private ChatClient chatClient;

    public OllamaController(OllamaChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }
//    public AnthropicController(AnthropicChatModel chatModel) {
//        this.chatModel = chatModel;
//    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){

       // String response = chatModel.call(message);
        String response = chatClient.prompt(message).call().content();
        return ResponseEntity.ok(response);
    }
}
