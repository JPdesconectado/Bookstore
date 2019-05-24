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
	
	private static String[] descricao = {"Harry Potter é um garoto cujos pais, feiticeiros, \r\n" + 
										"foram assassinados por um poderosíssimo bruxo\r\n" + 
										"quando ele ainda era um bebê. Ele foi levado, então, \r\n" + 
										"para a casa dos tios que nada tinham a ver com o sobrenatural.\r\n" + 
										"Pelo contrário. Até os 10 anos, Harry foi uma espécie de gata \r\n" + 
										"borralheira: maltratado pelos tios, herdava roupas velhas do \r\n" + 
										"primo gorducho, tinha óculos remendados e era tratado como um estorvo.\r\n" + 
										"No dia de seu aniversário de 11 anos, entretanto, ele parece deslizar\r\n" + 
										"por um buraco sem fundo, como o de Alice no país das maravilhas, \r\n" + 
										"que o conduz a um mundo mágico. Descobre sua verdadeira história\r\n" + 
										"e seu destino: ser um aprendiz de feiticeiro até o dia em que terá \r\n" + 
										"que enfrentar a pior força do mal, o homem que assassinou seus pais. \r\n" + 
										"O menino de olhos verde, magricela e desengonçado, tão habituado à rejeição, \r\n" + 
										"descobre, também, que é um herói no universo dos magos. Potter fica sabendo \r\n" + 
										"que é a única pessoa a ter sobrevivido a um ataque do tal bruxo do mal e \r\n" + 
										"essa é a causa da marca em forma de raio que ele carrega na testa. Ele não \r\n" + 
										"é um garoto qualquer, ele sequer é um feiticeiro qualquer; ele é Harry Potter, \r\n" + 
										"símbolo de poder, resistência e um líder natural entre os sobrenaturais.\r\n" + 
										"A fábula, recheada de fantasmas, paredes que falam, caldeirões, \r\n" + 
										"sapos, unicórnios, dragões e gigantes, não é, entretanto, apenas um passatempo.",
										
										"A saga dos personagens de Crônicas de Gelo e Fogo não começou \r\n" + 
										"com as disputas pelo trono de ferro. Este Guia inédito e \r\n" + 
										"ricamente ilustrado reúne um amplo material inédito que se estende \r\n" + 
										"desde a Era da Aurora até a Era do Heróis; a partir da vinda do primeiros homens \r\n" + 
										"até a chegada de Aegon, o Conquistador; da conquista de Aegon do Trono de Ferro \r\n" + 
										"até a Rebelião de Robert e da queda do Rei Louco, Aerys II Targaryen, o que tem \r\n" + 
										"causado as \"atuais\" lutas dos Starks, Lannisters, Baratheon e Targaryen.", 
										
										"Duzentos anos após a conquista, a dinastia Targaryen vive seu auge. \r\n" + 
										"Os Sete Reinos de Westeros atravessam um tempo de relativa paz, \r\n" + 
										"nos últimos anos do reinado do Bom Rei Daeron. É neste cenário que Dunk, \r\n" + 
										"um menino pobre da Baixada das Pulgas, tem uma chance única: deixar a vida miserável \r\n" + 
										"em Porto Real para se tornar escudeiro de um cavaleiro andante. Alguns anos depois, \r\n" + 
										"com a morte do cavaleiro, Dunk já adulto decide tomar seu lugar e fazer fama no torneio \r\n" + 
										"de Campina de Vaufreixo. É quando conhece Egg, um menino de dez anos, cabeça totalmente \r\n" + 
										"raspada que é muito mais do que aparenta ser. Dunk aceita Egg como seu escudeiro e juntos \r\n" + 
										"viajam por Westeros em busca de trabalho e aventuras.", 
										
										"Para um mundo em que a magia encontra a realidade, e o resultado \r\n" + 
										"é um mundo ficcional que tem fascinado gerações. Esta edição apresenta \r\n" + 
										"todas as sete crônicas integralmente, num único volume. Os livros são \r\n" + 
										"apresentados de acordo com a ordem de preferência de Lewis, cada capítulo \r\n" + 
										"com uma ilustração do artista original, Pauline Baynes. \r\n" + 
										"Enganosamente simples e direta, 'As crônicas de Nárnia' continuam cativando \r\n" + 
										"os leitores com aventuras, personagens e fatos que falam a pessoas de todas as idades.", 
										
										"O que realmente aconteceu durante a Dança dos Dragões? \r\n" + 
										"Por que era tão perigoso visitar Valíria depois da Destruição? \r\n" + 
										"Qual é a origem dos três ovos de dragão que chegaram a Daenerys? \r\n" + 
										"Essas são algumas das questões respondidas neste livro essencial, \r\n" + 
										"relatadas por um sábio meistre da Cidadela.", 
										
										"O dragão de gelo era uma criatura lendária e temida, pois nenhum homem jamais \r\n" + 
										"havia domado um. Quando sobrevoava o mundo, deixava um rastro de frio desolador \r\n" + 
										"e terras congeladas. Mas Adara não tinha medo, pois ela era uma criança do inverno, \r\n" + 
										"nascida durante o frio mais intenso de que alguém tinha memória. Adara não se \r\n" + 
										"lembrava de quando viu o dragão de gelo pela primeira vez. Parecia que a criatura \r\n" + 
										"sempre estivera em sua vida, avistada de longe enquanto ela brincava na neve gelada \r\n" + 
										"durante muito tempo depois de as outras crianças terem fugido do frio."
										
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

