package moe.clienthax.pixelmonbridge.api.pixelmon;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.EVsStore;
import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatType;

/**
 * Created by Justin
 */
public interface EVStore extends Cloneable {
    void randomizeMaxEVs();

    void fill(int... evs);

    int getAvailableEvs();

    int get(StatType stat);

    void set(StatType stat, int val);

    void add(StatType stat, int val);

    boolean berry(StatType stat);

    boolean vitamin(StatType stat);

    int[] getArray();

    /**
     * @param store the EVStore to combine with this one
     * @return this
     */
    EVStore combine(EVStore store);

    default EVStore clone() {
        EVStore store = (EVStore) new EVsStore();
        store.fill(getArray());
        return store;
    }
}
