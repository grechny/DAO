package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 Обновить студента, предмет, оценка
 Добавить студента, предмет, оценку
 Удалить студента, предмет, оценку
 */

public interface GenericDAO <T> {

    public T selectByID (Integer key) throws SQLException;
    public ArrayList<T> selectAll() throws SQLException;
    public T create(T object) throws SQLException;
    public void update(T object) throws SQLException;
    public void delete(Integer key) throws SQLException;

}