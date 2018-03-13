package moe.clienthax.pixelmonbridge.impl.entity;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.EnumType;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonEnumType;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonEnumTypes;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonType;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonTypes;
import org.spongepowered.api.registry.RegistrationPhase;
import org.spongepowered.api.registry.util.AdditionalRegistration;
import org.spongepowered.api.registry.util.DelayedRegistration;
import org.spongepowered.api.registry.util.RegisterCatalog;
import org.spongepowered.common.registry.type.MinecraftEnumBasedCatalogTypeModule;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by clienthax on 10/03/2018.
 */

@RegisterCatalog(PixelmonEnumTypes.class)
public class PixelmonEnumTypeRegistryModule extends MinecraftEnumBasedCatalogTypeModule<EnumType, PixelmonEnumType> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (EnumType enumType : EnumType.values()) {
            if(!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (PixelmonEnumType) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     * @return
     */
    @Override
    public Map<String, PixelmonEnumType> provideCatalogMap() {
        final HashMap<String, PixelmonEnumType> map = new HashMap<>();
        for (Map.Entry<String, PixelmonEnumType> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected EnumType[] getValues() {
        return EnumType.values();
    }

}