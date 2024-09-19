package packageController;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import packageControle.ClienteDAO;
import packageControle.CompraDAO;
import packageControle.ProdutoDAO;
import packageModel.Cliente;
import packageModel.Compra;
import packageModel.Produto;

public class controllerRegistraVenda implements Initializable {

	@FXML
	private Button btnCadastraVenda;

	@FXML
	private Button btnCancelarVenda;

	@FXML
	private Button btnPesquisarProdutoRegistraVenda;

	@FXML
	private TableColumn<Produto, String> columnNome;

	@FXML
	private TableColumn<Produto, String> columnPrecoUN;

	@FXML
	private TableColumn<Produto, String> columnQuantidade;

	@FXML
	private TableColumn<Produto, String> colunmID;

	@FXML
	private TableView<Produto> tableProduto;
	
	@FXML
    private TableColumn<Compra, String> columnCliente;

    @FXML
    private TableColumn<Compra, String> columnID;

    @FXML
    private TableColumn<Compra, String> columnPrecoTotal;

    @FXML
    private TableColumn<Compra, String> columnProduto;

    @FXML
    private TableColumn<Compra, String> columnQuatidade;

    @FXML
    private TableColumn<Compra, String> columnVendedor;

    @FXML
    private TableView<Compra> tableRelatorioVenda;

	@FXML
	private TextField textCNPJ_CPFRegistraV;

	@FXML
	private TextField textidClienteRegistraV;

	@FXML
	private TextField textCPFRegistraV;

	@FXML
	private TextField textClienteRegistraV;

	@FXML
	private TextField textCodigoRegistraV;

	@FXML
	private TextField textDescontoRegistraV;

	@FXML
	private TextField textNomeVendedorRegistraV;

	@FXML
	private TextField textPesquisarProduto;

	@FXML
	private TextField textPrecoTotalRegistraV;

	@FXML
	private TextField textPrecoUNRegistraV;

	@FXML
	private TextField textQuantidadeRegistraV;

	@FXML
	private TextField textidVendedorRegistraV;

	private ObservableList<Produto> ArrayProduto;
	private ObservableList<Compra> ArrayCompra;
	private CompraDAO compra = new CompraDAO();

	Produto produto = new Produto();
	ArrayList<Cliente> cliente1 = new ArrayList<>();
	Cliente cliente2 = new Cliente();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private ClienteDAO clienteDAO = new ClienteDAO();

	public void CarregarTableProduto() {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.read());

		colunmID.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columnPrecoUN.setCellValueFactory(new PropertyValueFactory<>("ProcoUN"));

		tableProduto.setItems(ArrayProduto);
	}

	@FXML
	void ActionBtnCadastraVenda(ActionEvent event) {
		if (cliente2 != null && produto != null && textidVendedorRegistraV != null) {
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText(
					"Deseja realmente Salvar a venda para o vendedor : " + textNomeVendedorRegistraV.getText());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
				mensagemDeExclusao.show();
				CompraDAO compraDAO = new CompraDAO();
				Compra compra = new Compra();
				compra.setIdCliente(cliente2.getIdCliente());
				compra.setIdVendedor(textidVendedorRegistraV.getText());
				compra.setIdProduto(produto.getIdProduto());
				compra.setQuantidade(textQuantidadeRegistraV.getText());
				compra.setPrecoTotal(textPrecoTotalRegistraV.getText());
				compraDAO.create(compra);
				textidClienteRegistraV.setText("");
				textClienteRegistraV.setText("");
				textCNPJ_CPFRegistraV.setText("");
				textCodigoRegistraV.setText("");
				textPesquisarProduto.setText("");
				textQuantidadeRegistraV.setText("");
				textPrecoUNRegistraV.setText("");
				textPrecoTotalRegistraV.setText("");
				textDescontoRegistraV.setText("");
				cliente2 = null;
		} 
		}else {
			Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
			mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
			mensagemDeExclusao.show();
			}
		}	

	@FXML
	void ActionBtnCancelarVenda(ActionEvent event) {
		Stage stage = (Stage) btnCancelarVenda.getScene().getWindow();
		stage.close();
	}

	@FXML
	void ActionBtnProdutoRegistraVenda(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(textPesquisarProduto.getText()));

		colunmID.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
		columnPrecoUN.setCellValueFactory(new PropertyValueFactory<>("ProcoUN"));

		tableProduto.setItems(ArrayProduto);
		tableProduto.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableProduto();
		cliente2 = null;
		textCPFRegistraV.setText(controllerLogin.vendedor.getCPF());
		textNomeVendedorRegistraV.setText(controllerLogin.vendedor.getNome());
		textidVendedorRegistraV.setText(controllerLogin.vendedor.getIdVendedor());
		textQuantidadeRegistraV.setText("0");

		tableProduto.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = tableProduto.getSelectionModel().getSelectedIndex();
				produto = tableProduto.getItems().get(i);
				textCodigoRegistraV.setText(produto.getCodigo());
				textPrecoUNRegistraV.setText(produto.getProcoUN());
				textPesquisarProduto.setText(produto.getNome());
			}
		});
	}

	@FXML
	void definirPrecoTotal(KeyEvent event) {
		if (textQuantidadeRegistraV.getText() != "" && textQuantidadeRegistraV.getText() != null) {

			double quantidade = Double.parseDouble(textQuantidadeRegistraV.getText());

			if (quantidade < 30) {
				textDescontoRegistraV.setText("");
				double precoTotal = Double.parseDouble(textPrecoUNRegistraV.getText())
						* Double.parseDouble(textQuantidadeRegistraV.getText());
				textPrecoTotalRegistraV.setText(Double.toString(precoTotal));

			} else {

				double precoTotal = (Double.parseDouble(textPrecoUNRegistraV.getText())
						* Double.parseDouble(textQuantidadeRegistraV.getText()));
				precoTotal = precoTotal * 0.85;
				textPrecoTotalRegistraV.setText(Double.toString(precoTotal));
				Double desconto = precoTotal * 0.15;
				textDescontoRegistraV.setText(Double.toString(desconto));

			}
		}
	}

	@FXML
	void definirCliente(KeyEvent evente) {
		if (clienteDAO.search(textCNPJ_CPFRegistraV.getText()) != null) {
			cliente1 = clienteDAO.search(textCNPJ_CPFRegistraV.getText());
			cliente2 = cliente1.get(0);
			textidClienteRegistraV.setText(cliente2.getIdCliente());
			textClienteRegistraV.setText(cliente2.getNome());
		}
	}
public void CarregarRelatorioVenda() {
    	
    	ArrayCompra = FXCollections.observableArrayList(compra.read());
    	
    	columnID.setCellValueFactory(new PropertyValueFactory<>("idCompra"));
    	columnVendedor.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
    	columnCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
    	columnProduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnQuatidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
    	columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("PrecoTotal"));
    	
    	tableRelatorioVenda.setItems(ArrayCompra);
    }
}