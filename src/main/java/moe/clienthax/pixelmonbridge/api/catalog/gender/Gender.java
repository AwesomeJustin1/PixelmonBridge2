package moe.clienthax.pixelmonbridge.api.catalog.gender;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.lang.reflect.Field;

/**
 * Created by Justin
 */
@CatalogedBy(Genders.class)
public interface Gender extends CatalogType {
    default String getCatalogName() {
        for (Field field : Genders.class.getDeclaredFields()) {
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
        return "None";
    }

    default int getIndex() {
        return com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender.getGender(getCatalogName()).ordinal();
    }
}
