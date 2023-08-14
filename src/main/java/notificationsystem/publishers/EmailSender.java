package notificationsystem.publishers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import notificationsystem.Payload;
import notificationsystem.Subscriber;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailSender implements NotificationSender {
    private static EmailSender INSTANCE;
    private final List<Subscriber> subscriptions = new ArrayList<>();;

    public static NotificationSender getInstance() {
        if (EmailSender.INSTANCE == null) {
            EmailSender.INSTANCE = new EmailSender();
        }

        return EmailSender.INSTANCE;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriptions.add(subscriber);
    }

    @Override
    public void send(Payload payload) {
        subscriptions.forEach(subscriber -> subscriber.notify(payload));
    }
}
