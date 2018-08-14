package ui.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import server.controller.HttpHelper;
import ui.model.SummonerRankedProfile;
import ui.model.SummonerRankedStats;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The purpose of this class is to fully utilize Summoner profile models to build a complete profile to be returned.
 */
public class ProfileBuilder {

    private SummonerRankedProfile summonerRP;
    private List<SummonerRankedStats> summonerRS;

    private String[] links = new String[3]; // [Key, Profile, RankedStats]

    private HttpHelper req = new HttpHelper();

    private boolean error = false;

    private static final Map<String, String> borderColor;
    static
    {
        borderColor = new LinkedHashMap<String, String>();
        borderColor.put("Unranked", "404040");
        borderColor.put("BRONZE", "6A4825");
        borderColor.put("SILVER", "90A1B5");
        borderColor.put("GOLD", "BBA630");
        borderColor.put("PLATINUM", "00a851");
        borderColor.put("DIAMOND", "1C75BB");
        borderColor.put("MASTER", "FEFFF6");
        borderColor.put("CHALLENGER", "BB7A0C");
    }

    public ProfileBuilder(){ }

    public ProfileBuilder(String[] urls) throws IOException {
        links = urls;
        buildProfile();
    }

    public void buildProfile()  throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String key = links[0];
        String json;

        String url_Profile = links[1] + key;
        json = req.getJson(url_Profile);

        try {
            summonerRP = objectMapper.readValue(json, SummonerRankedProfile.class);
            String url_RankedStats = links[2] + summonerRP.getId() + key;
            json = req.getJson(url_RankedStats);
            summonerRS = objectMapper.readValue(json, new TypeReference<List<SummonerRankedStats>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            error = true;
        }
    }

    public String getHtml() {
        String html;

        if (error) {
            html = "error";
            return html;
        }

        html = "             <div class=\"profile-name\">\n" +
                "                <a id=\"name\">" + summonerRP.getName() +"</a>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"profile-name\">\n" +
                "                <a id=\"level\"> LvL " + summonerRP.getSummonerLevel() + "</a>\n" +
                "                <a id=\"rank\">" + getRankedData() + "</a>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"icon-container\">\n" +
                "                <img src=" + getProfileIcon() + " height=\"100px\" width=\"101px\">\n" +
                "            </div>";
        return html;
    }

    public String getRankedData() {
        if(summonerRS == null || summonerRS.size() == 0) {
            return "Unranked";
        }
        else {
            String tierTemp = summonerRS.get(0).getTier();
            String rank = summonerRS.get(0).getRank();
            String tier = tierTemp.charAt(0) + tierTemp.substring(1).toLowerCase();

            return tier + " " + rank;
        }
    }

    public String getProfileIcon() {
        return "http://ddragon.leagueoflegends.com/cdn/8.15.1/img/profileicon/" + summonerRP.getProfileIconId() + ".png";
    }

    public String getRankedTierIcon() {
        return summonerRS.get(0).getTier().toLowerCase() + "_" + summonerRS.get(0).getRank().toLowerCase();
    }

    public String getWinRate() {
        int wins = Integer.parseInt(summonerRS.get(0).getWins());
        int losses = Integer.parseInt(summonerRS.get(0).getLosses());
        return Integer.toString((wins*100) / (wins+losses));
    }


    public String getRankedContainer() {
        String html = "";
        if (getRankedData().equals("Unranked")) {
            html = "<div class=\"body-container\">\n" +
                    "                <div class=\"rank-icon-container\">\n" +
                    "                    <div id=\"soloQ\">\n" +
                    "                        <img src=\"/images/tier-icons/"+ getRankedData() + ".png\" height=\"150px\" width=\"151px\">\n" +
                    "                    </div>\n" +
                    "                    <div id=\"tier-info\">\n" +
                    "                        <ul class=\"tier-stats\" style=\"list-style-type:none\">\n" +
                    "                            <li><a id=\"rank\">Unranked</a></li>\n" +
                    "                            <li><a id=\"points\">0 Points</a></li>\n" +
                    "                            <li><a id=\"name\">N/A</a></li>\n" +
                    "                        </ul>\n" +
                    "                    </div>\n" +
                    "                    <div id=\"soloQLogo\">\n" +
                    "                        <a>SOLO</a>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>";
            return html;
        }
        else {
            html = "            <div class=\"body-container\" style=\"border: 5px solid #" + borderColor.get(summonerRS.get(0).getTier()) + "\">\n" +
                    "                <div class=\"rank-icon-container\">\n" +
                    "                    <div id=\"soloQ\">\n" +
                    "                        <img src=\"/images/tier-icons/"+ getRankedTierIcon() + ".png\" height=\"150px\" width=\"151px\">\n" +
                    "                    </div>\n" +
                    "                    <div id=\"tier-info\">\n" +
                    "                        <ul class=\"tier-stats\" style=\"list-style-type:none\">\n" +
                    "                            <li><a id=\"rank\">" + getRankedData() + "</a></li>\n" +
                    "                            <li><a id=\"points\">" + summonerRS.get(0).getLeaguePoints() + " Points</a></li>\n" +
                    "                            <li><a id=\"name\">" + summonerRS.get(0).getLeagueName() + "</a></li>\n" +
                    "                        </ul>\n" +
                    "                    </div>\n" +
                    "                    <div id=\"win-rates\">\n" +
                    "                        <div class=\"c100 p" + getWinRate() + " dark center\">\n" +
                    "                            <span>" + getWinRate() + "%</span>\n" +
                    "                            <div class=\"slice\"><div class=\"bar\"></div><div class=\"fill\"></div></div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <div id=\"soloQLogo\">\n" +
                    "                        <a>SOLO</a>\n" +
                    "                        <a id=\"rates\">" + summonerRS.get(0).getWins() + "W / " + summonerRS.get(0).getLosses() + "L " + "</a>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>";
            return html;
        }
    }
}
