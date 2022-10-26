package com.bridgelabz.addressbookspringapp.configuration;

import com.bridgelabz.addressbookspringapp.mailSender.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public MailSender emailSenderService()
    {
        return new MailSender();
    }
}
