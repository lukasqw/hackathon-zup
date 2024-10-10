package com.example.hackathon_zup.controllers;

import com.example.hackathon_zup.application.WebhookConsumerService;
import com.example.hackathon_zup.core.entities.WebhookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final WebhookConsumerService webhooksConsumerService;

    @Autowired
    public WebhookController(WebhookConsumerService webhooksConsumerService) {
        this.webhooksConsumerService = webhooksConsumerService;
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> receberWebhook(@RequestBody WebhookRequest request) {
        try {
            webhooksConsumerService.consumeWebhook(request);
            logger.info("Webhook processed successfully");
            return ResponseEntity.ok("Lead recebido e processado com sucesso.");
        } catch (Exception e) {
            logger.error("Error processing webhook", e);
            return ResponseEntity.status(500).body("Erro ao processar o Lead.");
        }
    }
}