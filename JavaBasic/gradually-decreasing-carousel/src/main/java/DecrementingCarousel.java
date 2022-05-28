public class DecrementingCarousel {
    private final int capacity;
    int[] arr;
    int counter = 0;
    boolean isRunning;

    public DecrementingCarousel(int capacity) {
        this.isRunning = false;
        this.capacity = capacity;
        this.arr = new int[capacity];

    }


    public boolean addElement(int element){
        if(isRunning) return false;
        if (counter < capacity && element > 0) {
            arr[counter] = element;
            counter++;
            return true;
        }
        return false;

    }

    public CarouselRun run(){
        if(isRunning) return null;
        else {
            isRunning = true;
            return new CarouselRun(capacity, arr, getClassName());
        }
    }

    public String getClassName(){
        return "DecrementingCarousel";
    }

}
