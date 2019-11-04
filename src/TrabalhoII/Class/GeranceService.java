package TrabalhoII.Class;

import java.util.ArrayList;

/**
 * Gerance_Service
 */
public class GeranceService {
    private static int count = 0;
    private final int cod;
    private Service service;
    private Person client;
    private Employee employee;
    private String date;
    private int timeInit;
    private int timeFinal;
    private ArrayList<Product> listProduct = new ArrayList<>();

    public GeranceService(Service ser, Person cli, Employee emp,ArrayList<Product> array, String dat, int timI, int timF){
        cod = count;
        service = ser;
        client = cli;
        employee = emp;
        date = dat;
        listProduct = array;
        timeInit = timI;
        timeFinal = timF;
    }

    /**
     * 
     * @param ser
     * @param cli
     * @param emp
     * @param dat
     * @param timI
     * @param timF
     */
    public GeranceService(Service ser, Person cli, Employee emp, String dat, int timI, int timF){
        cod = count;
        service = ser;
        client = cli;
        employee = emp;
        date = dat;
        timeInit = timI;
        timeFinal = timF;
    }

    /**
     * @return the client
     */
    public Person getClient() {
        return client;
    }
    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }
    /**
     * @return the service
     */
    public Service getService() {
        return service;
    }
    /**
     * @return the timeFinal
     */
    public int getTimeFinal() {
        return timeFinal;
    }
    /**
     * @return the timeInit
     */
    public int getTimeInit() {
        return timeInit;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Person client) {
        this.client = client;
    }
    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    /**
     * @param service the service to set
     */
    public void setService(Service service) {
        this.service = service;
    }
    /**
     * @param timeFinal the timeFinal to set
     */
    public void setTimeFinal(int timeFinal) {
        this.timeFinal = timeFinal;
    }
    /**
     * @param timeInit the timeInit to set
     */
    public void setTimeInit(int timeInit) {
        this.timeInit = timeInit;
    }

    /**
     *  this method return employee's salary
     * @return salary
     */
    public double salary(){
        int totalTime = getTimeFinal() - getTimeInit();
        double salary = totalTime * employee.getValorT();
        return salary;
    }
}
