package kr.or.kosa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
    
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Emp emp = new Emp();
    	EmpDao dao = new EmpDao();
    	
    	System.out.println("doProcess");
    	
		ArrayList<Emp> Sal = new ArrayList<Emp>(dao.salRank());
				
		request.setAttribute("Sal", Sal);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("highchart.jsp");
		dispatcher.forward(request, response);
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
