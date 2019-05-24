package tabelaDeEmprestimos;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tabelaDeLivros.ListaInterface;
import tabelaDeLivros.Livro;


public class EmprestimoInterface extends Application {

	private AnchorPane pane;
	private TableView <Acervo> tabEstante;
	private TableColumn <Acervo, String> colunaNome;
	private TableColumn <Acervo, String> colunaCod;
	private TableColumn <Acervo, String> colunaAno;
	private TableColumn <Acervo, String> colunaAutor;
	private TableColumn <Acervo, String> colunaEditora;
	private Button butApagar, butVoltar, butConfirmar;
	private static Stage stage;
	private static ObservableList<Acervo> listLivros;
	
	
	@Override
	
	public void start(Stage stage) throws Exception {
		componentes();
		funcoes();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Lista de Emprestimo");
		stage.getIcons().add(new Image("https://vignette.wikia.nocookie.net/2007scape/images/7/7a/Mage%27s_book_detail.png/revision/latest?cb=20180310083825"));
		stage.show();
		layout();
		EmprestimoInterface.stage = stage;
	}
	
	@SuppressWarnings("unchecked")
	private void componentes() {
		listLivros = FXCollections.observableArrayList();
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		tabEstante = new TableView<Acervo>();
		cadLivro();
		tabEstante.setItems(listLivros);
		tabEstante.setPrefSize(780, 550);
		colunaNome = new TableColumn<Acervo, String>();
		colunaNome.setCellValueFactory(new PropertyValueFactory<Acervo, String>("nome"));	
		colunaNome.setText("Nome");
		colunaCod = new TableColumn<Acervo, String>();
		colunaCod.setCellValueFactory(new PropertyValueFactory<Acervo, String>("cod"));
		colunaCod.setText("Codigo");
		colunaAno = new TableColumn<Acervo, String>();
		colunaAno.setCellValueFactory(new PropertyValueFactory<Acervo, String>("ano"));
		colunaAno.setText("Ano");
		colunaAutor = new TableColumn<Acervo, String>();
		colunaAutor.setCellValueFactory(new PropertyValueFactory<Acervo, String>("autor"));
		colunaAutor.setText("Autor");
		colunaEditora = new TableColumn<Acervo, String>();
		colunaEditora.setCellValueFactory(new PropertyValueFactory<Acervo, String>("editora"));
		colunaEditora.setText("Editora");
		tabEstante.getColumns().addAll(colunaNome, colunaCod, colunaAno, colunaAutor, colunaEditora);
		butApagar = new Button("Deletar Livro");
		butVoltar = new Button("Voltar a Estante");
		butConfirmar = new Button ("Confirmar Emprestimo");
		pane.getChildren().addAll(tabEstante, butApagar, butVoltar, butConfirmar);
	}
	
	private void funcoes() {
		
		butApagar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				ListaInterface.emp.removerLivro(new Livro(tabEstante.getSelectionModel().getSelectedItem().getNome(), 
													tabEstante.getSelectionModel().getSelectedItem().getCod(),
													tabEstante.getSelectionModel().getSelectedItem().getAno(),
													tabEstante.getSelectionModel().getSelectedItem().getAutor(),
													tabEstante.getSelectionModel().getSelectedItem().getEditora()));

				tabEstante.getItems().remove(tabEstante.getSelectionModel().getSelectedItem());
			}
		});
		
		butVoltar.setOnAction((evento) -> {
				EmprestimoInterface.stage.close();
				
		});
		
		butConfirmar.setOnAction((evento) -> {
			
				Thread thread = new Thread() {
					public void run() {
						try {
							sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Emprestimo Realizado!");
						Platform.runLater(new Runnable(){
							public void run() {
								EmprestimoInterface.stage.close();
							}
						});
					};
				};
				thread.start();
			
		});
	}
	

	private void layout() {
		tabEstante.setLayoutX(10);
		tabEstante.setLayoutY(5);
		butApagar.setLayoutX(10);
		butApagar.setLayoutY(570);
		butVoltar.setLayoutX((pane.getWidth() - butVoltar.getWidth()) / 2);
		butVoltar.setLayoutY(570);
		butConfirmar.setLayoutX(650);
		butConfirmar.setLayoutY(570);
	}
	
	public class Acervo {
		
		private SimpleStringProperty nome;
		private SimpleStringProperty cod;
		private SimpleStringProperty ano;
		private SimpleStringProperty autor;
		private SimpleStringProperty editora;
		
		public Acervo (String nome, String cod, String ano, String autor, String editora) {
			
			this.nome = new SimpleStringProperty(nome);
			this.cod = new SimpleStringProperty(cod);
			this.ano = new SimpleStringProperty(ano);
			this.autor = new SimpleStringProperty(autor);
			this.editora = new SimpleStringProperty(editora);
		}

		public String getNome(){
			return nome.get();
		}
		
		public void setNome(String nome){
			this.nome.set(nome);
		}
		
		public String getCod() {
			return cod.get();
		}
		
		public void setCod(String cod){
			this.cod.set(cod);
		}
		
		public String getAno() {
			return ano.get();
		}
		
		public void setAno(String ano) {
			this.ano.set(ano);
		}
		
		public String getAutor() {
			return autor.get();
		}
		
		public void setAutor(String autor) {
			this.autor.set(autor);
		}
		
		public String getEditora() {
			return editora.get();
		}
		
		public void setEditora(String editora) {
			this.editora.set(editora);
		}
	}
	
	private void cadLivro() {
		for (Livro l : ListaInterface.emp.getLivros()) 
			listLivros.add(new Acervo(l.getNome(), l.getCod(), l.getAno(), l.getAutor(), l.getEditora()));
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
