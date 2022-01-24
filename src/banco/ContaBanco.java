package banco;
public class ContaBanco {
    
    //Atributos 
    public int numConta; 
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    //Métodos personalizados
    public void estadoAtual(){
        System.out.println("---------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.isStatus());
    }
    
    public void abrirConta(String t){
        setTipo(t);
        setStatus(true);
        if (t == "CC"){
            this.setSaldo(50);
        }
        else if (t == "CP"){
            this.setSaldo(150);
        }
        System.out.println("Conta de " + this.getDono() + " aberta com sucesso!");
    }
    
    public void fecharConta(){
        if (this.getSaldo() > 0) {
            System.out.println("Conta de " + this.getDono() + " não pode ser fechada porque ainda tem dinheiro");
        } 
        else if (this.getSaldo() < 0){
            System.out.println("Conta de " + this.getDono() + " não pode ser fechada pois tem débito");
        }
        else{
            System.out.println("Conta de " + this.getDono() + " fechada com sucesso");
            this.setStatus(false);
        }
    }
    
    public void depositar(float v){
        if (this.isStatus() == true) {
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Depósito de R$ " + v + " realizado com secesso na conta de " + this.getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada!");
        }
    }
    
    public void sacar(float v){
        if (this.isStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("saque de R$ " + v + " realizado na conta de " + this.getDono());
            } 
            else {
                System.out.println("saldo insuficiente para saque");
            }
        } 
        else {
            System.out.println("Impossível sacar de uma conta fechada!");
        }
    }
    
    public void pagarMensal(){
        int v = 0;
        if (this.getTipo() == "CC") {
            v = 12;
        } else if (this.getTipo() == "CP"){
            v = 20;
        }
        if (this.isStatus()) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade de " + this.getDono() + " paga com sucesso");
        } 
        else {
            System.out.println("Impossível pagar uma conta fechada!");
        }
    }
     
    //Getters and Setters
    public void ContaBanco(){
        this.setSaldo(0);
        this.setStatus(false);
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
