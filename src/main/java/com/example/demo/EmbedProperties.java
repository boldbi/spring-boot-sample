package com.example.demo;

import com.google.gson.annotations.SerializedName;

public class EmbedProperties {
    @SerializedName("DashboardId")
    public String dashboardId;

    @SerializedName("ServerUrl")
    public String serverUrl;

    @SerializedName("UserEmail") 
    public String userEmail;

    @SerializedName("EmbedSecret") 
    public String embedSecret;

    @SerializedName("EmbedType")
    public String embedType;

    @SerializedName("Environment")
    public String environment;

    @SerializedName("ExpirationTime")
    public String expirationTime;

    @SerializedName("SiteIdentifier")
    public String siteIdentifier;

    public String getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(String DashboardId) {
        this.dashboardId = DashboardId;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String ServerUrl) {
        this.serverUrl = ServerUrl;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.userEmail = UserEmail;
    }

    public String getEmbedSecret() {
        return embedSecret;
    }

    public void setEmbedSecret(String EmbedSecret) {
        this.embedSecret = EmbedSecret;
    }

    public String getEmbedType() {
        return embedType;
    }

    public void setEmbedType(String EmbedType) {
        this.embedType = EmbedType;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String Environment) {
        this.environment = Environment;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String ExpirationTime) {
        this.expirationTime = ExpirationTime;
    }

    public String getSiteIdentifier() {
        return siteIdentifier;
    }

    public void setSiteIdentifier(String SiteIdentifier) {
        this.siteIdentifier = SiteIdentifier;
    }
}
