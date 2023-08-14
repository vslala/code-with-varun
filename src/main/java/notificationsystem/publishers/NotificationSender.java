package notificationsystem.publishers;

import notificationsystem.Payload;
import notificationsystem.Subscriber;

public interface NotificationSender {
    void subscribe(Subscriber subscriber);

    void send(Payload payload);
}
