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
	
	private static String[] descricao = {"Harry Potter � um garoto cujos pais, feiticeiros, \r\n" + 
										"foram assassinados por um poderos�ssimo bruxo\r\n" + 
										"quando ele ainda era um beb�. Ele foi levado, ent�o, \r\n" + 
										"para a casa dos tios que nada tinham a ver com o sobrenatural.\r\n" + 
										"Pelo contr�rio. At� os 10 anos, Harry foi uma esp�cie de gata \r\n" + 
										"borralheira: maltratado pelos tios, herdava roupas velhas do \r\n" + 
										"primo gorducho, tinha �culos remendados e era tratado como um estorvo.\r\n" + 
										"No dia de seu anivers�rio de 11 anos, entretanto, ele parece deslizar\r\n" + 
										"por um buraco sem fundo, como o de Alice no pa�s das maravilhas, \r\n" + 
										"que o conduz a um mundo m�gico. Descobre sua verdadeira hist�ria\r\n" + 
										"e seu destino: ser um aprendiz de feiticeiro at� o dia em que ter� \r\n" + 
										"que enfrentar a pior for�a do mal, o homem que assassinou seus pais. \r\n" + 
										"O menino de olhos verde, magricela e desengon�ado, t�o habituado � rejei��o, \r\n" + 
										"descobre, tamb�m, que � um her�i no universo dos magos. Potter fica sabendo \r\n" + 
										"que � a �nica pessoa a ter sobrevivido a um ataque do tal bruxo do mal e \r\n" + 
										"essa � a causa da marca em forma de raio que ele carrega na testa. Ele n�o \r\n" + 
										"� um garoto qualquer, ele sequer � um feiticeiro qualquer; ele � Harry Potter, \r\n" + 
										"s�mbolo de poder, resist�ncia e um l�der natural entre os sobrenaturais.\r\n" + 
										"A f�bula, recheada de fantasmas, paredes que falam, caldeir�es, \r\n" + 
										"sapos, unic�rnios, drag�es e gigantes, n�o �, entretanto, apenas um passatempo.",
										
										"A saga dos personagens de Cr�nicas de Gelo e Fogo n�o come�ou \r\n" + 
										"com as disputas pelo trono de ferro. Este Guia in�dito e \r\n" + 
										"ricamente ilustrado re�ne um amplo material in�dito que se estende \r\n" + 
										"desde a Era da Aurora at� a Era do Her�is; a partir da vinda do primeiros homens \r\n" + 
										"at� a chegada de Aegon, o Conquistador; da conquista de Aegon do Trono de Ferro \r\n" + 
										"at� a Rebeli�o de Robert e da queda do Rei Louco, Aerys II Targaryen, o que tem \r\n" + 
										"causado as \"atuais\" lutas dos Starks, Lannisters, Baratheon e Targaryen.", 
										
										"Duzentos anos ap�s a conquista, a dinastia Targaryen vive seu auge. \r\n" + 
										"Os Sete Reinos de Westeros atravessam um tempo de relativa paz, \r\n" + 
										"nos �ltimos anos do reinado do Bom Rei Daeron. � neste cen�rio que Dunk, \r\n" + 
										"um menino pobre da Baixada das Pulgas, tem uma chance �nica: deixar a vida miser�vel \r\n" + 
										"em Porto Real para se tornar escudeiro de um cavaleiro andante. Alguns anos depois, \r\n" + 
										"com a morte do cavaleiro, Dunk j� adulto decide tomar seu lugar e fazer fama no torneio \r\n" + 
										"de Campina de Vaufreixo. � quando conhece Egg, um menino de dez anos, cabe�a totalmente \r\n" + 
										"raspada que � muito mais do que aparenta ser. Dunk aceita Egg como seu escudeiro e juntos \r\n" + 
										"viajam por Westeros em busca de trabalho e aventuras.", 
										
										"Para um mundo em que a magia encontra a realidade, e o resultado \r\n" + 
										"� um mundo ficcional que tem fascinado gera��es. Esta edi��o apresenta \r\n" + 
										"todas as sete cr�nicas integralmente, num �nico volume. Os livros s�o \r\n" + 
										"apresentados de acordo com a ordem de prefer�ncia de Lewis, cada cap�tulo \r\n" + 
										"com uma ilustra��o do artista original, Pauline Baynes. \r\n" + 
										"Enganosamente simples e direta, 'As cr�nicas de N�rnia' continuam cativando \r\n" + 
										"os leitores com aventuras, personagens e fatos que falam a pessoas de todas as idades.", 
										
										"O que realmente aconteceu durante a Dan�a dos Drag�es? \r\n" + 
										"Por que era t�o perigoso visitar Val�ria depois da Destrui��o? \r\n" + 
										"Qual � a origem dos tr�s ovos de drag�o que chegaram a Daenerys? \r\n" + 
										"Essas s�o algumas das quest�es respondidas neste livro essencial, \r\n" + 
										"relatadas por um s�bio meistre da Cidadela.", 
										
										"O drag�o de gelo era uma criatura lend�ria e temida, pois nenhum homem jamais \r\n" + 
										"havia domado um. Quando sobrevoava o mundo, deixava um rastro de frio desolador \r\n" + 
										"e terras congeladas. Mas Adara n�o tinha medo, pois ela era uma crian�a do inverno, \r\n" + 
										"nascida durante o frio mais intenso de que algu�m tinha mem�ria. Adara n�o se \r\n" + 
										"lembrava de quando viu o drag�o de gelo pela primeira vez. Parecia que a criatura \r\n" + 
										"sempre estivera em sua vida, avistada de longe enquanto ela brincava na neve gelada \r\n" + 
										"durante muito tempo depois de as outras crian�as terem fugido do frio."
										
										};
	
	@Override
	
	public void start(Stage stage) throws Exception {
		componentes();
		funcao();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle(book.getNome());
		stage.getIcons().add(new Image("https://vignette.wikia.nocookie.net/2007scape/images/7/7a/Mage%27s_book_detail.png/revision/latest?cb=20180310083825"));
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

