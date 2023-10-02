import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
private API_SERVER= environment.apiBaseUrl;
  constructor(private http : HttpClient) { }
  public getemployees():Observable<Employee[]>{
return this.http.get<Employee[]>(`${this.API_SERVER}/employee/all`);
  }
  public addEmployees(employee: Employee):Observable<Employee>{
    return this.http.post<Employee>(`${this.API_SERVER}/employee/add`,employee);
}
public updateEmployees(employee: Employee):Observable<Employee>{
  return this.http.put<Employee>(`${this.API_SERVER}/employee/update`,employee);
}
public deleteEmployees(employeeId: number):Observable<void>
{

  return this.http.delete<void>(`${this.API_SERVER}/employee/delete/${employeeId}`);
}

}
