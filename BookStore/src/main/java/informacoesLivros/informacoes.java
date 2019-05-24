package informacoesLivros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tabelaDeEmprestimos.EmprestimoInterface;
import tabelaDeLivros.ListaInterface;
import tabelaDeLivros.Livro;

public class informacoes extends Application {

	private AnchorPane pane;
	private ImageView imagemLivro;
	private Button butEmprestar;
	private Label detalhes;
	public static Stage stage;
	public static Livro book;
	public static int index;
	private static String[] capas = {"https://www.jkrowling.com/wp-content/uploads/2018/01/SorcerersStone_2017.png",
									"https://images-na.ssl-images-amazon.com/images/I/81XShzFm2EL.__BG0,0,0,0_FMpng_AC_UL300_SR300,300_.jpg",
									"https://daniel.gd/wp-content/uploads/2017/11/knight-of-seven-kingdoms.png",
									"https://img.maisonbible.net/55564-large_default/chronicles-of-narnia-the---7-books-in-1-hardcover.jpg",
									"https://www.platekompaniet.no/globalassets/boker/9780008307738.jpg?preset=ProductPage",
									"https://images.csmonitor.com/csm/2014/08/idragon.png?alias=standard_900x600"
									};
	
	private static String[] descricao = {"Batata", "Chinelo", "Café", "Água", "Pão", "Minancora"
			
			
										};
	
	@Override
	
	public void start(Stage stage) throws Exception {
		componentes();
		funcao();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle(book.getNome());
		stage.show();
		layout();
		informacoes.stage = stage;
	}
	
	
	private void componentes() {
		
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		imagemLivro = new ImageView(new Image(capas[index]));
		detalhes = new Label("Sinopse: " + index);
		imagemLivro.setFitWidth(250);
		imagemLivro.setFitHeight(250);
		butEmprestar = new Button("Emprestar");
		pane.getChildren().addAll(imagemLivro, detalhes, butEmprestar);
	}
	
	private void funcao() {
		butEmprestar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				ListaInterface.emp.addLivros(book);
				try {
					new EmprestimoInterface().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	private void layout() {
		detalhes.setLayoutX(350);
		detalhes.setLayoutY(50);
		butEmprestar.setLayoutX(10);
		butEmprestar.setLayoutY(260);
		
	}
	
	public String leitor(int index) {
		
		  BufferedReader objReader = null;
		  try {
		   String strCurrentLine;

		   objReader = new BufferedReader(new FileReader("C:\\Users\\Shino\\Documents\\Textos\\teste.txt"));

		   while ((strCurrentLine = objReader.readLine()) != null) {

		    return strCurrentLine;
		   }

		   
		  } catch (IOException e) {

		   e.printStackTrace();

		  } finally {

		   try {
		    if (objReader != null)
		     objReader.close();
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		return null;
		 }
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

