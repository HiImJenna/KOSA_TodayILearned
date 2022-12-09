package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MemoList() {
      super();
   }

   private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
      System.out.println("목록보기");
      //  http://localhost:8090/WebServlet_4_Memo_mvc/MemoList
      
      MemoDao dao = new MemoDao();
      try {
         List<Memo> memoList = dao.getMemoList();
         
         // 데이터 저장
         request.setAttribute("memolist", memoList);
         
         // view 지정
         RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
         
         //forward
         dis.forward(request, response);
      } catch (Exception e) {
      }
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response, "GET");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response, "POST");
   }

}