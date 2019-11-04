package TrabalhoII.Class;

import java.util.ArrayList;

import TrabalhoII.Interfaces.Service_Interface;

/**
 * Services
 */
public class Services implements Service_Interface {
    private ArrayList<Service> servicesList;

    public Services(){
        servicesList = new ArrayList<>();
    }

    @Override
    public void add(Service ser) {
        servicesList.add(ser);
    }

    /**
     * @return the servicesList
     */
    public ArrayList<Service> getServicesList() {
        ArrayList<Service> array = new ArrayList<>();
        for (Service service : servicesList) {
            array.add(service);
        } 
        return array;
    }
    @Override
    public Service get(int cod) {
        for (Service ser : servicesList){
            if (cod == ser.getCod()) {
                return ser;
            }
        }
        return null;
    }

    @Override
    public void set(int cod, Service ser) throws IllegalArgumentException{
        Service old = get(cod);
        if (old != null){
            old = ser;
        } else {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
    }

    @Override
    public void remove(int cod) {
        Service remove = get(cod);
        if (remove != null){
            servicesList.remove(remove);
        } else {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
    }

    @Override
    public Object[][] getInfo(int codigo) {
        Object[][] dice = null;
        for (Service ser : servicesList) {
            dice = new Object[1][5];
            dice[0][0]=ser.getCod();
            dice[0][1]=ser.getName();
            dice[0][2]=ser.getDescription();
            dice[0][3]=ser.getValue();
            String names ="";
            for (Employee emp : ser.getEmployeesList()) {
                names += emp.getName() +" \n";
            }
            dice[0][4]= names;
        }

        return dice;
    }
    
    
}