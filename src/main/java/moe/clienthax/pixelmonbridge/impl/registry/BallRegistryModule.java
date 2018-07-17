package moe.clienthax.pixelmonbridge.impl.registry;

import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import moe.clienthax.pixelmonbridge.api.catalog.ball.Ball;
import moe.clienthax.pixelmonbridge.api.catalog.ball.Balls;
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
@RegisterCatalog(Balls.class)
public class BallRegistryModule extends MinecraftEnumBasedCatalogTypeModule<EnumPokeballs, Ball> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (EnumPokeballs enumType : EnumPokeballs.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (Ball) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, Ball> provideCatalogMap() {
        final HashMap<String, Ball> map = new HashMap<>();
        for (Map.Entry<String, Ball> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected EnumPokeballs[] getValues() {
        return EnumPokeballs.values();
    }
}


