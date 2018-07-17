package moe.clienthax.pixelmonbridge.impl.mixin.core.pixelmon;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.IVStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Created by Justin
 */
@Mixin(IVStore.class)
public abstract class MixinIVStore implements moe.clienthax.pixelmonbridge.api.pixelmon.IVStore {

    public MixinIVStore() {

    }

    @Shadow
    public abstract void CopyIVs(IVStore ivs);

    @Shadow
    public abstract int get(StatsType stat);

    @Shadow
    public abstract void set(StatsType stat, int value);

    @Shadow
    public abstract void add(StatsType stat, int value);

    @Override
    public moe.clienthax.pixelmonbridge.api.pixelmon.IVStore clone() {
        IVStore copy = new IVStore();
        CopyIVs(copy);
        return (moe.clienthax.pixelmonbridge.api.pixelmon.IVStore) copy;
    }

    @Override
    public int get(StatType stat) {
        return get((StatsType) (Object) stat);
    }

    @Override
    public void set(StatType stat, int val) {
        set((StatsType) (Object) stat, val);
    }

    @Override
    public void add(StatType stat, int val) {
        add((StatsType) (Object) stat, val);
    }

}