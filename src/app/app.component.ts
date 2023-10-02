import { HttpErrorResponse } from '@angular/common/http';
import { NullVisitor } from '@angular/compiler/src/render3/r3_ast';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeServiceService } from './employee-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public employees: Employee[]=[];
  public editEmployee: Employee | undefined;
  public deleteEmployee: Employee | undefined;
constructor(private EmployeeService :EmployeeServiceService,){}
  ngOnInit(): void {

 this.getemployee();
  }
public getemployee():void{

  this.EmployeeService.getemployees().subscribe(
    (responce:Employee[])=>{

      this.employees=responce;

    }
    ,
    (error:HttpErrorResponse)=>{
      alert (error.message);

    }
  );
}
public onAddEmloyee(addForm: NgForm): void {
  document.getElementById('add-employee-form')?.click();
  this.EmployeeService.addEmployees(addForm.value).subscribe(
    (response: Employee) => {
      console.log(response);
      this.getemployee();
      addForm.reset();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
      addForm.reset();
    }
  );
}

public onUpdateEmloyee(employee: Employee): void {
  this.EmployeeService.updateEmployees(employee).subscribe(
    (response: Employee) => {
      console.log(response);
      this.getemployee();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

public onDeleteEmloyee(employeeId: number|undefined): void {
  if(employeeId!=null)
  {
  this.EmployeeService.deleteEmployees(employeeId).subscribe(
    (response: void) => {
      console.log(response);
      this.getemployee();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );}
}

public searchEmployees(key: string): void {
  console.log(key);
  const results: Employee[] = [];
  for (const employee of this.employees) {
    if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
      results.push(employee);
    }
  }
  this.employees = results;
  if (results.length === 0 || !key) {
    this.getemployee();
  }
}

public onOpenModal(employee: Employee |null, mode: string): void {
  const container = document.getElementById('main-container');
  const button = document.createElement('button');
  button.type = 'button';
  button.style.display = 'none';
  button.setAttribute('data-toggle', 'modal');
  if (mode === 'add') {
    button.setAttribute('data-target', '#addEmployeeModal');
  }
  if (mode === 'edit' &&employee!=null) {
    this.editEmployee = employee;
    button.setAttribute('data-target', '#updateEmployeeModal');
  }
  if (mode === 'delete'&&employee!=null) {
    this.deleteEmployee = employee;
    button.setAttribute('data-target', '#deleteEmployeeModal');
  }
  container?.appendChild(button);
  button.click();
}

}
