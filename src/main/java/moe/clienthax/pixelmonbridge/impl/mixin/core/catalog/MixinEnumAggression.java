package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import com.pixelmonmod.pixelmon.entities.pixelmon.EnumAggression;
import moe.clienthax.pixelmonbridge.api.catalog.aggression.Aggression;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by Justin
 */
@Mixin(EnumAggression.class)
@Implements(@Interface(iface = Aggression.class, prefix = "aggression$"))
public abstract class MixinEnumAggression {

    @Nullable
    private String spongeId;

    public String aggression$getId() {
        if (this.spongeId == null) {
            String name = ((EnumAggression) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }


    @Intrinsic
    public String aggression$getName() {
        return ((EnumAggression) (Object) this).name();
    }

}