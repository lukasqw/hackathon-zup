package com.example.hackathon_zup.application;

import com.example.hackathon_zup.adapters.MessageSenderGateway;
import com.example.hackathon_zup.adapters.StorageGateway;
import com.example.hackathon_zup.core.WebhookConsumerUseCase;
import com.example.hackathon_zup.core.entities.LeadAds;
import com.example.hackathon_zup.core.entities.LeadAdsMapper;
import com.example.hackathon_zup.core.entities.WebhookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WebhookConsumerService implements WebhookConsumerUseCase {

    private static final Logger logger = LoggerFactory.getLogger(WebhookConsumerService.class);

    private final StorageGateway storageGateway;
    private final MessageSenderGateway messageSenderGateway;

    @Autowired
    public WebhookConsumerService(StorageGateway storageGateway, MessageSenderGateway messageSenderGateway) {
        this.storageGateway = storageGateway;
        this.messageSenderGateway = messageSenderGateway;
    }

    @Override
    public void consumeWebhook(WebhookRequest request) {
        try {
            LeadAds leadAds = LeadAdsMapper.mapFieldsToLeadAds(request);
            logger.info("LeadAds mapped successfully: {}", leadAds);

            storageGateway.save(leadAds);
            logger.info("LeadAds saved successfully");

            messageSenderGateway.sendMessage(leadAds.getCellphone());
            logger.info("Message sent successfully to: {}", leadAds.getCellphone());
        } catch (Exception e) {
            logger.error("Error processing webhook request", e);
        }
    }
}