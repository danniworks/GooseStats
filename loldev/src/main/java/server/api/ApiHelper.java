package server.api;

import server.controller.ObjectController;

import java.io.IOException;

/**
 *  All api related data processed in this class
 */
public class ApiHelper {

    private String key = "RGAPI-f3a7eb35-924c-45da-a6c2-a38ce7bda804";
    private String filter;
    private String summonerName;
    public ObjectController obj = new ObjectController();

    public ApiHelper(String data, String type) {
        summonerName = data;
        filter = type;
    }

    /**
     * Perform action according to filter to update ret
     *
     * @throws IOException
     */
    public void doReq() throws IOException {
        String params = "?api_key=" + key;

        if (filter.equals("profile")) {
            String url_Profile = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/" + summonerName;
            String url_RankedStats = "https://na1.api.riotgames.com/lol/league/v3/positions/by-summoner/";
            String urls[] = {params, url_Profile, url_RankedStats};
            obj.setUrls(urls);
            obj.getHtml(filter);
        }
    }

    public String getRet(){
        return obj.getRet();
    }

    public String getErrorMessage() {
        String html;
        html = "<div class=\"errorMessage\">" +
                "<a id=\"errorA\">Summoner Not Found</a>" +
                "</div>";
        return html;
    }


}
