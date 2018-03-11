package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player.ImmutablePartyPokemonData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.entity.EntitySnapshot;

/**
 * Created by clienthax on 10/03/2018.
 */
public interface MutablePartyPokemonData extends MappedData<Integer, EntitySnapshot, MutablePartyPokemonData, ImmutablePartyPokemonData> {

    default MapValue<Integer, EntitySnapshot> partyPokemon() {
        return getMapValue();
    }

}


