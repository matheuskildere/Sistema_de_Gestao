package TrabalhoII.Class;
/**
 * Funcionario
 */
public class Employee extends Person {
    private static int count = 1;
    private final int cod;
    private String cargo;
    private double valorT;

    public Employee(String nam, long cpf, long rg, long telefone, long celular, String email ,Address adr, String car, double val) {
        super(nam, cpf, adr);
        cod = count;
        this.cargo = car;
        this.valorT = val;
        count++;
    }

    public Employee(String nam, long cpf, String car, double val, Address adr) {
        super(nam, cpf, adr);
        cod = count;
        this.cargo = car;
        this.valorT = val;
        count++;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @return the valorT
     */
    public double getValorT() {
        return valorT;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @param valorT the valorT to set
     */
    public void setValorT(float valorT) {
        this.valorT = valorT;
    }

    
}