package com.getarrays.employeermanager.repo;

import com.getarrays.employeermanager.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.Optional;

public interface EmployerRepo extends JpaRepository<Employer,Long> {
    


    Optional<Employer> findEmployerById(Long id);

    default void deleteEmployerById(Long id)
    {
        this.deleteAllByIdInBatch(Collections.singleton(id));

    }

}
