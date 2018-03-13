package moe.clienthax.pixelmonbridge.impl.mixin.core.sponge;

import moe.clienthax.pixelmonbridge.api.entity.PixelmonEnumType;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonType;
import moe.clienthax.pixelmonbridge.impl.entity.PixelmonEnumTypeRegistryModule;
import moe.clienthax.pixelmonbridge.impl.entity.PixelmonTypeRegistryModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.common.SpongeImpl;
import org.spongepowered.common.registry.CommonModuleRegistry;
import org.spongepowered.common.registry.SpongeGameRegistry;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(value = CommonModuleRegistry.class, remap = false)
public abstract class MixinCommonModuleRegistry {

    @Inject(method = "registerDefaultModules", at = @At("RETURN"))
    private void onRegister(CallbackInfo callbackInfo) {
        SpongeGameRegistry registry = SpongeImpl.getRegistry();
        registry.registerModule(PixelmonType.class, new PixelmonTypeRegistryModule());
        registry.registerModule(PixelmonEnumType.class, new PixelmonEnumTypeRegistryModule());
    }


}