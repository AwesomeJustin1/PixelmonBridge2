package moe.clienthax.pixelmonbridge.impl.mixin.core.pixelmon;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.EVsStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatType;
import moe.clienthax.pixelmonbridge.api.pixelmon.EVStore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Created by Justin
 */
@Mixin(EVsStore.class)
public abstract class MixinEVsStore implements moe.clienthax.pixelmonbridge.api.pixelmon.EVStore {
    @Shadow
    public int specialAttack;
    @Shadow
    public int hp;
    @Shadow
    public int attack;
    @Shadow
    public int defence;
    @Shadow
    public int specialDefence;
    @Shadow
    public int speed;

    public MixinEVsStore() {

    }

    @Shadow
    public abstract void gainEV(EVsStore evGain);

    @Shadow
    protected abstract int getRemainingEVs();

    @Shadow
    public abstract void set(StatsType stat, int amount);

    @Shadow
    public abstract int get(StatsType stat);

    @Shadow
    public abstract void addEVs(int i, StatsType stat);

    @Shadow
    public abstract boolean berryEVs(StatsType stat);

    @Shadow
    public abstract boolean vitaminEVs(StatsType stat);

    @Shadow
    public abstract void fillFromArray(int[] evs);

    @Override
    public void fill(int... evs) {
        fillFromArray(evs);
    }

    @Override
    public int getAvailableEvs() {
        return getRemainingEVs();
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
        addEVs(val, (StatsType) (Object) stat);
    }

    @Override
    public boolean berry(StatType stat) {
        return berryEVs((StatsType) (Object) stat);
    }

    @Override
    public boolean vitamin(StatType stat) {
        return vitaminEVs((StatsType) (Object) stat);
    }

    @Override
    public int[] getArray() {
        return new int[]{hp, attack, defence, specialAttack, specialDefence, speed};
    }

    @Override
    public EVStore combine(EVStore store) {
        gainEV((EVsStore) store);
        return this;
    }
}