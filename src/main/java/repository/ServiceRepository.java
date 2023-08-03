package repository;

import base.repository.BaseRepository;
import entity.Service;

import java.util.Optional;

public interface ServiceRepository extends BaseRepository<Service,Long> {
    boolean existByServiceName(String serviceName);

    Optional<Service> findByServiceName(String serviceName);
}
