<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
  <thead>
    <tr>
      <th scope="col">empno</th>
      <th scope="col">ename</th>
      <th scope="col">job</th>
      <th scope="col">mgr</th>
      <th scope="col">hiredate</th>
      <th scope="col">sal</th>
      <th scope="col">comm</th>
      <th scope="col">deptno</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="emplist" items="${emplist}" varStatus="status">
      <tr>
	      <td>${emplist.empno }</td>
	      <td>${emplist.ename }</td>
	      <td>${emplist.job }</td>
	      <td>${emplist.mgr }</td>
	      <td>${emplist.hiredate }</td>
	      <td>${emplist.sal }</td>
	      <td>${emplist.comm }</td>
	      <td>${emplist.deptno }</td>
    </tr>

  </c:forEach>
  </tbody>
</table>