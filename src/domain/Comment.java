package domain;


public class Comment {
    private int ticketId;
    private int userId;
    private String text;

    public Comment( int ticketId, int userId, String text) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.text = text;
    }

    public int getTicketId(){ return ticketId; }
    @Override
    public String toString(){
        return "ID: " + userId + " -> " + text;
    }
}