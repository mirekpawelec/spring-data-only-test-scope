package pl.pawelec.springdatascopetest.dao;

import pl.pawelec.springdatascopetest.model.Student;

public interface StudentDao {
    Student getById(int id);
}
