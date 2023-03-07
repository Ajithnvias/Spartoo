package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CommonMethods {
	
	public Properties p;
	FileInputStream fis;
	
	public String getProperty(String data) throws IOException
	{
		p = new Properties();
		String path = "C:\\Users\\Beqisoft\\eclipse-workspace\\Spartoo1\\src\\test\\java\\TestData\\HomePage.properties";
		fis = new FileInputStream(path);
		p.load(fis);
		return p.getProperty(data);
	}
	
	

	public ArrayList<String> searchData() {
		ArrayList<String> searchProducts = new ArrayList<String>();
		searchProducts.add("shoes");
		searchProducts.add("Slippers");
		return searchProducts;
	}

}
