package notificationsystem;

import notificationsystem.publishers.EmailSender;
import notificationsystem.publishers.NotificationSender;
import notificationsystem.publishers.SmsSender;

public enum NotificationChannel {
    EMAIL(EmailSender.getInstance()), SMS(SmsSender.getInstance());

    private final NotificationSender sender;

    NotificationChannel(NotificationSender sender) {
        this.sender = sender;
    }

    public void send(Payload payload) {
        this.sender.send(payload);
    }

    public void subscribe(Subscriber subscriber) {
        this.sender.subscribe(subscriber);
    }
}
