<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "java.sql.*" %>                    <!-- JSP���� JDBC�� ��ü�� ����ϱ� ���� java.sql ��Ű���� import �Ѵ� -->

<%

Connection conn = null;                                        // null�� �ʱ�ȭ �Ѵ�.
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs;

String pwd1 =     request.getParameter("Password");
String email1  =   request.getParameter("Email");
String mem_pw=null;
try{
String url = "jdbc:mysql://localhost:3306/smart";        // ����Ϸ��� �����ͺ��̽����� ������ URL ���
String id = "user";                                                    // ����� ����
String pw = "user";                                                // ����� ������ �н�����

Class.forName("com.mysql.jdbc.Driver");                       // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.
conn=DriverManager.getConnection(url,id,pw);              // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
out.println("����� ����Ǿ����ϴ�.");
pageContext.forward("gg.jsp");

//stmt = conn.createStatement();
String sql = "select email from member where email='email1'";
rs = stmt.executeQuery(sql);


if(!rs.next())
{
	out.print("alert('�ش� ������ �����ϴ�!');");

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
			out.print("alert('��й�ȣ�� Ʋ�Ƚ��ϴ�!');");
			pageContext.forward("new_login.html");
			
		}
		else
		{
			out.print("alert('�α��� ����!');");
			pageContext.forward("gg.jsp");
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}catch(Exception e){
		
		System.out.println(e);
		
	}
}

}catch(Exception e){                                                    // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
e.printStackTrace();

}
%>