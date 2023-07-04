package controller;

import dto.Student;

public interface IController {
void insert(Student stud);
String deleteById(Integer id);
String update(Student stud);
Student findById(Integer id);
}
