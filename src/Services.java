import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class Services implements IServices {

	List<Produto> listaDeProdutos = new ArrayList<Produto>();
	
	//Importação de CSV usando o OpenCSV
	@Override
	public List<Produto> importarExcel(String caminho) {
		try {		
			//importação
			@SuppressWarnings({ "deprecation", "resource" })
			CSVReader reader = new CSVReader(new FileReader(caminho), ',', '\'', 1);
			
			final Iterator<String[]> iterator = reader.iterator();

			 //pecorrendo cada linha do excel
	            while (iterator.hasNext()) {
	                final String[] linhaDoExcel = iterator.next();
	                String[] celulaDaLinha = linhaDoExcel[0].split(";");
	                
	                //passando as celulas do excel para o objeto produto
	                Produto produto = new Produto(
	                		celulaDaLinha[0],
	                		celulaDaLinha[1],
	                		Float.parseFloat(celulaDaLinha[2]),
	                		Integer.parseInt(celulaDaLinha[3]));
	                
	                //criando arraylist de produtos
	                listaDeProdutos.add(produto);	                
	            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaDeProdutos;
	}

	@Override
	public int sumEstoque(List<Produto> listaProduto) {

		int totalEstoque=0;
		  
		//pecorrendo todos os produtos e somando os valores de estoque a cada iteração
          for(int i=0; i<listaProduto.size(); i++) {
          	totalEstoque+=listaProduto.get(i).getEstoque();
          }
          
		return totalEstoque;
	}

	@Override
	public float mediaPrecos(List<Produto> listaProduto) {
		float mediaPrecos=0;
		
		//pecorrendo todos os produtos e somando os valores do preço a cada iteração e divindo pelo tamanho da lista
        for(int i=0; i<listaProduto.size(); i++) {
        	mediaPrecos+=listaProduto.get(i).getPreco();
        }
        mediaPrecos/=listaProduto.size();
        
		return mediaPrecos;
	}

	@Override
	public List<Produto> maioresValores(List<Produto> listaProduto) {
		List<Produto> listaDeProdutosMaiorValor = new ArrayList<Produto>();
		
		//Ordena a lista de produto usando o valor do produto, utilizando o comparable 
		//e por fim criando um array com os 2 primeiros produtos, que são os mais caros agora
		Collections.sort(listaProduto);
		for(int i=0; i<2 ; i++) {
			listaDeProdutosMaiorValor.add(listaProduto.get(i));
		}
		
		return listaDeProdutosMaiorValor;
	}
	
}
