package moe.clienthax.tests.commands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;

import java.util.Collection;

/**
 * Created by clienthax on 05/03/2018.
 */
public class BlockTestCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(!(src instanceof Player))
            return CommandResult.success();

        Player player = (Player) src;


        System.out.println("Block Types");

        Collection<BlockType> pixelmonItems = Sponge.getRegistry().getAllFor("pixelmon", BlockType.class);
        for (BlockType pixelmonItem : pixelmonItems) {
            System.out.println("public static final ItemType "+pixelmonItem.getName().toUpperCase()+" = Sponge.getRegistry().getType(ItemType.class, \""+pixelmonItem.getId()+"\").get();");
        }




        return CommandResult.success();
    }


}
