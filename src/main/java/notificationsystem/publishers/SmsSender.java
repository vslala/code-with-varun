package notificationsystem.publishers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import notificationsystem.Payload;
import notificationsystem.Subscriber;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SmsSender implements NotificationSender {
    private static SmsSender INSTANCE;
    private final List<Subscriber> subscriptions = new ArrayList<>();

    public static NotificationSender getInstance() {
        if (SmsSender.INSTANCE == null) {
            SmsSender.INSTANCE = new SmsSender();
        }

        return SmsSender.INSTANCE;
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
