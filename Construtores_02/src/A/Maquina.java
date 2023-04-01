package A;

public class Maquina {
    private int preco; //valor do ticket
    private int qtd; //quantidade de dinheiro inserido pelo cliente naquela compra
    private int total; //valor recolhido pela máquina até o momento atual
    private int ticket;

    public Maquina(int p){
        setPreco(p);
        setQtd();
        setTotal();
        setTicket();
    }

    public void insereDinheiro(int v){
        qtd += v;
        total += v;
        if (qtd < preco){
            System.out.println("Valor insuficiente. Insira mais "+(preco-qtd));
        } else {
            emiteTicket();
            qtd -= preco; //o preço do ticket é tirado do valor introduzido pelo ccliente
            if (qtd > 0){
                System.out.println("Troco: "+qtd);  //o troco é o que sobrou após a compra do ticket
                total -= qtd;  //o total final é o resultado sem o troco que foi entregue
                qtd = 0;//o valor introduzido pelo cliente é zerado
            }
        }
    }

    public void emiteTicket(){
        ticket += 1;
        System.out.println("\n==============\nTICKET\n=============");
    }

    public void setPreco(int p){
        preco = p;
    }

    public void setQtd(){
        qtd = 0;
    }

    public void setTotal(){
        total  = 0;
    }

    public void setTicket(){
        ticket = 0;
    }

    public int getPreco(){
        return preco;
    }

    public int getQtd(){
        return qtd;
    }

    public int getTotal(){
        return total;
    }

    public int getTicket(){
        return ticket;
    }

    public void mostraDados(){
        System.out.println("Valor do Ticket: "+this.preco);
        System.out.println("Quantidade Inserida pelo Cliente: "+this.qtd);
        System.out.println("Quantidade Total na Maquina: "+this.total);
        System.out.println("Quantidade Total de Tickets Vendidos: "+this.ticket);
    }
}
