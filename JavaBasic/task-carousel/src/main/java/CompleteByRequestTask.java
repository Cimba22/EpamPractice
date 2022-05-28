public class CompleteByRequestTask implements Task {

    boolean isComplete;
    boolean isFinished;


    @Override
    public void execute() {
        if(isComplete) isFinished = true;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        isComplete = true;
    }
}
