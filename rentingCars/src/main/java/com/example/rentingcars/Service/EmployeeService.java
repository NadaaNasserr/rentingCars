package com.example.rentingcars.Service;


import com.example.rentingcars.API.ApiException;
import com.example.rentingcars.Model.Car;
import com.example.rentingcars.Model.Employee;
import com.example.rentingcars.Model.Supplier;
import com.example.rentingcars.Model.User;
import com.example.rentingcars.Repository.CarRepository;
import com.example.rentingcars.Repository.EmployeeRepository;
import com.example.rentingcars.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
        Boolean tcheck =false;
        employee.setIsApproved(tcheck);
        employeeRepository.save(employee);
    }

    public void updateEmployee(Integer id, Employee employee) {
        Employee oldEmployee =employeeRepository.findEmployeeById(id);
        if (oldEmployee == null) {
            throw new ApiException("the Employee not found");
        }
        oldEmployee.setName(employee.getName());
        oldEmployee.setAge(employee.getAge());
        oldEmployee.setCountOfCarsInspected(employee.getCountOfCarsInspected());
        oldEmployee.setQualification(employee.getQualification());
        oldEmployee.setBonus(employee.getBonus());
        employeeRepository.save(oldEmployee);

    }
    public void deleteEmployee(Integer id){
        Employee employee =employeeRepository.findEmployeeById(id);
        if (employee == null) {
            throw new ApiException("the Employee not found");
        }
        employeeRepository.delete(employee);
    }

    public void assignEmployeeToCar(Integer employee_id, Integer car_id ){
        Employee employee = employeeRepository.findEmployeeById(employee_id);
        Car car = carRepository.findCarById(car_id);

        if(employee_id==null || car_id == null){
            throw  new ApiException("employee or car not found");
        }

        car.setEmployee(employee);
        carRepository.save(car);
    }
}
