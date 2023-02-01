package mx.edu.utez.contactos4b.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static mx.edu.utez.contactos4b.utils.MySQLConnection.getConnection;

public class DaoContacto {
    private String jdbcURL = "jdbc:mysql://localhost:3306/contactos";
    private String jdbcUsername = "root";
    private String jdbcPassword = "gatitaMin4_";
    private static final String DELETE_USERS_SQL = "delete from contact where id = ?;";
    private Connection connection;
    public List <BeanContacto> getContactos(){
        List<BeanContacto> listContactos = new ArrayList<>();
        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from contacto ");
            while (rs.next()){
                BeanContacto contacto = new BeanContacto();
                contacto.setId(rs.getInt("id"));
                contacto.setName(rs.getString("name"));
                contacto.setLastName(rs.getString("lastName"));
                contacto.setPhoneNumber(rs.getString("phoneNumber"));
                contacto.setDirection(rs.getString("direction"));
                contacto.setEmail(rs.getString("email"));
                contacto.setType(rs.getString("type"));
                listContactos.add(contacto);
            };
            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return listContactos;
    }
    public List <BeanContacto> search(String texto){
        List<BeanContacto> listContactos = new ArrayList<>();
        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from contacto where name LIKE '"+texto+"%' or phoneNumber like '"+texto+"%' or lastName like '"+texto+"%' or email like '"+texto+"%' ");
            while (rs.next()){
                BeanContacto contacto = new BeanContacto();
                contacto.setId(rs.getInt("id"));
                contacto.setName(rs.getString("name"));
                contacto.setLastName(rs.getString("lastName"));
                contacto.setPhoneNumber(rs.getString("phoneNumber"));
                contacto.setDirection(rs.getString("direction"));
                contacto.setEmail(rs.getString("email"));
                contacto.setType(rs.getString("type"));
                listContactos.add(contacto);
            };
            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return listContactos;
    }

    public List buscar(String texto){
        List<BeanContacto> lista = new ArrayList<>();
        String sql ;
        sql = "select * from contacto where name LIKE '"+texto+"%' or phoneNumber like '"+texto+"%' or lastName like '"+texto+"%' or email like '"+texto+"%' ";
        try {
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                BeanContacto contact= new BeanContacto();
                contact.setName(rs.getString("name"));
                contact.setLastName(rs.getString("lastName"));
                contact.setPhoneNumber(rs.getString("phoneNumber"));
                contact.setDirection(rs.getString("direction"));
                contact.setEmail(rs.getString("email"));
                contact.setType(rs.getString("type"));
                lista.add(contact);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return lista;
    }

    public int registerUser (BeanContacto beanUser) throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO contactos.contacto" + "(name, lastName, phoneNumber, direction,email,type) VALUES " + "(?,?,?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contactos","root","gatitaMin4_");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1, beanUser.getName());
            preparedStatement.setString(2, beanUser.getLastName());
            preparedStatement.setString(3, beanUser.getPhoneNumber());
            preparedStatement.setString(4, beanUser.getDirection());
            preparedStatement.setString(5, beanUser.getEmail());
            preparedStatement.setString(6, beanUser.getType());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

public static  int delete(BeanContacto contact){
        int status=0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from contacto where id=?");
            ps.setInt(1, (int)contact.getId());
            status=ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return status;
}

public static int update(BeanContacto contact){
        int status= 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps =con.prepareStatement(
                    "update contacto set name =?,lastName=?, phoneNumber=?,direction=?,email=?,type=? where id=?");
            ps.setString(1,contact.getName());
            ps.setString(2, contact.getLastName());
            ps.setString(3, contact.getPhoneNumber());
            ps.setString(4, contact.getDirection());
            ps.setString(5, contact.getEmail());
            ps.setString(6,contact.getType());
            ps.setInt(7, (int) contact.getId());
            status =ps.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
        return status;
}

public static BeanContacto getRecordById(int id){
        BeanContacto contact = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement("select * from contacto where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                contact = new BeanContacto();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setLastName(rs.getString("lastName"));
                contact.setPhoneNumber(rs.getString("phoneNumber"));
                contact.setDirection(rs.getString("direction"));
                contact.setEmail(rs.getString("email"));
                contact.setType(rs.getString("type"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return contact;
}


}
