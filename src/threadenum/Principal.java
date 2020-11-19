package threadenum;

public class Principal {
   
    public static void main(String[] args) {
        Conta eu = new Conta ("Melissa", 1000);
        Conta rod = new Conta ("Rodolfo", 1000);
        Conta jus= new Conta ("Jussimar", 1000);
        
        //System.out.println(eu.getNome());
        //System.out.println(eu.getSaldo());
        //System.out.println(eu.getOperacao());
        
        eu.DepositarValor(500);
        rod.DepositarValor(300);
        jus.RetirarValor(500);
        jus.DepositarValor(300);
        eu.RetirarValor(1500);
        eu.DepositarValor(300);
        eu.RetirarValor(500);
        eu.DepositarValor(300);
        eu.RetirarValor(500);
        jus.DepositarValor(1300);
        rod.RetirarValor(250);
        eu.RetirarValor(500);
        rod.DepositarValor(1300);
        rod.RetirarValor(250);
        eu.RetirarValor(500);
        jus.DepositarValor(1300);
        jus.RetirarValor(250);
        eu.DepositarValor(1300);
        eu.RetirarValor(250);
        
    }
}
