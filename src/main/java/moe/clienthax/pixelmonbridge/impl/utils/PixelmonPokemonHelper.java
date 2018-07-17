package moe.clienthax.pixelmonbridge.impl.utils;

import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.EnumType;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutablePokemonIDData;
import moe.clienthax.pixelmonbridge.api.utils.PokemonHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Optional;

public class PixelmonPokemonHelper implements PokemonHelper {

    @Override
    public Optional<Living> makeAndSetupPokemon(Player player, String pokemonName) {
        EnumPokemon enumPokemon = EnumPokemon.getFromNameAnyCase(pokemonName);
        if (enumPokemon != null) {
            EntityPixelmon pixelmon = (EntityPixelmon) PixelmonEntityList.createEntityByName(enumPokemon.name, (World) player.getWorld());
                /*
                if (pixelmon.getMoveset().isEmpty())
                    pixelmon.loadMoveset();//TODO this is going to be.. fun
                */
            Living living = (Living) pixelmon;
            living.offer(PixelmonDataKeys.POKEMON_CAUGHT_BALL, "PokeBall");
            //TODO movesets...
            living = giveRandomMoveset(living).get();
            living.offer(PixelmonDataKeys.POKEMON_BOSS_MODE, "NotBoss");
            MutablePokemonIDData idData = living.get(MutablePokemonIDData.class).get();
            idData.setAsPlayerPokemon(player);
            living.offer(idData);
            living.offer(Keys.TAMED_OWNER, Optional.of(player.getUniqueId()));

            return Optional.of(living);
        }


        return Optional.empty();
    }

    @Override
    public Optional<Living> giveRandomMoveset(Living pixelmon) {
        if (pixelmon.getClass().isAssignableFrom(EntityPixelmon.class)) {
            ((EntityPixelmon) pixelmon).loadMoveset();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Living> makeEgg(Living pixelmon1, Living pixelmon2) {
        EntityPixelmon parent1 = (EntityPixelmon) pixelmon1;
        EntityPixelmon parent2 = (EntityPixelmon) pixelmon2;
        if (!parent1.isEgg && !parent2.isEgg && EntityPixelmon.canBreed(parent1, parent2)) {//TODO change to use type
            EntityPixelmon egg = (EntityPixelmon) PixelmonEntityList.createEntityByName("Magikarp", (World) pixelmon1.getWorld());
            egg.makeEntityIntoEgg(parent1, parent2);
            return Optional.of((Living) egg);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Living> makeEgg(Player player, int slot1, int slot2) {
        try {
            PlayerStorage playerStorage = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP) player).get();//TODO naughty
            playerStorage.recallAllPokemon();
            EntityPixelmon parent1 = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(playerStorage.partyPokemon[slot1], (World) player.getWorld());
            EntityPixelmon parent2 = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(playerStorage.partyPokemon[slot2], (World) player.getWorld());
            return makeEgg((Living) parent1, (Living) parent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override//TODO change to match cmd
    public Optional<String> getHiddenPowerType(Living pixelmon) {
        int a, b, c, d, e, f;
        try {
            a = pixelmon.get(PixelmonDataKeys.POKEMON_HP_IVS).get() % 2;
            b = pixelmon.get(PixelmonDataKeys.POKEMON_ATTACK_IVS).get() % 2;
            c = pixelmon.get(PixelmonDataKeys.POKEMON_DEFENSE_IVS).get() % 2;
            d = pixelmon.get(PixelmonDataKeys.POKEMON_SPEED_IVS).get() % 2;
            e = pixelmon.get(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS).get() % 2;
            f = pixelmon.get(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS).get() % 2;
            double fedbca = (32 * f) + (16 * e) + (8 * d) + (4 * c) + (2 * b) + a;
            int type = (int) Math.floor((fedbca * 15f) / 63f);

            if (type == 0)
                return Optional.of(EnumType.Fighting.name());
            else if (type == 1)
                return Optional.of(EnumType.Flying.name());
            else if (type == 2)
                return Optional.of(EnumType.Poison.name());
            else if (type == 3)
                return Optional.of(EnumType.Ground.name());
            else if (type == 4)
                return Optional.of(EnumType.Rock.name());
            else if (type == 5)
                return Optional.of(EnumType.Bug.name());
            else if (type == 6)
                return Optional.of(EnumType.Ghost.name());
            else if (type == 7)
                return Optional.of(EnumType.Steel.name());
            else if (type == 8)
                return Optional.of(EnumType.Fire.name());
            else if (type == 9)
                return Optional.of(EnumType.Water.name());
            else if (type == 10)
                return Optional.of(EnumType.Grass.name());
            else if (type == 11)
                return Optional.of(EnumType.Electric.name());
            else if (type == 12)
                return Optional.of(EnumType.Psychic.name());
            else if (type == 13)
                return Optional.of(EnumType.Ice.name());
            else if (type == 14)
                return Optional.of(EnumType.Dragon.name());
            else if (type == 15)
                return Optional.of(EnumType.Dark.name());
            else
                return Optional.of(EnumType.Normal.name());
        } catch (Exception e1) {
            e1.printStackTrace();
            return Optional.empty();
        }
    }

}
