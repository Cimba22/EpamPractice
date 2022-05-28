public class CountDownTask implements Task{
    private int value;

    public CountDownTask(int value) {
        this.value = Math.max(value, 0);
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
        if(getValue() != 0) value -= 1;
        else isFinished();
    }

    @Override
    public boolean isFinished() {
        return getValue() == 0;
    }
}
