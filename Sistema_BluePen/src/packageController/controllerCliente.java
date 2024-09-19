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
import packageControle.ClienteDAO;
import packageModel.Cliente;

public class controllerCliente implements Initializable {

	@FXML
	private Button btnEditarCliente;

	@FXML
	private Button btnExcluirCliente;

	@FXML
	private Button btnFornecedorCliente;

	@FXML
	private Button btnMenuPrincipal;

	@FXML
	private Button btnPesquisarCliente;

	@FXML
	private Button btnProdutoCliente;

	@FXML
	private Button btnRegistraVendaCliente;

	@FXML
	private Button btnSalvarCliente;

	@FXML
	private Button btnVendedorCliente;

	@FXML
	private TextField textPesquisarCliente;

	@FXML
	private TableColumn<Cliente, String> columnCPF_CNPJ;

	@FXML
	private TableColumn<Cliente, String> columnEmail;

	@FXML
	private TableColumn<Cliente, String> columnEndereco;

	@FXML
	private TableColumn<Cliente, String> columnNascimento;

	@FXML
	private TableColumn<Cliente, String> columnNome;

	@FXML
	private TableColumn<Cliente, String> columnPrimeiraCompra;

	@FXML
	private TableColumn<Cliente, String> columnTelefone;

	@FXML
	private TableColumn<Cliente, String> columnTipoJuritico;

	@FXML
	private TableColumn<Cliente, String> colunmID;

	@FXML
	private TableView<Cliente> tableCliente;

	private ObservableList<Cliente> ArrayCliente;

	private static ClienteDAO cliente = new ClienteDAO();

	@FXML
	public void CarregarTableCliente() {
		ArrayCliente = FXCollections.observableArrayList(cliente.read());

		colunmID.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF_CNPJ.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnPrimeiraCompra.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnTipoJuritico.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));

		tableCliente.setItems(ArrayCliente);
	}

	@FXML
	void ActionBtnPesquisarCliente(ActionEvent event) {

		ArrayCliente = FXCollections.observableArrayList(cliente.search(textPesquisarCliente.getText()));

		colunmID.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF_CNPJ.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnPrimeiraCompra.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnTipoJuritico.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));

		tableCliente.setItems(ArrayCliente);
		tableCliente.refresh();
	}

	@FXML
	void ActionBtnDeletarCliente(ActionEvent event) {
		int i = tableCliente.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente primeiro!");
			mensagemDeErro.show();
		} else {
			Cliente cliente = new Cliente();
			cliente = tableCliente.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o cliente: " + cliente.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO c = new ClienteDAO();
				c.delete(cliente.getCPF_CNPJ());

				Alert mensagemDeExcluir = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExcluir.setContentText("Cliente excluido com sucesso!");
				mensagemDeExcluir.show();
				CarregarTableCliente();
			}
		}
	}

	@FXML
	void ActionBtnCadastraCliente(ActionEvent event) throws IOException {
		clienteEditar = null;
		Main.TelaCadastroCliente();
		CarregarTableCliente();
	}

	public static Cliente clienteEditar = new Cliente();

	@FXML
	void ActionBtnEditar(ActionEvent event) throws IOException {
		if (tableCliente.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Cliente para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableCliente.getSelectionModel().getSelectedIndex();
			clienteEditar = tableCliente.getItems().get(i);
			Main.TelaCadastroCliente();
		}
		CarregarTableCliente();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableCliente();
	}

	@FXML
	void btnTelaVenda(ActionEvent event) {
		Main.changeScreen("vendedor");
	}

	@FXML
	void btButtonTeste(ActionEvent event) {
		Main.changeScreen("main");
	}

	@FXML
	void btnTelaFornecedor(ActionEvent event) {
		Main.changeScreen("fornecedor");
	}

	@FXML
	void btnTelaProduto(ActionEvent event) {
		Main.changeScreen("produto");
	}

	@FXML
	void ActionBtnRegistraVendaCli(ActionEvent event) {
		Main.changeScreen("registraVenda");
	}
}
