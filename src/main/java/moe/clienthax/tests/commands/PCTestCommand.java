package moe.clienthax.tests.commands;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by clienthax on 10/03/2018.
 */
public class PCTestCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player player = (Player) src;

        Location<World> pcloc = player.getLocation().add(-1, 0, 0);
        System.out.println(pcloc);

        if(pcloc.getTileEntity().isPresent()) {
            TileEntity tileEntity = pcloc.getTileEntity().get();

            Optional<UUID> uuid = tileEntity.get(PixelmonDataKeys.COMPUTER_OWNER).get();
            DyeColor dyeColor = tileEntity.get(PixelmonDataKeys.COMPUTER_COLOR).get();
            Boolean ravemode = tileEntity.get(PixelmonDataKeys.COMPUTER_RAVE_MODE).get();

            tileEntity.offer(PixelmonDataKeys.COMPUTER_RAVE_MODE, true);

            System.out.println(uuid.isPresent()+" "+dyeColor.getId()+" "+ravemode);

        } else {
            System.out.println("Wheres mah tile entity!?");
        }


        return CommandResult.success();
    }

}
