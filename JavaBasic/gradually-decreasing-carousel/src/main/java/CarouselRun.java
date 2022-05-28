public class CarouselRun {
    private final int capacity;
    private final int[] carousel;
    private int counter;
    private final String className;
    int decrement = 1;



    public CarouselRun(int capacity, int[] carousel, String className) {

        this.capacity = capacity;
        this.carousel = carousel;
        this.counter = 0;
        this.className = className;

        isFinished();
    }


    public int next() {
        int beforeDecreasing = 0;



        if (isFinished()) return -1;
        else {

            if(className.equals("DecrementingCarousel")){
                while (beforeDecreasing == 0) {

                if (carousel[counter] > 0) {
                    beforeDecreasing = carousel[counter];
                    carousel[counter] -= 1;
                }

                if (counter + 1 >= capacity){
                    counter = 0;
                }
                else counter++;
            }


            }else {
                beforeDecreasing = carousel[counter];
                carousel[counter] -= decrement;
                do {
                    counter++;
                    if (counter == carousel.length){
                        decrement++;
                        counter = 0;
                    }
                }while ((carousel[counter] <= 0) && !isFinished());
            }
        }

        return beforeDecreasing;

    }

    public boolean isFinished() {
        boolean result = false;
        for (int elem : carousel) {
            if (elem > 0) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }

}
