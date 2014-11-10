import dao.GenericDAO;
import dao.DAOFactory;
import dto.Mark;
import dto.Student;
import dto.Subject;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 Какие должны быть действия:
 Прочитать всех студентов
 Получить все предметы одного студента вместе с их оценками
 Получить все предметы

 Обновить студента, предмет, оценку
 Добавить студента, предмет, оценку
 Удалить студента, предмет, оценку
*/

public class Lesson8 {

    public static void main (String args[]) throws SQLException, ClassNotFoundException {

        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        GenericDAO studentDAO = mysqlFactory.getStudentsDAO();
        GenericDAO subjectDAO = mysqlFactory.getSubjectsDAO();
        GenericDAO markDAO = mysqlFactory.getMarksDAO();

        Student student = new Student();
        Subject subject = new Subject();
        Mark mark = new Mark();

        for (Student students : (ArrayList<Student>) studentDAO.selectAll()) {
            System.out.println("Student Id " + students.getId() +
                    " is " + students.getLastName() + " " + students.getFirstName());
        }

        for (Mark marks : (ArrayList<Mark>) markDAO.selectAll()) {
            if (marks.getStudentId() == 1) {
                System.out.println("Subject: " + marks.getSubjectId() + ". Mark is " + marks.getMark());
            }
        }

        for (Subject subjects : (ArrayList<Subject>) subjectDAO.selectAll()) {
            System.out.println("Subject ID " + subjects.getId() + " is " + subjects.getSubject());
        }

        student.setValues(1,"Ivan","Ivanov");
        subject.setValues(1,"Astronomy");
        mark.setValues(1,1,10,9);

        student = (Student) studentDAO.create(student);
        subject = (Subject) subjectDAO.create(subject);
        mark = (Mark) markDAO.create(mark);

        System.out.println("Inserted objects:");
        System.out.println("Student Id " + student.getId() + " is " + student.getLastName() + " " + student.getFirstName());
        System.out.println("Subject ID " + subject.getId() + " is " + subject.getSubject());
        System.out.println("Mark ID: " + mark.getId() + ". Mark is " + mark.getMark());

        student.setFirstName("Petr");
        student.setLastName("Petrov");
        studentDAO.update(student);

        subject.setSubject("Universe");
        subjectDAO.update(subject);

        mark.setMark(10);
        markDAO.update(mark);

        student = (Student) studentDAO.selectByID(student.getId());
        subject = (Subject) subjectDAO.selectByID(subject.getId());
        mark = (Mark) markDAO.selectByID(mark.getId());
        System.out.println("Updated objects:");
        System.out.println("Student Id " + student.getId() + " is " + student.getLastName() + " " + student.getFirstName());
        System.out.println("Subject ID " + subject.getId() + " is " + subject.getSubject());
        System.out.println("Mark ID: " + mark.getId() + ". Mark is " + mark.getMark());

        studentDAO.delete(student.getId());
        subjectDAO.delete(subject.getId());
        markDAO.delete(mark.getId());
    }
}
