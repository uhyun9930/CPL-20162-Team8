<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "java.sql.*" %>                    <!-- JSP에서 JDBC의 객체를 사용하기 위해 java.sql 패키지를 import 한다 -->

<%

Connection conn = null;                                        // null로 초기화 한다.
PreparedStatement pstmt = null;

String name =   request.getParameter("Name");
String pwd =     request.getParameter("Password");
String email  =   request.getParameter("Email");

try{
String url = "jdbc:mysql://localhost:3306/smart";        // 사용하려는 데이터베이스명을 포함한 URL 기술
String id = "user";                                                    // 사용자 계정
String pw = "user";                                                // 사용자 계정의 패스워드

Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
out.println("제대로 연결되었습니다.");

///
String sql = "insert into member values('"+email+"','"+name+"','"+pwd+"')";        // sql 쿼리
                                    // 쿼리를 실행한다.
Statement stat = conn.createStatement();
stat.executeUpdate(sql);
out.println("member 테이블에 새로운 레코드를 추가했습니다.");        // 성공시 메시지 출력

stat.close();
conn.close();
pageContext.forward("new_login.html");

}catch(Exception e){                                                    // 예외가 발생하면 예외 상황을 처리한다.
e.printStackTrace();
out.println("member 테이블에 새로운 레코드 추가에 실패했습니다.");
}
%>