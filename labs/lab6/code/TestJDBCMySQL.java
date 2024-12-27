import java.sql.*;

public class TestJDBCMySQL
{   public static void main(String[] args)
    {   String url = "jdbc:mysql://localhost/Orders";
        String uid = "root";
        String pw = "304rootpw";              
              
        try ( Connection con = DriverManager.getConnection(url, uid, pw);
              Statement stmt = con.createStatement();) 
        {
            ResultSet rst = stmt.executeQuery("SELECT productId, quantity*pricePerItem totalSales FROM OrderedProduct JOIN Orders ON OrderedProduct.orderId = Orders.orderId WHERE orderDate > '2017-09-01' GROUP BY OrderedProduct.productId ORDER BY totalSales DESC LIMIT 5");
            while (rst.next())
            {   System.out.println(rst.getInt("productId")+","+rst.getDouble("totalSales"));
            }
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
        }
    }
}