package org.artemis.commands.fun;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.artemis.commands.Command;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class JokeCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {

        try {
            InputStream input = getClass().getResourceAsStream("/jokes.json");

            if (input == null) {
                event.getChannel().sendMessage("Erro: A Lista de piadas nao pode ser encontrada!").queue();
                return;
            }

            Gson gson = new Gson();
            JsonObject obj = gson.fromJson(new InputStreamReader(input), JsonObject.class);

            JsonArray jokes = obj.getAsJsonArray("jokes");

            Random r = new Random();
            int index = r.nextInt(jokes.size());
            String joke = jokes.get(index).getAsString();

            event.getChannel().sendMessage(joke).queue();

        } catch (Exception e) {
            event.getChannel().sendMessage("Erro ao carregar as piadas.").queue();
            e.printStackTrace();
        }
    }
}
