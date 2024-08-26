package properity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	FileInputStream fis;

	public Properties configFile() throws IOException {

		File f = new File(
				"C:\\Users\\VISHNU\\eclipse-workspace\\AugIPT\\src\\main\\java\\com\\confiProperties\\ConProperties");

		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Properties p = new Properties();
		p.load(fis);

		return p;

	}

	public String getBrowser() throws IOException {
		String browser = configFile().getProperty("browser");
		return browser;
	}

	public String getUrl() throws IOException {
		String url = configFile().getProperty("url");
		return url;
	}

	public String getUsername() throws IOException {
		String username = configFile().getProperty("username");
		return username;
	}

	public String getPassword() throws IOException {
		String password = configFile().getProperty("password");
		return password;
	}

	public String getHome() throws IOException {
		String home = configFile().getProperty("home");
		return home;
	}

	public String getinvalidpass() throws IOException {
		String invalidpass = configFile().getProperty("invalidpass");
		return invalidpass;
	}

	public String getinvalidmail() throws IOException {
		String invalidmail = configFile().getProperty("invalidmail");
		return invalidmail;
	}

	public String getfirstname() throws IOException {
		String firstname = configFile().getProperty("firstname");
		return firstname;

	}

	public String getlastname() throws IOException {
		String lastname = configFile().getProperty("lastname");
		return lastname;

	}

	public String getzipcode() throws IOException {
		String zipcode = configFile().getProperty("zipcode");
		return zipcode;

	}

	public String getfirstname2() throws IOException {
		String firstname2 = configFile().getProperty("firstname2");
		return firstname2;

	}

	public String getlastname2() throws IOException {
		String lastname2 = configFile().getProperty("lastname2");
		return lastname2;

	}

	public String getzipcode2() throws IOException {
		String zipcode2 = configFile().getProperty("zipcode2");
		return zipcode2;

	}

	public String getfirstname3() throws IOException {
		String firstname3 = configFile().getProperty("firstname3");
		return firstname3;

	}

	public String getlastname3() throws IOException {
		String lastname3 = configFile().getProperty("lastname3");
		return lastname3;

	}

	public String getzipcode3() throws IOException {
		String zipcode3 = configFile().getProperty("zipcode3");
		return zipcode3;

	}

	public String getfirstname4() throws IOException {
		String firstname4 = configFile().getProperty("firstname4");
		return firstname4;

	}

	public String getlastname4() throws IOException {
		String lastname4 = configFile().getProperty("lastname4");
		return lastname4;

	}

	public String getzipcode4() throws IOException {
		String zipcode4 = configFile().getProperty("zipcode4");
		return zipcode4;

	}

	public String getfirstname5() throws IOException {
		String firstname5 = configFile().getProperty("firstname5");
		return firstname5;

	}

	public String getlastname5() throws IOException {
		String lastname5 = configFile().getProperty("lastname5");
		return lastname5;

	}

	public String getzipcode5() throws IOException {
		String zipcode5 = configFile().getProperty("zipcode5");
		return zipcode5;

	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

