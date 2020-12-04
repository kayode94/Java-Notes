package com.lambda.webemployees.controllers;



import com.lambda.webemployees.models.Employee;
import com.lambda.webemployees.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// CONTROLLERS CONTROL THE WAY WE INTERACT WITH THE OUTSIDE WORLD
// CONTROLLERS BRING IN REQUESTS FROM THE CLIENT AND SENDING IT BACK TO THE CLIENT
// TURNING THE CLASS INTO A BEAN
// THE CLASS IS ALSO A REST CONTROLLER
@RestController
public class EmployeeController
{
    //STEP 1.
        // WE NEED TO CREATE A REPOSITORY
        // CREATE AN OBJECT OF THE REPOSITORY WHEN WE FIRST RUN THE CLASS
        // CREATE AN OBJECT OF THE REPOSITORY
    @Autowired
    EmployeeRepository emprepos;

    private List<Employee> findEmployees(List<Employee> myList, CheckEmployee tester)
    {
        List<Employee> tempList = new ArrayList<>();
        for(Employee e : myList)
        {
            if(tester.test(e))
            {
                tempList.add(e);
            }
        }
        return tempList;
    }

    // http://localhost:2019/employees/all
    // CREATING THE ENDPOINT USING @GetMapping(value ="your/endpoint", produces="application/json")
    @GetMapping(value = "/employees/all", produces = "application/json")
    // RETURN A ResponseEntity<?>
    // THE METHOD WORKING WITH ResponseEntity is listAllEmployees()
    public ResponseEntity<?> listAllEmployees()
    {
        // CREATE A LIST OF EMPLOYEE
        List<Employee> myList = new ArrayList<>();

        // THE REPOSITORY HAS A METHOD .findAll()
            // THE REPOSITORY DOESN'T KNOW WHAT TYPE OF DATA I WANT TO GET RETURNED
            // RETURNS AN ITERATOR .findAll().iterator()
            // WE THEN TAKE THE ITERATOR AND COVERT IT TO THE LIST WE CREATED
            // .findAll().iterator().forEachRemaining(yourListName::add)
        // SO findAll() employees that gives me an .iterator()
            // I LOOP THOUGH THE .iterator()
            // .forEachRemaining() element in the iterator
            // add the element to my array list myList::add
        emprepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((e1, e2) -> e1.getLname().compareToIgnoreCase(e2.getLname()));

        // RETURN THE LIST WE JUST CREATED
        // RETURN THE STATUS HttpStatus.OK
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //filter the list
    // http://localhost:2019/employees/name/s
    @GetMapping(value = "/employees/name/{letter}", produces = "application/json")
    public ResponseEntity<?> listAllEmployeesByFirstName(@PathVariable char letter)
    {
        List <Employee> myList = new ArrayList<>();
        emprepos.findAll().iterator().forEachRemaining(myList::add);
        List <Employee> returnList = findEmployees(myList, e -> e.getFname().charAt(0) == letter);

        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    //http://localhost:2019/employees/total
    @GetMapping(value = "/employees/total", produces = "application/json")
    public ResponseEntity<?> totalEmployeeSalary()
    {
        List <Employee> myList = new ArrayList<>();
        emprepos.findAll().iterator().forEachRemaining(myList::add);

        double total = 0.0;
        for (Employee e : myList)
        {
            total = total + e.getSalary();
        }

        System.out.println("Total Salary: " + total);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }


}
