package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.CompraDAO;
import packageModel.Compra;

public class controllerRelatorioVenda implements Initializable{

    @FXML
    private Button btnCadastraRelatorioVen;

    @FXML
    private Button btnPesquisarRelatorioVen;
    
    @FXML
    private Button btnMenuPrincipal;

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
    private TextField textPesquisaRelatorioVen;
    
    private ObservableList<Compra> ArrayCompra;
    private CompraDAO compra = new CompraDAO();
    
    public static Compra CompraCad = new Compra();
    
    @FXML
    void ActionBtnCadastroRelatorioven(ActionEvent event) throws IOException {
    	controllerRelatorioVenda.CompraCad = null;
    	Main.TelaRegistraVenda();
    	CarregarRelatorioVenda();
    }

    @FXML
    void actionBtnPesquisarRelatorioVen(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarRelatorioVenda();
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
    @FXML
    void ActionBtnMenuPrinciapal(ActionEvent event) {
    	Main.changeScreen("main");
    }

}