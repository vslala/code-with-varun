package com.codewithvarun.mailer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MailerTest {

    @Test
    void itShouldSendMailToTheRecipient() {
        var mailer = new Mailer();
        var mailPacket = MailPacket.newInstance()
                .from("abc@gmail.com")
                .to("xyz@gmail.com")
                .subject("This is a test mail")
                .body("Oh mama. Hello World!");

        boolean flag = mailer.send(mailPacket);
        assertTrue(flag);
    }
}