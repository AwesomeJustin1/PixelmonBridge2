package moe.clienthax.pixelmonbridge.impl.entity;

import com.pixelmonmod.pixelmon.enums.EnumType;
import moe.clienthax.pixelmonbridge.api.catalog.type.Type;
import moe.clienthax.pixelmonbridge.api.catalog.type.Types;
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

@RegisterCatalog(Types.class)
public class PixelmonEnumTypeRegistryModule extends MinecraftEnumBasedCatalogTypeModule<EnumType, Type> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (EnumType enumType : EnumType.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (Type) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, Type> provideCatalogMap() {
        final HashMap<String, Type> map = new HashMap<>();
        for (Map.Entry<String, Type> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected EnumType[] getValues() {
        return EnumType.values();
    }
}