import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class EmployeeControllerJDBC implements EmployeeDAO {
	public final String SELECT_ALL = "SELECT * FROM EMPLOYEES";
	public final String SELECT_BY_ID = "SELECT * FROM hr.employees where employee_id = ?";
	public final String SELECT_BY_LASTNAME = "SELECT * FROM EMPLOYEES where last_name like ?";
	public final String DELETE_BY_ID = "delete from employees where employee_id = ?";
	public final String INSERT = "insert into employees values (?,?,?,?,?,?,?,?,?,?,?)";
	public final String UPDATE_SALARY = "update employees set salary = ? where employee_id = ?";
	
	private Connection con; 
	
	public EmployeeControllerJDBC()
	{
		Conexion_JDBC conector = new Conexion_JDBC("root", "3306", "127.0.0.1", "jdbc:mysql:", "hr", "", "jdbc:mysql://127.0.0.1:3306/hr");
		try {
			con = conector.AbrirConexion();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
	}
	
	@Override
	public ArrayList<Employee> SelectAll() {
		//creamos un arrayList de Employee
		ArrayList<Employee> lista = new ArrayList<Employee>();
		try {
			Statement st= (Statement) con.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery(SELECT_ALL);
			
			while(rs.next()) {
				//Para obtener los datos: rs.getInt(1), rs.getString(2)...;
				//rellenamos el arrayList de employee
				Employee e = new Employee(rs.getInt(1), rs.getString(2));
				lista.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//seteamos el arrayList de employee a nulo
			lista = null;
		}
		//devolvemos el arrayList de employee
		return lista;
	}
	@Override
	public ArrayList<Employee> SelectByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employee SelectByEmployee_id(int id) {
		
		try {
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(SELECT_BY_ID);
			//"SELECT * FROM EMPLOYEES where employee_id = ?"
			ps.setInt(1, id);
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			rs.next();
			//Para obtener los datos: rs.getInt(1), rs.getString(2)...;
			//rellenamos el arrayList de employee
			Employee e = new Employee(rs.getInt(1), rs.getString(2));
			return e;
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	@Override
	public boolean InsertEmployee(int id, String fn, String ln, String email, String tel, String hire, String job,
			double salary, double commission, int manager, int department) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean UpdateEmployeeSalaryById(int employee_id, double new_salary) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean DeleteEmployeeById(int employee_id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
