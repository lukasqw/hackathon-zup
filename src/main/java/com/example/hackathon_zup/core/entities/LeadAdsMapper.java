package com.example.hackathon_zup.core.entities;

public class LeadAdsMapper {

    public static LeadAds mapFieldsToLeadAds(WebhookRequest fieldsData) {
        LeadAds leadAds = new LeadAds();

        for (WebhookField field : fieldsData.getFields_data()) {
            String fieldName = field.getName();
            String[] fieldValue = field.getValue();

            if (fieldValue != null && fieldValue.length > 0) {
                switch (fieldName) {
                    case "name":
                        leadAds.setName(fieldValue[0]);
                        break;
                    case "email":
                        leadAds.setEmail(fieldValue[0]);
                        break;
                    case "telefone":
                        leadAds.setCellphone(fieldValue[0]);
                        break;
                    case "cnpj":
                        leadAds.setCnpj(fieldValue[0]);
                        break;
                }
            }
        }

        return leadAds;
    }
}