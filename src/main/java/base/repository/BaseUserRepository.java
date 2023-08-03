package base.repository;


import base.entity.BaseUserEntity;

import javax.persistence.NoResultException;

public interface BaseUserRepository<E extends BaseUserEntity>
        extends BaseRepository<E,Long>{

    boolean isEmailUnique(String email)throws NoResultException;
    E findByEmail(String email);


}
