public class Requirements {

    public static void requireNonNull(Object obj){
        if (obj == null){
            throw new NullPointerException("NullPointerException");
        }
    }

    public static void requireNonNull(Object obj, String message) {
        if (obj == null){
            throw new NullPointerException(message);
        }
    }

    public static void checkArgument(boolean value) {
        if (!value) throw new IllegalArgumentException("IllegalArgumentException");
    }

    public static void checkArgument(boolean value, String message) {
        if (!value) throw new IllegalArgumentException(message);
    }

    public static void checkState(boolean value) {
        if (!value) throw new IllegalStateException("IllegalStateException");
    }

    public static void checkState(boolean value, String message) {
        if (!value) throw new IllegalStateException(message);
    }

    public static void checkIndex(int index, int size) {
        try{
            int[] arr = new int[size];
            arr[index] = 1;
        } catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
    }


}
