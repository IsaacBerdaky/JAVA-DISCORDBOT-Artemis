package org.example.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {
    void executeCommand(MessageReceivedEvent event, String[] args);
}
