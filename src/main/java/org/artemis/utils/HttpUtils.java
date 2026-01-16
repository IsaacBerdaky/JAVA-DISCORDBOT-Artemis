package org.artemis.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    public static String get(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setConnectTimeout(8000);
        con.setReadTimeout(8000);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        return content.toString();
    }
}
