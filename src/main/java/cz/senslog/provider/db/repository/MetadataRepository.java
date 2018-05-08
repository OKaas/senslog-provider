package cz.senslog.provider.db.repository;

import cz.senslog.model.db.MetadataEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "metadata", path = "metadata")
public interface MetadataRepository extends PagingAndSortingRepository<MetadataEntity, Long>, JpaSpecificationExecutor {
}
