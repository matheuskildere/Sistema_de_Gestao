package TrabalhoII.Class;

import java.util.ArrayList;

import TrabalhoII.Interfaces.Employees_Interface;


/**
 * Employees
 */
public class Employees implements Employees_Interface {
    private ArrayList<Employee> employeesList;

    public Employees (){
        employeesList = new ArrayList<>();
    }

    @Override
    public void add(Employee emp) {
        employeesList.add(emp);

    }

    /**
     * @return the employeesList
     */
    public ArrayList<Employee> getEmployeesList() {
        ArrayList<Employee> lEmployees = new ArrayList<>();
        for (Employee employee : employeesList) {
            lEmployees.add(employee);
        }
        return lEmployees;
    }

    @Override
    public Employee get(long cpf) {
        for (Employee emp : employeesList) {
            if (cpf == emp.getCpf()) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public Object[] getInfo(int codigo) {
        Object[] dice = null;  
        for (Employee emp : employeesList) {
            if (emp.getCod() == codigo){
                Object[][] employeeObjects = new Object[1][9];
                employeeObjects[0][0] = emp.getCod();
                employeeObjects[0][1] = emp.getName();
                employeeObjects[0][2] = emp.getCpf();
                employeeObjects[0][3] = emp.getRg();
                employeeObjects[0][4] = emp.getFoneC();
                employeeObjects[0][5] = emp.getFoneR();
                employeeObjects[0][6] = emp.getEmail();
                employeeObjects[0][7] = emp.getCargo();
                employeeObjects[0][8] = emp.getValorT();

                
                Object[][] adrObjects = emp.getAddress().getInfo();
                
                dice = new Object[2];
                dice[0] =employeeObjects;
                dice[1] = adrObjects;
            }
        }

        return dice;
    }

    @Override
    public void set(long cpf, Employee emp) throws IllegalArgumentException {
        Employee old = get(cpf);
        if (old != null) {
            old = emp;
        } else {
            throw new IllegalArgumentException("Cliente n√o encontrado!");
        }
    }

    @Override
    public void remove(long cpf) {
        Employee remove = get(cpf);
        if (remove != null) {
            employeesList.remove(remove);
        } else {
            throw new IllegalArgumentException("Produto n√£o encontrado!");
        }
    }

    
}