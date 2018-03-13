package moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon;

import com.google.common.collect.ImmutableMap;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableIVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableIVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableEVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableIVData;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.common.data.processor.common.AbstractEntityDataProcessor;

import java.util.Map;
import java.util.Optional;

/**
 * Created by clienthax on 12/03/2018.
 */

public class IVDataProcessor extends AbstractEntityDataProcessor<EntityPixelmon, MutableIVData, ImmutableIVData> {

    public IVDataProcessor() {
        super(EntityPixelmon.class);
    }

    @Override
    protected boolean doesDataExist(EntityPixelmon dataHolder) {
        return true;
    }

    @Override
    protected boolean set(EntityPixelmon dataHolder, Map<Key<?>, Object> keyValues) {
        dataHolder.stats.IVs.HP = (int) keyValues.get(PixelmonDataKeys.POKEMON_HP_IVS);
        dataHolder.stats.IVs.Attack = (int) keyValues.get(PixelmonDataKeys.POKEMON_ATTACK_IVS);
        dataHolder.stats.IVs.Defence = (int) keyValues.get(PixelmonDataKeys.POKEMON_DEFENSE_IVS);
        dataHolder.stats.IVs.SpAtt = (int) keyValues.get(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS);
        dataHolder.stats.IVs.SpDef = (int) keyValues.get(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS);
        dataHolder.stats.IVs.Speed = (int) keyValues.get(PixelmonDataKeys.POKEMON_SPEED_IVS);
        return true;
    }

    @Override
    protected Map<Key<?>, ?> getValues(EntityPixelmon dataHolder) {
        ImmutableMap.Builder<Key<?>, Object> builder = ImmutableMap.builder();
        builder.put(PixelmonDataKeys.POKEMON_HP_IVS, dataHolder.stats.IVs.HP);
        builder.put(PixelmonDataKeys.POKEMON_ATTACK_IVS, dataHolder.stats.IVs.Attack);
        builder.put(PixelmonDataKeys.POKEMON_DEFENSE_IVS, dataHolder.stats.IVs.Defence);
        builder.put(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, dataHolder.stats.IVs.SpAtt);
        builder.put(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, dataHolder.stats.IVs.SpDef);
        builder.put(PixelmonDataKeys.POKEMON_SPEED_IVS, dataHolder.stats.IVs.Speed);
        return builder.build();
    }

    @Override
    protected MutableIVData createManipulator() {
        return new PixelmonMutableIVData();
    }

    @Override
    public Optional<MutableIVData> fill(DataContainer container, MutableIVData mutableIVData) {
        System.out.println("ivdataprocessr->fill");
        return Optional.empty();
    }

    @Override
    public DataTransactionResult remove(DataHolder dataHolder) {
        return DataTransactionResult.failNoData();
    }

}
