package moe.clienthax.pixelmonbridge.impl.utils;

import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerComputerStorage;
import moe.clienthax.pixelmonbridge.api.utils.ComputerHelper;
import net.minecraft.world.World;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.common.entity.SpongeEntitySnapshot;

public class PixelmonComputerHelper implements ComputerHelper {

    @Override
    public void addToComputer(Player player, EntitySnapshot snapshot) {
        try {
            PlayerComputerStorage computerStorage = PixelmonStorage.computerManager.getPlayerStorageFromUUID((World) player.getWorld(), player.getUniqueId());
            computerStorage.addToComputer(((SpongeEntitySnapshot) snapshot.withLocation(player.getLocation())).getCompound().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
