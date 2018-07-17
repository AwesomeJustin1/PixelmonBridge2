package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import com.pixelmonmod.pixelmon.enums.EnumNature;
import moe.clienthax.pixelmonbridge.api.catalog.nature.Nature;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by Justin
 */
@Mixin(EnumNature.class)
@Implements(@Interface(iface = Nature.class, prefix = "nature$"))
public abstract class MixinEnumNature {

    @Nullable
    private String spongeId;

    public String nature$getId() {
        if (this.spongeId == null) {
            String name = ((EnumNature) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }


    @Intrinsic
    public String nature$getName() {
        return ((EnumNature) (Object) this).name();
    }

}