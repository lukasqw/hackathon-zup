package com.example.hackathon_zup.infra.messageSender;

import com.example.hackathon_zup.adapters.MessageSenderGateway;
import org.springframework.stereotype.Service;

@Service
public class whatsappSender implements MessageSenderGateway {
    @Override
    public void sendMessage(String cellphone) {
        // TODO Auto-generated method stub
        System.out.println("Whatsapp");
        System.out.println(cellphone);
    }
}
