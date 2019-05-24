package tabelaDeLivros;

import informacoesLivros.informacoes;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tabelaDeLivros.Livro;
import tabelaDeEmprestimos.Emprestimo;

public class ListaInterface extends Application {

	private AnchorPane pane;
	private TextField txtPesquisa;
	private TableView<Acervo> tabEstante;
	private TableColumn<Acervo, String> colunaNome;
	private TableColumn<Acervo, String>	colunaCod;
	private TableColumn<Acervo, String> colunaAno;
	private TableColumn<Acervo, String> colunaAutor;
	private TableColumn<Acervo, String> colunaEditora;
	private static ObservableList<Acervo> listLivros = FXCollections.observableArrayList();
	public static Emprestimo emp = new Emprestimo();
	
	
	@Override
	
	public void start(Stage stage) throws Exception {
		
		componentes();
		funcoes();
		Scene scene = new Scene(pane);    
		stage.setScene(scene);   
		stage.setTitle("Estante de Livros");
		stage.show();     
		layout();
		
	}
	
	public static void main(String[] args){            
		launch(args);        
		
	}
	


	@SuppressWarnings("unchecked")
	private void componentes() {
		
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		
		txtPesquisa = new TextField();
		txtPesquisa.setPromptText("Digite o nome para pesquisa");
		txtPesquisa.setPrefWidth(200);
		txtPesquisa.setFocusTraversable(true);
		tabEstante = new TableView<Acervo>();
		cadLivro();
		tabEstante.setItems(listLivros);
		tabEstante.setPrefSize(780, 550);
		final Label title = new Label("Catálogo de Livros");
		title.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
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
		pane.getChildren().addAll(txtPesquisa, title, tabEstante);
		
	}
	
	private ObservableList<Acervo> buscaLivro(){

		ObservableList<Acervo> encontrado = FXCollections.observableArrayList();
		
		for (Acervo a: listLivros) {
			if (a.getNome().contains(txtPesquisa.getText()) || a.getAutor().contains(txtPesquisa.getText()) || a.getEditora().contains(txtPesquisa.getText())) {
				encontrado.add(a);
			}
		}
		
		return encontrado;
	}
	
	private void funcoes() {	
		txtPesquisa.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				if (!txtPesquisa.getText().equals("")) {
					tabEstante.setItems(buscaLivro());
				}else {
					tabEstante.setItems(listLivros);
				}
			}
		});
		
		tabEstante.setOnMousePressed((evento) -> {
			
					if (evento.getClickCount() == 2) {
						informacoes.index = tabEstante.getSelectionModel().getSelectedIndex();
						informacoes.book = new Livro (tabEstante.getSelectionModel().getSelectedItem().getNome(), 
													tabEstante.getSelectionModel().getSelectedItem().getCod(),
													tabEstante.getSelectionModel().getSelectedItem().getAno(),
													tabEstante.getSelectionModel().getSelectedItem().getAutor(),
													tabEstante.getSelectionModel().getSelectedItem().getEditora()
													);
		
						try {		
						new informacoes().start(new Stage());
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
		
		});
	}
	

	
	private void cadLivro() {
		Lista l = new Lista();
		l.addLivros(
				new Livro("Harry Potter e a Pedra Filosofal", "#001", "1997", "JK Rolling", "Rocco"),
				new Livro("O Mundo de Gelo e Fogo", "#002", "2014", "George RR Martin", "LeYa"), 
				new Livro("O Cavaleiro dos Sete Reinos", "#003", "2014", "George RR Martin", "LeYa"), 
				new Livro("As Crônicas de Nárnia", "#004", "2000", "C. S. Lewis", "WMF Martins Fontes"), 
				new Livro("Fogo e Sangue", "#005", "2018", "George RR Martin", "LeYa"), 
				new Livro("O Dragão de Gelo", "#006", "1980", "George RR Martin", "LeYa")
		);
		
		for (Livro liv: l.getLivros())
			listLivros.add(new Acervo(liv.getNome(), liv.getCod(), liv.getAno(), liv.getAutor(), liv.getEditora()));
	}
	
	
	private void layout() {

		
		txtPesquisa.setLayoutX(590);
		txtPesquisa.setLayoutY(10);
		tabEstante.setLayoutX(10);
		tabEstante.setLayoutY(40);
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
	
}



