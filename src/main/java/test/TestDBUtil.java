package test;

import java.util.List;

import jakarta.persistence.EntityManager;

import models.Employee;
import utils.DBUtil;

public class TestDBUtil {

    public static void main(String[] args) {

       EntityManager em = DBUtil.createEntityManager();
       
       List<Employee> employees = em.createNamedQuery("employee.getAll", Employee.class).getResultList();
       
       System.out.println(employees);
       for(Employee emp: employees) {
           System.out.print(emp.getId() + " : " + emp.getCode() 
                                   + " : " + emp.getName()
                                   + " : "  + emp.getPassword() 
                                   + " : " + emp.getAdminFlag() 
                                   + " : " + emp.getCreatedAt() 
                                   + " : " + emp.getUpdatedAt() + "\n");
       }
    }

}