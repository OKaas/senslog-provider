package cz.senslog.provider.service;

import cz.senslog.provider.db.model.UserEntity;
import cz.senslog.provider.db.model.UserGroupEntity;
import cz.senslog.provider.db.repository.UserGroupRepository;
import cz.senslog.provider.db.repository.UserRepository;
import cz.senslog.provider.security.UserToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by OK on 11/17/2017.
 */
@Service
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public UserToken loadUserByUsername(String username) throws
            UsernameNotFoundException {

        LOGGER.info("Try login: {}", username);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String currentUserName = auth == null ? null : auth.getName();
        }

        // get token
        final String accessToken = request.getHeader("header-name");
        UserToken userToken = null;
        UserEntity user = null;

        if (null != accessToken) {
            //get and check whether token is valid (from DB or file wherever you are storing the token)
        }

        user = userRepository.findByNameEquals(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        userToken = new UserToken(user.getName(), user.getPassword(), user.getUserGroup(), getGroup(user), getGrantedAuthorities(username) );

        // set to context
        final UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(user, null, userToken.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        return userToken;
    }

    /* --- Collaborates --- */

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
        Collection<? extends GrantedAuthority> authorities;
        authorities = asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");

        LOGGER.info("Get authorities for: {}", username);

        return authorities;
    }

    private Set<Long> getGroup(UserEntity userEntity){
        // TODO little dummy but for now works

        Set<Long> ret = new HashSet<>();
        UserGroupEntity tmp = userEntity.getUserGroup();

        // get all parents
        while( tmp != null ){
            ret.add(tmp.getId());

            tmp = tmp.getUserGroup();
        }

        List<UserGroupEntity> children = userEntity.getUserGroup().getUserGroups();

        // get all children
        if( children != null ){
            children.forEach( e -> ret.add(e.getId()) );
        }

        return ret;
    }

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}




