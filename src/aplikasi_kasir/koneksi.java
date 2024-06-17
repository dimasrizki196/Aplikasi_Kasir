/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasi_kasir;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class koneksi {
    private final String url="jdbc:mysql://localhost/db_indomaret";
    private final String username_xampp = "root";
    private final String password_xampp = "";
    private Connection con;
    
    public void connect(){
        try {
            con = (Connection) DriverManager.getConnection(url, username_xampp, password_xampp);
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public Connection getCon(){
        return con;
    }
}
