package com.example.hackathon_zup.adapters;

import com.example.hackathon_zup.core.entities.LeadAds;

public interface StorageGateway {

    void save(LeadAds leadAds);

    void delete(LeadAds leadAds);

    void update(LeadAds leadAds);

    LeadAds findById(String id);
}
