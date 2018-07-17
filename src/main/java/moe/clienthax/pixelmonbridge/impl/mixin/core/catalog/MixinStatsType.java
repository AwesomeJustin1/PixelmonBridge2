package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatType;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by Justin
 */
@Mixin(StatsType.class)
@Implements(@Interface(iface = StatType.class, prefix = "stattype$"))
public abstract class MixinStatsType {

    @Nullable
    private String spongeId;

    public String stattype$getId() {
        if (this.spongeId == null) {
            String name = ((StatsType) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }


    @Intrinsic
    public String stattype$getName() {
        return ((StatsType) (Object) this).name();
    }

}