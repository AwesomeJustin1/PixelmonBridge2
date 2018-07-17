package moe.clienthax.pixelmonbridge.api.catalog.aggression;

import com.pixelmonmod.pixelmon.entities.pixelmon.EnumAggression;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.lang.reflect.Field;

/**
 * Created by Justin
 */
@CatalogedBy(Aggressions.class)
public interface Aggression extends CatalogType {
    default String getCatalogName() {
        try {
            for (Field field : Aggressions.class.getDeclaredFields()) {
                if (field.get(null) == this)
                    return field.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TF happened here lol";
    }

    default int getIndex() {
        String name = getCatalogName();
        for (EnumAggression aggression : EnumAggression.values()) {
            if (aggression.name().equalsIgnoreCase(name))
                return aggression.index;
        }
        return 0;
    }
}
