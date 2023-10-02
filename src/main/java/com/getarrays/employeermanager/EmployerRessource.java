package com.getarrays.employeermanager;

import com.getarrays.employeermanager.model.Employer;
import com.getarrays.employeermanager.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") //Give the class a default URL
public class EmployerRessource {
    private final EmployerService employerService;


    public EmployerRessource(EmployerService employerService) {
        this.employerService = employerService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employer>> getAllEmployees(){
        List<Employer> employees=employerService.findAllEmployer();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable("id") Long id){
        Employer employee=employerService.findEmployerById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<Employer> addEmployee(@RequestBody Employer employee)
    {
        Employer newEmployer=employerService.addEmployer(employee);
        return new ResponseEntity<>(newEmployer,HttpStatus.CREATED);

    }
    @PutMapping("/update")
    public  ResponseEntity<Employer> updateEmployee(@RequestBody Employer employee)
    {
        Employer UpdateEmployer=employerService.updateEmployer(employee);
        return new ResponseEntity<>(UpdateEmployer,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteEmployee(@PathVariable("id") long id)
    {
               employerService.DeleteEmployer(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
