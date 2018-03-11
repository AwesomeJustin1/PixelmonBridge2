package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.player;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player.ImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.player.PixelmonMutablePartyPokemonData;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.common.data.manipulator.immutable.common.AbstractImmutableMappedData;

import java.util.Map;

/**
 * Created by clienthax on 10/03/2018.
 */
public class PixelmonImmutablePartyPokemonData extends AbstractImmutableMappedData<Integer, EntitySnapshot, ImmutablePartyPokemonData, MutablePartyPokemonData> implements ImmutablePartyPokemonData {

    public PixelmonImmutablePartyPokemonData(Map<Integer, EntitySnapshot> value) {
        super(ImmutablePartyPokemonData.class, value, PixelmonDataKeys.PARTY_POKEMON, PixelmonMutablePartyPokemonData.class);
    }

}