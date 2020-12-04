package com.lambda.webemployees.repositories;

import com.lambda.webemployees.models.Employee;
import org.springframework.data.repository.CrudRepository;

// REPOSITORIES CONNECTS OUR MODELS TO THE REST OF OUR APPLICATION
// MAKING USE OF THE ABSTRACT CLASS CrudRepository

//WHEN CREATING A CrudRepository WE HAVE TO TELL IT
    // THE NAME OF THE MODEL
    // TELL IT THE DATA TYPE OF THE MODEL'S PRIMARY KEY
    // PRIMARY KEY MUST BE GIVEN AS A CLASS
    // CAPITAL "L" "long"
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{

}
