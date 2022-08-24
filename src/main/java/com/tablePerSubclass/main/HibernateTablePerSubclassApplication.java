package com.tablePerSubclass.main;

import com.tablePerSubclass.model.ContractEmployee;
import com.tablePerSubclass.model.Employee;
import com.tablePerSubclass.model.PermanentEmployee;
import com.tablePerSubclass.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class HibernateTablePerSubclassApplication {

	public static void main(String[] args) {
		//	SpringApplication.run(HibernateTablePerSubclassApplication.class, args);
		SessionFactory sf = HibernateUtil.getSessionFactory();

		//Get session from Sesson factory
		Session session = sf.openSession();
		//Begin transaction
		Transaction t=session.beginTransaction();

		//Creating Employee base class record
		Employee employee=new Employee();
		employee.setName("John");
		employee.setCity("new jersy");

		//Creating Permanent Employee subclass record
		PermanentEmployee permanentEmployee=new PermanentEmployee();
		permanentEmployee.setName("Jacob");
		permanentEmployee.setSalary(30000);
		permanentEmployee.setCity("california");


		//Creating Contract Employee subclass record
		ContractEmployee contractEmployee=new ContractEmployee();
		contractEmployee.setName("Raj");
		contractEmployee.setHourlyrate(2000);
		contractEmployee.setCity("hyderabad");

		//persist all the employee records
		session.persist(employee);
		session.persist(permanentEmployee);
		session.persist(contractEmployee);

		//Commit the transaction and close the session
		t.commit();
		session.close();
		System.out.println("successfully persisted all the Employee records");
	}

}
