public class TaskCarousel {
    private final int capacity;
    private Task[] carouselStorage;
    int elementCount = 0;
    private int execute_pointer;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        carouselStorage = new Task[elementCount];
        execute_pointer = -1;
    }

    public boolean addTask(Task task) {
        if(elementCount >= capacity || task.isFinished() ||
                task instanceof CountDownTask && ((CountDownTask) task).getValue() == 0) return false;
        elementCount++;

        Task[] oldTasks = carouselStorage;
        carouselStorage = new Task[elementCount];

        if (elementCount - 1 >= 0) System.arraycopy(oldTasks, 0, carouselStorage, 0, elementCount - 1);
            carouselStorage[elementCount -1] = task;

        return true;
    }

    public void removeTask(int index){
        if(index < 0 || index >= elementCount) return;

        elementCount--;
        Task[] oldTasks = carouselStorage;
        carouselStorage = new Task[elementCount];

        int tmp_i = 0;
        for (int i = 0; i < elementCount && tmp_i < elementCount +1; tmp_i++) {
            if(tmp_i == index)
                continue;

            carouselStorage[i] = oldTasks[tmp_i];
            i++;
        }
    }

    public boolean execute() {
        if (isEmpty()) return false;

        execute_pointer++;

        if(execute_pointer >= carouselStorage.length) execute_pointer = 0;

        Task currentTask = carouselStorage[execute_pointer];

        if(currentTask != null && !currentTask.isFinished()){
            currentTask.execute();

            if(currentTask.isFinished()){
                removeTask(execute_pointer);
                execute_pointer--;
            }
            return true;
        }else return execute();
    }

    public boolean isFull() {
        return elementCount == capacity;
    }

    public boolean isEmpty() {
        return carouselStorage.length == 0;
    }

}
