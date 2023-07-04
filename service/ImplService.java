package service;

import dao.Idao;
import dto.Student;
import factory.DaoFactory;
import dto.Student;
public class ImplService implements IService {
private Idao ds;
	@Override
	public void insert(Student stud) {
		// TODO Auto-generated method stub
		ds=DaoFactory.getDaoFactory();
	//	System.out.println("Implementation is given by the class :: "+ds.getClass().getName());
		ds.insert(stud);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		ds=DaoFactory.getDaoFactory();
	    Student str=ds.findById(id);
	    System.out.println(ds.getClass().getName());
		return str;
	}

	@Override
	public String deleteById(Integer id) {
		ds=DaoFactory.getDaoFactory();
		 String str=ds.deleteById(id);
		return str;
	}

	@Override
	public String update(Student stud) {
		ds=DaoFactory.getDaoFactory();
		return ds.update(stud);
	}

	

}
