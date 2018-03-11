package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.entity.EntitySnapshot;

/**
 * Created by clienthax on 10/03/2018.
 */
public interface ImmutablePartyPokemonData extends ImmutableMappedData<Integer, EntitySnapshot, ImmutablePartyPokemonData, MutablePartyPokemonData> {

    default ImmutableMapValue<Integer, EntitySnapshot> partyPokemon() {
        return getMapValue();
    }

}
