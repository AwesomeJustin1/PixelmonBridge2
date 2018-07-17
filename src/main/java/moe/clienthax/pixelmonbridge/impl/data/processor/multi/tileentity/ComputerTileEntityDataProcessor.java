package moe.clienthax.pixelmonbridge.impl.data.processor.multi.tileentity;

import com.google.common.collect.ImmutableMap;
import com.pixelmonmod.pixelmon.blocks.tileEntities.TileEntityPC;
import com.pixelmonmod.pixelmon.storage.NbtKeys;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.tileentity.ImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity.MutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.tileentity.PixelmonMutableComputerTileEntityData;
import net.minecraft.item.EnumDyeColor;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.common.data.processor.common.AbstractTileEntityDataProcessor;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by clienthax on 10/03/2018.
 */
public class ComputerTileEntityDataProcessor extends AbstractTileEntityDataProcessor<TileEntityPC, MutableComputerTileEntityData, ImmutableComputerTileEntityData> {

    public ComputerTileEntityDataProcessor() {
        super(TileEntityPC.class);
    }

    @Override
    protected boolean doesDataExist(TileEntityPC dataHolder) {
        return true;
    }

    @Override
    protected boolean set(TileEntityPC dataHolder, Map<Key<?>, Object> keyValues) {
        Optional<UUID> owner = (Optional<UUID>) keyValues.get(PixelmonDataKeys.COMPUTER_OWNER);
        dataHolder.setOwner(owner.orElse(null));
        dataHolder.setColour(((DyeColor) keyValues.get(PixelmonDataKeys.COMPUTER_COLOR)).getId().toLowerCase());
        dataHolder.setRave((boolean) keyValues.get(PixelmonDataKeys.COMPUTER_RAVE_MODE));
        return true;
    }

    @Override
    protected Map<Key<?>, ?> getValues(TileEntityPC dataHolder) {
        ImmutableMap.Builder<Key<?>, Object> builder = ImmutableMap.builder();
        builder.put(PixelmonDataKeys.COMPUTER_OWNER, Optional.ofNullable(dataHolder.getOwnerUUID()));
        builder.put(PixelmonDataKeys.COMPUTER_COLOR, (DyeColor) (Object) EnumDyeColor.valueOf(dataHolder.getColour().toUpperCase()));
        builder.put(PixelmonDataKeys.COMPUTER_RAVE_MODE, dataHolder.getRave());
        return builder.build();
    }

    @Override
    protected MutableComputerTileEntityData createManipulator() {
        return new PixelmonMutableComputerTileEntityData();
    }

    @Override
    public Optional<MutableComputerTileEntityData> fill(DataContainer container, MutableComputerTileEntityData mutableComputerTileEntityData) {

        Optional<UUID> ownerUUID = Optional.empty();
        Optional<String> ownerMaybe = container.getString(DataQuery.of("UnsafeData", NbtKeys.PC_OWNER));
        if (ownerMaybe.isPresent()) {
            ownerUUID = Optional.of(UUID.fromString(ownerMaybe.get()));
        }
        String colorName = container.getString(DataQuery.of("UnsafeData", NbtKeys.PC_COLOUR)).get();
        DyeColor dyeColor = (DyeColor) (Object) EnumDyeColor.valueOf(colorName.toUpperCase());

        Boolean raveMode = container.getBoolean(DataQuery.of("UnsafeData", NbtKeys.PC_RAVE)).get();

        return Optional.of(new PixelmonMutableComputerTileEntityData(ownerUUID, dyeColor, raveMode));

    }

    @Override
    public DataTransactionResult remove(DataHolder dataHolder) {
        return DataTransactionResult.failNoData();
    }

}
