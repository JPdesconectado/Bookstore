package Login;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
import menu.Menu;

public class Login extends Application {        
	
	private AnchorPane pane;
	private TextField txtLogin;
	private TextField txtSenha;
	private Button botEntrar;
	private ImageView imagem, logo;
	private Text inicio;
	private static Stage stage;
	@Override
	
	public void start(Stage stage) throws Exception { 
	                
	componentes();
	funcoes();
	Scene scene = new Scene(pane);    
	stage.setScene(scene);   
	stage.getIcons().add(new Image("https://vignette.wikia.nocookie.net/2007scape/images/7/7a/Mage%27s_book_detail.png/revision/latest?cb=20180310083825"));
	stage.setTitle("Livraria - Bookstore");
	stage.setResizable(false);
	stage.show();     
	layouts();
	Login.stage = stage;
	
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
        txtLogin = new TextField();
        txtLogin.setPromptText("Digite aqui seu login"); 
        txtSenha = new PasswordField();
        txtSenha.setPromptText("Digite aqui sua senha");
        botEntrar = new Button("Entrar");
        imagem = new ImageView(new Image("https://cdn140.picsart.com/290100131068211.png?r1024x1024"));
        logo = new ImageView(new Image("http://www.sclance.com/pngs/open-book-png-icon/open_book_png_icon_959216.png"));
        logo.setFitWidth(100);
		logo.setFitHeight(100);
        pane.getChildren().addAll(inicio, txtLogin, txtSenha, botEntrar, imagem, logo);
        
	}
	
	private void layouts() {
		

		txtLogin.setLayoutX(400);
		txtLogin.setLayoutY(20);
		txtSenha.setLayoutX(560);
		txtSenha.setLayoutY(20);
		botEntrar.setLayoutX(720);
		botEntrar.setLayoutY(20);
		imagem.setLayoutX(320);
		imagem.setLayoutY(170);
		logo.setLayoutX(10);
		inicio.setLayoutX(150);
		inicio.setLayoutY(50);
		
		
	}
	
	public interface verifica {
		boolean check(String login, String senha);
	}
	private void funcoes() {
		botEntrar.setOnAction((evento) -> {
				slc t = new slc();
				if (t.check(txtLogin.getText(), txtSenha.getText()) == true) {
					try {
						new Menu().start(new Stage());
						Login.getStage().close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					
					Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Login e/ou senha inválidos");
                    alert.setContentText("Tente novamente.");
                    alert.showAndWait();
				}
			});
		
		txtSenha.setOnAction((evento) -> {
			
			if (txtLogin.getText().equals("admin") && txtSenha.getText().equals("admin")) {
				try {
					new Menu().start(new Stage());
					Login.getStage().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				
				Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Login e/ou senha inválidos");
                alert.setContentText("Tente novamente.");
                alert.showAndWait();
			}
		});
		
	}	
		
	public class slc implements verifica {
		public boolean check(String Login, String senha) {
			if (Login.equals("admin") && senha.equals("admin")) {
				return true;
			}else {
				return false;
			}
		}
	}
	public static Stage stage() {
		return stage;
	}
	
	
	}
