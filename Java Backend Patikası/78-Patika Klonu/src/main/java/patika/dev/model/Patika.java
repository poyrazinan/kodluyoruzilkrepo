package patika.dev.model;

import patika.dev.database.ConnectionPool;
import patika.dev.manager.GuiManager;

import java.sql.*;
import java.util.ArrayList;

public class Patika {

    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
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

    public static ArrayList<Patika> getPatikaArray() {
        String SQL_QUERY = "SELECT * FROM patika";
        return patikaArrayGetter(SQL_QUERY);
    }

    public static ArrayList<Patika> getPatikaArray(String SQL_QUERY) {
        return patikaArrayGetter(SQL_QUERY);
    }

    private static ArrayList<Patika> patikaArrayGetter(String SQL_QUERY) {
        ArrayList<Patika> userArray = new ArrayList<>();

        try (Connection con = ConnectionPool.getConnection())
        {
            Statement pst = con.createStatement();
            ResultSet set = pst.executeQuery(SQL_QUERY);

            while (set.next()) {
                userArray.add(new Patika(set.getInt("id"), set.getString("name")));
            }

            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return userArray;
    }

    public static boolean addPatika(String name) {
        if (getPatika(name) != null) {
            GuiManager.sendNotification("userExists");
            return false;
        }
        String SQL_QUERY = "INSERT INTO patika (name) VALUES (?)";
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setString(1, name);
            pst.executeUpdate();
            pst.close();
            ConnectionPool.closeConnection();
            return true;
        }
        catch (SQLException e1) { e1.printStackTrace(); return false; }
    }

    public static Patika getPatika(int id) {
        Patika patika = null;

        String SQL_QUERY = "SELECT * FROM patika WHERE id = ?";
        try (Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setInt(1, id);
            ResultSet set = pst.executeQuery();

            if (set.next()) {
                patika = new Patika(set.getInt("id"), set.getString("name"));
            }
            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return patika;
    }

    public static Patika getPatika(String name) {
        Patika patika = null;

        String SQL_QUERY = "SELECT * FROM patika WHERE name = ?";
        try (Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setString(1, name);
            ResultSet set = pst.executeQuery();

            if (set.next()) {
                patika = new Patika(set.getInt("id"), set.getString("name"));
            }
            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return patika;
    }

    public static void removePatika(int id) {
        String SQL_QUERY = "DELETE FROM patika WHERE id = ?";
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

    public static boolean updatePatika(int id, String name) {
        Patika patika = getPatika(name);
        if (patika != null && patika.getId() != id) {
            GuiManager.sendNotification("userExists");
            return false;
        }
        String SQL_QUERY = "UPDATE patika SET name = ? WHERE id = ?";

        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setString(1, name);
            pst.setInt(2, id);

            pst.executeUpdate();
            pst.close();
            ConnectionPool.closeConnection();
            return true;
        }
        catch (SQLException e1) { e1.printStackTrace(); return false; }
    }
}
