package base.repository;

import base.entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<T, ID> {

    protected final EntityManager em;

    public BaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public T save(T t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            t = em.merge(t);
        }
        return t;
    }

    @Override
    public List<T> saveALl(Collection<T> ts) {
        List<T> savedEntities = new ArrayList<>();
        ts.forEach(
                entity -> savedEntities.add(save(entity))
        );
        return savedEntities;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(
                em.find(
                        getEntityClass(), id
                )
        );
    }

    public abstract Class<T> getEntityClass();

    @Override
    public void deleteById(ID id) {
        em.remove(
                findById(id).orElseThrow(
                        //EXCEPTION
                        () -> new RuntimeException("entity not found")
                )
        );
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(getEntityClass());
        Root<T> root = query.from(getEntityClass());
        query.select(root);
        return em.createQuery(query).getResultList();
    }

    @Override
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        em.getTransaction().commit();
    }

}
