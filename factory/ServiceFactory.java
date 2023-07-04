package factory;

import service.IService;
import service.ImplService;

public class ServiceFactory {
 private static IService ser;
 private ServiceFactory() {
	 
 }
 public static IService getServiceFactory() {
	 if(ser==null)
		 ser=new ImplService();
	 
	 return ser;
 }
}
