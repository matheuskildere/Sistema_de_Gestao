package TrabalhoII.Class;


/**
 * Adress
 */
public class Address {
    private String logradoro;
    private long number;
    private String complement;
    private String bairro;
    private String city;
    private String state;
    private long cep;
    
    /**
     * 
     * @param log
     * @param num
     * @param bai
     * @param cit
     * @param sta
     */
    public Address (String log, long num, String bai, String cit, String sta){
        this.logradoro = log;
        this.number = num;
        complement = "undefined";
        this.bairro = bai;
        this.city = cit;
        this.state = sta;
        cep = 0;
    }

    /**
     * 
     * @param log
     * @param com
     * @param num
     * @param bai
     * @param cit
     * @param sta
     * @param cep
     */
    public Address(String log, String com, long num, String bai, String cit, String sta, long cep) {
        this.logradoro = log;
        this.number = num;
        this.complement = com;
        this.bairro = bai;
        this.city = cit;
        this.state = sta;
        this.cep = cep;
    }

    public Object[][] getInfo() {
        Object dice[][] = new Object[1][7];
        dice[0][0] = logradoro;
        dice[0][1] = number;
        dice[0][2] = bairro;
        dice[0][3] = complement;
        dice[0][4] = cep;
        dice[0][5] = city;
        dice[0][6] = state;
        return dice;
    }
    
    /**
     * @return the logradoro
     */
    public String getLogradoro() {
        return logradoro;
    }

    /**
     * @return the number
     */
    public long getNumber() {
        return number;
    }

    /**
     * @return the complement
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the cep
     */
    public long getCep() {
        return cep;
    }
    
    /**
     * @param logradoro the logradoro to set
     */
    public void setLogradoro(String logradoro) {
        this.logradoro = logradoro;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * @param complement the complement to set
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(long cep) {
        this.cep = cep;
    }
}
