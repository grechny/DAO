package dao;

import dao.mysql.MySQLDAOFactory;

public abstract class DAOFactory {

    public static final int MYSQL = 1;

    public abstract GenericDAO getStudentsDAO();
    public abstract GenericDAO getSubjectsDAO();
    public abstract GenericDAO getMarksDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
