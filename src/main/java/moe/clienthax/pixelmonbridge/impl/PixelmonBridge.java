package moe.clienthax.pixelmonbridge.impl;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player.ImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item.ImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.tileentity.ImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity.MutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableBaseStatsData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableEVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.player.PixelmonImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.item.PixelmonImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.tileentity.PixelmonImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableBaseStatsData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableEVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.player.PixelmonMutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.item.PixelmonMutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.tileentity.PixelmonMutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon.BaseStatsDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon.EVDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.player.PartyPokemonProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.item.PixelmonSpriteItemDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.tileentity.ComputerTileEntityDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.entity.pixelmon.basestats.*;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.entity.pixelmon.evs.*;
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
         * Base Stat Data
         */
        DataUtil.registerDataProcessorAndImpl(MutableBaseStatsData.class, PixelmonMutableBaseStatsData.class, ImmutableBaseStatsData.class, PixelmonImmutableBaseStatsData.class, new BaseStatsDataProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_BASESTATS_HP, new BaseStatsHPValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, new BaseStatsAttackValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, new BaseStatsDefenseValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, new BaseStatsSPAttackValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, new BaseStatsSPDefenseValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, new BaseStatsSpeedValueProcessor());

        /**
         * EV Data
         */
        DataUtil.registerDataProcessorAndImpl(MutableEVData.class, PixelmonMutableEVData.class, ImmutableEVData.class, PixelmonImmutableEVData.class, new EVDataProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_HP_EVS, new HPEVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_ATTACK_EVS, new AttackEVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_DEFENSE_EVS, new DefenseEVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, new SPAttackEVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, new SPDefenseEVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_SPEED_EVS, new SpeedEVSValueProcessor());

        /**
         * Player Data
         */
        DataUtil.registerDualProcessor(MutablePartyPokemonData.class, PixelmonMutablePartyPokemonData.class, ImmutablePartyPokemonData.class, PixelmonImmutablePartyPokemonData.class, new PartyPokemonProcessor());
        //DataUtil.registerDualProcessor(MutableComputerPokemonData.class, PixelmonMutableComputerPokemonData.class, ImmutableComputerPokemonData.class, PixelmonImmutableComputerPokemonData.class, new ComputerPokemonProcessor());


    }


}
