package com.lambda.webemployees.models;


import javax.persistence.*;

// MODELS(TABLE) ARE WHERE WE SET UP THE STRUCTURE OF OUR DATABASE

// BEAN-> MANAGED BY SPRING
// TO TURN SOMETHING INTO A BEAN WE HAVE TO TELL IT THE TYPE
// WE USE ANNOTATIONS TO TELL THE BEAN THE TYPE

//THIS IS A TABLE(ENTITY)
// THIS IS HOW YOU TURN A MODEL/TABLE/JAVA OBJECT INTO A BEAN
@Entity

// WHEN WE CREATE THE TABLE
// THE TABLE NAME = EMPLOYEES
@Table(name = "employees")
public class Employee //THIS PIECE OF JAVA CODE IS SETTING UP THE ENTITY VIA @ENTITY
{
  // CREATING THE PRIMARY KEY FOR THE TABLE
  // USE THE ANNOTATION "@Id"
  @Id
  // TELLING HOW WE WANT TO GENERATE THE Id
  // WE ARE TELLING THE DATA BASE GENERATE THE Id HOWEVER YOU WANT TO
  @GeneratedValue(strategy = GenerationType.AUTO)

  //-----LONG----
  // HAS A WRAPPER CLASS CALLED "LONG"
  // ABLE TO USE MORE NUMBERS
  // IN SPRING WE HAVE TO GIVE THE CLASS SOMETIMES NOT THE PRIMITIVE OBJECT
  private long empid; // THIS PIECE OF JAVA CODE IS SETTING UP THE Id VIA @Id

  // EACH FIELD WILL BECOME A COLUMN IN OUR DATABASE
  // EACH FIELD MUST BE IN ALL LOWERCASE LETTERS(afieldname)

  private String fname;
  private String lname;
  private double salary;

    // STEP 1. CREATE THE CONSTRUCTOR
        // Right click empty space
        // Click Generate --> Constructor
        // Generate the default contructor first --> select "NONE"
        // default constructor - required by Spring Data JPA
  public Employee()
  {

  }


    // STEP 2. GENERATE OUR OWN CONSTRUCTOR
        // Right click empty space
        // Click Generate --> Constructor
        // Select all fields(fname, lname, salary)
    public Employee(String fname, String lname, double salary)
    {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
    }

    // STEP 3. CREATE GETTERS AND SETTERS FOR THE FIELDS
        // Right click empty space
        // Click Generate --> Getter and Setter
        // Select all fields(fname, lname, empid, salary)

    public long getEmpid()
    {
        return empid;
    }

    public void setEmpid(long empid)
    {
        this.empid = empid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    // STEP 4. CREATE A toString()
        // Right click empty space
        // Click Generate --> toString()
        // Select all fields get the full state of the object (fname, lname, empid, salary)
    @Override
    public String toString()
    {
        return "Employee{" +
                "empid=" + empid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
