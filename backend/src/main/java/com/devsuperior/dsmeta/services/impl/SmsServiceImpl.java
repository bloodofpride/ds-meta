package com.devsuperior.dsmeta.services.impl;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.interfa.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Override
    public void sendSms(Sale sale) {
        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
        String msg = "O Vendedor "+sale.getSellerName()+ " foi destaque em " + date
                + " com um total de R$" + String.format("%.2f", sale.getAmount());
        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg).create();

        System.out.println(message.getSid());
    }
}
