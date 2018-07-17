package moe.clienthax.pixelmonbridge.impl.mixin.core.sponge;

import moe.clienthax.pixelmonbridge.api.catalog.aggression.Aggression;
import moe.clienthax.pixelmonbridge.api.catalog.attackcategory.AttackCategory;
import moe.clienthax.pixelmonbridge.api.catalog.ball.Ball;
import moe.clienthax.pixelmonbridge.api.catalog.growth.Growth;
import moe.clienthax.pixelmonbridge.api.catalog.nature.Nature;
import moe.clienthax.pixelmonbridge.api.catalog.pixelmon.PixelmonType;
import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatType;
import moe.clienthax.pixelmonbridge.api.catalog.type.Type;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pixelmon;
import moe.clienthax.pixelmonbridge.impl.entity.PixelmonEnumTypeRegistryModule;
import moe.clienthax.pixelmonbridge.impl.entity.PixelmonTypeRegistryModule;
import moe.clienthax.pixelmonbridge.impl.registry.*;
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
        registry.registerModule(Type.class, new PixelmonEnumTypeRegistryModule());
        registry.registerModule(Ball.class, new BallRegistryModule());
        registry.registerModule(Aggression.class, new AggressionRegistryModule());
        registry.registerModule(Growth.class, new GrowthRegistryModule());
        registry.registerModule(AttackCategory.class, new AttackCategoryRegistryModule());
        registry.registerModule(Nature.class, new NatureRegistryModule());
        registry.registerModule(StatType.class, new StatTypeRegistryModule());
    }

    @Inject(method = "registerDefaultSuppliers", at = @At("RETURN"))
    private void onRegister(SpongeGameRegistry registry, CallbackInfo ci) {
        registry.registerBuilderSupplier(Pixelmon.Builder.class, Pixelmon.PokemonBuilder::new);
    }
}