package pl.pawelec.springdatascopetest.dao.impl;

import org.springframework.stereotype.Repository;
import pl.pawelec.springdatascopetest.dao.StudentDao;
import pl.pawelec.springdatascopetest.model.Student;
import pl.pawelec.springdatascopetest.utils.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public Student getById(int id) {
        Student student = null;
        String sql = "SELECT * FROM Student WHERE id = ?";

        try {
            PreparedStatement preparedStatement = DBManager.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            } else {
                System.out.println("No data found!");
            }
            resultSet.close();
            preparedStatement.close();
//            DBManager.closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return student;
    }
}
