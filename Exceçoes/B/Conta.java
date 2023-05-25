package B;

public class Conta {
    private String nome;
    private float saldo;
    private int numero;
    private String senha,usuario;

    public Conta(String a, String senha, float b, int c) throws MoneyException{
        setNome(a);
        setSaldo(b);
        setNumero(c);
        setSenha(senha);
        setUsuario(a);
    }

    public void depositaDinheiro(float valor) throws MoneyException {
        if (valor <= 0) throw new MoneyException("Valor Invalido.");
        setSaldo(this.getSaldo()+valor);
        System.out.println("Operacao realizada com sucesso!");
    }

    public void sacarDinheiro(float v) throws MoneyException{
        if (v > this.getSaldo()){
            throw new MoneyException();
        } else setSaldo(this.getSaldo() - v);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(float saldo) throws MoneyException{
        if (saldo < 100) throw new MoneyException();
        this.saldo = saldo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }
}
