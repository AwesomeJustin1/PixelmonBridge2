package moe.clienthax.pixelmonbridge.api.storage;

import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pixelmon;

/**
 * Created by Justin
 */
public interface ComputerBox {

    boolean hasSpace();


    boolean contains(int[] id);


    int count();


    void add(Pixelmon p);


    int getNextSpace();


    Pixelmon getPokemon(int[] id);


    Pixelmon[] getAllPokemon();


    Pixelmon getByPosition(int pos);


    void load(Pixelmon boxTag);


    void save(Pixelmon nbt);


    void addToFirstSpace(Pixelmon n);


    void changePokemon(int boxPos, Pixelmon n);


    int getPlayerIdFromPokemon();


    void updatePokemon(Pixelmon p);


    void unlockAllPokemon();
}
