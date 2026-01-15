package org.example.managers;

import org.example.commands.*;
import org.example.commands.basic.InfoCommand;
import org.example.commands.basic.PingCommand;
import org.example.commands.fun.CatGifCommand;
import org.example.commands.fun.CoinCommand;
import org.example.commands.fun.DiceCommand;
import org.example.commands.fun.JokeCommand;

import java.util.Collection;
import java.util.HashMap;

public class CommandManager {

    private final HashMap<String, Command> commands = new HashMap<>();

    public CommandManager(){

        // Basic
        commands.put("ping", new PingCommand());
        commands.put("info", new InfoCommand());

        // Fun
        commands.put("1d20", new DiceCommand());
        commands.put("coinflip", new CoinCommand());
        commands.put("piada", new JokeCommand());
        commands.put("catgif", new CatGifCommand());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName.toLowerCase());
    }

    public Collection<Command> getAllCommands() {
        return commands.values();
    }
}

