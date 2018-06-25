
package exemplo10;

public class Hospital {
    
    private String nome, cnpj, categoria;
    private double rendaAtual;
    private short ano;
    private boolean privado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getRendaAtual() {
        return rendaAtual;
    }

    public void setRendaAtual(double rendaAtual) {
        this.rendaAtual = rendaAtual;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }
    
    
    
    
}
