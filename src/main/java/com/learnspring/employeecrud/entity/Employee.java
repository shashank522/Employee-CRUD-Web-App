package com.learnspring.employeecrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last Name is required")
    @Size(min=1,message = "Last Name is required")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",message = "Enter a valid email address")
    @Column(name = "email")
    private String email;
    public Employee(){}
    public Employee(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

}
