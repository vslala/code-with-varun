package com.codewithvarun.mailer;

public class MailPacket {
    private String from;
    private String to;
    private String subject;
    private String body;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public static MailPacket newInstance() {
        return new MailPacket();
    }

    public MailPacket from(String fromEmail) {
        this.from = fromEmail;
        return this;
    }

    public MailPacket to(String toEmail) {
        this.to = toEmail;
        return this;
    }

    public MailPacket subject(String subject) {
        this.subject = subject;
        return this;
    }

    public MailPacket body(String mailBody) {
        this.body = mailBody;
        return this;
    }
}
