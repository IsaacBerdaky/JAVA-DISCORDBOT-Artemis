package org.example.commands.fun;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.example.commands.Command;

import java.util.Random;

public class CoinCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {
        Random r = new Random();
        int randomVal = r.nextInt(10) + 1;
        if (randomVal < 5 ) {
            event.getChannel().sendMessage("**Coroa!**").queue();
        } else {
            event.getChannel().sendMessage("**Cara**").queue();
        }
    }
}
