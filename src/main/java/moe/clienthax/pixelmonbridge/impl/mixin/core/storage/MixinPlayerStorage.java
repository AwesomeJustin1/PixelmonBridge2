package moe.clienthax.pixelmonbridge.impl.mixin.core.storage;

import com.pixelmonmod.pixelmon.storage.BaseStorage;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerComputerStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import moe.clienthax.pixelmonbridge.api.entity.Player;
import moe.clienthax.pixelmonbridge.api.storage.ComputerStorage;
import org.spongepowered.asm.mixin.Mixin;

import java.util.UUID;

/**
 * Created by Justin
 */
@Mixin(PlayerStorage.class)
public abstract class MixinPlayerStorage extends BaseStorage implements moe.clienthax.pixelmonbridge.api.storage.PlayerStorage {
    PlayerComputerStorage computerStorage;

    public MixinPlayerStorage(UUID uuid) {
        super(uuid);
    }

    @Override
    public ComputerStorage getComputer() {
        if (computerStorage == null)
            computerStorage = PixelmonStorage.computerManager.getPlayerStorage(getPlayer());
        return (ComputerStorage) computerStorage;
    }

    public Player getOwner() {
        return (Player) super.getPlayer();
    }
}