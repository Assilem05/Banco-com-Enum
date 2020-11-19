package threadenum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.plaf.TableHeaderUI;

public class Conta implements Runnable{
    private String nome;
    private double saldo;
    private String operacao;
    double valor;

public Conta(String nome, double saldo){
    this.nome = nome;
    this.saldo = saldo;
    this.operacao = "Consulta";
    double valor;
}

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOperacao() {
        return this.operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public double getSaldo() {
        return this.saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    void ExibirSaldo(){
        Thread consulta = new Thread( this);
        consulta.start();
        try {
            consulta.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void DepositarValor(double valor){
        this.valor = valor;
        this.setOperacao("Deposito");
        Thread deposito = new Thread( this);
        deposito.start();
        try {
            deposito.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void RetirarValor(double valor){
        this.valor = valor * (-1);
        this.setOperacao("Saque");
        Thread saque = new Thread( this);
        saque.start();
        try {
            saque.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void run(){
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:ms");
        Date data = new Date();
        System.out.println(dateFormat.format(data));
        
        try{
        System.out.println("Titular: " + this.nome);
        if(this.operacao == "Consulta"){
            double saldo = this.getSaldo();
           
            System.out.println("Checando o seu saldo, aguarde...");
            
            Thread.sleep(500);
           
            System.out.println("Seu saldo atual é R$: " + saldo);
            System.out.println("-------------------------------------------------");
        }
        else if(this.operacao == "Deposito"){
            System.out.println("Realizando depósito, aguarde...");
            
            Thread.sleep(500);
            this.setSaldo(this.getSaldo() + valor);
           
            System.out.println("Seu saldo atual é R$: " + this.saldo);
            System.out.println("-------------------------------------------------");
        }
        else{
            double saldo = this.getSaldo();
            if(saldo > (this.valor * (-1))){
                System.out.println("Contando cédulas, aguarde...");
            
                Thread.sleep(500);
                this.setSaldo(saldo + valor);
           
                System.out.println("Retire o seu dinheiro");
                System.out.println("Seu saldo atual é R$: " + this.saldo);
                System.out.println("-------------------------------------------------");
            }else {
                System.out.println("Saldo insuficiente.. ;-;");
                System.out.println("A operação não foi realizada!");
                System.out.println("Seu saldo atual é R$: " + this.getSaldo());
                //this.ExibirSaldo();
            }  
        }
        this.setOperacao("Consulta");
        this.valor = 0;
        
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

