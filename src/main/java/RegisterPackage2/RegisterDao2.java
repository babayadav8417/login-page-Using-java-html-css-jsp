package RegisterPackage2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import java.util.*;
public class RegisterDao2 {
		private String dbUrl="jdbc:mysql://localhost:3306/userdb";
		private String dbUname="root";
		private String dbPassword="Baba@1234";
		private String dbDriver="com.mysql.cj.jdbc.Driver";
		
		public void loadDriver(String dbDriver) {
			try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Connection getConnection() {
			 Connection con=null;
			 try {
				con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return con;
		}
		
		public String insert(Member2 member) {
			loadDriver(dbDriver);
			Connection con =getConnection();
			String result2 ="Data entered successfully";
			String sql="insert into member2 values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps;
			try {
			ps=con.prepareStatement(sql);
			ps.setString(1,member.getfName());
			ps.setString(2,member.getlName());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getAddress());
			ps.setString(5,member.getDob());
			ps.setString(6,member.getmNumber());
			ps.setString(7,member.getGender());
			ps.setString(8,member.getAge());
			ps.setString(9,member.getLanguage());
			System.out.println(member.getLanguage());
			ps.executeUpdate();
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result2="Data not entered";
			}
			
			return result2;
		}
		
}

