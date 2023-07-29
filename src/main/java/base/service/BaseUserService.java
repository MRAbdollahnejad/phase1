package base.service;


import base.entity.BaseUserEntity;

public interface BaseUserService<Q extends BaseUserEntity> extends BaseService<Q,Long>{

    boolean isEmailUnique(String email);
    void changeUserPassword(Q q , String newPassword) ;
}
