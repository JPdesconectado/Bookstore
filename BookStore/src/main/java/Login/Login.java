package Login;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application {        
	
	private AnchorPane pane;
	private TextField txtLogin;
	private TextField txtSenha;
	private Button botEntrar;
	private Button botSair;
	private ImageView imagem;
	private static Stage stage;
	@Override
	
	public void start(Stage stage) throws Exception { 
	                
	componentes();
	funcoes();
	Scene scene = new Scene(pane);    
	stage.setScene(scene);   
	stage.setTitle("Livraria - Bookstore");
	stage.show();     
	layouts();
	Login.stage = stage;
	
	}
	
	public static void main(String[] args){            
		launch(args);        
		
		}
	
	private void componentes() {
		
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);  
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, orange 100%);");
		txtLogin = new TextField();          
		txtLogin.setPromptText("Digite aqui seu login"); 
		txtSenha = new PasswordField();           
		txtSenha.setPromptText("Digite aqui sua senha");
		botEntrar = new Button("Entrar");  
		botSair = new Button("Sair"); 
		imagem = new ImageView(new Image("https://image.flaticon.com/icons/png/128/167/167755.png"));
		pane.getChildren().addAll(txtLogin, txtSenha, botEntrar, botSair, imagem);      
	}
	
	private void layouts() {
		
		txtLogin.setLayoutX(10);
		txtLogin.setLayoutY(110);
		txtSenha.setLayoutX(10);
		txtSenha.setLayoutY(140);
		botEntrar.setLayoutX(10);
		botEntrar.setLayoutY(170);
		botSair.setLayoutX(70);
		botSair.setLayoutY(170); 
		imagem.setLayoutX(20);
		imagem.setLayoutY(-10);
		
	}
	
	private void funcoes() {
		botSair.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
	
		botEntrar.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				if (txtLogin.getText().equals("admin") && txtSenha.getText().equals("admin")) {
					// TODO proxima janela
				}else {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}	
		
	
	public static Stage stage() {
		return stage;
	}
	
	
	}
