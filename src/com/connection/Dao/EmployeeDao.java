package com.connection.Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Employee;



public class EmployeeDao {



	private Connection conn;

	public EmployeeDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveEmployee(Employee c) {
		boolean f = false;

		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee(name,phno) values(?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getPhno());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editEmployee(Employee c) {
		boolean f = false;

		try {
			PreparedStatement ps = conn.prepareStatement("update employee set phno=? where id=?");
			ps.setString(1, c.getPhno());
			ps.setInt(2, c.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteEmployee(int id) {
		boolean f = false;

		try {
			PreparedStatement ps = conn.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		Employee obj = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				obj=new Employee();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhno(rs.getString(3));
				list.add(obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
