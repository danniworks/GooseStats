package ui.model;


/**
 * Builds Summoner object
 */
public class SummonerRankedProfile{

    private String profileIconId;
    private String name;
    private String summonerLevel;
    private String accountId;
    private String id;
    private String revisionDate;

    public SummonerRankedProfile(){}

    public String getProfileIconId() {
        return profileIconId;
    }

    public String getName() {
        return name;
    }

    public String getSummonerLevel() {
        return summonerLevel;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getId() {
        return id;
    }

    public String getRevisionDate() {
        return revisionDate;
    }

    /**
     * Creates HTML for object
     *
     * @return (String) HTML of Summoner Object
     */
    public String getHtml() {
        String html;

        html = "<div class='profile-container'>" +
                    "<div class='profile-basic'>" +
                        "<a>" + getName() + "</a>" +
                        "<a> Level " + getSummonerLevel() + "</a>" +
                        "<a> Profile id " + getProfileIconId() + "</a>" +
                        "<a> Summoner id " + getId() + "</a>" +
                    "</div>" +
                "</div>";

        return html;
    }
}
