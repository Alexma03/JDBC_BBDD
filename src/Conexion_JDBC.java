import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion_JDBC {
	
	String user;
	String port;
	String hostname;
	String conector;
	String database;
	String password;
	String url;
	Connection con;
	
	public Conexion_JDBC(String user, String port, String hostname, String conector, String database, String password,
			String url) {

		this.user = user;
		this.port = port;
		this.hostname = hostname;
		this.conector = conector;
		this.database = database;
		this.password = password;
		this.url = url;
	}
	
	public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		this.con = (Connection) DriverManager.getConnection(this.url , this.user , this.password);
		
		return this.con;
	}
	
	public void CerrarConexion() throws SQLException {
		this.con.close();
	}
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getConector() {
		return conector;
	}

	public void setConector(String conector) {
		this.conector = conector;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
