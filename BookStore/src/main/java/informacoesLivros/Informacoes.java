package informacoesLivros;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tabelaDeEmprestimos.EmprestimoInterface;
import tabelaDeLivros.ListaInterface;
import tabelaDeLivros.Livro;

public class Informacoes extends Application {

	private AnchorPane pane;
	private ImageView imagemLivro;
	private Button butEmprestar, butVoltar;
	private Label detalhes;
	public static Stage stage;
	public static Livro book;
	public static int index;
	public static String oldNome = null;
	private static String[] capas = {"https://ae01.alicdn.com/kf/HTB1_tg_bcfrK1RkSnb4q6xHRFXab/Harry-Potter-and-the-Sorcerer-s-Stone-J-K-Rowling-Published-in-2014-English-Kids-Fiction.jpg_640x640.jpg",
									"https://images-na.ssl-images-amazon.com/images/I/81XShzFm2EL.__BG0,0,0,0_FMpng_AC_UL300_SR300,300_.jpg",
									"https://daniel.gd/wp-content/uploads/2017/11/knight-of-seven-kingdoms.png",
									"https://img.maisonbible.net/55564-large_default/chronicles-of-narnia-the---7-books-in-1-hardcover.jpg",
									"https://www.platekompaniet.no/globalassets/boker/9780008307738.jpg?preset=ProductPage",
									"https://images.csmonitor.com/csm/2014/08/idragon.png?alias=standard_900x600"
									};
	
	private static String[] descricao = {"Harry Potter � um garoto cujos pais, feiticeiros, \r\n" + 
										"foram assassinados por um poderos�ssimo bruxo\r\n" + 
										"quando ele ainda era um beb�. No dia de seu anivers�rio de 11 anos, entretanto, \r\n" + 
										"ele parece deslizar por um buraco sem fundo, como o de Alice no pa�s das \r\n" +
										"maravilhas que o conduz a um mundo m�gico. Descobre sua verdadeira hist�ria\r\n" + 
										"e seu destino: ser um aprendiz de feiticeiro at� o dia em que ter� \r\n" + 
										"que enfrentar a pior for�a do mal, o homem que assassinou seus pais. \r\n",
										
										"A saga dos personagens de Cr�nicas de Gelo e Fogo n�o come�ou \r\n" + 
										"com as disputas pelo trono de ferro. Este Guia in�dito e \r\n" + 
										"ricamente ilustrado re�ne um amplo material in�dito que se estende \r\n" + 
										"desde a Era da Aurora at� a Era do Her�is; a partir da vinda dos \r\n " +
										"primeiros homens at� a chegada de Aegon, o Conquistador; \r\n" +
										"da conquista de Aegon do Trono de Ferro at� a Rebeli�o de \r\n" +
										"Robert e da queda do Rei Louco, Aerys II Targaryen, o que tem \r\n" + 
										"causado as \"atuais\" lutas dos Starks, Lannisters, Baratheon e Targaryen.", 
										
										"Duzentos anos ap�s a conquista, a dinastia Targaryen vive seu auge. \r\n" + 
										"Os Sete Reinos de Westeros atravessam um tempo de relativa paz, \r\n" + 
										"nos �ltimos anos do reinado do Bom Rei Daeron. � neste cen�rio que Dunk, \r\n" + 
										"um menino pobre da Baixada das Pulgas, tem uma chance �nica: deixar a \r\n" + 
										"vida miser�vel em Porto Real para se tornar escudeiro de um cavaleiro \r\n" +
										"andante. Alguns anos depois, com a morte do cavaleiro, Dunk j� adulto \r\n" +
										"decide tomar seu lugar e fazer fama no torneio de Campina de Vaufreixo. \r\n" +
										"� quando conhece Egg, um menino de dez anos, cabe�a totalmente raspada \r\n" +
										"que � muito mais do que aparenta ser. Dunk aceita Egg como seu escudeiro \r\n" +
										"e juntos viajam por Westeros em busca de trabalho e aventuras.", 
										
										"Para um mundo em que a magia encontra a realidade, e o resultado \r\n" + 
										"� um mundo ficcional que tem fascinado gera��es. Esta edi��o apresenta \r\n" + 
										"todas as sete cr�nicas integralmente, num �nico volume. Os livros s�o \r\n" + 
										"apresentados de acordo com a ordem de prefer�ncia de Lewis, cada cap�tulo \r\n" + 
										"com uma ilustra��o do artista original, Pauline Baynes. \r\n" + 
										"Enganosamente simples e direta, 'As cr�nicas de N�rnia' continuam cativando \r\n" + 
										"os leitores com aventuras, personagens e fatos que falam a \r\n" + 
										"pessoas de todas as idades.", 
										
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
		BackgroundImage back = new BackgroundImage(new Image("https://images.unsplash.com/photo-1460602594182-8568137446ce?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80", 
        		800, 600, false, true),  BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(back));
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
		detalhes.setFont(Font.font("Amble CN", FontWeight.BOLD, 13));
		detalhes.setTextFill(Color.web("#ffffff"));
		imagemLivro.setFitWidth(250);
		imagemLivro.setFitHeight(250);
		butEmprestar = new Button("Emprestar");
		butVoltar = new Button("Voltar");
		pane.getChildren().addAll(imagemLivro, detalhes, butEmprestar, butVoltar);
	}
	
	private void funcao() {
		butEmprestar.setOnAction((evento) -> {
				if (book.getNome() != oldNome) {
				ListaInterface.emp.addLivros(book);
				oldNome = book.getNome();				
				}
				try {
					new EmprestimoInterface().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
		
		butVoltar.setOnAction((evento) ->{
			Informacoes.stage.close();
		});
	}
	
	private void layout() {
		detalhes.setLayoutX(300);
		detalhes.setLayoutY(50);
		butEmprestar.setLayoutX(120);
		butEmprestar.setLayoutY(260);
		butVoltar.setLayoutX(50);
		butVoltar.setLayoutY(260);
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

