package moe.clienthax.pixelmonbridge.impl.mixin.core.storage;

import com.pixelmonmod.pixelmon.config.PixelmonConfig;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.storage.PlayerComputerStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import moe.clienthax.pixelmonbridge.api.data.FixedSizeList;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pixelmon;
import moe.clienthax.pixelmonbridge.api.storage.ComputerBox;
import moe.clienthax.pixelmonbridge.api.storage.ComputerStorage;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Justin
 */
@Mixin(PlayerComputerStorage.class)
public abstract class MixinPlayerComputerStorage implements ComputerStorage {
    @Shadow
    public PlayerStorage playerStorage;
    @Shadow
    public int lastBoxOpen;

    @Shadow
    private com.pixelmonmod.pixelmon.storage.ComputerBox[] storageBoxes;

    @Shadow
    public abstract com.pixelmonmod.pixelmon.storage.ComputerBox getBoxFromPosition(int pos);

    @Shadow
    public abstract EntityPixelmon getPokemonEntity(int[] pokemonID, World world);

    @Shadow
    public abstract boolean hasChanges();

    @Override
    public boolean addToComputer(Pixelmon pokemon) {
        for (ComputerBox c : getBoxes()) {
            if (!c.hasSpace()) continue;
            c.addToFirstSpace(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public void updatePokemon(Pixelmon p) {
        for (ComputerBox b : getBoxes()) {
            if (!b.contains(p.getPokemonId())) continue;
            b.updatePokemon(p);
        }
    }

    @Override
    public boolean contains(Pixelmon p) {
        return contains(p.getPokemonId());
    }

    @Override
    public void setChanged(Pixelmon p) {
        setChanged(p.getPokemonId());
    }

    @Override
    public ComputerBox getBox(int pos) {
        return (ComputerBox) getBoxFromPosition(pos);
    }

    @Override
    public void addToBox(int originalBox, Pixelmon n) {
        getBox(originalBox).add(n);
    }

    @Override
    public Pixelmon getPokemon(int[] pokemonID) {
        return (Pixelmon) getPokemonEntity(pokemonID, playerStorage.getPlayer().world);
    }

    @Override
    public void changePokemon(int box, int boxPos, Pixelmon n) {
        ((ComputerBox) storageBoxes[box]).changePokemon(boxPos, n);
    }

    public FixedSizeList<ComputerBox> getBoxes() {
        return new FixedSizeList<>(PixelmonConfig.computerBoxes, Arrays.stream(storageBoxes).<ComputerBox>map(c -> (ComputerBox) c).collect(Collectors.toList()));
    }

    @Override
    public void update(FixedSizeList<ComputerBox> boxes) {
        storageBoxes = boxes.toArray(com.pixelmonmod.pixelmon.storage.ComputerBox.class, b -> {
            com.pixelmonmod.pixelmon.storage.ComputerBox b1 = (com.pixelmonmod.pixelmon.storage.ComputerBox) b;
            b1.hasChanged = true;
            return b1;
        });
    }
}