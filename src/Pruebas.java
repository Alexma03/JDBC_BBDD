import java.util.ArrayList;

import controlador.EmployeeControllerJDBC;
import modelo.Employee;

public class Pruebas {

	public static void main(String[] args) {
		EmployeeControllerJDBC ec = new EmployeeControllerJDBC();
		//probando select_by_id
		Employee e = ec.SelectByEmployee_id(100);
		System.out.println(e);
		//probando select_all
		ArrayList<Employee> lista = ec.SelectAll();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
		
		
	}

}
