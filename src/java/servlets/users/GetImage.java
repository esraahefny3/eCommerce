package servlets.users;

import com.mysql.jdbc.Driver;
import databaseConnection.DataBaseManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HeshamMuhammed
 */
public class GetImage extends HttpServlet {

    private DataBaseManager dbm = new DataBaseManager();
    private Connection con;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        try {
            dbm = new DataBaseManager();
            con = dbm.getCon();
            Statement statement = con.createStatement();

            String id = request.getParameter("name");
            System.err.println("name=" + id);
            if (id != "") {
                String query = "Select image from eCommerce.product where id = " + id;
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    Blob imageBlob = resultSet.getBlob(1);
                    if (imageBlob != null) {
                        int blobLength = (int) imageBlob.length();
                        byte[] blobAsBytes = imageBlob.getBytes(1, blobLength);
                        OutputStream outputStream = response.getOutputStream();
                        outputStream.write(blobAsBytes);
                        System.err.println("hnaa1");
                    } else {
                        // File image = new File("C:\\Users\\HeshamMuhammed\\Desktop\\no.jpg");
                        ClassLoader classLoader = getClass().getClassLoader();
                        File image = new File(classLoader.getResource("image/no.jpg").getFile());
                        byte[] bytesArray = new byte[(int) image.length()];
                        FileInputStream fileInputStream = new FileInputStream(image);
                        fileInputStream.read(bytesArray);
                        fileInputStream.close();
                        OutputStream outputStream = response.getOutputStream();
                        outputStream.write(bytesArray);
                    }

                }
            }
        } catch (SQLException ex) {
            System.err.println("Connection Failed");
            ex.printStackTrace();
        } finally {
            System.out.println("Connected");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
