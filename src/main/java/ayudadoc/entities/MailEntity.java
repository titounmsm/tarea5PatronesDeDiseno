package ayudadoc.entities;

public class MailEntity {
    
    private final String from;
    private final String to;
    private final String subject;
    private final String body;
    public MailEntity(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
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
    
   
}
