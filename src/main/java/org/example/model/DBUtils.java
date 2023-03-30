package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static Connection connect() {
        Connection conn = null;
        String url = "jdbc:sqlite:src/main/resources/database/test.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static final String table_user= "User";
    public static final String table_class="Class";
    public static final String table_attendance="Attendance";

    public static final String Column_user_id="user_id";
    public static final String Column_user_name="username";
    public static final String Column_classid="class_id";
    public static final String Column_classname="class_name";
    public static final String Column_id="id";
    public static final String Column_password="password";

    public static void insert_user(Connection conn, User user) {

            String query = "SELECT * FROM "+ table_user + " WHERE " + Column_user_name + " = " + user;

        List<User> users= new ArrayList<>();

            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database/test.db");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    int id = resultSet.getInt(Column_user_id);

                    User user1 = new User("",1,12);
                    users.add(user1);
                }

            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
            return;

        }
    public List<User> getAllBooks(Connection conn, String names){
            String query = "SELECT * FROM "+ table_user + " WHERE "+Column_user_name + " like %" + names + "%";

            List<User> modelUsers = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
               while(resultSet.next()){

                int user_id = resultSet.getInt(Column_user_id);

                String username = resultSet.getString(Column_user_name);

                String password = resultSet.getString(Column_password);

                User user1 = new User("",12,24);

                User.add(user1);

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
          return modelUsers;

    }

    public static List<Class> getBooksFilter(Connection conn,int active){

        String query = "SELECT * FROM "+ table_class + " WHERE " + Column_classname + " = " + active;

        List<Class> modelClasses = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                int class_id = resultSet.getInt(Column_user_id);

                String class_name = resultSet.getString(Column_classname);

                Class modelClass1 = new Class(class_id,"");

                modelClasses.add(modelClass1);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return modelClasses;
    }

    public static void addAttendance(Attendance Attendance, Connection connection){

        String sql = "INSERT INTO " + table_attendance + "("+ Column_id + "," + Column_user_id + "," + Column_classid +") " +

                "VALUES(?,?,?)";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, Attendance.getId());

            pstmt.setInt(2, Attendance.getUserid());

            pstmt.setInt(3, Attendance.getClassid());

            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }}

