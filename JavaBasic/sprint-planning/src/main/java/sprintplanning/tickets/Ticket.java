package sprintplanning.tickets;

public class Ticket {
    private int id;
    private String name;
    private int estimate;
    private boolean completeStatus = false;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completeStatus;
    }

    public void complete() {
        completeStatus = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
