package repository;

import base.repository.BaseRepository;
import entity.Service;

public interface ServiceRepository extends BaseRepository<Service,Long> {
    boolean existByServiceName(String serviceName);
}
