package moe.clienthax.pixelmonbridge.api.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/**
 * Created by Justin
 */
public class FixedSizeList<T> extends ArrayList<T> {
    private int maxSize;

    public FixedSizeList(int maxSize) {
        this.maxSize = maxSize;
    }

    public FixedSizeList(int maxSize, Collection<? extends T> c) {
        super(c);
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public boolean add(T t) {
        return size() + 1 <= maxSize && super.add(t);
    }

    @Override
    public void add(int index, T element) {
        if (size() + 1 <= maxSize)
            super.add(index, element);
    }

    public <R> R[] toArray(Class<R> returnClass, Function<T, R> mapper) {
        R[] arr = (R[]) Array.newInstance(returnClass, maxSize);
        for (int i = 0; i < size(); i++)
            if (get(i) != null)
                arr[i] = mapper.apply(get(i));
        return arr;
    }
}
