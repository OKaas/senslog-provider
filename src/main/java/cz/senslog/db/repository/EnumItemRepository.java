package cz.senslog.db.repository;

import cz.senslog.db.model.EnumItemEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 1/21/2018.
 */
@RepositoryRestResource(collectionResourceRel = "enumItem", path = "enumItem")
public interface EnumItemRepository extends PagingAndSortingRepository<EnumItemEntity, Long>, JpaSpecificationExecutor {
}
