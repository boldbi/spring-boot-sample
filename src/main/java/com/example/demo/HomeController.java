package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HomeController {

    EmbedProperties embedProperties;

    private void ensureEmbedProperties() throws IOException {
        if (this.embedProperties == null) {
            ClassPathResource resource = new ClassPathResource("embedConfig.json");
            byte[] jsonBytes = StreamUtils.copyToByteArray(resource.getInputStream());
            String jsonContent = new String(jsonBytes, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            this.embedProperties = gson.fromJson(jsonContent, EmbedProperties.class);
        }
    }

    @GetMapping("getEmbedConfig")
    public ResponseEntity<?> getEmbedConfig() {
        try {
            ensureEmbedProperties();

            // Create a Map with the desired properties
            Map<String, String> result = new HashMap<>();
            result.put("dashboardId", embedProperties.getDashboardId());
            result.put("serverUrl", embedProperties.getServerUrl());
            result.put("embedType", embedProperties.getEmbedType());
            result.put("environment", embedProperties.getEnvironment());
            result.put("siteIdentifier", embedProperties.getSiteIdentifier());
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            Map<String, String> err = new HashMap<>();
            err.put("error", "embedConfig.json not found. Please obtain it from: https://help.boldbi.com/site-administration/embed-settings/#get-embed-configuration-file");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }

    @PostMapping("TokenGeneration")
    public String tokenGeneration() throws Exception {
        if (this.embedProperties == null) {
            getEmbedConfig();
        }

        Map<String, Object> embedDetails = new HashMap<>();
        embedDetails.put("email", embedProperties.getUserEmail());
        embedDetails.put("serverurl", embedProperties.getServerUrl());
        embedDetails.put("siteidentifier", embedProperties.getSiteIdentifier());
        embedDetails.put("embedsecret", embedProperties.getEmbedSecret());
        Map<String, String> dashboard = new HashMap<>();
        dashboard.put("id", embedProperties.getDashboardId());
        embedDetails.put("dashboard", dashboard);

        Gson gson = new Gson();
        String jsonPayload = gson.toJson(embedDetails);

        String requestUrl;
        String siteId = embedProperties.getSiteIdentifier();
        if (siteId == null || siteId.trim().isEmpty()) {
            requestUrl = embedProperties.getServerUrl() + "/api/embed/authorize";
        } else {
            requestUrl = embedProperties.getServerUrl() + "/api/" + siteId + "/embed/authorize";
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String resultContent = response.body();

        JsonObject obj = gson.fromJson(resultContent, JsonObject.class);
        String token = null;
        if (obj != null && obj.has("Data")) {
            JsonObject data = obj.getAsJsonObject("Data");
            if (data.has("access_token")) {
                token = data.get("access_token").getAsString();
            }
        }
        return token;
    }
}