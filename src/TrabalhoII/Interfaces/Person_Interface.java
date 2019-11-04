package TrabalhoII.Interfaces;

import TrabalhoII.Class.Person;

/**
 * Person_Interface
 */
public interface Person_Interface {

    /**
     * Add a new service on people list
     * @param per
     */
    public void add(Person per);

    /**
     * Catch the person with the cpf informed
     * @param cpf
     * @return a object type of person
     */
    public Person get(long cpf);
    
    /**
     * @param codigo
     * @return ArrayList with client's information
     */
    public Object[] getInfo(long cpf);

    /**
     * modify informations of Person
     * @param cpf
     * @param per
     */
    public void set(long cpf, Person per);

    /**
     * Remove Person with cpf informed of people list
     * @param cpf
     */
    public void remove(long cpf);
}