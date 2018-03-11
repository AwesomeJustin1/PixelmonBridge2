package moe.clienthax.pixelmonbridge.impl.entity;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonType;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonTypes;
import org.spongepowered.api.registry.RegistrationPhase;
import org.spongepowered.api.registry.util.AdditionalRegistration;
import org.spongepowered.api.registry.util.DelayedRegistration;
import org.spongepowered.api.registry.util.RegisterCatalog;
import org.spongepowered.common.registry.type.MinecraftEnumBasedCatalogTypeModule;

import java.util.Locale;

/**
 * Created by clienthax on 10/03/2018.
 */

@RegisterCatalog(PixelmonTypes.class)
public class PixelmonTypeRegistryModule extends MinecraftEnumBasedCatalogTypeModule<EnumPokemon, PixelmonType> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (EnumPokemon enumPokemon : EnumPokemon.values()) {
            if(!this.catalogTypeMap.containsKey(enumAs(enumPokemon).getId())) {
                this.catalogTypeMap.put(enumAs(enumPokemon).getId().toLowerCase(Locale.ENGLISH), (PixelmonType) (Object) enumPokemon);
            }
        }
    }

    @Override
    protected EnumPokemon[] getValues() {
        return EnumPokemon.values();
    }

}