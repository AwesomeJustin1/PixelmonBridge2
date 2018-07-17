package moe.clienthax.pixelmonbridge.impl.mixin.core.player.data;

import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.entity.Player;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pokemon;
import moe.clienthax.pixelmonbridge.api.storage.PlayerStorage;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.common.mixin.core.entity.player.MixinEntityPlayer;

import java.util.List;
import java.util.Optional;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(value = EntityPlayerMP.class, priority = 1111)
public abstract class MixinEntityPlayerMP extends MixinEntityPlayer implements Player {
    private com.pixelmonmod.pixelmon.storage.PlayerStorage storage;

    @Override
    public PlayerStorage getStorage() {
        if (storage == null) {
            storage = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP) (Object) this).get();
        }
        return (PlayerStorage) storage;
    }

    @Override
    public Optional<Pokemon> getPokemon(int pos) {
        return Optional.ofNullable(storage.partyPokemon[pos]).map(nbt -> (Pokemon) nbt);
    }

    @Override
    public void supplyVanillaManipulators(List<DataManipulator<?, ?>> manipulators) {
        super.supplyVanillaManipulators(manipulators);
        get(MutablePartyPokemonData.class).ifPresent(manipulators::add);
    }
}
