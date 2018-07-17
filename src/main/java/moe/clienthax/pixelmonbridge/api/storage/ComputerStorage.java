package moe.clienthax.pixelmonbridge.api.storage;

import moe.clienthax.pixelmonbridge.api.data.FixedSizeList;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pixelmon;

/**
 * Created by Justin
 */
public interface ComputerStorage {

    void addToBox(int originalBox, Pixelmon n);


    boolean addToComputer(Pixelmon pokemon);


    int count();


    void changePokemon(int box, int boxPos, Pixelmon n);


    ComputerBox getBox(int boxNumber);


    FixedSizeList<ComputerBox> getBoxes();

    void update(FixedSizeList<ComputerBox> boxes);

    Pixelmon getPokemon(int[] pokemonID);


    boolean hasChanges();


    boolean contains(int[] pokemonID);


    void setChanged(int[] pokemonID);


    boolean contains(Pixelmon p);


    void setChanged(Pixelmon p);


    void updatePokemon(Pixelmon p);
}
