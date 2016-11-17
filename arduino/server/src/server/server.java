package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class server {
      ServerSocket server = null;
      Socket client = null;
      static final int port = 3000; //상수값으로 port 번호 설정
      //private static ConnectionDB connectionDB; 
      static byte[] buffer = new byte[65507];
     
      server()
      {
         try
         {
          DatagramSocket ds = new DatagramSocket(port); //port 번호: 3000으로 ServerSocket 생성
         DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            
            // ConnectionDB connectionDB = new ConnectionDB();
            
            System.out.println("*****  Server Program이 Clinet 접속을 기다립니다. *****");


            //*** Clinet가 보내온 message를 Server가 읽은 후 다시 Clinet에게 전송함 ***//
            while (true) //ObjectInputStream.readObject() 호출
            {
              try {
               ds.receive(dp);
               String s = new String(dp.getData(), 0, 0, dp.getLength());
                  if (s.equals("quit")) //"quit" 입력시 종료
                  {
                     break;
                  }
               System.out.println(dp.getAddress()+" at port "+dp.getPort()+ " says "+s);
               //connectionDB.insertDB(s);
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            }
         }
         catch (SocketException se)
         {
            System.err.println(se);
            System.exit(0);
         }
      }
      public static void main(String[] args) 
      {
         new server(); 
      }
}
