package net.eterniamc.pixelmonbridge.events;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.pokedex.EnumPokedexRegisterStatus;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.Cause;

public class PokedexUpdateEvent implements Event {
    private Cause cause;
    private EnumPokedexRegisterStatus status;
    private EnumPokemon pokemon;

    public PokedexUpdateEvent(Cause cause, EnumPokedexRegisterStatus status, EnumPokemon pokemon) {
        this.cause = cause;
        this.status = status;
        this.pokemon = pokemon;
    }

    @Override
    public Cause getCause() {
        return cause;
    }

    public EnumPokedexRegisterStatus getStatus() {
        return status;
    }

    public EnumPokemon getPokemon() {
        return pokemon;
    }
}
