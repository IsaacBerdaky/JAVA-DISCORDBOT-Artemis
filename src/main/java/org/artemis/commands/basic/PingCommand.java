package org.artemis.commands.basic;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.artemis.commands.Command;

public class PingCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("Pong! 🏓 | " + "**" + event.getJDA().getGatewayPing() + "ms**").queue();    }
}
