package jonghan.gallery.google.service;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import jonghan.gallery.global.constants.ConfigUtils;
import jonghan.gallery.google.dto.googledto.GoogleLoginDto;
import jonghan.gallery.google.dto.googledto.GoogleLoginRequest;
import jonghan.gallery.google.dto.googledto.GoogleLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class GoogleService {
    private final ConfigUtils configUtils;

    @Autowired
    GoogleService(ConfigUtils configUtils) {
        this.configUtils = configUtils;
    }

    public ResponseEntity<Object> moveGoogleInitUrl() {
        String authUrl = configUtils.googleInitUrl();
        URI redirectUri = null;
        try {
            redirectUri = new URI(authUrl);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(redirectUri);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }


    public ResponseEntity<GoogleLoginDto> redirectGoogleLogin(String authCode) {
        RestTemplate restTemplate = new RestTemplate();
        GoogleLoginRequest requestParams = GoogleLoginRequest.builder()
                .clientId(configUtils.getGoogleClientId())
                .clientSecret(configUtils.getGoogleSecret())
                .code(authCode)
                .redirectUri(configUtils.getGoogleRedirectUri())
                .grantType("authorization_code")
                .build();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<GoogleLoginRequest> httpRequestEntity = new HttpEntity<>(requestParams, headers);
            ResponseEntity<String> apiResponseJson = restTemplate.postForEntity(configUtils.getGoogleAuthUrl() + "/token", httpRequestEntity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            GoogleLoginResponse googleLoginResponse = objectMapper.readValue(apiResponseJson.getBody(), new com.fasterxml.jackson.core.type.TypeReference<GoogleLoginResponse>() {});

            String jwtToken = googleLoginResponse.getIdToken();

            String requestUrl = UriComponentsBuilder.fromHttpUrl(configUtils.getGoogleAuthUrl() + "/tokeninfo").queryParam("id_token", jwtToken).toUriString();

            String resultJson = restTemplate.getForObject(requestUrl, String.class);

            if(resultJson != null) {
                GoogleLoginDto userInfoDto = objectMapper.readValue(resultJson, new TypeReference<GoogleLoginDto>() {});

                return ResponseEntity.ok().body(userInfoDto);
            }
            else {
                throw new Exception("Google OAuth failed!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body(null);
    }
}
