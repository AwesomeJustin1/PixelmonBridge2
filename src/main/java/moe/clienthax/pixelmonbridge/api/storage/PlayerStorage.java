package moe.clienthax.pixelmonbridge.api.storage;

import moe.clienthax.pixelmonbridge.api.data.FixedSizeList;
import moe.clienthax.pixelmonbridge.api.entity.Player;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pixelmon;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pokemon;

/**
 * Created by Justin
 */
public interface PlayerStorage {
    FixedSizeList<Pixelmon> getPartyPokemon();

    ComputerStorage getComputer();

    void removeFromParty(int pos);

    void removeFromComputer(int box, int pos);

    void removeFromParty(Pokemon pokemon);

    Player getOwner();
}
