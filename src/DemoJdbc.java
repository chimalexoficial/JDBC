import org.postgresql.Driver;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

/*
* import packages
* load driver
* register driver
* connection
* create a statement (db query)
* execute statement
* close connection
* */
public class DemoJdbc {
    //        String sql = "INSERT INTO student VALUES (5, 'John', 48 )";
    //        String sql = "UPDATE student SET sname='Max' WHERE sid = 5";
    //        String sql = "DELETE from student WHERE sid = 5";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "root";

        int sid = 102;
        String sname = "Jasmine";
        int marks = 52;

        String sql = "INSERT INTO student VALUES (?,?,?)";
//        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connected :D");
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);

        st.execute();
        con.close();
        System.out.println("Connection closed");
    }
}


//        ResultSet result = st.executeQuery(sql);
//        result.next();
//        String name = result.getString(1);
//        System.out.println("Name of the student is " + name);

//        while(result.next()) { //next row
//            System.out.print(result.getInt(1) + " - ");
//            System.out.print(result.getString(2) + " - ");
//            System.out.println(result.getInt(3));
//        }
