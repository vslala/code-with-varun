package notificationsystem;

public record Payload(String subject, String msg) {

    public static Payload of(String subject, String msg) {
        return new Payload(subject, msg);
    }
}
