package com.gamevault.gamevault.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamevault.gamevault.dto.LoginDto;
import com.gamevault.gamevault.models.User;
import com.gamevault.gamevault.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/login", method = RequestMethod.POST,  produces = "application/json")
public class Login {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> logar(@RequestBody LoginDto login) throws JsonProcessingException {



        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.username(), login.password());
        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        usernamePasswordAuthenticationToken.getCredentials();
        var user = (User) authentication.getPrincipal();

        return ResponseEntity.status(200).body(tokenService.gerarToken(user));

    }
}
