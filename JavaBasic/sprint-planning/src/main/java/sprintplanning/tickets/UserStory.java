package sprintplanning.tickets;

public class UserStory extends Ticket {
    private UserStory [] dependsOn;
    boolean dependsStatus = false;


    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = new UserStory[dependsOn.length];
        this.dependsOn = dependsOn.clone();
    }

    @Override
    public void complete() {
        boolean dependsStatus = true;
        for (UserStory user : dependsOn) {
            if(!user.isCompleted()){
                dependsStatus = false;
                break;
            }
        }
        if(dependsStatus) super.complete();
    }

    public UserStory[] getDependencies() {
        return dependsOn.clone();
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
