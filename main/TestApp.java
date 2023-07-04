package main;
import controller.IController;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import dto.Student;
import factory.ControllerFactory;

public class TestApp {

	public static void main(String[] args) {

		Integer sid;
		String name;
		String adress;		
		Integer age;
		String email;


		IController con=null;

		try {
			while(true) {
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. Insertion...");
				System.out.println("2.Deletion...");
				System.out.println("3. Reading...");
				System.out.println("4. Updating...");
				System.out.println("5. Exit...");
				Integer option=Integer.parseInt(br.readLine());
				switch(option) {
				case 1:
					System.out.println("Case one is used for inserting the data into database....");
					System.out.println("Enter Student Id");
					sid=Integer.parseInt(br.readLine());
					System.out.println("Enter the name of the Student... ");
					name=br.readLine();
					System.out.println("Enter the adress of the Student ...");
					adress=br.readLine();
					System.out.println("Enter the age of the Student...");
					age=Integer.parseInt(br.readLine());
					System.out.println("Enter the email id of the Student...");
					email=br.readLine();
					Student std=new Student();
					std.setAdress(adress);
					std.setAge(age);
					std.setEmail(email);
					std.setName(name);
					std.setSid(sid);
					con=ControllerFactory.getControllerFactory();
					con.insert(std);
					break;
				case 2:
					System.out.println("Case two is used for deletion a record from the database...");
					System.out.println("Enter the id of the student for deleting the record from the databse...");
					sid=Integer.parseInt(br.readLine());
					con=ControllerFactory.getControllerFactory();
					con.deleteById(sid);
					break;
				case 3:
					System.out.println("Case three is used for the Reading the data From the database...");
					Student stud=new Student();
					sid=Integer.parseInt(br.readLine());
					stud.setSid(sid);
					con=ControllerFactory.getControllerFactory();
					Student std1= con.findById(sid);
					System.out.println("Student id of the Student ::"+std1.getSid());
					System.out.println("Name of the Student is ::"+std1.getName());
					System.out.println("Adress of the Student"+std1.getAdress());
					System.out.println("Age of the Student is ::"+std1.getAge());
					System.out.println("Email id of the Student is ::"+std1.getEmail());
					break;
				case 4:
					System.out.println("case four is used for updating the record of the student ....");
					System.out.println("Enter the id of the Student for updating the record...");
					sid=Integer.parseInt(br.readLine());

					//sid=sc.nextInt();
					con=ControllerFactory.getControllerFactory();
					Student std2=con.findById(sid);
					if(std2!=null) {
						System.out.println("Old id of the Student is :::"+sid);
						System.out.println("Enter new Student id ...");
						// Integer newSid=Integer.parseInt(br.readLine());
						String newSid=br.readLine();
						Student std3=new Student();
						if(newSid.equals("")|| newSid.equals(sid)) {
							std3.setSid(sid);
						}else {
							std3.setSid(Integer.parseInt(newSid));
						}



						name=std2.getName();
						System.out.println("Name of the old Student is ::"+name);
						System.out.println("Enter Name of the Student...");
						String newName=br.readLine();
						if(newName.equals("")) {
							std3.setName(name);
						}else {
							std3.setName(newName);
						}
						adress=std2.getAdress();
						System.out.println("Adress of the old student ::"+adress);
						System.out.println("Enter Adress of the Student..,");
						String addr=br.readLine();

						if(addr.equals("")) {
							std3.setAdress(adress);
						}else {
							std3.setAdress(addr);
						}
						age=std2.getAge();
						System.out.println("Age of Old Student is ::"+age);
						System.out.println("Enter the age of the Student...");
						//	int newAge=sc.nextInt();
						String  newAge=br.readLine();
						if(newAge.equals("")) {
							std3.setAge(age);
						}else {
							std3.setAge(Integer.parseInt(newAge));
						}
						email=std2.getEmail();
						System.out.println("Email of the old Student is ::"+email);
						System.out.println("Enter email id of the Student...");

						String newEmail=br.readLine();
						System.out.println(newEmail);
						if(email.equals(newEmail)||email.equals("")) {
							std3.setEmail(email);
						}else {
							std3.setEmail(newEmail);
						}
						String str= con.update(std3);
						System.out.println(str);
					}

					break;
				case 5:
					System.out.println("Thanks for using the application...");
					System.exit(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}

