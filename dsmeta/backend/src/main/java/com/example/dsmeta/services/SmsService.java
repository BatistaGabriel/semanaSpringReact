package com.example.dsmeta.services;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SaleRepository saleRepository;

    /**
     * Based on the informed sale id it sends an SMS
     * notifying the necessary phone number the information
     * regarding the sale id informed.
     *
     * @param saleId <b>Long</b> the sale id
     */
    public void sendSms(Long saleId) {
        Sale sale = saleRepository.findById(saleId).get();

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, getMessageContent(sale)).create();

        System.out.println(message.getSid());
    }

    private String getCustomizedSaleDate(Sale sale) {
        return sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
    }

    private String getCustomizedSaleAmount(Sale sale) {
        return String.format("%.2f", sale.getAmount());
    }

    private String getMessageContent(Sale sale) {
        return MessageFormat.format(
                "The sale [{0}], performed by the seller [{1}] at [{2}] has the amount of $[{3}]",
                sale.getId(),
                sale.getSellerName(),
                getCustomizedSaleDate(sale),
                getCustomizedSaleAmount(sale));
    }
}