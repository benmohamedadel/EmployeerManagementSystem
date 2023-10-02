package com.getarrays.employeermanager.service;

import com.getarrays.employeermanager.exception.UserNotFoundException;
import com.getarrays.employeermanager.model.Employer;
import com.getarrays.employeermanager.repo.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployerService {


    private  final EmployerRepo EmployerRepo;

    @Autowired
    public EmployerService(com.getarrays.employeermanager.repo.EmployerRepo employerRepo) {
        EmployerRepo = employerRepo;
    }
     public Employer addEmployer(Employer employer)
     {
         employer.setEmployerCode(UUID.randomUUID().toString());
         return EmployerRepo.save(employer);

     }
    public List<Employer> findAllEmployer(){

        return EmployerRepo.findAll();
    }
    public Employer updateEmployer(Employer employer)
    {
        return EmployerRepo.save(employer);
    }

    public Employer findEmployerById(Long id)
    {return EmployerRepo.findEmployerById(id).orElseThrow(()->new UserNotFoundException("User By Id " +id+ " was not found"));

    }
    public void DeleteEmployer(Long id)
    {
        EmployerRepo.deleteEmployerById(id);
    }
}
