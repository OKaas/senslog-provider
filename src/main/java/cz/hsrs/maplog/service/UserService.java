package cz.hsrs.maplog.service;

import cz.hsrs.maplog.db.entity.UserEntity;
import cz.hsrs.maplog.db.entity.UserGroupEntity;
import cz.hsrs.maplog.db.repository.UserGroupRepository;
import cz.hsrs.maplog.db.repository.UserRepository;
import cz.hsrs.maplog.security.UserToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by OK on 11/17/2017.
 */
@Service
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public UserToken loadUserByUsername(String username) throws
            UsernameNotFoundException {

        LOGGER.info("Try login: {}", username);

        UserEntity user = userRepository.findByNameEquals(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return new UserToken(user.getName(), user.getPassword(), user.getUserGroup(), getGroup(user), getGrantedAuthorities(username) );
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




