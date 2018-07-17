package moe.clienthax.pixelmonbridge.impl.registry;

import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import moe.clienthax.pixelmonbridge.api.catalog.growth.Growth;
import moe.clienthax.pixelmonbridge.api.catalog.growth.Growths;
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
@RegisterCatalog(Growths.class)
public class GrowthRegistryModule extends MinecraftEnumBasedCatalogTypeModule<EnumGrowth, Growth> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (EnumGrowth enumType : EnumGrowth.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (Growth) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, Growth> provideCatalogMap() {
        final HashMap<String, Growth> map = new HashMap<>();
        for (Map.Entry<String, Growth> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected EnumGrowth[] getValues() {
        return EnumGrowth.values();
    }
}


