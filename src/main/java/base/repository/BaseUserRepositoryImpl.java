package base.repository;

import base.entity.BaseUserEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public abstract class BaseUserRepositoryImpl<E extends BaseUserEntity>
        extends BaseRepositoryImpl<E, Long>
        implements BaseUserRepository<E> {

    public BaseUserRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public boolean isEmailUnique(String email) {
        return em.createQuery("select b from BaseUserEntity b where b.emailAddress=:email")
                .setParameter("email", email)
                .getResultList().size() == 0;
    }

    @Override
    public E findByEmail(String email) throws NoResultException {
        return em.createQuery("select b from "+getEntityClass().getSimpleName()+" b where b.emailAddress=:email",getEntityClass())
                .setParameter("email",email).getSingleResult();
    }
}
