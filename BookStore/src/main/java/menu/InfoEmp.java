package menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InfoEmp extends Application {

	private AnchorPane pane;
	private Button butVoltar, butReg, butPrazo, butRen, butRes, butPen, butLem;
	public static Stage stage;
	private Text inicio;
	private ImageView logo, imagem1, imagem2;
	
	@Override
	
	public void start(Stage stage) throws Exception {
		componentes();
		funcoes();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Informacoes Importantes");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://vignette.wikia.nocookie.net/2007scape/images/7/7a/Mage%27s_book_detail.png/revision/latest?cb=20180310083825"));
		stage.show();
		layout();
		InfoEmp.stage = stage;
	}
	
	
	private void componentes() {
		
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		BackgroundImage back = new BackgroundImage(new Image("https://images.unsplash.com/photo-1460602594182-8568137446ce?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80", 
				800, 600, false, true),  BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(back));
        inicio = new Text();
        inicio.setFont(Font.font("calibri", FontWeight.BLACK, FontPosture.REGULAR, 40));
        inicio.setText("BookStore");
		butVoltar = new Button("Voltar");
		butReg = new Button("Regulamento para Uso");
		butPrazo = new Button("Prazos e Regras");
		butRen = new Button("Renovaçoes");
		butPen = new Button("Penalidades");
		butRes = new Button("Reservas");
		butLem = new Button("Lembretes");
		logo = new ImageView(new Image("http://www.sclance.com/pngs/open-book-png-icon/open_book_png_icon_959216.png"));
	    logo.setFitWidth(100);
		logo.setFitHeight(100);
        imagem1 = new ImageView(new Image("http://i.imgur.com/enOkJbE.png"));
        imagem2 = new ImageView(new Image("https://orig06.deviantart.net/6db3/f/2012/339/0/e/kakashi_render_by_lbackfromthedeadl-d5n70qv.png"));
        imagem2.setFitHeight(328);
        imagem2.setFitWidth(300);
		pane.getChildren().addAll(inicio, logo, imagem1, imagem2, butVoltar, butReg, butPrazo, butRen, butPen, butRes, butLem);
	}
	
	private void funcoes() {
		
		butVoltar.setOnAction((evento) -> {
			try {
				new Menu().start(new Stage());
				InfoEmp.stage.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		butReg.setOnAction((evento) -> {
			Alert dialogoReg = new Alert(AlertType.INFORMATION);
			dialogoReg.setTitle("BookStore");
			dialogoReg.setHeaderText("Regulamento para Uso");
			dialogoReg.setContentText("Para utilizar o serviço de empréstimo é necessário estar de posse da carteirinha da biblioteca\r\n" +
			"Os materiais dispostos para empréstimo atualmente são livros e revistas");
			dialogoReg.showAndWait(); 
		});
		
		butPrazo.setOnAction((evento) -> {
			Alert dialogoPrazo = new Alert(AlertType.INFORMATION);
			dialogoPrazo.setTitle("BookStore");
			dialogoPrazo.setHeaderText("Prazo e numero maximo de emprestimos");
			dialogoPrazo.setContentText("O prazo máximo de empréstimo para cada livro é de 15 dias. \r\n" +
			"O número máximo de empréstimos por aluno é de 4 livros.");
			dialogoPrazo.showAndWait(); 
		});
		
		butRen.setOnAction((evento) -> {
			Alert dialogoRen = new Alert(AlertType.INFORMATION);
			dialogoRen.setTitle("BookStore");
			dialogoRen.setHeaderText("Renovacoes");
			dialogoRen.setContentText("Os empréstimos podem ser renovados até duas vezes pelo mesmo período, sempre que não haja reservas prévias. \r\n" +
			"Não se renovarão documentos reservados, empréstimos espirados e aqueles que, por razões de demanda, estabeleça a biblioteca. ");
			dialogoRen.showAndWait(); 
		});
		
		butRes.setOnAction((evento) -> {
			Alert dialogoRes = new Alert(AlertType.INFORMATION);
			dialogoRes.setTitle("BookStore");
			dialogoRes.setHeaderText("Reservas");
			dialogoRes.setContentText("Serão admitidas reservas de obras que se encontrem emprestadas por outros usuários.  \r\n" +
			"O número máximo de reservas é de três documentos. ");
			dialogoRes.showAndWait(); 
		});
		
		butPen.setOnAction((evento) -> {
			Alert dialogoPen = new Alert(AlertType.INFORMATION);
			dialogoPen.setTitle("BookStore");
			dialogoPen.setHeaderText("Penalidades");
			dialogoPen.setContentText("Os leitores que não cumpram com os prazos de devolução, ficarão impedidos de fazer uso dos serviços restantes \r\n" +
			"A perda ou destruição de documentos implica a restituição dos mesmos ou o abono da quantidade que estabeleça a biblioteca. \r\n" +
			"A biblioteca se reserva o direito de cancelar a inscrição do leitor que não cumpra este regulamento.");
			dialogoPen.showAndWait(); 
		});
		
		butLem.setOnAction((evento) -> {
			Alert dialogoLem = new Alert(AlertType.INFORMATION);
			dialogoLem.setTitle("BookStore");
			dialogoLem.setHeaderText("Lembrete");
			dialogoLem.setContentText("Só tem livro bom aqui!");
			dialogoLem.showAndWait(); 
		});
	}
	
	private void layout() {
		butReg.setLayoutX(360);
		butReg.setLayoutY(200);
		butPrazo.setLayoutX(360);
		butPrazo.setLayoutY(250);
		butRen.setLayoutX(360);
		butRen.setLayoutY(300);
		butRes.setLayoutX(360);
		butRes.setLayoutY(350);
		butPen.setLayoutX(360);
		butPen.setLayoutY(400); 
		butLem.setLayoutX(360);
		butLem.setLayoutY(450);
		butVoltar.setLayoutX(360);
		butVoltar.setLayoutY(500); 
		logo.setLayoutX(377);
		logo.setLayoutY(50);
		inicio.setLayoutX(345);
		inicio.setLayoutY(50);
		imagem1.setLayoutX(-120);
		imagem1.setLayoutY(300);
		imagem2.setLayoutX(520);
		imagem2.setLayoutY(300);
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

