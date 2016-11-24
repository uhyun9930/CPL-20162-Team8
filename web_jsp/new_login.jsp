<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "java.sql.*" %>                    <!-- JSP에서 JDBC의 객체를 사용하기 위해 java.sql 패키지를 import 한다 -->

<%

Connection conn = null;                                        // null로 초기화 한다.
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs;

String pwd1 =     request.getParameter("Password");
String email1  =   request.getParameter("Email");
String mem_pw=null;
try{
String url = "jdbc:mysql://localhost:3306/smart";        // 사용하려는 데이터베이스명을 포함한 URL 기술
String id = "user";                                                    // 사용자 계정
String pw = "user";                                                // 사용자 계정의 패스워드

Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
out.println("제대로 연결되었습니다.");
pageContext.forward("gg.jsp");

//stmt = conn.createStatement();
String sql = "select email from member where email='email1'";
rs = stmt.executeQuery(sql);


if(!rs.next())
{
	out.print("alert('해당 정보가 없습니다!');");

	stmt.close();
	conn.close();
	pageContext.forward("new_login.html");
}
else
{
	try{
		mem_pw=rs.getString("pass");
		if(mem_pw.compareTo(pwd1)!=0 )
		{	
			out.print("alert('비밀번호가 틀렸습니다!');");
			pageContext.forward("new_login.html");
			
		}
		else
		{
			out.print("alert('로그인 성공!');");
			pageContext.forward("gg.jsp");
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}catch(Exception e){
		
		System.out.println(e);
		
	}
}

}catch(Exception e){                                                    // 예외가 발생하면 예외 상황을 처리한다.
e.printStackTrace();

}
%>