package moe.clienthax.pixelmonbridge.impl;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player.ImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item.ImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.tileentity.ImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity.MutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.player.PixelmonImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.item.PixelmonImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.tileentity.PixelmonImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.player.PixelmonMutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.item.PixelmonMutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.tileentity.PixelmonMutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.player.PartyPokemonProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.item.PixelmonSpriteItemDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.tileentity.ComputerTileEntityDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.item.SpritePathValueProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity.ComputerColorValueProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity.ComputerOwnerValueProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity.ComputerRaveValueProcessor;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.common.data.util.DataUtil;

import static moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys.SPRITE_NAME;

/**
 * Created by clienthax on 09/03/2018.
 */
@Plugin(name = "PixelmonBridge", version = "0.1", id = "pixelmonbridge", description = "bridge for pixelmon api", dependencies = @Dependency(id = "pixelmon"))
public class PixelmonBridge {

    @Listener
    public void onPreInit(GamePreInitializationEvent event) {
        registerData();


    }

    private void registerData() {

        DataUtil.registerDataProcessorAndImpl(MutablePixelmonSpriteItemData.class, PixelmonMutablePixelmonSpriteItemData.class,
                ImmutablePixelmonSpriteItemData.class, PixelmonImmutablePixelmonSpriteItemData.class,
                new PixelmonSpriteItemDataProcessor()
        );

        DataUtil.registerValueProcessor(SPRITE_NAME, new SpritePathValueProcessor());


        /**
         * Tile entity data
         */
        //TileEntityPC
        DataUtil.registerDataProcessorAndImpl(MutableComputerTileEntityData.class, PixelmonMutableComputerTileEntityData.class, ImmutableComputerTileEntityData.class, PixelmonImmutableComputerTileEntityData.class, new ComputerTileEntityDataProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.COMPUTER_OWNER, new ComputerOwnerValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.COMPUTER_COLOR, new ComputerColorValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.COMPUTER_RAVE_MODE, new ComputerRaveValueProcessor());

        /**
         * Player Data
         */
        DataUtil.registerDualProcessor(MutablePartyPokemonData.class, PixelmonMutablePartyPokemonData.class, ImmutablePartyPokemonData.class, PixelmonImmutablePartyPokemonData.class, new PartyPokemonProcessor());
        //DataUtil.registerDualProcessor(MutableComputerPokemonData.class, PixelmonMutableComputerPokemonData.class, ImmutableComputerPokemonData.class, PixelmonImmutableComputerPokemonData.class, new ComputerPokemonProcessor());


    }


}
