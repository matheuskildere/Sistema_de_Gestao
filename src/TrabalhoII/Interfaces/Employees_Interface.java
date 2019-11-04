package TrabalhoII.Interfaces;

import TrabalhoII.Class.Employee;

/**
 * Employees_Interface
 */
public interface Employees_Interface {

    /**
     * Add a new service on Employees list
     * @param emp 
     */
    public void add(Employee emp);

    /**
     * Catch the employee with the cpf informed
     * @param cpf
     * @return a object type of Employee
     */
    public Employee get(long cpf);
    
    /**
     * @param codigo
     * @return ArrayList with employee's information
     */
    public Object[] getInfo(int codigo);

    /**
     * modify informations of employee
     * @param cpf
     * @param emp
     */
    public void set(long cpf, Employee emp);

    /**
     * Remove Employee with cpf informed of employees list
     * @param cpf
     */
    public void remove(long cpf);
    
}