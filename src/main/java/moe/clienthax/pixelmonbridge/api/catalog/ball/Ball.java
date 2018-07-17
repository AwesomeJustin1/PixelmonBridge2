package moe.clienthax.pixelmonbridge.api.catalog.ball;

import com.pixelmonmod.pixelmon.config.PixelmonItemsPokeballs;
import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import com.pixelmonmod.pixelmon.items.ItemPokeball;
import com.pixelmonmod.pixelmon.items.ItemPokeballDisc;
import com.pixelmonmod.pixelmon.items.ItemPokeballLid;
import net.minecraft.item.Item;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.lang.reflect.Field;

@CatalogedBy(Balls.class)
public interface Ball extends CatalogType {
    static Ball fromEnum(EnumPokeballs ball) {
        try {
            for (Field field : Balls.class.getDeclaredFields()) {
                if (field.getName().equalsIgnoreCase(ball.getFilenamePrefix()))
                    return (Ball) field.get(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Balls.POKE_BALL;
    }

    default EnumPokeballs getEnum() {
        try {
            for (Field field : Balls.class.getDeclaredFields()) {
                if (field.get(null) == this)
                    return EnumPokeballs.getPokeballFromString(field.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EnumPokeballs.PokeBall;
    }

    default double getBreakChance() {
        return getEnum().getBreakChance();
    }

    default double getBallBonus() {
        return getEnum().getBallBonus();
    }

    default int getIndex() {
        return getEnum().getIndex();
    }

    default ItemPokeball getItem() {
        return PixelmonItemsPokeballs.getItemFromEnum(getEnum());
    }

    default ItemPokeballLid getLid() {
        return PixelmonItemsPokeballs.getLidFromEnum(getEnum());
    }

    default ItemPokeballDisc getDisc() {
        return PixelmonItemsPokeballs.getDiscFromEnum(getEnum());
    }

    default Item getItem(int type) {
        switch (type) {
            case 0:
                return getEnum().getItem();
            case 1:
                return getEnum().getLid();
            case 2:
                return getEnum().getDisc();
            default:
                return null;
        }
    }
}