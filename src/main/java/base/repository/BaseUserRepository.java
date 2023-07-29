package base.repository;


import base.entity.BaseUserEntity;

public interface BaseUserRepository<E extends BaseUserEntity>
        extends BaseRepository<E,Long>{

    boolean isEmailUnique(String email);


}
