package moe.clienthax.pixelmonbridge.api.catalog.growth;

import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.lang.reflect.Field;

/**
 * Created by Justin
 */
@CatalogedBy(Growths.class)
public interface Growth extends CatalogType {
    default String getCatalogName() {
        for (Field field : Growths.class.getDeclaredFields()) {
            try {
                if (field.get(null) == this) {
                    String name = field.getName().toLowerCase();
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    return name;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return "Ordinary";
    }

    default int getIndex() {
        return EnumGrowth.valueOf(getCatalogName()).index;
    }
}
