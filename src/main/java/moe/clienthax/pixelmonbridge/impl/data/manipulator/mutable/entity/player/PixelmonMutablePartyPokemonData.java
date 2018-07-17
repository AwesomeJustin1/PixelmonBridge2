package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.player;

import com.google.common.collect.Maps;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player.ImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.player.PixelmonImmutablePartyPokemonData;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.common.data.manipulator.mutable.common.AbstractMappedData;

import java.util.Map;

/**
 * Created by clienthax on 10/03/2018.
 */
public class PixelmonMutablePartyPokemonData extends AbstractMappedData<Integer, EntitySnapshot, MutablePartyPokemonData, ImmutablePartyPokemonData> implements MutablePartyPokemonData {

    public PixelmonMutablePartyPokemonData() {
        this(Maps.newHashMap());
    }

    public PixelmonMutablePartyPokemonData(Map<Integer, EntitySnapshot> value) {
        super(MutablePartyPokemonData.class, value, PixelmonDataKeys.PARTY_POKEMON, PixelmonImmutablePartyPokemonData.class);
    }

}
