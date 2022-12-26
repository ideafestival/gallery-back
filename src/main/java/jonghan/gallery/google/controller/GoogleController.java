package jonghan.gallery.google.controller;

import jonghan.gallery.google.dto.googledto.GoogleLoginDto;
import jonghan.gallery.google.service.GoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/google")
public class GoogleController {

    private final GoogleService googleService;


    @Autowired
    public GoogleController(GoogleService googleService) {
        this.googleService = googleService;
    }


    @GetMapping(value = "/login")
    public ResponseEntity<Object> moveGoogleInitUrl() {
        return googleService.moveGoogleInitUrl();
    }
    @GetMapping(value = "/login/redirect")
    public ResponseEntity<GoogleLoginDto> redirectGoogleLogin(
            @RequestParam(value = "code") String authCode
    ) {
        return googleService.redirectGoogleLogin(authCode);
    }

}
