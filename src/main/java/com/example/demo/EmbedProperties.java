package com.example.demo;

import com.google.gson.annotations.SerializedName;

public class EmbedProperties {
    @SerializedName("DashboardId")
    public String DashboardId;

    @SerializedName("ServerUrl")
    public String ServerUrl;

    @SerializedName("UserEmail") 
    public String UserEmail;

    @SerializedName("EmbedSecret") 
    public String EmbedSecret;

    @SerializedName("EmbedType")
    public String EmbedType;

    @SerializedName("Environment")
    public String Environment;

    @SerializedName("ExpirationTime")
    public String ExpirationTime;

    @SerializedName("SiteIdentifier")
    public String SiteIdentifier;

    public String getDashboardId() {
        return DashboardId;
    }

    public void setDashboardId(String DashboardId) {
        this.DashboardId = DashboardId;
    }

    public String getServerUrl() {
        return ServerUrl;
    }

    public void setServerUrl(String ServerUrl) {
        this.ServerUrl = ServerUrl;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public String getEmbedSecret() {
        return EmbedSecret;
    }

    public void setEmbedSecret(String EmbedSecret) {
        this.EmbedSecret = EmbedSecret;
    }

    public String getEmbedType() {
        return EmbedType;
    }

    public void setEmbedType(String EmbedType) {
        this.EmbedType = EmbedType;
    }

    public String getEnvironment() {
        return Environment;
    }

    public void setEnvironment(String Environment) {
        this.Environment = Environment;
    }

    public String getExpirationTime() {
        return ExpirationTime;
    }

    public void setExpirationTime(String ExpirationTime) {
        this.ExpirationTime = ExpirationTime;
    }

    public String getSiteIdentifier() {
        return SiteIdentifier;
    }

    public void setSiteIdentifier(String SiteIdentifier) {
        this.SiteIdentifier = SiteIdentifier;
    }
}
