package moe.clienthax.pixelmonbridge.impl.registry;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatType;
import moe.clienthax.pixelmonbridge.api.catalog.stattype.StatTypes;
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
@RegisterCatalog(StatTypes.class)
public class StatTypeRegistryModule extends MinecraftEnumBasedCatalogTypeModule<StatsType, StatType> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (StatsType enumType : StatsType.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (StatType) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, StatType> provideCatalogMap() {
        final HashMap<String, StatType> map = new HashMap<>();
        for (Map.Entry<String, StatType> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected StatsType[] getValues() {
        return StatsType.values();
    }
}


