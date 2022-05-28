public class CarouselRun {
    private final int capacity;
    private final int[] carousel;
    private int counter;


    public CarouselRun(int capacity, int[] carousel) {

        this.capacity = capacity;
        this.carousel = carousel;
        this.counter = 0;

        isFinished();


    }

    public int next() {
        if (isFinished()) return -1;
        else {
            int result = 0;
            while (result == 0) {
                if (carousel[counter] > 0) {
                    result = carousel[counter];
                    carousel[counter] -= 1;

                }
                if (counter + 1 >= capacity) counter = 0;
                else counter++;
            }
            isFinished();
            return result;
        }
    }

    public boolean isFinished() {
        boolean result = false;
        for (int elem : carousel) {
            if (elem != 0) {
                result = false;
                break;
            } else {
                result = true;
            }
        }


        return result;
    }
}
