package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon;

import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutablePokemonIDData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutablePokemonIDData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutablePokemonIDData;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.common.data.manipulator.mutable.common.AbstractListData;
import org.spongepowered.common.data.value.mutable.SpongeListValue;

import java.util.List;

/**
 * Created by clienthax on 19/03/2018.
 */

public class PixelmonMutablePokemonIDData extends AbstractListData<Integer, MutablePokemonIDData, ImmutablePokemonIDData> implements MutablePokemonIDData {

    public PixelmonMutablePokemonIDData() {
        this(Lists.newArrayList());
    }

    public PixelmonMutablePokemonIDData(List<Integer> value) {
        super(MutablePokemonIDData.class, value, PixelmonDataKeys.POKEMON_ID, PixelmonImmutablePokemonIDData.class);
    }

    @Override
    public ListValue<Integer> pokemonID() {
        return new SpongeListValue<>(PixelmonDataKeys.POKEMON_ID, getValue());
    }

    @Override
    public void setAsPlayerPokemon(Player player) {
        PlayerStorage playerStorage = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP) player).get();//TODO bad
        setValue(Lists.newArrayList((int) player.getUniqueId().getLeastSignificantBits(), playerStorage.getNextID()));
    }

}
