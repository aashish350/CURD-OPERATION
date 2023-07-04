package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Student;
import utility.Connector;
import dto.Student;
public class Impldao implements Idao {
	PreparedStatement pstm=null;
	@Override
	public void insert(Student stud) {
		PreparedStatement pstm;
		try {
			Connection con=Connector.getJdbcConnection();
		//	System.out.println("Implementation class name of this object is ::"+con.getClass().getName());
			String query="insert into Student (Sid,Name,Age,Email,Adress) values(?,?,?,?,?)";
			pstm=con.prepareStatement(query);
			
			pstm.setInt(1, stud.getSid());
			pstm.setString(2, stud.getName());
			pstm.setInt(3, stud.getAge());
			pstm.setString(4, stud.getEmail());
			pstm.setString(5, stud.getAdress());
			int row=pstm.executeUpdate();
			if(row==1) {
				System.out.println("Insertion is happened sucessfully");
			}else {
				System.out.println("insertion of student data failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		 Student std = new Student();
        try {
			Connection con=Connector.getJdbcConnection();
			String query="select * from Student where Sid=?";
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, id);
		   ResultSet res=pstm.executeQuery();
		//  System.out.println("Nothing happened ");
		   if(res!=null) {
			   if(res.next()) {
				   std.setSid(res.getInt(1));
				   std.setName(res.getString(2));
				   std.setAge(res.getInt(3));
				   std.setEmail(res.getString(4));
				   std.setAdress(res.getString(5));
			   }
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String deleteById(Integer id) {
		
		try {
			Connection con=Connector.getJdbcConnection();
			String query="delete from Student where Sid=?";
			pstm=con.prepareStatement(query);
			pstm.setInt(1, id);
			int row=pstm.executeUpdate();
			//System.out.println(row);
			if(row==1) {
				System.out.println("Deletion happens sucessfully");
				return "sucess";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String update(Student stud) {
		Connection con;
		String query="update Student set sid=?,name=?,adress=?, email=?,age=?";
	
		try {
			con = Connector.getJdbcConnection();
			pstm=con.prepareStatement(query);
			if(pstm!=null) {
				pstm.setInt(1, stud.getSid());
				pstm.setString(2, stud.getName());
				pstm.setString(3, stud.getAdress());
				pstm.setString(4, stud.getEmail());
				pstm.setInt(5, stud.getAge());
			int row=	pstm.executeUpdate();
				if(row==1) {
					
					return "sucess";
				}else
					return "failed";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "fialed";
	}

}
