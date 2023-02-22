package RegisterPackage2;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Register
 * 
 * 
 */

@WebServlet("/Register2")
public class Register2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fName=request.getParameter("Fname");
		String lName=request.getParameter("Lname");
		String email=request.getParameter("Ename");
		String address=request.getParameter("Aname");
		String dob=request.getParameter("Dname");
		String mobile=request.getParameter("Mnumber");
		String gender=request.getParameter("gender");
		String age=request.getParameter("Agename");
		String language=request.getParameter("langauge");
		
		System.out.println(fName +" "+ lName+" "+email+" "+ address+" "+dob+" "+mobile+" "+gender+" "+age+" "+language);
		
		Member2 member=new Member2(fName,lName, email, address, dob,mobile, gender,age,language);
		
		RegisterDao2 rDao2=new RegisterDao2();
		
		String result2=rDao2.insert(member);
		
		System.out.println(result2); 
		
		response.getWriter().print(result2);
	}

}
