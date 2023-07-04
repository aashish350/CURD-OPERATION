package dao;

import dto.Student;

public interface Idao {
void insert(Student stud);
Student findById(Integer id);
String deleteById(Integer id);
String update(Student stud);
}
