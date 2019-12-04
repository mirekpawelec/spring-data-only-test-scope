package pl.pawelec.springdatascopetest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawelec.springdatascopetest.dao.StudentDao;
import pl.pawelec.springdatascopetest.model.Student;
import pl.pawelec.springdatascopetest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getById(int id) {
        return studentDao.getById(id);
    }
}
