package dao.mysql;

import dao.GenericDAO;
import dao.DAOFactory;

import java.sql.*;

public class MySQLDAOFactory extends DAOFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/Lesson8";
    private static final String DBUSER = "root";
    private static final String DBPASS = "";

    public static Connection createConnection () {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c;
        try {
            c = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return c;
    }

    public GenericDAO getStudentsDAO() {
        return new StudentsMySQLDAO();
    }
    public GenericDAO getSubjectsDAO() {
        return new SubjectsMySQLDAO();
    }
    public GenericDAO getMarksDAO() {
        return new MarksMySQLDAO();
    }


}
