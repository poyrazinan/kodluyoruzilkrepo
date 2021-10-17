package patika.dev.model;

import patika.dev.database.ConnectionPool;
import patika.dev.manager.GuiManager;

import java.sql.*;
import java.util.ArrayList;

public class User {

    private int id;
    private String name, uname, pass, type;

    public User() {
    }

    public User(int id, String name, String uname, String pass, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getUserArray() {
        String SQL_QUERY = "SELECT * FROM user";
        return userArrayGetter(SQL_QUERY);
    }

    public static ArrayList<User> getUserArray(String SQL_QUERY) {
        return userArrayGetter(SQL_QUERY);
    }

    private static ArrayList<User> userArrayGetter(String SQL_QUERY) {
        ArrayList<User> userArray = new ArrayList<>();

        try (Connection con = ConnectionPool.getConnection())
        {
            Statement pst = con.createStatement();
            ResultSet set = pst.executeQuery(SQL_QUERY);

            while (set.next()) {
                userArray.add(new User(set.getInt("id"), set.getString("name"),
                        set.getString("uname"), set.getString("pass"),
                        set.getString("type")));
            }

            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return userArray;
    }

    public static boolean addUser(String name, String uname, String pass, String type) {
        if (getUser(uname) != null) {
            GuiManager.sendNotification("userExists");
            return false;
        }
        String SQL_QUERY = "INSERT INTO user (name, uname, pass, type) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setString(1, name);
            pst.setString(2, uname);
            pst.setString(3, pass);
            pst.setString(4, type);
            pst.executeUpdate();
            pst.close();
            ConnectionPool.closeConnection();
            return true;
        }
        catch (SQLException e1) { e1.printStackTrace(); return false; }
    }

    public static User getUser(String uname) {
        User user = null;

        String SQL_QUERY = "SELECT * FROM user WHERE uname = ?";
        try (Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setString(1, uname);
            ResultSet set = pst.executeQuery();

            if (set.next()) {
                user = new User(set.getInt("id"), set.getString("name"),
                        set.getString("uname"), set.getString("pass"),
                        set.getString("type"));
            }
            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return user;
    }

    public static User getUser(int id) {
        User user = null;

        String SQL_QUERY = "SELECT * FROM user WHERE id = ?";
        try (Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setInt(1, id);
            ResultSet set = pst.executeQuery();

            if (set.next()) {
                user = new User(set.getInt("id"), set.getString("name"),
                        set.getString("uname"), set.getString("pass"),
                        set.getString("type"));
            }
            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return user;
    }

    public static void removeUser(int id) {
        String SQL_QUERY = "DELETE FROM user WHERE id = ?";
        try (Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }
    }

    public static boolean updateUser(int id, String name, String uname, String pass, String type) {
        User user =getUser(uname);
        if (user != null && user.getId() != id) {
            GuiManager.sendNotification("userExists");
            return false;
        }
        String SQL_QUERY = "UPDATE user SET name = ?, uname = ?, pass = ?, type = ? WHERE id = ?";

        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setString(1, name);
            pst.setString(2, uname);
            pst.setString(3, pass);
            pst.setString(4, type);
            pst.setInt(5, id);

            pst.executeUpdate();
            pst.close();
            ConnectionPool.closeConnection();
            return true;
        }
        catch (SQLException e1) { return false; }
    }

}
