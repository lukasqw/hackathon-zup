package com.example.hackathon_zup.core;

import com.example.hackathon_zup.core.entities.WebhookRequest;

public interface WebhookConsumerUseCase {
    void consumeWebhook(WebhookRequest request);
}
