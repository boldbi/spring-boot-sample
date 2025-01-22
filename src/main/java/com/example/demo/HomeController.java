package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HomeController {

    EmbedProperties embedProperties;
    @GetMapping("getEmbedConfig")
    public Map<String, String> getEmbedConfig() throws IOException {
        ClassPathResource resource = new ClassPathResource("embedConfig.json");
        byte[] jsonBytes = StreamUtils.copyToByteArray(resource.getInputStream());
        String jsonContent = new String(jsonBytes, StandardCharsets.UTF_8);

        Gson gson = new Gson();
        this.embedProperties = gson.fromJson(jsonContent, EmbedProperties.class);

        // Create a Map with the desired properties
        Map<String, String> result = new HashMap<>();
        result.put("dashboardId", embedProperties.getDashboardId());
        result.put("serverUrl", embedProperties.getServerUrl());
        result.put("embedType", embedProperties.getEmbedType());
        result.put("environment", embedProperties.getEnvironment());
        result.put("siteIdentifier", embedProperties.getSiteIdentifier());
        return result;
    }

    @PostMapping("authorizationServer")
    public String authorizationServer(@RequestBody EmbedClass embedQueryString) throws Exception {
        String embedQuery = embedQueryString.getEmbedQuerString();
        embedQuery += "&embed_user_email=" + embedProperties.getUserEmail();
        String embedDetailsUrl = "/embed/authorize?" + embedQuery + "&embed_signature=" + GetSignatureUrl(embedQuery);
        String baseAddressString = embedQueryString.getDashboardServerApiUrl();
        String fullUrl = baseAddressString + embedDetailsUrl;
        URL url = new URL(fullUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public String GetSignatureUrl(String queryString) throws Exception {
        if (queryString != null){
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(embedProperties.getEmbedSecret().getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
            return new String(Base64.getEncoder().encode(sha256_HMAC.doFinal(queryString.getBytes("UTF-8"))));
            }
        return null;
    }
}