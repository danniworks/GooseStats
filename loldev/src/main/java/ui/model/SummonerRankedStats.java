package ui.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SummonerRankedStats extends SummonerRankedProfile{

    private String queueType;
    private String hotStreak;
    private String wins;
    private String veteran;
    private String losses;
    private String playerOrTeamId;
    private String leagueName;
    private String playerOrTeamName;
    private String inactive;
    private String rank;
    private String freshBlood;
    private String leagueId;
    private String tier;
    private String leaguePoints;
    private String miniSeries;

    public SummonerRankedStats() { }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(String hotStreak) {
        this.hotStreak = hotStreak;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getVeteran() {
        return veteran;
    }

    public void setVeteran(String veteran) {
        this.veteran = veteran;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    public void setPlayerOrTeamId(String playerOrTeamId) {
        this.playerOrTeamId = playerOrTeamId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(String freshBlood) {
        this.freshBlood = freshBlood;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(String leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public String getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(String miniSeries) {
        this.miniSeries = miniSeries;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("miniSeries")
    private void unpackNested(Map<String,Object> miniSeries) {
        this.miniSeries = (String)miniSeries.get("progress");
    }
}
