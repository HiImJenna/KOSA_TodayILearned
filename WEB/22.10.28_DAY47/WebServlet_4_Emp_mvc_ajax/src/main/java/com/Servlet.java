package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmpDAO;
import DTO.Emp;
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response , String method) throws ServletException, IOException {
    	//1. 한글처리
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
        PrintWriter out = response.getWriter();
        
    	//2. 요청받기 (데이터) request
    	String data = request.getParameter("EMP");
    	System.out.println(data);
    	
    	//3. 요청판단
		 String msg="";

		 //java 파일 용이 (DAO , DTO)
		 EmpDAO edao = new EmpDAO();
		 Emp emp = new Emp();
		 
		 
		 List<Emp> list = edao.getEmpAllList();
		 System.out.println("test" + list);

		//4. 데이터 저장
		 request.setAttribute("emplist", list);
		 
		//5. view 페이지 설정
		//뷰 지정하기 (Dispatcher)
		RequestDispatcher dis = request.getRequestDispatcher("/Team2_Main_EMP.jsp");
		 
		 
		//6. view 데이터 전달(forward)
		 dis.forward(request, response);

		 }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
