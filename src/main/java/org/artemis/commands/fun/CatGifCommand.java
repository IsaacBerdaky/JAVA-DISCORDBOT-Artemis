package org.artemis.commands.fun;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.artemis.commands.Command;
import org.artemis.utils.HttpUtils;

public class CatGifCommand implements Command {
    Dotenv dotenv = Dotenv.load();
    String API_KEY = dotenv.get("GIPHY_KEY");

    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {
        String gifUrl = fetchRandomCatGif();

        if (gifUrl == null) {
            event.getChannel().sendMessage("Não consegui achar um GIF de gato agora 😿").queue();
            return;
        }

        event.getChannel().sendMessage(gifUrl).queue();
    }

    private String fetchRandomCatGif() {
        try {
            String endpoint = "https://api.giphy.com/v1/gifs/random?api_key=" + API_KEY + "&tag=cat&rating=g";

            String response = HttpUtils.get(endpoint);

            int urlIndex = response.indexOf("\"url\":");
            if (urlIndex == -1) return null;

            String sub = response.substring(urlIndex + 7);
            int endIndex = sub.indexOf("\"");

            return sub.substring(0, endIndex);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
