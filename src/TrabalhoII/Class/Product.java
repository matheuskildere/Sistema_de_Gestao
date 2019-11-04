package TrabalhoII.Class;

/**
 * Produto
 */
public class Product {
    private static int count = 1;
    private final int cod;
    private String name;
    private String type;
    private String description;
    private int quantidade;
    private double valueUnit;

    public Product(String nam, int qua, double val) {
        this.name = nam;
        cod = count;
        type = "undefinide";
        description = "undefinide";
        this.quantidade = qua;
        this.valueUnit = val;
        count++;
    }

    public Product(String nam, String typ, String des, int qua, double val) {
        cod = count;
        this.name = nam;
        this.type = typ;
        this.description = des;
        this.quantidade = qua;
        this.valueUnit = val;
        count++;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the valueUnit
     */
    public double getValueUnit() {
        return valueUnit;
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
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param valueUnit the valueUnit to set
     */
    public void setValueUnit(double valueUnit) {
        this.valueUnit = valueUnit;
    }
    
    @Override
    public String toString() { 
        return name;
    }
}
