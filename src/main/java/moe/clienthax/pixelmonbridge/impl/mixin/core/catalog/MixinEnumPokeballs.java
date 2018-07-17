package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import moe.clienthax.pixelmonbridge.api.catalog.ball.Ball;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by Justin
 */
@Mixin(EnumPokeballs.class)
@Implements(@Interface(iface = Ball.class, prefix = "ball$"))
public abstract class MixinEnumPokeballs {

    @Nullable
    private String spongeId;

    public String ball$getId() {
        if (this.spongeId == null) {
            String name = ((EnumPokeballs) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }


    @Intrinsic
    public String ball$getName() {
        return ((EnumPokeballs) (Object) this).name();
    }

}