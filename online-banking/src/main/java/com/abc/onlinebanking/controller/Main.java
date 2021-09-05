package com.abc.onlinebanking.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main
{
   public static void main(String[] args)
   {
      Employee[] employees = {
         new Employee("J", "Red", 51000, "IT"),
         new Employee("A", "Green", 71600, "IT"),
         new Employee("M", "Black", 35187.5, "Sales"),
         new Employee("K", "Yellow", 47100.77, "Marketing"),
         new Employee("L", "Pink", 62001, "IT"),
         new Employee("D", "Blue", 32001, "Sales"),
         new Employee("W", "Brown", 42361.4, "Marketing")};

      // get List view of the Employees
      List<Employee> list = Arrays.asList(employees);

      // display all Employees
      System.out.println("Complete Employee list:");
      list.stream().forEach(System.out::println);
      
      Map<String, Double> avgSalary = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
    		  Collectors.averagingDouble(Employee::getSalary)));
      
      
      
      Set<Entry<String, Double>> entrySet = avgSalary.entrySet();
      
      for (Entry<String, Double> entry : entrySet) {
    	  System.out.println(entry.getKey() + " : " + entry.getValue());
      } 
      
      //System.out.println("avgSalary:" + avgSalary);
      
      // average of Employee salaries with DoubleStream average method
      /*
      System.out.printf("Average of Employees' salaries: %.2f%n",
         list.stream().collect(Collectors.groupingBy(Employee::getDepartment))
 //            .mapToDouble(Employee::getSalary)
 //            .average()
 //            .getAsDouble());   
     */
   } 
}
class Employee
{
   private String firstName;
   private String lastName;
   private double salary; 
   private String department;
   
   // constructor 
   public Employee(String firstName, String lastName, 
      double salary, String department)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
      this.department = department;
   } 

   // set firstName
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   // get firstName
   public String getFirstName()
   {
      return firstName;
   }

   // set lastName
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   // get lastName
   public String getLastName()
   {
      return lastName;
   }

   // set salary
   public void setSalary(double salary)
   {
      this.salary = salary;
   }

   // get salary
   public double getSalary()
   {
      return salary;
   }

   // set department
   public void setDepartment(String department)
   {
      this.department = department;
   }

   // get department
   public String getDepartment()
   {
      return department;
   }

   // return Employee's first and last name combined
   public String getName()
   {
      return String.format("%s %s", getFirstName(), getLastName());
   }

   // return a String containing the Employee's information
   @Override
   public String toString() 
   {
      return String.format("%-8s %-8s %8.2f   %s", 
         getFirstName(), getLastName(), getSalary(), getDepartment());
   } 
}