package TrabalhoII.Class;

import java.util.ArrayList;

import TrabalhoII.Interfaces.Products_Interface;

/**
 * Products
 */
public class Products implements Products_Interface{
    private ArrayList<Product> productsList;

    public Products(){
        productsList = new ArrayList<>();
    }

    @Override
    public void add(Product pro) {
        productsList.add(pro);
    }

     /**
     * @return the productsList
     */
    public ArrayList<Product> getProductsList() {
        ArrayList<Product> pArrayList = new ArrayList<>();
        for (Product product : productsList) {
            pArrayList.add(product);
        }
        return pArrayList;
    }

    @Override
    public Product get(int cod) {
        for (Product pro : productsList){
            if (cod == pro.getCod()) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public void set(int cod, Product pro) throws IllegalArgumentException{
        Product old = get(cod);
        if (old != null){
            old = pro;
        } else {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
    }

    @Override
    public void remove(int cod) {
        Product remove = get(cod);
        if (remove != null){
            productsList.remove(remove);
        } else {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
    }

    @Override
    public Object[][] getInfo(int codigo) {
        Object[][] dice = null;
        for (Product pro : productsList) {
            dice = new Object[1][5];
            dice[0][0]=pro.getCod();
            dice[0][1]=pro.getName();
            dice[0][2]=pro.getDescription();
            dice[0][3]=pro.getType();
            dice[0][4]=pro.getValueUnit();
        }

        return dice;
    }
}