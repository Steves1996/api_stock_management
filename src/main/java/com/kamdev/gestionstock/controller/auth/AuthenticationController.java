package com.kamdev.gestionstock.controller.auth;

import com.kamdev.gestionstock.dto.auth.AuthenticationRequest;
import com.kamdev.gestionstock.dto.auth.AuthenticationResponse;
import com.kamdev.gestionstock.services.auth.ApplicationUserDetailsService;
import com.kamdev.gestionstock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        final String jwt = jwtUtil.generateToken(userDetails);
        return  ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }
}
