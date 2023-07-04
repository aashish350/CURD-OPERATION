package factory;

import dao.Idao;
import dao.Impldao;

public class DaoFactory {
  private static Idao da;
  private DaoFactory() {
	  
  }
  public static Idao getDaoFactory() {
	  if(da==null)
		  da=new Impldao();
	  return da;
  }
}
