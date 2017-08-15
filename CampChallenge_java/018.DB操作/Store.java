/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import static java.lang.System.out;
import java.sql.*;

public class Store {

    public static void main(String[] args) {

        Connection db_con = null;
        PreparedStatement db_st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "GEEKJOB", "password");

            
            db_st = db_con.prepareStatement("insert into profiles values ( ? , ?, ? , ? , ?)");
            db_st.setInt(1, 5);
            db_st.setInt(4,20);
            db_st.setString(2, "山田 太郎");
            db_st.setString(3, "080-1111-2222");
            db_st.setString(5, "1994-08-08");
            
            db_st.executeUpdate();

            db_st.close();
            db_con.close();
        } catch (SQLException e_sqle) {
            out.println("接続時にエラーが発生しました:" + e_sqle.toString());
        } catch (Exception e) {
            out.println("接続時にエラーが発生しました：" + e.toString());
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
            }
        }
    }
}
