package service;

import dto.Student;

public interface IService {
 void insert(Student stud);
 Student findById(Integer id);
 String deleteById(Integer id);
 String update(Student stud);
}
