package informacoesLivros;

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

public class Informacoes extends Application {

	private AnchorPane pane;
	private ImageView imagemLivro;
	private Button butEmprestar;
	private Label detalhes;
	public static Stage stage;
	public static Livro book;
	public static int index;
	private static String[] capas = {"https://ae01.alicdn.com/kf/HTB1_tg_bcfrK1RkSnb4q6xHRFXab/Harry-Potter-and-the-Sorcerer-s-Stone-J-K-Rowling-Published-in-2014-English-Kids-Fiction.jpg_640x640.jpg",
									"https://images-na.ssl-images-amazon.com/images/I/81XShzFm2EL.__BG0,0,0,0_FMpng_AC_UL300_SR300,300_.jpg",
									"https://daniel.gd/wp-content/uploads/2017/11/knight-of-seven-kingdoms.png",
									"https://img.maisonbible.net/55564-large_default/chronicles-of-narnia-the---7-books-in-1-hardcover.jpg",
									"https://www.platekompaniet.no/globalassets/boker/9780008307738.jpg?preset=ProductPage",
									"https://images.csmonitor.com/csm/2014/08/idragon.png?alias=standard_900x600"
									};
	
	private static String[] descricao = {"Harry Potter � um garoto cujos pais, feiticeiros, foram assassinados por um poderos�ssimo bruxo\\n\r\n" + 
										"quando ele ainda era um beb�. Ele foi levado, ent�o, para a casa dos tios que nada tinham a ver com o sobrenatural.\\n \r\n" + 
										"Pelo contr�rio. At� os 10 anos, Harry foi uma esp�cie de gata borralheira: maltratado pelos tios,\\n \r\n" + 
										"herdava roupas velhas do primo gorducho, tinha �culos remendados e era tratado como um estorvo.\\n \r\n" + 
										"No dia de seu anivers�rio de 11 anos, entretanto, ele parece deslizar por um buraco sem fundo,\\n \r\n" + 
										"como o de Alice no pa�s das maravilhas, que o conduz a um mundo m�gico.\\n \r\n" + 
										"Descobre sua verdadeira hist�ria e seu destino:\\n \r\n" + 
										"ser um aprendiz de feiticeiro at� o dia em que ter� que enfrentar a pior for�a do mal,\\n \r\n" + 
										"o homem que assassinou seus pais. O menino de olhos verde, magricela e desengon�ado,\\n \r\n" + 
										"t�o habituado � rejei��o, descobre, tamb�m, que � um her�i no universo dos magos.\\n \r\n" + 
										"Potter fica sabendo que � a �nica pessoa a ter sobrevivido a um ataque do tal bruxo do mal e\\n \r\n" + 
										"essa � a causa da marca em forma de raio que ele carrega na testa. Ele n�o � um garoto qualquer,\\n \r\n" + 
										"ele sequer � um feiticeiro qualquer; ele � Harry Potter, s�mbolo de poder, resist�ncia e um l�der\\n \r\n" + 
										"natural entre os sobrenaturais. A f�bula, recheada de fantasmas, paredes que falam, caldeir�es,\\n \r\n" + 
										"sapos, unic�rnios, drag�es e gigantes, n�o �, entretanto, apenas um passatempo.\\n", "2", "3", "4", "5", "6"
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
		Informacoes.stage = stage;
	}
	
	
	private void componentes() {
		
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		imagemLivro = new ImageView(new Image(capas[index]));
		detalhes = new Label("Sinopse: " + descricao[index]);
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
		detalhes.setLayoutX(300);
		detalhes.setLayoutY(50);
		butEmprestar.setLayoutX(10);
		butEmprestar.setLayoutY(260);
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

