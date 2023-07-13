package com.example.demo; 
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmbedProperties {
    @JsonProperty("DashboardId")
    private String dashboardId;

    @JsonProperty("ServerUrl")
    private String serverUrl;

    @JsonProperty("UserEmail")
    private static String userEmail;

    @JsonProperty("EmbedSecret")
    private static String embedSecret;

    @JsonProperty("EmbedType")
    private String embedType;

    @JsonProperty("Environment")
    private String environment;

    @JsonProperty("ExpirationTime")
    private String expirationTime;

    @JsonProperty("SiteIdentifier")
    private String siteIdentifier;

    public String getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(String dashboardId) {
        this.dashboardId = dashboardId;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public static String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        EmbedProperties.userEmail = userEmail;
    }

    public static String getEmbedSecret() {
        return embedSecret;
    }

    public void setEmbedSecret(String embedSecret) {
        EmbedProperties.embedSecret = embedSecret;
    }

    public String getEmbedType() {
        return embedType;
    }

    public void setEmbedType(String embedType) {
        this.embedType = embedType;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getSiteIdentifier() {
        return siteIdentifier;
    }

    public void setSiteIdentifier(String siteIdentifier) {
        this.siteIdentifier = siteIdentifier;
    }
}
