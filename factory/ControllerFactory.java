package factory;

import controller.IController;
import controller.ImplController;

public class ControllerFactory {
private static IController cont;
 private ControllerFactory() {
	 
 }
 public static IController getControllerFactory() {
	 if(cont==null) {
		 cont=new ImplController();
	 }
	 return cont;
 }
}
