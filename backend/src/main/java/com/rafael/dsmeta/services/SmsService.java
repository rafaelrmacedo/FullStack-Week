package com.rafael.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rafael.dsmeta.entities.Sale;
import com.rafael.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${tw ilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

    @Autowired
    private SaleRepository saleRepository;

	public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();

        String msg = "The seller " + sale.getSellerName() + " was featured in " + date + " with a amount of $" + String.format("%.2f", sale.getAmount());

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}