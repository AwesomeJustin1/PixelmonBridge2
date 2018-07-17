package moe.clienthax.pixelmonbridge.impl.mixin.core.pixelmon;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.EVsStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Stats;
import moe.clienthax.pixelmonbridge.api.pixelmon.EVStore;
import moe.clienthax.pixelmonbridge.api.pixelmon.IVStore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Created by Justin
 */
@Mixin(Stats.class)
public abstract class MixinStats implements moe.clienthax.pixelmonbridge.api.pixelmon.Stats {

    @Shadow
    public com.pixelmonmod.pixelmon.entities.pixelmon.stats.IVStore ivs;

    @Shadow
    public EVsStore evs;

    public MixinStats() {
    }

    @Override
    public IVStore getIVs() {
        return (IVStore) ivs;
    }

    @Override
    public void setIVs(IVStore ivs) {
        this.ivs = (com.pixelmonmod.pixelmon.entities.pixelmon.stats.IVStore) ivs;
    }

    public EVStore getEVs() {
        return (EVStore) evs;
    }

    public void setEVs(EVStore evs) {
        this.evs = (EVsStore) evs;
    }
}