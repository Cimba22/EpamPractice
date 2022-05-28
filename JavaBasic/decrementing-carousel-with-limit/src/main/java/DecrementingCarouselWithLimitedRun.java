public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity,actionLimit);

    }

    public String getClassName(){
        return "DecrementingCarouselWithLimitedRun";
    }


}
