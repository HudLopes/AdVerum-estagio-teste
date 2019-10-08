import java.util.List;

public class AppAdVerum {

	public static void main(String[] args) {
		
		//Variaveis da tela
		List<Produto> listaImportacao;
		IServices services = new Services();
		HtmlTemplate html = new HtmlTemplate();
		
		//importação do arquivo
		listaImportacao = services.importarExcel("/estoque.csv");

		//prints no console -> produtos mais caros
		System.out.println("Produtos mais caros:");
		List<Produto> ListarMaioresValores = services.maioresValores(listaImportacao);
		ListarMaioresValores.forEach(nome -> System.out.println(nome.getNome() + ", R$: " + nome.getPreco()));
		
		// prints no console -> Preço medio dos produtos
		System.out.printf("\nPreço médio dos produtos: " + "%.2f \n", services.mediaPrecos(listaImportacao)) ;
	
		//prints no console -> quantidade de itens em estoque
		System.out.println("\nQuantidade de itens em estoque: " + services.sumEstoque(listaImportacao));
		
		//HTMl generate
		html.generateHtmlImportacao(listaImportacao);
	}
}
