package moe.clienthax.pixelmonbridge.impl.registry;

import com.pixelmonmod.pixelmon.enums.EnumNature;
import moe.clienthax.pixelmonbridge.api.catalog.nature.Nature;
import moe.clienthax.pixelmonbridge.api.catalog.nature.Natures;
import org.spongepowered.api.registry.RegistrationPhase;
import org.spongepowered.api.registry.util.AdditionalRegistration;
import org.spongepowered.api.registry.util.DelayedRegistration;
import org.spongepowered.api.registry.util.RegisterCatalog;
import org.spongepowered.common.registry.type.MinecraftEnumBasedCatalogTypeModule;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Justin
 */
@RegisterCatalog(Natures.class)
public class NatureRegistryModule extends MinecraftEnumBasedCatalogTypeModule<EnumNature, Nature> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (EnumNature enumType : EnumNature.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (Nature) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, Nature> provideCatalogMap() {
        final HashMap<String, Nature> map = new HashMap<>();
        for (Map.Entry<String, Nature> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected EnumNature[] getValues() {
        return EnumNature.values();
    }
}


