package org.example.managers;

import  org.example.commands.*;

import java.util.HashMap;

public class CommandManager {
    private final HashMap<String, Command> commands = new HashMap<>();
    public CommandManager(){
        commands.put("ping", new pingCommand());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName.toLowerCase());
    }
}
