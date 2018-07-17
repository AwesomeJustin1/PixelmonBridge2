package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import com.pixelmonmod.pixelmon.enums.EnumType;
import moe.clienthax.pixelmonbridge.api.catalog.type.Type;
import moe.clienthax.pixelmonbridge.api.events.CalculateTypeEffectivenessEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(EnumType.class)
@Implements(@Interface(iface = Type.class, prefix = "pixelmonenumtype$"))
public abstract class MixinEnumType {

    @Nullable
    private String spongeId;

    @Inject(method = "getEffectiveness", at = @At("RETURN"), remap = false, cancellable = true)
    private static void onGetEffectiveness(EnumType t1, EnumType t2, CallbackInfoReturnable<Float> cir) {
        CalculateTypeEffectivenessEvent event = new CalculateTypeEffectivenessEvent(t1, t2, cir.getReturnValue());
        Sponge.getEventManager().post(event);
        cir.setReturnValue(event.getEffectiveness());
    }

    public String pixelmonenumtype$getId() {
        if (this.spongeId == null) {
            String name = ((EnumType) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }

    @Intrinsic
    public String pixelmonenumtype$getName() {
        return ((EnumType) (Object) this).name();
    }
}
