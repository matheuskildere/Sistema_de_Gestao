package TrabalhoII.Interfaces;

import TrabalhoII.Class.Product;

/**
 * Products_Interface
 */
public interface Products_Interface {

    /**
     * Add a new product on product's list
     * @param pro 
     */
    public void add(Product pro);

    /**
     * Catch the product with the cod informed
     * @param cod
     * @return a object type of Product
     */
    public Product get(int cod);

    /**
     * @param codigo
     * @return ArrayList with product's information
     */
    public Object[][] getInfo(int codigo);
    
    /**
     * modify informations of product
     * @param cod
     * @param pro
     */
    public void set(int cod, Product pro);

    /**
     * Remove Product with cod informed of product's list
     * @param cod
     */
    public void remove(int cod);
}