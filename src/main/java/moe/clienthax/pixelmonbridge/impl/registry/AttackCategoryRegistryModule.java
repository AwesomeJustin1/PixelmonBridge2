package moe.clienthax.pixelmonbridge.impl.registry;

import moe.clienthax.pixelmonbridge.api.catalog.attackcategory.AttackCategories;
import moe.clienthax.pixelmonbridge.api.catalog.attackcategory.AttackCategory;
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
@RegisterCatalog(AttackCategories.class)
public class AttackCategoryRegistryModule extends MinecraftEnumBasedCatalogTypeModule<com.pixelmonmod.pixelmon.enums.battle.AttackCategory, AttackCategory> {

    @DelayedRegistration(RegistrationPhase.INIT)
    @AdditionalRegistration
    public void customRegistration() {
        for (com.pixelmonmod.pixelmon.enums.battle.AttackCategory enumType : com.pixelmonmod.pixelmon.enums.battle.AttackCategory.values()) {
            if (!this.catalogTypeMap.containsKey(enumAs(enumType).getId())) {
                this.catalogTypeMap.put(enumAs(enumType).getId().toLowerCase(Locale.ENGLISH), (AttackCategory) (Object) enumType);
            }
        }
    }

    /**
     * Needed to make the fields in PixelmonTypes.class Hook up correctly
     *
     * @return
     */
    @Override
    public Map<String, AttackCategory> provideCatalogMap() {
        final HashMap<String, AttackCategory> map = new HashMap<>();
        for (Map.Entry<String, AttackCategory> entry : this.catalogTypeMap.entrySet()) {
            map.put(entry.getKey().replace("minecraft:", "").replace("pixelmon:", ""), entry.getValue());
        }
        return map;
    }

    @Override
    protected com.pixelmonmod.pixelmon.enums.battle.AttackCategory[] getValues() {
        return com.pixelmonmod.pixelmon.enums.battle.AttackCategory.values();
    }
}


