package com.pinnoserv.portal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinnoserv.portal.custommodels.JwtResponse;
import com.pinnoserv.portal.custommodels.userregmodel.ApiResponseBody;
import com.pinnoserv.portal.entity.ApiUsers;
//import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.configuration.JwtToken;
import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.JwtRequest;
import com.pinnoserv.portal.repositories.ApiUserRepository;
//import com.pinnoserv.portal.repositories.UserRepository;
import com.pinnoserv.portal.service.CustomUserDetailsService;
import com.pinnoserv.portal.custommodels.userregmodel.ApiResponseRegistration;
import com.pinnoserv.portal.utils.Crypt;
import com.pinnoserv.portal.utils.MCrypt;
import com.pinnoserv.portal.utils.SharedFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    private Environment environment;

    @Autowired
    SharedFunctions globalFunctions;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    ApiUserRepository apiUserRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            String username = authenticationRequest.getUsername();
            LOG.info("-----------------Username from postman------------------ {}", username);
//          Users user = userRepository.findByUsername(username);
            ApiUsers user = apiUserRepository.findByUsername(username);
            LOG.info("-----------------Generated User------------------ {}", user);

            if (user != null) {
                authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
                final UserDetails userDetails = customUserDetailsService
                        .loadUserByUsername(authenticationRequest.getUsername());
                final String token = jwtToken.generateToken(userDetails);
                LOG.info("------------------Token Generated------------------");

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
//    @PostMapping("/create")
//    public ResponseEntity<?> addNewUser(@RequestBody() Users user) {
//        LOG.info("---------------------------STARTING 'ADD NEW USER' --------------------------------");
//        ApiResponse apiResponse = new ApiResponse();
//        HttpStatus responseStatus = HttpStatus.OK;
//        try {
//            user.setCreatedBy(new BigInteger("1"));
//            user.setDateCreated(new Date(System.currentTimeMillis()));
//            if (userRepository.existsByUsername(user.getUsername())){
//                LOG.info("...............Username already existed...............");
//                apiResponse.setResponseCode("01");
//                apiResponse.setResponseDescription("Error! Username Exists !");
//                responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//            else {
//                user.setPassword(globalFunctions.encodePassword(user.getPassword()));
//                Users savedUser = userRepository.saveAndFlush(user);
//                apiResponse.setEntity(savedUser);
//                apiResponse.setResponseCode("00");
//                apiResponse.setResponseDescription("Success! User saved.");
//            }
//        } catch (Exception e) {
//            LOG.error("ERROR! COULD NOT SAVE >> " + e.getMessage());
//            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
//                Map<String, String> error = new HashMap();
//                error.put("error", e.getMessage());
//                error.put("cause", e.getCause().toString());
//                apiResponse.setEntity(error);
//            }
//            apiResponse.setResponseCode("01");
//            apiResponse.setResponseDescription("Error! Could not add User");
//            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
//            LOG.info("---------------------------ENDING 'ADD NEW User'--------------------------------'");
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(apiResponse, responseStatus);
//    }

/**
 * Endpoint To Register New API Users
 *
 * @param
 * @return
 */
    @RequestMapping(value = "/userreg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUSer(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        ApiResponse response = new ApiResponse();
        ApiResponseRegistration apiResponseRegistration= new ApiResponseRegistration();

        ApiResponseBody responseBody = new ApiResponseBody();
//        ApiResponse error = new ApiResponse();
        ApiResponseRegistration error = new ApiResponseRegistration();
//        MCrypt mCrypt = new MCrypt();
        ObjectMapper objectMapper = new ObjectMapper();
//        SharedFunctions sharedFunctions = new SharedFunctions();
//        ApiResponse apiResponse = new ApiResponse();

        boolean swaggerswitch = environment.getRequiredProperty("datasource.apigateway.swaggerEnable") != null
                && environment.getRequiredProperty("datasource.apigateway.swaggerEnable").equals("true");
        try {
            if (swaggerswitch) {
                if (apiUserRepository.existsByUsername(username)) {
                    LOG.info("...............Username already existed...............");
                    apiResponseRegistration.setMessage("Error");
                    apiResponseRegistration.setNarration("Username Exists");
                    apiResponseRegistration.setResponseCode("01");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    String password = body.get("password");
                    String encodedPassword = new BCryptPasswordEncoder().encode(password);
                    String fullname = body.get("fullname");
                    Integer accessChannelId = Integer.parseInt(body.get("accesschannel"));
                    Integer organisationIdFk = new Integer("1");
                    Date createdDate = new Date(System.currentTimeMillis());
                    Integer inTrash = Integer.parseInt(body.get("inTrash"));
//                  body.setDateCreated(new Date(System.currentTimeMillis()));

                    apiUserRepository.save(new ApiUsers(username, encodedPassword, fullname, accessChannelId, inTrash, createdDate, organisationIdFk));
                    LOG.info("..............User Registration Successful...............");
                    apiResponseRegistration.setMessage("Success");
                    apiResponseRegistration.setNarration("User Registration Successful");
                    apiResponseRegistration.setResponseCode("00");
//                   responseBody.setHashedBody(Arrays.toString(mCrypt.encrypt(objectMapper.writeValueAsString(apiResponseRegistration))));
//                    responseBody.setHashedBody(Crypt.encrypt(objectMapper.writeValueAsString(apiResponseRegistration), sharedFunctions.getSecretKey()));
//                    apiResponse.setEntity(error);
//                  user.setPassword(globalFunctions.encodePassword(user.getPassword()));

//                  apiResponse.setEntity(savedUser);
                    responseBody.setHashedBody(objectMapper.writeValueAsString(body));
                    return new ResponseEntity<>(responseBody, HttpStatus.OK);
                }
            } else {
                LOG.info("...............Endpoint Disabled...............");
                apiResponseRegistration.setMessage("Error");
                apiResponseRegistration.setNarration("Invalid Endpoint");
                apiResponseRegistration.setResponseCode("01");
//                responseBody.setHashedBody(Arrays.toString(mCrypt.encrypt(objectMapper.writeValueAsString(apiResponseRegistration))));
//                responseBody.setHashedBody(Crypt.encrypt(objectMapper.writeValueAsString(apiResponseRegistration), sharedFunctions.getSecretKey()));

                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOG.error("Error occurred during user reg {}", e);
            try {
                error.setMessage("error");
                error.setResponseCode("01");
                error.setNarration(e.getMessage());
//                responseBody.setHashedBody(Arrays.toString(mCrypt.encrypt(objectMapper.writeValueAsString(error))));
//                responseBody.setHashedBody(Crypt.encrypt(objectMapper.writeValueAsString(error), sharedFunctions.getSecretKey()));
//                responseBody.setHashedBody(objectMapper.writeValueAsString(body));
//                mCrypt.encrypt()
            } catch (Exception ex) {
                LOG.error("Error occured during fetching of accounts {}", ex);
            }
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
    }

//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        LOG.info("Authetication Request received {}",objectMapper.writeValueAsString(authenticationRequest));
//        String authUsername = authenticationRequest.getUsername().trim();
//        String authPassword = authenticationRequest.getPassword().trim();
//        //LOGGER.info("Username received {}", authUsername);
//        //LOGGER.info("Password received {}", authPassword);
//        authenticate(authUsername, authPassword);
//        final UserDetails userDetails = customUserDetailsService
//                .loadUserByUsername(authUsername);
//
////        LOG.info("After Authenticate Function");
//        final String token = jwtToken.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//


}
