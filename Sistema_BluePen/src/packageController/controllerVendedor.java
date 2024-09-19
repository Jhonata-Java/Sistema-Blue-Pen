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
import packageControle.VendedorDAO;
import packageModel.Vendedor;

public class controllerVendedor implements Initializable {

	@FXML
	private Button btnClienteVendedor;

	@FXML
	private Button btnEditarVendedor;

	@FXML
	private Button btnExcluirVendedor;

	@FXML
	private Button btnFornecedorVendedor;

	@FXML
	private Button btnMenuPrincipalVendedor;

	@FXML
	private Button btnPesquisarVendedor;

	@FXML
	private Button btnProdutoVendedor;

	@FXML
	private Button btnRegistraVendaVendedor;

	@FXML
	private Button btnSalvarVendedor;
	@FXML
	private TextField textPesquisaVendedor;

	@FXML
	private TableColumn<Vendedor, String> columnTelefone;

	@FXML
	private TableColumn<Vendedor, String> columnCPF;

	@FXML
	private TableColumn<Vendedor, String> columnDataCont;

	@FXML
	private TableColumn<Vendedor, String> columnDataNasc;

	@FXML
	private TableColumn<Vendedor, String> columnEmail;

	@FXML
	private TableColumn<Vendedor, String> columnEndereco;

	@FXML
	private TableColumn<Vendedor, String> columnID;

	@FXML
	private TableColumn<Vendedor, String> columnNome;

	@FXML
	private TableColumn<Vendedor, String> columnTotalVend;

	@FXML
	private TableView<Vendedor> tableVendedor;

	private ObservableList<Vendedor> ArrayVendedor;

	private VendedorDAO vendedor = new VendedorDAO();

	@FXML
	void ActionBtnCadastraVendedor(ActionEvent event) throws IOException {
		vendedorEditar = null;
		Main.TelaCadastraVendedor();
		CarregarTableVendedor();
	}

	@FXML
	void ActionBtnEditarVendedor(ActionEvent event) throws IOException {
		if (tableVendedor.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Vendedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableVendedor.getSelectionModel().getSelectedIndex();
			vendedorEditar = tableVendedor.getItems().get(i);
			Main.TelaCadastroCliente();
		}
		CarregarTableVendedor();
	}

	@FXML
	void ActionBtnExcluirVendedor(ActionEvent event) {
		int i = tableVendedor.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro!");
			mensagemDeErro.show();
		} else {
			Vendedor vendedor = new Vendedor();
			vendedor = tableVendedor.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o vendedor: " + vendedor.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO c = new ClienteDAO();
				c.delete(vendedor.getCPF());

				Alert mensagemDeExcluir = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExcluir.setContentText("Vendedor excluido com sucesso!");
				mensagemDeExcluir.show();
			}
			CarregarTableVendedor();
		}
	}

	public void CarregarTableVendedor() {
		ArrayVendedor = FXCollections.observableArrayList(vendedor.read());

		columnID.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataCont.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		columnTotalVend.setCellValueFactory(new PropertyValueFactory<>("TotalVend"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		tableVendedor.setItems(ArrayVendedor);
	}

	@FXML
	void ActionBtnPesquisarVendedor(ActionEvent event) {
		ArrayVendedor = FXCollections.observableArrayList(vendedor.search(textPesquisaVendedor.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataCont.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		columnTotalVend.setCellValueFactory(new PropertyValueFactory<>("TotalVend"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		tableVendedor.setItems(ArrayVendedor);
		tableVendedor.refresh();
	}

	public static Vendedor vendedorEditar = new Vendedor();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableVendedor();
	}

	@FXML
	void ActionBtnRegistroVendaVen(ActionEvent event) {
		Main.changeScreen("registraVenda");
	}

	@FXML
	void btnTelaCliente(ActionEvent event) {
		Main.changeScreen("cliente");
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
}
