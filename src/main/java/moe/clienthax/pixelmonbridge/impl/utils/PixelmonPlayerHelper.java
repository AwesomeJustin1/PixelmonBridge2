package moe.clienthax.pixelmonbridge.impl.utils;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import moe.clienthax.pixelmonbridge.api.utils.PlayerHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.player.Player;

public class PixelmonPlayerHelper implements PlayerHelper {

    @Override
    public void addToParty(Player player, EntitySnapshot snapshot) {
        try {
            PlayerStorage computerStorage = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP) player).get();//TODO bad
            computerStorage.addToParty((EntityPixelmon) snapshot.withLocation(player.getLocation()).restore().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
