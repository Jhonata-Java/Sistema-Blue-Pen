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
import packageControle.ProdutoDAO;
import packageModel.Produto;

public class controllerProduto implements Initializable {

	@FXML
	private Button btnCadastroProduto;

	@FXML
	private Button btnClienteProduto;

	@FXML
	private Button btnDeletarProduto;

	@FXML
	private Button btnEditarProduto;

	@FXML
	private Button btnFornecedorProduto;

	@FXML
	private Button btnMenuPrincipalProduto;

	@FXML
	private Button btnPesquisarProduto;

	@FXML
	private Button btnRegistraVendaProduto;

	@FXML
	private Button btnVendedorProduto;

	@FXML
	private TableColumn<Produto, String> columnCodigo;

	@FXML
	private TableColumn<Produto, String> columnEstoque;

	@FXML
	private TableColumn<Produto, String> columnFabricacao;

	@FXML
	private TableColumn<Produto, String> columnID;

	@FXML
	private TableColumn<Produto, String> columnNome;

	@FXML
	private TableColumn<Produto, String> columnPrecoUN;

	@FXML
	private TableColumn<Produto, String> columnTipoUN;

	@FXML
	private TableColumn<Produto, String> columnValidade;

	@FXML
	private TextField textPesquisarProduto;

	@FXML
	private TableView<Produto> tableProduto;

	private ObservableList<Produto> ArrayProduto;

	private ProdutoDAO produto = new ProdutoDAO();

	public void CarregarTableProduto() {
		ArrayProduto = FXCollections.observableArrayList(produto.read());

		columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		columnEstoque.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columnPrecoUN.setCellValueFactory(new PropertyValueFactory<>("ProcoUN"));
		columnTipoUN.setCellValueFactory(new PropertyValueFactory<>("TipoUN"));
		columnFabricacao.setCellValueFactory(new PropertyValueFactory<>("DataFab"));
		columnValidade.setCellValueFactory(new PropertyValueFactory<>("DataVal"));

		tableProduto.setItems(ArrayProduto);
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
	void btnTelaCliente(ActionEvent event) {
		Main.changeScreen("cliente");
	}

	@FXML
	void ActionBtnRegistraVendaPro(ActionEvent event) {
		Main.changeScreen("registraVenda");
	}

	@FXML
	void ActionBtnPesquisarProduto(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produto.search(textPesquisarProduto.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		columnEstoque.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columnPrecoUN.setCellValueFactory(new PropertyValueFactory<>("ProcoUN"));
		columnTipoUN.setCellValueFactory(new PropertyValueFactory<>("TipoUN"));
		columnFabricacao.setCellValueFactory(new PropertyValueFactory<>("DataFab"));
		columnValidade.setCellValueFactory(new PropertyValueFactory<>("DataVal"));

		tableProduto.setItems(ArrayProduto);
		tableProduto.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableProduto();
	}

	public static Produto ProdutoEditar = new Produto();

	@FXML
	void ActionBtnEditarProduto(ActionEvent event) throws IOException {
		if (tableProduto.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Produto para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableProduto.getSelectionModel().getSelectedIndex();
			ProdutoEditar = tableProduto.getItems().get(i);
			Main.TelaCadastroProduto();
		}
		CarregarTableProduto();
	}

	@FXML
	void ActionBtnCadastraProduto(ActionEvent event) throws IOException {
		ProdutoEditar = null;
		Main.TelaCadastroProduto();
		CarregarTableProduto();
	}

	@FXML
	void ActionBtnDeletarProduto(ActionEvent event) {
		int i = tableProduto.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um produto primeiro!");
			mensagemDeErro.show();
		} else {
			Produto produto = new Produto();
			produto = tableProduto.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o produto: " + produto.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ProdutoDAO p = new ProdutoDAO();
				p.delete(produto.getCodigo());

				Alert mensagemDeExcluir = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExcluir.setContentText("Produto deletado com sucesso!");
				mensagemDeExcluir.show();
				CarregarTableProduto();
			}
		}
	}
}
