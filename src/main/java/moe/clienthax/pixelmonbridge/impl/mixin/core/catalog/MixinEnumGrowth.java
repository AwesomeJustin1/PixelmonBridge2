package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import moe.clienthax.pixelmonbridge.api.catalog.growth.Growth;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by Justin
 */
@Mixin(EnumGrowth.class)
@Implements(@Interface(iface = Growth.class, prefix = "growth$"))
public abstract class MixinEnumGrowth {

    @Nullable
    private String spongeId;

    public String growth$getId() {
        if (this.spongeId == null) {
            String name = ((EnumGrowth) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }


    @Intrinsic
    public String growth$getName() {
        return ((EnumGrowth) (Object) this).name();
    }

}