package notificationsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static notificationsystem.NotificationChannel.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class NotificationManagerTest {

    public static final Payload EMAIL_SUBSCRIPTION_PAYLOAD = Payload.of("New Subscriber!", String.format("Thank you for subscribing to our %s channel.", EMAIL));
    public static final Payload SMS_SUBSCRIPTION_PAYLOAD = Payload.of("New Subscriber!", String.format("Thank you for subscribing to our %s channel.", SMS));
    public static final Payload EMAIL_NOTIFICATION_PAYLOAD = Payload.of("Email Notification!", "This is an email notification!");
    NotificationManager manager;

    @BeforeEach
    public void setUp() {
        manager = new NotificationManager();
    }

    @Test
    public void subscribe_to_email_notification() {
        // given
        Subscriber subscriber = Mockito.mock(Subscriber.class);
        var captor = ArgumentCaptor.forClass(Payload.class);

        // when
        manager.subscribe(EMAIL, subscriber);

        // then
        verify(subscriber, times(1)).notify(captor.capture());
        assertEquals(EMAIL_SUBSCRIPTION_PAYLOAD, captor.getValue());
    }

    @Test
    public void subscribe_to_email_and_sms_notification() {
        // given
        Subscriber subscriber = Mockito.mock(Subscriber.class);
        var captor = ArgumentCaptor.forClass(Payload.class);

        // when
        manager.subscribe(EMAIL, subscriber);
        manager.subscribe(SMS, subscriber);

        // then
        verify(subscriber, times(2)).notify(captor.capture());
        var captorValues = captor.getAllValues();
        assertEquals(EMAIL_SUBSCRIPTION_PAYLOAD, captorValues.get(0));
        assertEquals(SMS_SUBSCRIPTION_PAYLOAD, captorValues.get(1));
    }

    @Test
    public void send_email_notification_to_all() {
        // given
        Subscriber subscriber = Mockito.mock(Subscriber.class);
        var captor = ArgumentCaptor.forClass(Payload.class);

        // when
        manager.subscribe(EMAIL, subscriber);
        manager.subscribe(SMS, subscriber);

        // then
        manager.send(EMAIL, EMAIL_NOTIFICATION_PAYLOAD);

        // then
        verify(subscriber, times(3)).notify(captor.capture());
        var captorValues = captor.getAllValues();
        assertEquals(EMAIL_SUBSCRIPTION_PAYLOAD, captorValues.get(0));
        assertEquals(SMS_SUBSCRIPTION_PAYLOAD, captorValues.get(1));
        assertEquals(EMAIL_NOTIFICATION_PAYLOAD, captorValues.get(2));
    }
}
