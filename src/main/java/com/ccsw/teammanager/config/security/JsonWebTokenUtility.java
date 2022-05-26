package com.ccsw.teammanager.config.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ccsw.teammanager.person.PersonService;
import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.user.UserService;
import com.ccsw.teammanager.user.model.UserRoleEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author jhcore
 * @author rroigped
 */
@Component
public class JsonWebTokenUtility {

    private static final Logger LOG = LoggerFactory.getLogger(JsonWebTokenUtility.class);

    private static final String CLAIM_FIRST_NAME = "firstName";

    private static final String CLAIM_LAST_NAME = "lastName";

    private static final String CLAIM_DISPLAY_NAME = "displayName";

    private static final String CLAIM_EMPLOYEE_NUMBER = "employeeNumber";

    private static final String CLAIM_GLOBAL_ID = "globalID";

    private static final String CLAIM_EMPLOYEE_GRADE = "employeeGrade";

    private static final String CLAIM_EMAIL = "email";

    private static final String CLAIM_OFFICE_NAME = "officeName";

    private static final String CLAIM_REFRESH = "refresh";

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    private static final Long EXPIRATION_TIME = 1 * 60 * 60 * 1000L;

    private Key secretKey;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    private Map<String, UserInfoAppDto> userCache = new HashMap<>();

    /**
     * Create UserDetails from JWT
     *
     * @param jwtToken The json web token
     * @return userDetails
     */
    public final UserInfoAppDto createUserDetails(String jwtToken) {

        try {
            Claims claims = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(jwtToken).getBody();

            if (isExpired(claims.getExpiration()))
                return null;

            String username = claims.getSubject();

            UserInfoAppDto userDetails = this.userCache.get(username);

            if (userDetails == null || isExpired(userDetails.getExpiration()) || jwtToken.equals(userDetails.getJwt()) == false) {
                userDetails = createNewUserDetails(username, jwtToken);
                addCustomPropertiesJwtToUserDetails(claims, userDetails);
                this.userCache.put(username, userDetails);
            }

            return userDetails;

        } catch (ExpiredJwtException ex) {
            return null;
        }

    }

    private UserInfoAppDto createNewUserDetails(String username, String jwtToken) {

        UserInfoAppDto userDetails = new UserInfoAppDto();
        userDetails.setUsername(username);
        userDetails.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
        userDetails.setJwt(jwtToken);
        PersonEntity person = this.personService.personExists(username);

        if (person != null) {
            userDetails.setWithPON(person.isWithPON());
        } else {
            userDetails.setWithPON(false);
        }

        userDetails.setRole("USER");
        List<UserRoleEntity> userRoles = this.userService.getRolesByUsername(username);
        for (UserRoleEntity userRole : userRoles) {
            userDetails.addRole(userRole.getRole().getRole());
        }

        if (person != null) {
            if (person.getGrade() != null) {
                if (person.getGrade().equals("D") || person.getGrade().equals("E") || person.getGrade().equals("F")) {
                    userDetails.addRole("GESTOR");
                }
            }
        }

        return userDetails;
    }

    /**
     *
     * @param jwtToken
     * @return
     */
    public final boolean tokensAreInvalid(String accessToken, String refreshToken) {

        Claims claimsAccessToken = null;
        Claims claimsRefreshToken = null;

        try {
            claimsAccessToken = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(accessToken).getBody();

            if (isExpired(claimsAccessToken.getExpiration()))
                return true;

        } catch (ExpiredJwtException ex) {
            LOG.info("User token expired " + accessToken);
            return true;
        }

        try {
            claimsRefreshToken = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(refreshToken).getBody();

            if (isExpired(claimsRefreshToken.getExpiration()))
                return true;

        } catch (ExpiredJwtException ex) {
            LOG.info("User token expired " + refreshToken);
            return true;
        }

        Boolean isRefreshClaim = (Boolean) claimsRefreshToken.get(CLAIM_REFRESH);
        if (isRefreshClaim == false)
            return true;

        Date expirationDateAccessToken = claimsAccessToken.getExpiration();
        Date expirationDateRefreshToken = claimsRefreshToken.getExpiration();

        return expirationDateAccessToken.getTime() != expirationDateRefreshToken.getTime();
    }

    /**
     * @param userDetails
     */
    private boolean isExpired(Date expirationDate) {

        Date now = new Date();

        // check if jwt is valid
        if (now.after(expirationDate))
            return true;

        return false;
    }

    /**
     * Add a custom properties from JWT to UserDetails
     *
     * @param claims
     * @param userDetails
     */
    private void addCustomPropertiesJwtToUserDetails(Claims claims, UserInfoDto userDetails) {

        userDetails.setFirstNameValue((String) claims.get(CLAIM_FIRST_NAME));
        userDetails.setLastNameValue((String) claims.get(CLAIM_LAST_NAME));
        userDetails.setDisplayNameValue((String) claims.get(CLAIM_DISPLAY_NAME));
        userDetails.setMailValue((String) claims.get(CLAIM_EMAIL));
        userDetails.setEmployeeNumberValue((String) claims.get(CLAIM_EMPLOYEE_NUMBER));
        userDetails.setGlobalIDValue((String) claims.get(CLAIM_GLOBAL_ID));
        userDetails.setGradeValue((String) claims.get(CLAIM_EMPLOYEE_GRADE));
        userDetails.setPhysicalDeliveryOfficeNameValue((String) claims.get(CLAIM_OFFICE_NAME));

    }

    /**
     * Set the encodedKey from properties
     *
     * @param encodedKey new value of encoded key
     */
    @Value("${jwt.encodedKey}")
    public final void setEncodedKey(String encodedKey) {

        byte[] decodedKey = DatatypeConverter.parseBase64Binary(encodedKey);
        this.secretKey = new SecretKeySpec(decodedKey, SIGNATURE_ALGORITHM.getJcaName());

    }

}