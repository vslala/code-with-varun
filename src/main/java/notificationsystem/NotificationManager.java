package notificationsystem;

import java.util.List;

import static notificationsystem.NotificationChannel.*;

public class NotificationManager {

    private final List<NotificationChannel> notificationChannels = List.of(
            EMAIL,
            SMS
    );
    public void subscribe(NotificationChannel notificationChannel, Subscriber subscriber) {
        NotificationChannel channel = notificationChannels.stream()
                .filter(notifier -> notifier == notificationChannel)
                .findFirst()
                .orElseThrow();

        channel.subscribe(subscriber);
        subscriber.notify(Payload.of("New Subscriber!", String.format("Thank you for subscribing to our %s channel.", notificationChannel.name())));
    }

    public void send(NotificationChannel notificationChannel, Payload payload) {
        NotificationChannel channel = notificationChannels.stream()
                .filter(notifier -> notifier == notificationChannel)
                .findFirst()
                .orElseThrow();

        channel.send(payload);
    }
}
