<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import = "java.sql.*" %>                    <!-- JSP���� JDBC�� ��ü�� ����ϱ� ���� java.sql ��Ű���� import �Ѵ� -->

<%

Connection conn = null;                                        // null�� �ʱ�ȭ �Ѵ�.
PreparedStatement pstmt = null;

String name =   request.getParameter("Name");
String pwd =     request.getParameter("Password");
String email  =   request.getParameter("Email");

try{
String url = "jdbc:mysql://localhost:3306/smart";        // ����Ϸ��� �����ͺ��̽����� ������ URL ���
String id = "user";                                                    // ����� ����
String pw = "user";                                                // ����� ������ �н�����

Class.forName("com.mysql.jdbc.Driver");                       // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.
conn=DriverManager.getConnection(url,id,pw);              // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
out.println("����� ����Ǿ����ϴ�.");

///
String sql = "insert into member values('"+email+"','"+name+"','"+pwd+"')";        // sql ����
                                    // ������ �����Ѵ�.
Statement stat = conn.createStatement();
stat.executeUpdate(sql);
out.println("member ���̺� ���ο� ���ڵ带 �߰��߽��ϴ�.");        // ������ �޽��� ���

stat.close();
conn.close();
pageContext.forward("new_login.html");

}catch(Exception e){                                                    // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
e.printStackTrace();
out.println("member ���̺� ���ο� ���ڵ� �߰��� �����߽��ϴ�.");
}
%>