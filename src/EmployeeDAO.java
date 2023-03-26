import java.util.ArrayList;

public interface EmployeeDAO {
	public ArrayList<Employee> SelectAll();
	public ArrayList<Employee> SelectByLastName(String last_name);
	public Employee SelectByEmployee_id(int id);
	public boolean InsertEmployee(int id, String fn, String ln, String email, String tel, String hire, String job, double salary, double commission, int manager, int department );
	public boolean UpdateEmployeeSalaryById(int employee_id, double new_salary);
	public boolean DeleteEmployeeById(int employee_id);
}
