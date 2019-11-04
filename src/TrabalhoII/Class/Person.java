package TrabalhoII.Class;

/**
 * This class (Person) is a representation of one person real.
 */
public class Person {
    private String name;
    private long cpf;
    private long rg;
    private long foneR;
    private long foneC;
    private String email;
    private Address address;

    /**
     * Constructor of class simple Person
     * @param nam
     * @param cpf
     * @param log
     * @param num
     * @param bai
     * @param cit
     * @param sta
     */
    public Person(String nam, long cpf, Address adr) {
        this.name = nam; 
        this.cpf = cpf;
        rg = 0;
        foneR = 0;
        foneC = 0;
        email = "undefined";
        this.address = adr;
    }

    /**
     * Constructor of class all  Person
     * @param nam
     * @param cpf
     * @param log
     * @param num
     * @param bai
     * @param cit
     * @param sta
     */
    public Person(String nam, long cpf, long rg, long fonR, long fonC, String ema, Address adr) {
        this.name = nam; 
        this.cpf = cpf;
        this.rg = rg;
        this.foneR = fonR;
        this.foneC = fonC;
        this.email = ema;
        this.address = adr;

    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(long rg) {
        this.rg = rg;
    }

    /**
     * @param foneR the foneR to set
     */
    public void setFoneR(long foneR) {
        this.foneR = foneR;
    }

    /**
     * @param foneC the foneC to set
     */
    public void setFoneC(long foneC) {
        this.foneC = foneC;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @return the rg
     */
    public long getRg() {
        return rg;
    }

    /**
     * @return the foneR
     */
    public long getFoneR() {
        return foneR;
    }

    /**
     * @return the foneC
     */
    public long getFoneC() {
        return foneC;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }
    @Override
    public String toString() {
        return name;
    }
}