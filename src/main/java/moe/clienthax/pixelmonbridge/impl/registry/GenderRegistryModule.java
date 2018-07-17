package moe.clienthax.pixelmonbridge.impl.registry;

import moe.clienthax.pixelmonbridge.api.catalog.gender.Gender;
import moe.clienthax.pixelmonbridge.api.catalog.gender.Genders;
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
@RegisterCatalog(Genders.class)
public class GenderRegistryModule extends MinecraftEnumBasedCatalogTypeModule<com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender, Gender> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender enumType : com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (Gender) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, Gender> provideCatalogMap() {
        final HashMap<String, Gender> map = new HashMap<>();
        for (Map.Entry<String, Gender> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender[] getValues() {
        return com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender.values();
    }
}


