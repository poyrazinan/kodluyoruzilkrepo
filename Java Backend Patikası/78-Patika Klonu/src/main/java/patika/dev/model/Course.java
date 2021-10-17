package patika.dev.model;

import patika.dev.database.ConnectionPool;
import patika.dev.manager.GuiManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Course {

    private int id, userId, patikaId;
    private String name, lang, video;

    private Patika patika;
    private User user;

    public Course(int id, int userId, int patikaId, String name, String lang, String video) {
        this.id = id;
        this.userId = userId;
        this.patikaId = patikaId;
        this.name = name;
        this.lang = lang;
        this.video = video;
        this.patika = Patika.getPatika(patikaId);
        this.user = User.getUser(userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public static ArrayList<Course> getCourseArray() {
        String SQL_QUERY = "SELECT * FROM course";
        return courseArrayGetter(SQL_QUERY);
    }

    public static ArrayList<Course> getCourseArray(String SQL_QUERY) {
        return courseArrayGetter(SQL_QUERY);
    }

    private static ArrayList<Course> courseArrayGetter(String SQL_QUERY) {
        ArrayList<Course> userArray = new ArrayList<>();

        try (Connection con = ConnectionPool.getConnection())
        {
            Statement pst = con.createStatement();
            ResultSet set = pst.executeQuery(SQL_QUERY);

            while (set.next()) {
                int patikaId = set.getInt("patika_id"),
                        userId = set.getInt("user_id"),
                        id = set.getInt("id");

                if (User.getUser(userId) == null || Patika.getPatika(patikaId) == null) {
                    removeCourse(id);
                    break;
                }
                else {
                    userArray.add(new Course(set.getInt("id"), set.getInt("user_id"),
                            set.getInt("patika_id"), set.getString("name"),
                            set.getString("lang"), set.getString("video")));
                }

            }

            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return userArray;
    }

    public static boolean addCourse(String coursename, String lang, String video, int patikaId, int userId) {
        if (getCourse(coursename) != null) {
            GuiManager.sendNotification("userExists");
            return false;
        }
        String SQL_QUERY = "INSERT INTO course (user_id, patika_id, name, lang, video) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setInt(1, userId);
            pst.setInt(2, patikaId);
            pst.setString(3, coursename);
            pst.setString(4, lang);
            pst.setString(5, video);
            pst.executeUpdate();
            pst.close();
            ConnectionPool.closeConnection();
            return true;
        }
        catch (SQLException e1) { e1.printStackTrace(); return false; }
    }

    public static Course getCourse(String name) {
        Course course = null;

        String SQL_QUERY = "SELECT * FROM course WHERE name = ?";
        try (Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(SQL_QUERY);
            pst.setString(1, name);
            ResultSet set = pst.executeQuery();

            if (set.next()) {
                course = new Course(set.getInt("id"), set.getInt("user_id"),
                        set.getInt("patika_id"), set.getString("name"),
                        set.getString("lang"), set.getString("video"));
            }
            set.close();
            pst.close();
            ConnectionPool.closeConnection();
        }
        catch (SQLException e1) { e1.printStackTrace(); }

        return course;
    }

    public static void removeCourse(int id) {
        String SQL_QUERY = "DELETE FROM course WHERE id = ?";
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
}
