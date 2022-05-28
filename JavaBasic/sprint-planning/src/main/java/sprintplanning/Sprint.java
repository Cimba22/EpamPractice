package sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private final int capacity;
    private int ticketsLimit;
    private Ticket[] checkTicket;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.checkTicket = new Ticket[0];
    }

    public boolean dependencyAcceptStatus(UserStory userStory) {
        boolean dependencyAcceptStatus;
        int dependencyUnCompletedCount = 0;
        int dependencyInSprintCount = 0;
        UserStory[] userStoryDependencies = userStory.getDependencies();
        for (UserStory userStoryD : userStoryDependencies) {
            if (!userStoryD.isCompleted()) {
                dependencyUnCompletedCount++;
                for (Ticket sprintT : checkTicket)
                    if (userStoryD == sprintT)
                        dependencyInSprintCount++;
            }
        }
        dependencyAcceptStatus = dependencyUnCompletedCount == dependencyInSprintCount;

        return dependencyAcceptStatus;
    }

    public boolean isCapacityOverflow(Ticket ticket){
        return (getTotalEstimate() + ticket.getEstimate()) > capacity;
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory == null || userStory.isCompleted() || ticketsLimit == 0 || isCapacityOverflow(userStory)){
            return false;
        }else if (dependencyAcceptStatus(userStory)){
            addTicket(userStory);
            return true;
        }
        else return false;

    }

    public void addTicket(Ticket ticket){
        Ticket[] tempTicket = new Ticket[checkTicket.length + 1];
        System.arraycopy(checkTicket, 0, tempTicket, 0, checkTicket.length);
        tempTicket[tempTicket.length - 1] = ticket;
        checkTicket = new Ticket[tempTicket.length];
        checkTicket = tempTicket.clone();
        this.setTicketsLimit(ticketsLimit - 1);
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted() || ticketsLimit == 0 || isCapacityOverflow(bugReport)) {
            return false;
        } else {
            addTicket(bugReport);
            return true;
        }
    }

    public Ticket[] getTickets() {
       return checkTicket.clone();
    }

    public int getTotalEstimate() {
        int sum = 0;
        if(checkTicket != null){
            for (Ticket ticket : checkTicket) {
                sum += ticket.getEstimate();
            }
        }
        return sum;
    }

    public void setTicketsLimit(int ticketsLimit) {
        this.ticketsLimit = ticketsLimit;
    }

}
