import java.util.List;

public interface IServices {
     
	List<Produto> importarExcel(String caminho);
     
    int sumEstoque(List<Produto> listaProduto);
    
    float mediaPrecos(List<Produto> listaProduto);
    
    List<Produto> maioresValores(List<Produto> listaProduto);
}
