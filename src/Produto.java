public class Produto implements Comparable<Produto> {

	//@model
	private String nome;
	private String marca;
	private float preco;
	private int estoque;
	
	Produto(String nome, String marca, float preco, int estoque){
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	//ordernar lista (para extrair os maiores valores)
	@Override
	public int compareTo(Produto outroProduto) {
		 if (this.preco > outroProduto.getPreco()) {
	          return -1;
	     }
	     if (this.preco < outroProduto.getPreco()) {
	          return 1;
	     }
	     return 0;
	}
	
	//Getters n' Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
}
