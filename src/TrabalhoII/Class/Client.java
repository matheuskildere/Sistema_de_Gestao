package TrabalhoII.Class;

import java.util.ArrayList;

import TrabalhoII.Interfaces.Person_Interface;

/**
 * People
 */
public class Client implements Person_Interface {
    private ArrayList<Person> clientList;

    public Client() {
        clientList = new ArrayList<>();
    }

    @Override
    public void add(Person per) {
        clientList.add(per);
    }

    public ArrayList<Person> getList(){
        return clientList;
    }

    @Override
    public Person get(long cpf) {
        for (Person per : clientList) {
            if (cpf == per.getCpf()) {
                return per;
            }
        }
        return null;
    }

    @Override
    public void set(long cpf, Person per) throws IllegalArgumentException {
        Person old = get(cpf);
        if (old != null) {
            remove(cpf);
            add(per);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }

    @Override
    public void remove(long cpf) {
        Person remove = get(cpf);
        if (remove != null) {
            clientList.remove(remove);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }

    @Override
    public Object[] getInfo(long cpf) {
        Object[] dice = null;  
        for (Person cli : clientList) {
            if (cli.getCpf() == cpf){
                Object[][] client = new Object[1][6];
                client[0][0] = cli.getName();
                client[0][1] = cli.getCpf();
                client[0][2] =cli.getRg();
                client[0][3] = cli.getFoneC();
                client[0][4] = cli.getFoneR();
                client[0][5] = cli.getEmail(); 
                
                Object[][] adrObjects = cli.getAddress().getInfo();
                
                dice = new Object[2];
                dice[0] =client;
                dice[1] = adrObjects;
            }
        }
        return dice;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}