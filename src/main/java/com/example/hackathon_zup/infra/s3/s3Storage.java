package com.example.hackathon_zup.infra.s3;

import com.example.hackathon_zup.adapters.StorageGateway;
import com.example.hackathon_zup.core.entities.LeadAds;
import org.springframework.stereotype.Service;

@Service
public class s3Storage implements StorageGateway {

    @Override
    public void save(LeadAds leadAds) {
        // TODO Auto-generated method stub
        System.out.println("S3");
        System.out.println(leadAds);
    }

    @Override
    public void delete(LeadAds leadAds) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(LeadAds leadAds) {
        // TODO Auto-generated method stub
    }

    @Override
    public LeadAds findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }
}
