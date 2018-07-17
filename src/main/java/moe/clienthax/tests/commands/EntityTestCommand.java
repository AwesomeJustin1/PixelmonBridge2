package moe.clienthax.tests.commands;

import moe.clienthax.pixelmonbridge.api.catalog.pixelmon.PixelmonType;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Collection;

/**
 * Created by clienthax on 05/03/2018.
 */
public class EntityTestCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player))
            return CommandResult.success();

        Player player = (Player) src;

        System.out.println(player.getContainers());

        Collection<Entity> nearbyEntities = player.getNearbyEntities(50);
        for (Entity nearbyEntity : nearbyEntities) {
            if (!(nearbyEntity.getType() instanceof PixelmonType))
                continue;

            System.out.println(nearbyEntity.getContainers());

            System.out.println(nearbyEntity.get(PixelmonDataKeys.POKEMON_BASESTATS_HP).get());
            MutableBaseStatsData mutableBaseStatsData = nearbyEntity.get(MutableBaseStatsData.class).get();
            System.out.println(mutableBaseStatsData.attack().get());
            System.out.println(mutableBaseStatsData.hp().get());

        }


        return CommandResult.success();
    }


}
