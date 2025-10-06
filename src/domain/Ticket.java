package domain;

public class Ticket {
    private int id;
    private String title;
    private String description;
    private int reporterId;
    private Integer assigneeId; // nullable
    private int categoryId;
    private String state;

    public Ticket(int id, String title, String descripcion, int reporterId,
                  Integer assigneeId, int categoryId, String state) {
        this.id = id;
        this.title = title;
        this.description = descripcion;
        this.reporterId = reporterId;
        this.assigneeId = assigneeId;
        this.categoryId = categoryId;
        this.state = state;
    }

    // getters & setters
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getTitle(){ return title; }
    public String getDescription(){ return description; }
    public int getReporterId(){ return reporterId; }
    public Integer getAssigneeId(){ return assigneeId; }
    public void setAssigneeId(Integer assigneeId){ this.assigneeId = assigneeId; }
    public int getCategoryID(){ return categoryId; }
    public String getState(){ return state; }
    public void setStateId(String state){ this.state = state; }
    @Override
    public String toString(){
        return id + " | " + title + " | reporter:" + reporterId + " | assignee:" + assigneeId + " | cat:" + categoryId + " | est:" + state;
    }
}
