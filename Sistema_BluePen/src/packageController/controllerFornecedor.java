package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.FornecedorDAO;
import packageModel.Fornecedor;

public class controllerFornecedor implements Initializable{

    @FXML
    private TableColumn<Fornecedor, String> columnCNPJ;

    @FXML
    private TableColumn<Fornecedor, String> columnEmail;

    @FXML
    private TableColumn<Fornecedor, String> columnEndereco;

    @FXML
    private TableColumn<Fornecedor, String> columnID;

    @FXML
    private TableColumn<Fornecedor, String> columnNome;

    @FXML
    private TableColumn<Fornecedor, String> columnTelefone;

    @FXML
    private TableView<Fornecedor> tableFornecedor;
    
    @FXML
    private Button btnPesquisarFornecedor;
    
    @FXML
    private TextField textPesquisarFornecedor;
    
    private ObservableList<Fornecedor> ArrayFornecedor;
    
    private FornecedorDAO fornecedor = new FornecedorDAO();
    
    @FXML
    void ActionCadastraFornecedor(ActionEvent event) throws IOException {
    	fornecedorEditar = null;
    	Main.TelaCadastraFornecedor();
    	CaregarTableFornecedor();
    }

    @FXML
    void ActionEditarFornecedor(ActionEvent event) throws IOException {
    	if (tableFornecedor.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Fornecedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableFornecedor.getSelectionModel().getSelectedIndex();
			fornecedorEditar = tableFornecedor.getItems().get(i);
			Main.TelaCadastroCliente();
		}
    	CaregarTableFornecedor();
    }

    @FXML
    void ActionExcluirFornecedor(ActionEvent event) {
    	int i = tableFornecedor.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Fornecdor primeiro!");
			mensagemDeErro.show();
		} else {
			Fornecedor forn = new Fornecedor();
			forn = tableFornecedor.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o Fornecedor: " + forn.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				FornecedorDAO f = new FornecedorDAO();
				f.delete(forn.getCNPJ());

				Alert mensagemDeExcluir = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExcluir.setContentText("Fornecedor excluido com sucesso!");
				mensagemDeExcluir.show();
				CaregarTableFornecedor();
			}
		}
    }
    
    @FXML
    void btnPesquisarFornecedor(ActionEvent event) {
    	ArrayFornecedor = FXCollections.observableArrayList(fornecedor.search(textPesquisarFornecedor.getText()));
    	
    	columnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
    	columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
    	columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    	columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
    	columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
    	
    	tableFornecedor.setItems(ArrayFornecedor);
    	tableFornecedor.refresh();
    }
    
    public void CaregarTableFornecedor() {
    	ArrayFornecedor = FXCollections.observableArrayList(fornecedor.read());
    	
    	columnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
    	columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
    	columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    	columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
    	columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
    	
    	tableFornecedor.setItems(ArrayFornecedor);
    }
    
    public static Fornecedor fornecedorEditar = new Fornecedor();
    
    @FXML
    void btnTelaVenda(ActionEvent event) {
    	Main.changeScreen("vendedor");
    }
    
    @FXML
    void btButtonTeste(ActionEvent event) {
    	Main.changeScreen("main");
    }

    @FXML
    void btnTelaCliente(ActionEvent event) {
    	Main.changeScreen("cliente");
    }

    @FXML
    void btnTelaProduto(ActionEvent event) {
    	Main.changeScreen("produto");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CaregarTableFornecedor();
	}

}
