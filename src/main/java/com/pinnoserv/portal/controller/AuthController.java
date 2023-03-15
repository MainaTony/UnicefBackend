package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.configuration.JwtToken;
import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.JwtRequest;
import com.pinnoserv.portal.repositories.UserRepository;
import com.pinnoserv.portal.service.CustomUserDetailsService;
import com.pinnoserv.portal.utils.SharedFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private Environment environment;

    @Autowired
    SharedFunctions globalFunctions;

    @Autowired
    AuthenticationManager authManager;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            String username = authenticationRequest.getUsername();
            Users user = userRepository.findByUsername(username);
            if (user != null) {
                authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
                final UserDetails userDetails = customUserDetailsService
                        .loadUserByUsername(authenticationRequest.getUsername());
                final String token = jwtToken.generateToken(userDetails);
                Map<String, Object> responseMap = new HashMap<String, Object>();
                responseMap.put("token", token);
                responseMap.put("user", user);
                LOG.info("token>>{}", token);
                apiResponse.setResponseCode("00");
                apiResponse.setResponseDescription("Authenticated Successfully");
                apiResponse.setEntity(responseMap);
                LOG.info("------------------AUTHENTICATION ENDED WITH RESPONSE CODE {}------------------", apiResponse.getResponseCode());
            }
            else {
                // Invalid Password
                LOG.info("USER NOT FOUND: USERNAME >> '{}'  >> RETURNING WITH STATUS CODE 01", username);
                apiResponse.setResponseCode("01");
                apiResponse.setResponseDescription("Failed. User not found.");
            }
        }
        catch (Exception e){
            LOG.error("Error in Auth: ", e.getMessage());
            e.printStackTrace();
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Failed:Invalid credentials.");
            return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
        }
        LOG.info("----------------- AUTHENTICATION ENDED ----------------");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    /**
     * Endpoint To Register New API Users
     *
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> addNewUser(@RequestBody() Users user) {
        LOG.info("---------------------------STARTING 'ADD NEW USER' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            user.setCreatedBy(new BigInteger("1"));
            user.setDateCreated(new Date(System.currentTimeMillis()));
            if (userRepository.existsByUsername(user.getUsername())){
                LOG.info("...............Username already existed...............");
                apiResponse.setResponseCode("01");
                apiResponse.setResponseDescription("Error! Username Exists !");
                responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            else {
                user.setPassword(globalFunctions.encodePassword(user.getPassword()));
                Users savedUser = userRepository.saveAndFlush(user);
                apiResponse.setEntity(savedUser);
                apiResponse.setResponseCode("00");
                apiResponse.setResponseDescription("Success! User saved.");
            }
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT SAVE >> " + e.getMessage());
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause().toString());
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not add User");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'ADD NEW User'--------------------------------'");
            e.printStackTrace();
        }
        return new ResponseEntity<>(apiResponse, responseStatus);
    }
}
