import java.util.*;

class IntStringCappedMap extends AbstractMap<Integer, String> {

    Map<Integer, String> map = new TreeMap<>();

    private final long capacity;

    public IntStringCappedMap(final long capacity) {
        this.capacity = capacity;
    }

    public long getCapacity() {
        return capacity;
    }

    @Override
    public Set<Entry<Integer, String>> entrySet() {
        return new AbstractSet<>() {
            @Override
            public Iterator<Entry<Integer, String>> iterator() {
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        //implement this method
                        return iterator().hasNext();
                    }

                    @Override
                    public Entry<Integer, String> next() {
                        //implement this method
                        return iterator().next();
                    }
                };
            }

            @Override
            public int size() {
                return IntStringCappedMap.this.size();
            }
        };
    }

    @Override
    public String get(final Object key) {
        //implement this method
        return map.get(map.keySet().toArray()[0]);
    }

    @Override
    public String put(final Integer key, final String value) {
        //implement this method
        return map.put(key, value);
    }

    @Override
    public String remove(final Object key) {
        //implement this method
       return map.remove(key);
    }

    @Override
    public int size() {
        //implement this method
        return map.size();
    }

}
