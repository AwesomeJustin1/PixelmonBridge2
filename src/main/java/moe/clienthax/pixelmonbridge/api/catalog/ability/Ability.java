package moe.clienthax.pixelmonbridge.api.catalog.ability;

import java.util.Optional;

/**
 * Created by Justin
 */
public interface Ability {
    static Optional<Ability> getAbility(String name) {
        return com.pixelmonmod.pixelmon.entities.pixelmon.abilities.AbilityBase.getAbility(name).map(a -> (Ability) a);
    }

    String getLocalizedName();
}
