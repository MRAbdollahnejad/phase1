package base.service;

import base.entity.BaseUserEntity;
import base.repository.BaseUserRepository;
import util.UserValidator;

public abstract class BaseUserServiceImpl<Q extends BaseUserEntity, R extends BaseUserRepository<Q>>
        extends BaseServiceImpl<Q, Long, R>
        implements BaseUserService<Q> {

    public BaseUserServiceImpl(R repository) {
        super(repository);
    }

    @Override
    public boolean isEmailUnique(String email){
        return repository.isEmailUnique(email);
    }

    @Override
    public void changeUserPassword(Q q, String newPassword)  {
        UserValidator userValidator=new UserValidator();
        if (!userValidator.passwordValidator(newPassword)){
            System.out.println("fail to change password please choose strong password");
            return;
        }else{
        q.setPassword(newPassword);
            this.save(q);
        }
    }
}
