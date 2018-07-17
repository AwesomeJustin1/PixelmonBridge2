package moe.clienthax.pixelmonbridge.api.pixelmon;

import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatType;

/**
 * Created by Justin
 */
public interface IVStore extends Cloneable {
    int[] getArray();

    void maximizeIVs();

    IVStore clone();

    int get(StatType stat);

    void set(StatType stat, int val);

    void add(StatType stat, int val);
}
