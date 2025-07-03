package vn.edu.eiu.cse456;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.edu.eiu.cse456.entity.Course;
import vn.edu.eiu.cse456.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Connection conn = null;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {
            String url = "jdbc:mysql://localhost:3306/cse456_Q4_2025";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url,"root","Tuoi123&");
            System.out.println("Connected to database successfully");

            //Sau khi kết nối thành công thì tiếp tục thực hiện truy vấn bằng SQL
            //Tạo Class PreparedStatement để thực hiện câu truy vấn.
            PreparedStatement pstmt = conn.prepareStatement("select * from Student");

            ResultSet rs = pstmt.executeQuery();// run query and save the list to rs
//            while (rs.next()) {
//                System.out.print(rs.getString(1)+"|");
//                System.out.print(rs.getString("FirstName")+"|");
//                System.out.print(rs.getString("LsstName")+"|");
//                System.out.print(rs.getString("YOB")+"|");
//                System.out.println(rs.getString("GPA")+"|");
//            }
            while (rs.next()) {
                System.out.printf("|%4s|%10s|%10s|%4s|%4s\n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}