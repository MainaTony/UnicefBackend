package com.pinnoserv.portal.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.Key;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import com.google.gson.Gson;
import com.pinnoserv.portal.entity.ApiUsers;
//import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.configuration.JwtRequestFilter;
import com.pinnoserv.portal.configuration.JwtToken;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.repositories.ApiUserRepository;
//import com.pinnoserv.portal.repositories.UserRepository;
import com.pinnoserv.portal.repositories.UserRepository;
import com.pinnoserv.portal.service.DatabaseService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author mwendwakelvin
 */
@Service
public class SharedFunctions {

    @Autowired
    Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApiUserRepository apiUserRepository;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JwtToken jwtToken;

    public PasswordEncoder passwordencoder = new BCryptPasswordEncoder();

    private static final Logger LOGGER = LoggerFactory.getLogger(SharedFunctions.class);

    Gson gson = new Gson();

    public static int getRandomIntegerBetweenRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String removeLastChar(String s) {
        int stringLength = s.length();
        String finalString = "";
        if (s != null || stringLength != 0) {
            finalString = s.substring(2, stringLength);
        }
        return finalString;
    }

    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    public String formatPhoneNumber(String s) {
        int stringLength = s.length();
        String finalString = "";
        if (s != null || stringLength != 0) {
            if (stringLength == 10)
                finalString = s.substring(1, stringLength);
            else if (stringLength == 12)
                finalString = s.substring(3, stringLength);
        }
        return "254"+finalString;
    }

    public  String formatPhoneNumber2(String msisdn) {
        String start_char = String.valueOf(msisdn.charAt(0));

        int msisdn_length = msisdn.length();
        LOGGER.info("Starting char" + start_char);
        LOGGER.info("MSISDN Length" + msisdn_length);

        if (start_char.equals("+") && msisdn_length == 13) {
            msisdn = msisdn.substring(4);
        } else if (start_char.equals("2") && msisdn_length == 12) {
            msisdn = msisdn.substring(3);
        } else if (start_char.equals("0") && msisdn_length == 10) {
            msisdn = msisdn.substring(1);
        } else if (start_char.equals("7") && msisdn_length == 9) {
            msisdn = msisdn;
        } else {
            return "0";
        }
        return msisdn;
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static String makeGetRequest(String endpoint) { //Use PHP file to do TRX
        String response = "";
        LOGGER.info("endpoint: "+endpoint);
        try {
            URL url = new URL(endpoint);
            URLConnection url_connection = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            url_connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response = response + inputLine;
            }

            LOGGER.info("Response :" + response);

            return response;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * mobile number should be start with a 7
     *
     * @param phoneNumber | The phone number
     * @return String
     */
    public static boolean validPhoneNumber(String phoneNumber) {
        boolean valid = false;
        if(!phoneNumber.equals("")) {
            if ((phoneNumber.substring(0, 3).matches("254") || phoneNumber.substring(0, 2).matches("07") || phoneNumber.substring(0, 2).matches("01")) && (phoneNumber.length() == 10 || phoneNumber.length() == 12)) {
                valid = true;
            }
        }
        return valid;
    }

    public static List<String> splitStringEqually(String text, int size) {
        List<String> result = new ArrayList<>((text.length() + size - 1) / size);
        for (int i = 0; i < text.length(); i += size) {
            result.add(text.substring(i, Math.min(text.length(), i + size)));
        }
        return result;
    }

    public String formatToken(String token) {
        List<String> response = splitStringEqually(token, 4);
        String lc =  "";
        for (String s : response) {
            lc = lc + "-" + s;
        }
        return lc.substring(1);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public boolean passwordMatches(String rawPassword, String hashedPassword) {
        Boolean passwordsMatch = passwordencoder.matches(rawPassword, hashedPassword);
        LOGGER.info("PASSWORDS MATCH ? >>  {}", passwordsMatch);
        return passwordsMatch;
    }

    public String encodePassword(String password) {
        return passwordencoder.encode(password);
    }

    public String generateToken(Users user, Map<String, Object> params) {
        String token = "";
        try {
            LOGGER.info("--- [ENTERED FUNCTION] GENERATE TOKEN ----");
            String jwtTimeout = environment.getProperty("jwt.timeout");
            AtomicReference<String> expirationDuration = new AtomicReference<>(jwtTimeout);
            Long expiration = new Long(expirationDuration.get());
            params.put("ttlMillis", expiration);
            LOGGER.info("EXPIRATION DURATION >> {}", expiration);
            token = createJWT(user, user.getUsername(), params, "ACCESS_TOKEN");
            String[] tokenParts = token.split("\\.");
            if (tokenParts.length != 3) {
                LOGGER.info("TOKEN MUST CONTAIN ONLY 2 PERIODS >> RETURNING WITH STATUS CODE 500 >> PERIODS FOUND >> {}", tokenParts.length);
                return null;
            }
            userRepository.assignToken(tokenParts[2], user.getId());
            LOGGER.info("--- [EXITED FUNCTION] GENERATE TOKEN ----");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    public String createJWT(Users user, String subject, Map<String, Object> params, String type) {
        String response = "";
        try {
            LOGGER.info("--- [ENTERED FUNCTION] CREATE JWT ----");
            String jwtSecret = environment.getProperty("jwt.secret");
            //The JWT signature algorithm we will be using to sign the token
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            //We will sign our JWT with our ApiKey secret
            byte[] apiKeySecretBytes = DatatypeConverter.parseHexBinary(jwtSecret.replace("\n", "").replace("\r", ""));
            //byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("UT52ITY9856@#!");
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
            //Let's set the JWT Claims
            JwtBuilder builder = Jwts.builder()
                    .setId(user.getId().toString())
                    .setIssuedAt(now)
                    .claim("id", user.getId())
                    .claim("user", gson.toJson(user))
                    .claim("type", type);
            //LOGGER.info("CLAIMS SET >> ID >> " + user.getId() + " >> USER >> {}", gson.toJson(user));
            //Add extra claims if they exist
            if (params.size() > 0) {
                params.entrySet().forEach((entry) -> {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    builder.claim(key, value);
                });
            }
            builder.setSubject(subject);
            builder.setIssuer("UserManagement");
            LOGGER.info("ISSUER >> {} ", "UserManagement");
            builder.signWith(signatureAlgorithm, signingKey);
            //if it has been specified, let's add the expiration
            if (params.containsKey("ttlMillis")) {
                long ttlMillis = Long.parseLong(params.get("ttlMillis").toString());
                LOGGER.info("ttmilis >> {}", ttlMillis);
                long expMillis = nowMillis + ttlMillis;
                Date exp = new Date(expMillis);
                builder.setExpiration(exp);
                LOGGER.info("EXPIRATION SET >> {} ", exp);
            }
            LOGGER.info("--- [EXITING FUNCTION] CREATE JWT ----");
            //Builds the JWT and serializes it to a compact, URL-safe string
            response = builder.compact();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String getSecretKey(){
        return Crypt.encodeKey(environment.getRequiredProperty("datasource.apigateway.encryptionKey"));
    }

    public ApiUsers verifyToken(String requestTokenHeader) {
        ApiUsers user = null;
        String username = null;
        String token = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            token = requestTokenHeader.substring(7);
            try {
                username = jwtToken.getUsernameFromToken(token);
            } catch (Exception e) {
                LOGGER.error("JWT Token has expired", e);
            }
        } else {
            LOGGER.warn("JWT Token does not begin with Bearer String");
        }
        user = apiUserRepository.findByUsername(username);
        LOGGER.info("User : " + user);
        return  user;
    }
}
