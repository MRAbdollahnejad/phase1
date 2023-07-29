package service;

import base.service.BaseUserService;
import dto.SpecialistDTO;
import entity.Specialist;

public interface SpecialistService extends BaseUserService<Specialist> {
    void signupSpecialist(SpecialistDTO specialistDTO);
}
