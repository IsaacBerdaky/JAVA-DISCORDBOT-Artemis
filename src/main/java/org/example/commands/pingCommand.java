package org.example.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class pingCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("Pong! 🏓").queue();    }
}
