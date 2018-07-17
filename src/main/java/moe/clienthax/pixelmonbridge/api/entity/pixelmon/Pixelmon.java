package moe.clienthax.pixelmonbridge.api.entity.pixelmon;

import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.World;

/**
 * Can be safely casted to/from EntityPixelmon without any loss of data
 * Created by Justin
 */
public interface Pixelmon extends Entity, PokemonData {
    static Pixelmon from(World world, String... args) {
        return (Pixelmon) new PokemonSpec(args).create((net.minecraft.world.World) world);
    }

    static Pixelmon from(World world, String args) {
        return from(world, args.split(" "));
    }
}
