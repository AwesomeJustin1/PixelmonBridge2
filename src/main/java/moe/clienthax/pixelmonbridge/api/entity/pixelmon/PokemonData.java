package moe.clienthax.pixelmonbridge.api.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.catalog.ability.Ability;
import moe.clienthax.pixelmonbridge.api.catalog.aggression.Aggression;
import moe.clienthax.pixelmonbridge.api.catalog.ball.Ball;
import moe.clienthax.pixelmonbridge.api.catalog.gender.Gender;
import moe.clienthax.pixelmonbridge.api.catalog.growth.Growth;
import moe.clienthax.pixelmonbridge.api.catalog.nature.Nature;
import moe.clienthax.pixelmonbridge.api.catalog.type.Type;
import moe.clienthax.pixelmonbridge.api.entity.Player;
import moe.clienthax.pixelmonbridge.api.pixelmon.Moveset;
import moe.clienthax.pixelmonbridge.api.pixelmon.Stats;
import moe.clienthax.pixelmonbridge.api.storage.PlayerStorage;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Justin
 */
public interface PokemonData {
    String getName();

    Pokemon setName(String name);

    Ability getAbility();

    Pokemon setAbilityBase(Ability ability);

    Aggression getAggression();

    Pokemon setAggression(Aggression aggression);

    Ball getBall();

    Pokemon setBall(Ball ball);

    int getForm();

    Pokemon setForm(int form);

    Optional<Player> getOwner();

    Pokemon setOwner(Player player);

    Gender getGender();

    Pokemon setGender(Gender gender);

    Growth getGrowth();

    Pokemon setGrowth(Growth growth);

    boolean isShiny();

    Pokemon setIsShiny(boolean shiny);

    int getSlot();

    int[] getPokemonId();

    ItemStack getPhoto();

    String getOriginalTrainer();

    Pokemon setOriginalTrainer(UUID uuid);

    Pokemon setOriginalTrainer(String name);

    Pokemon setOriginalTrainer(Player player);

    String getNickname();

    Pokemon setNickname(String nickname);

    Moveset getMoveset();

    Pokemon setMoveset(Moveset moveset);

    Stats getStats();

    Pokemon setStats(Stats stats);

    Nature getNature();

    Pokemon setNature(Nature nature);

    Type getMainType();

    Optional<Type> getSecondaryType();

    default Optional<PlayerStorage> getStorage() {
        return getOwner().map(Player::getStorage);
    }

    int getFriendship();

    Pokemon setFriendship(int friendship);

    int getLevel();

    Pokemon setLevel(int level);
}
