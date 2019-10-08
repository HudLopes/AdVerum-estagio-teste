import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HtmlTemplate {
	
	public void generateHtmlImportacao(List<Produto> importacao) {
		
		List<Produto> listImportacao = importacao;
		String path = "html/importacao.html";
		
		//@Util
		DecimalFormat fmt = new DecimalFormat("0.00");
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		//Iniciando html
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter(path));

			// HEADER
			file.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
					+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
					+ "    <title>Produtos</title>\r\n" + "    <link rel=\"stylesheet\" href=\"importacao.css\">\r\n"
					+ "</head>\r\n" + "\r\n" + "<body>\r\n" + "    <h1>Lista de Produtos</h1>\r\n" + "    <hr>\r\n"
					+ "    <p>Lista gerada em " + data + " as " + hora + " </p>\r\n" + "    \r\n" + "    <table>\r\n"
					+ "        <thead>\r\n" + "            <tr>\r\n" + "                <th>Produto</th>\r\n"
					+ "                <th>Marca</th>\r\n" + "                <th>Preco</th>\r\n"
					+ "                <th>Estoque</th>\r\n" + "            </tr>\r\n" + "        </thead>\r\n"
					+ "        <tbody>\r\n" + "            <!-- Lista de produtos -->\r\n");
			
			//pecorrendo a lista e preenchendo as celulas do html
			listImportacao.forEach(produto -> {
		try {
			file.write("  <tr>\r\n" + 
					" <td>" + produto.getNome()  + "</td>\r\n" + 
					" <td>" + produto.getMarca() + "</td>\r\n" + 
					" <td> " + fmt.format(produto.getPreco()) + "</td>\r\n" + //tratando formato decimal
					" <td>" + produto.getEstoque() + "</td>\r\n" + 
					" </tr>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			//fechando tags do html
			file.write("</tbody>\r\n" + "    </table>\r\n" + "\r\n" + "</body>\r\n" + "</html>");
			file.close();
			System.out.println("\nHtml gerado em: " + path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}



