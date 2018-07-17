package moe.clienthax.pixelmonbridge.impl.registry;

import com.pixelmonmod.pixelmon.entities.pixelmon.EnumAggression;
import moe.clienthax.pixelmonbridge.api.catalog.aggression.Aggression;
import moe.clienthax.pixelmonbridge.api.catalog.aggression.Aggressions;
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
@RegisterCatalog(Aggressions.class)
public class AggressionRegistryModule extends MinecraftEnumBasedCatalogTypeModule<EnumAggression, Aggression> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (EnumAggression enumType : EnumAggression.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getIndex())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (Aggression) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, Aggression> provideCatalogMap() {
        final HashMap<String, Aggression> map = new HashMap<>();
        for (Map.Entry<String, Aggression> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected EnumAggression[] getValues() {
        return EnumAggression.values();
    }
}


