package moe.clienthax.pixelmonbridge.impl;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.config.*;
import jdk.nashorn.internal.ir.Block;
import moe.clienthax.pixelmonbridge.api.PixelmonBridgeAPI;
import moe.clienthax.pixelmonbridge.api.block.PixelmonBlockTypes;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.*;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player.ImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.item.ImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.tileentity.ImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.*;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.item.MutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity.MutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.api.item.PixelmonItemTypes;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.*;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.player.PixelmonImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.item.PixelmonImmutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.tileentity.PixelmonImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.*;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.player.PixelmonMutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.item.PixelmonMutablePixelmonSpriteItemData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.tileentity.PixelmonMutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon.BaseStatsDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon.EVDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon.IVDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.player.PartyPokemonProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.item.PixelmonSpriteItemDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.multi.tileentity.ComputerTileEntityDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.single.entity.pixelmon.EggDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.single.entity.pixelmon.NameDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.single.entity.pixelmon.NickNameDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.single.entity.pixelmon.PokemonIDDataProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.entity.pixelmon.basestats.*;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.entity.pixelmon.evs.*;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.entity.pixelmon.ivs.*;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.item.SpritePathValueProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity.ComputerColorValueProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity.ComputerOwnerValueProcessor;
import moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity.ComputerRaveValueProcessor;
import moe.clienthax.pixelmonbridge.impl.utils.PixelmonBlockHelper;
import moe.clienthax.pixelmonbridge.impl.utils.PixelmonComputerHelper;
import moe.clienthax.pixelmonbridge.impl.utils.PixelmonPlayerHelper;
import moe.clienthax.pixelmonbridge.impl.utils.PixelmonPokemonHelper;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.common.data.util.DataUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by clienthax on 09/03/2018.
 */
@Plugin(name = "PixelmonBridge", version = "0.1", id = "pixelmonbridge", description = "bridge for pixelmon api", authors = {"Clienthax","Justin"}, dependencies = @Dependency(id = "pixelmon"))
public class PixelmonBridge {

    public static void setStaticFinalField(Field field, Object value) throws ReflectiveOperationException {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, value);
    }

    @Listener(order = Order.LATE)
    public void onPreInit(GamePreInitializationEvent event) {
        registerHelpers();
        registerData();
        for (Class aClass : new Class[]{PixelmonBlocks.class, PixelmonBlocksApricornTrees.class, PixelmonBlocksBerryTrees.class}) {
            for (Field field : aClass.getDeclaredFields()) {
                try {
                    if (field.get(null) instanceof BlockType) {
                        BlockType block = (BlockType) field.get(null);
                        try {
                            setStaticFinalField(PixelmonBlockTypes.class.getDeclaredField(block.getName().split(":")[1]), block);
                        } catch (Exception e) {
                            Pixelmon.LOGGER.error("Can't find entry for " + block.getName() + " in PixelmonBlockTypes");
                            e.printStackTrace();
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Class aClass : new Class[]{PixelmonItems.class,
                PixelmonItemsPokeballs.class,
                PixelmonItemsApricorns.class,
                PixelmonItemsBadgecases.class,
                PixelmonItemsBadges.class,
                PixelmonItemsFossils.class,
                PixelmonItemsHeld.class,
                PixelmonItemsMail.class,
                PixelmonItemsTools.class
        }) {
            for (Field field : aClass.getDeclaredFields()) {
                try {
                    if (field.get(null) instanceof ItemType) {
                        ItemType item = (ItemType) field.get(null);
                        try {
                            setStaticFinalField(PixelmonItemTypes.class.getDeclaredField(item.getName().split(":")[1]), item);
                        } catch (Exception e) {
                            Pixelmon.LOGGER.error("Can't find entry for " + item.getName() + " in PixelmonItemTypes");
                            e.printStackTrace();
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        PixelmonItemsTMs.HMs.forEach(i->{
            ItemType item = (ItemType) i;
            try {
                setStaticFinalField(PixelmonItemTypes.class.getDeclaredField(item.getName().split(":")[1]), item);
            } catch (Exception e) {
                Pixelmon.LOGGER.error("Can't find entry for " + item.getName() + " in PixelmonItemTypes");
                e.printStackTrace();
            }
        });
        PixelmonItemsTMs.TMs.forEach(i->{
            ItemType item = (ItemType) i;
            try {
                setStaticFinalField(PixelmonItemTypes.class.getDeclaredField(item.getName().split(":")[1]), item);
            } catch (Exception e) {
                Pixelmon.LOGGER.error("Can't find entry for " + item.getName() + " in PixelmonItemTypes");
                e.printStackTrace();
            }
        });
    }

    private void registerHelpers() {
        try {
            setStaticFinalField(PixelmonBridgeAPI.class.getDeclaredField("pokemonHelper"), new PixelmonPokemonHelper());
            setStaticFinalField(PixelmonBridgeAPI.class.getDeclaredField("computerHelper"), new PixelmonComputerHelper());
            setStaticFinalField(PixelmonBridgeAPI.class.getDeclaredField("blockHelper"), new PixelmonBlockHelper());
            setStaticFinalField(PixelmonBridgeAPI.class.getDeclaredField("playerHelper"), new PixelmonPlayerHelper());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerData() {

        /**
         * Item data
         */
        DataUtil.registerDataProcessorAndImpl(MutablePixelmonSpriteItemData.class, PixelmonMutablePixelmonSpriteItemData.class, ImmutablePixelmonSpriteItemData.class, PixelmonImmutablePixelmonSpriteItemData.class, new PixelmonSpriteItemDataProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.SPRITE_NAME, new SpritePathValueProcessor());


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
         * IV Data
         */
        DataUtil.registerDataProcessorAndImpl(MutableIVData.class, PixelmonMutableIVData.class, ImmutableIVData.class, PixelmonImmutableIVData.class, new IVDataProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_HP_IVS, new HPIVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_ATTACK_IVS, new AttackIVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_DEFENSE_IVS, new DefenseIVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, new SPAttackIVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, new SPDefenseIVSValueProcessor());
        DataUtil.registerValueProcessor(PixelmonDataKeys.POKEMON_SPEED_IVS, new SpeedIVSValueProcessor());

        /**
         * Misc pokemon data
         */
        DataUtil.registerDualProcessor(MutableEggData.class, PixelmonMutableEggData.class, ImmutableEggData.class, PixelmonImmutableEggData.class, new EggDataProcessor());
        DataUtil.registerDualProcessor(MutableNameData.class, PixelmonMutableNameData.class, ImmutableNameData.class, PixelmonImmutableNameData.class, new NameDataProcessor());
        DataUtil.registerDualProcessor(MutableNickNameData.class, PixelmonMutableNickNameData.class, ImmutableNickNameData.class, PixelmonImmutableNickNameData.class, new NickNameDataProcessor());
        DataUtil.registerDualProcessor(MutablePokemonIDData.class, PixelmonMutablePokemonIDData.class, ImmutablePokemonIDData.class, PixelmonImmutablePokemonIDData.class, new PokemonIDDataProcessor());

        /**
         * moe.clienthax.pixelmonbridge.api.entity.Player Data
         */
        DataUtil.registerDualProcessor(MutablePartyPokemonData.class, PixelmonMutablePartyPokemonData.class, ImmutablePartyPokemonData.class, PixelmonImmutablePartyPokemonData.class, new PartyPokemonProcessor());
        //DataUtil.registerDualProcessor(MutableComputerPokemonData.class, PixelmonMutableComputerPokemonData.class, ImmutableComputerPokemonData.class, PixelmonImmutableComputerPokemonData.class, new ComputerPokemonProcessor());


    }
}
