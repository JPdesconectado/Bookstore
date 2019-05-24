package menu;

import javafx.application.Application;
import javafx.scene.Scene;
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
import tabelaDeLivros.ListaInterface;
import net.kurobako.gesturefx.GesturePane;

public class Menu extends Application {
	
	private AnchorPane pane;
	private Button botEmprestimo;
	private Button botSair;
	private Button botInfo;
	private ImageView logo, imagem1, imagem2;
	private Text inicio;
	private static Stage stage;
	private GesturePane pes;
	
	@Override
	
	public void start(Stage stage) throws Exception { 
	                
	componentes();
	funcoes();
	Scene scene = new Scene(pane);    
	stage.setScene(scene);   
	stage.getIcons().add(new Image("https://vignette.wikia.nocookie.net/2007scape/images/7/7a/Mage%27s_book_detail.png/revision/latest?cb=20180310083825"));
	stage.setTitle("Bookstore - Menu");
	stage.setResizable(false);
	stage.show();     
	layouts();
	Menu.stage = stage;
	
	}
	
	public static Stage getStage() {
		return stage;
	}
	public static void main(String[] args){            
		launch(args);        
		
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
        botEmprestimo = new Button("Emprestimo");
        botSair = new Button("Sair");
        botInfo = new Button("Informacoes");
        logo = new ImageView(new Image("http://www.sclance.com/pngs/open-book-png-icon/open_book_png_icon_959216.png"));
        logo.setFitWidth(100);
		logo.setFitHeight(100);
		imagem1 = new ImageView(new Image("http://i.imgur.com/enOkJbE.png"));
        imagem2 = new ImageView(new Image("https://orig06.deviantart.net/6db3/f/2012/339/0/e/kakashi_render_by_lbackfromthedeadl-d5n70qv.png"));
        imagem2.setFitHeight(328);
        imagem2.setFitWidth(300);
        pes = new GesturePane(imagem2);
        pane.getChildren().addAll(inicio, botEmprestimo, botSair, botInfo, imagem1, pes);
        
	}
	
	private void layouts() {
		

		botEmprestimo.setLayoutX(385);
		botEmprestimo.setLayoutY(200);
		botInfo.setLayoutX(385);
		botInfo.setLayoutY(250);
		botSair.setLayoutX(405);
		botSair.setLayoutY(300);
		logo.setLayoutX(377);
		logo.setLayoutY(50);
		inicio.setLayoutX(345);
		inicio.setLayoutY(50);
		imagem1.setLayoutX(-120);
		imagem1.setLayoutY(300);
		pes.setLayoutX(540);
		pes.setLayoutY(300);
		
	}
	
	private void funcoes() {
		botEmprestimo.setOnAction((evento) -> {
					try {
						new ListaInterface().start(new Stage());
						Menu.getStage().close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			});
		
		botSair.setOnAction((evento) -> {
				Menu.getStage().close();
			});
	
		botInfo.setOnAction((evento) -> {
			try {
				new InfoEmp().start(new Stage());
				Menu.getStage().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}	
		
	
	public static Stage stage() {
		return stage;
	}
	
	
	}

