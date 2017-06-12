package cz.hsrs.maplog.rest.resource;

import cz.hsrs.maplog.rest.dto.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 6/9/2017.
 */
@RepositoryRestResource(collectionResourceRel = "unit", path = "unit")
public interface DataRepositoryResource extends PagingAndSortingRepository<User, String> {

    /* --- Collaborates --- */
    // @Query("SELECT c FROM User u where u.user = :user")
    // Unit findNameById(@Param("user") String user);

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


