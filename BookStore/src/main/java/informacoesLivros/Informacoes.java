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
	
	private static String[] descricao = {"Harry Potter é um garoto cujos pais, feiticeiros, foram assassinados por um poderosíssimo bruxo\\n\r\n" + 
										"quando ele ainda era um bebê. Ele foi levado, então, para a casa dos tios que nada tinham a ver com o sobrenatural.\\n \r\n" + 
										"Pelo contrário. Até os 10 anos, Harry foi uma espécie de gata borralheira: maltratado pelos tios,\\n \r\n" + 
										"herdava roupas velhas do primo gorducho, tinha óculos remendados e era tratado como um estorvo.\\n \r\n" + 
										"No dia de seu aniversário de 11 anos, entretanto, ele parece deslizar por um buraco sem fundo,\\n \r\n" + 
										"como o de Alice no país das maravilhas, que o conduz a um mundo mágico.\\n \r\n" + 
										"Descobre sua verdadeira história e seu destino:\\n \r\n" + 
										"ser um aprendiz de feiticeiro até o dia em que terá que enfrentar a pior força do mal,\\n \r\n" + 
										"o homem que assassinou seus pais. O menino de olhos verde, magricela e desengonçado,\\n \r\n" + 
										"tão habituado à rejeição, descobre, também, que é um herói no universo dos magos.\\n \r\n" + 
										"Potter fica sabendo que é a única pessoa a ter sobrevivido a um ataque do tal bruxo do mal e\\n \r\n" + 
										"essa é a causa da marca em forma de raio que ele carrega na testa. Ele não é um garoto qualquer,\\n \r\n" + 
										"ele sequer é um feiticeiro qualquer; ele é Harry Potter, símbolo de poder, resistência e um líder\\n \r\n" + 
										"natural entre os sobrenaturais. A fábula, recheada de fantasmas, paredes que falam, caldeirões,\\n \r\n" + 
										"sapos, unicórnios, dragões e gigantes, não é, entretanto, apenas um passatempo.\\n", "2", "3", "4", "5", "6"
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

