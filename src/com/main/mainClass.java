package com.main;



import java.util.List;
import java.util.Scanner;

import com.Entity.Employee;
import com.connection.DBEmployeeConnection;
import com.connection.Dao.EmployeeDao;



public class mainClass {

	public static void main(String[] args) {

		boolean f = true;

		while (f) {
			System.out.println("----------------------");
			System.out.println("1. Create Employee");
			System.out.println("2. Edit Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. View Employee");
			System.out.println("5. Exit");
			System.out.println("----------------------");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter One Of the Option Displayed Above");
			int no = sc.nextInt();

			EmployeeDao dao = new EmployeeDao(DBEmployeeConnection.getConn());

			switch (no) {
			case 1:
				System.out.println("Enter Employee Name");
				String name = sc.next();
				System.out.println("Enter Employee Ph No");
				String phno = sc.next();

				Employee c = new Employee();
				c.setName(name);
				c.setPhno(phno);

				boolean s1 = dao.saveEmployee(c);

				if (s1) {
					System.out.println(" Employee  Saved..");
				} else {
					System.out.println("Something wrong on server..");
				}
				break;

			case 2:
				System.out.println("Enter Employee Id");
				int id = sc.nextInt();
				System.out.println("Enter Employee Name");
				String name2 = sc.next();
				System.out.println("Enter Employee Ph no");
				String phno2 = sc.next();

				Employee c2 = new Employee();
				c2.setId(id);
				c2.setName(name2);
				c2.setPhno(phno2);

				boolean s2 = dao.editEmployee(c2);

				if (s2) {
					System.out.println(" Employee Phno Edit Sucessfully..");
				} else {
					System.out.println("Employee Is not Available");
				}

				break;
			case 3:

				System.out.println("Enter Employee Id");
				int id3 = sc.nextInt();

				boolean s3 = dao.deleteEmployee(id3);

				if (s3) {
					System.out.println("Employee Delete Sucessfully..");
				} else {
					System.out.println("Employee Is not Available");
				}

				break;
			case 4:

				List<Employee> list = dao.getAllEmployee();

				if (list.isEmpty()) {
					System.out.println("Phno is Not Available");
				} else {

					for (Employee con : list) {
						System.out.println("Id=" + con.getId());
						System.out.println("Name=" + con.getName());
						System.out.println("Phno=" + con.getPhno());
						System.out.println("---------------------");
					}
				}
				break;
			case 5:
				f = false;
				System.out.println("Thank u..Visit Again..");
				break;

			default:
				System.out.println("Please Enter Correct No..");
				break;
			}

		}

	}

}

