package com.example.demo; 
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HomeController {

    @PostMapping("GetDetails")
    public String getDetails(@RequestBody EmbedClass embedQuerString) throws Exception{
        String embedQuery = embedQuerString.getEmbedQuerString();
        embedQuery+= "&embed_user_email=" + EmbedProperties.email;
        String embedDetailsUrl = "/embed/authorize?" + embedQuery + "&embed_signature=" + GetSignatureUrl(embedQuery);
        RestTemplate restTemplate = new RestTemplate();
        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
        defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);//To avaiod encoding of query parameter which already encode using GetSignatureUrl method
        restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
        String baseAddressString = embedQuerString.getDashboardServerApiUrl();
        String result = restTemplate.getForObject(baseAddressString + embedDetailsUrl, String.class);
        return result;
    }
    public String GetSignatureUrl(String queryString) throws Exception {
        if (queryString != null){
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(EmbedProperties.embedSecret.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        	return new String(Base64.getEncoder().encode(sha256_HMAC.doFinal(queryString.getBytes("UTF-8"))));
            }
        return null;
      }

}

