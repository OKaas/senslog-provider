package cz.hsrs.maplog.util;

import cz.hsrs.maplog.db.entity.UserGroupEntity;
import cz.hsrs.maplog.rest.dto.UserGroup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
@Component
public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

    /* --- Collaborates --- */
    public UserGroup convertToDto(UserGroupEntity group) {
        if( group != null ){
            return modelMapper.map(group, UserGroup.class);
        } else {
            return null;
        }
    }

    public List<UserGroup> convertToDto(List<UserGroupEntity> group) {

        List<UserGroup> ret = new ArrayList<>();
        for( UserGroupEntity gr : group ){
            ret.add(convertToDto(gr));
        }

        return ret;
    }

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


