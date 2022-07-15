package com.devsuperior.dsmeta.services.interfa;

import com.devsuperior.dsmeta.entities.Sale;

public interface SmsService {
    void sendSms(Sale sale);
}
