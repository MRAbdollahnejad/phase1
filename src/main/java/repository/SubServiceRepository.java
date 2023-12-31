package repository;

import base.repository.BaseRepository;
import entity.Service;
import entity.SubService;

import java.util.Optional;

public interface SubServiceRepository extends BaseRepository<SubService,Long> {

    boolean existBySubServiceNameAndService(String subServiceName, Service service);
}
