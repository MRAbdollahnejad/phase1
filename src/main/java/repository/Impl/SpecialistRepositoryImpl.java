package repository.Impl;

import base.repository.BaseUserRepositoryImpl;
import entity.Specialist;
import repository.SpecialistRepository;

import javax.persistence.EntityManager;

public class SpecialistRepositoryImpl extends BaseUserRepositoryImpl<Specialist> implements SpecialistRepository {
    public SpecialistRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Specialist> getEntityClass() {
        return Specialist.class;
    }
}
