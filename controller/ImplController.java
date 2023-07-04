package controller;

import dto.Student;
import factory.ServiceFactory;
import service.IService;

public class ImplController implements IController                                                                                                                                                                                                                                                                                                                   {
  private IService ser;
	public void insert(Student stud) {
		ser=ServiceFactory.getServiceFactory();
		//System.out.println("Implementation class of this method is ::"+ser.getClass().getName());
		ser.insert(stud);
	}

	public String deleteById(Integer id) {
		ser=ServiceFactory.getServiceFactory();
		Student std=new Student();
		std=ser.findById(id);
		if(std!=null) {
			String str=ser.deleteById(id);
			if(str.equals("sucess")){
				return "deletion happens sucessfully";
			}
		}
		
		return "deletion failed";
	}

	public String update(Student stud) {
		ser=ServiceFactory.getServiceFactory();
		return ser.update(stud);
	}

	public Student findById(Integer id) {
		ser=ServiceFactory.getServiceFactory();
		Student str=ser.findById(id);
		System.out.println(ser.getClass().getName());
		return str;
	}

}
