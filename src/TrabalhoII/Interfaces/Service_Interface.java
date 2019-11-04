package TrabalhoII.Interfaces;

import TrabalhoII.Class.Service;

/**
 * Service_Interface
 */
public interface Service_Interface {

    /**
     * Add a new service on service's list
     * @param ser 
     */
    public void add(Service ser);

    /**
     * Catch the service with the cod informed
     * @param cod
     * @return a object type of Service
     */
    public Service get(int cod);
    
    /**
     * @param codigo
     * @return ArrayList with service's information
     */
    public Object[][] getInfo(int codigo);

    /**
     * modify informations of service
     * @param cod
     * @param ser
     */
    public void set(int cod, Service ser);

    /**
     * Remove Service with cod informed of service's list
     * @param cod
     */
    public void remove(int cod);
}