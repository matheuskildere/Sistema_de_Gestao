package TrabalhoII.Class;

import java.util.ArrayList;

/**
 * Servico
 */
public class Service {
    private static int count = 1;
    private final int cod;
    private String name;
    private String description;
    private double value;
    private ArrayList<Employee> employeesList;
	public Object getEmployeesList;

    public Service(String nam, String des, double val, ArrayList<Employee> listEmp){
        cod = count;
        this.name = nam;
        this.description = des;
        this.value = val;
        employeesList = listEmp;
        count++;
    }


    public Service(String nam, double val, ArrayList<Employee> listEmp){
        cod = count;
        this.name = nam;
        this.value = val;
        count++;
    }

    public void addEmployeer(Employee emp){
        employeesList.add(emp);
    }

     /**
     * @return the new list with employees 
     */
    public ArrayList<Employee> getEmployeesList() {
        ArrayList<Employee> eArrayList = new ArrayList<>();
        for (Employee emp : employeesList) {
            eArrayList.add(emp);
        }
        return eArrayList;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }
}