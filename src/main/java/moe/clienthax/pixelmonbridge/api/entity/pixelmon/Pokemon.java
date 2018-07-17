package moe.clienthax.pixelmonbridge.api.entity.pixelmon;

import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.world.World;

/**
 * Can be safely casted to and from NBTTagCompound when NBTTagCompound represents a pokemon
 * Created by Justin
 */
public interface Pokemon extends PokemonData {
    static Pokemon from(String... args) {
        return (Pokemon) new PokemonSpec(args).writeToNBT(new NBTTagCompound());
    }

    static Pokemon from(String args) {
        return from(args.split(" "));
    }

    default ItemStack getPhoto() {
        return (ItemStack) (Object) ItemPixelmonSprite.getPhoto((EntityPixelmon) create(Sponge.getServer().getWorld(Sponge.getServer().getDefaultWorldName()).get()));
    }

    default Pixelmon create(World world) {
        return (Pixelmon) PixelmonEntityList.createEntityFromNBT((NBTTagCompound) this, (net.minecraft.world.World) world);
    }
}
