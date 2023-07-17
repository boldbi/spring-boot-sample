package com.example.demo; 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.google.gson.Gson;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HomeController {

    EmbedProperties embedProperties;
    @GetMapping("getEmbedConfig")
    public EmbedProperties getEmbedConfig() throws IOException {
        ClassPathResource resource = new ClassPathResource("embedConfig.json");
        byte[] jsonBytes = StreamUtils.copyToByteArray(resource.getInputStream());
        String jsonContent = new String(jsonBytes, StandardCharsets.UTF_8);

        Gson gson = new Gson();
        embedProperties = gson.fromJson(jsonContent, EmbedProperties.class);
        return embedProperties;
    }

    @PostMapping("authorizationServer")
    public String authorizationServer(@RequestBody EmbedClass embedQueryString) throws Exception {
        String embedQuery = embedQueryString.getEmbedQuerString();
        embedQuery += "&embed_user_email=" + embedProperties.getUserEmail();
        String embedDetailsUrl = "/embed/authorize?" + embedQuery + "&embed_signature=" + GetSignatureUrl(embedQuery);
        RestTemplate restTemplate = new RestTemplate();
        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
        defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
        String baseAddressString = embedQueryString.getDashboardServerApiUrl();
        String result = restTemplate.getForObject(baseAddressString + embedDetailsUrl, String.class);
        return result;
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

