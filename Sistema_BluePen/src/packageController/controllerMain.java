package packageController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class controllerMain {

    @FXML
    private Button btVoltar;

    @FXML
    private Button btnCLiente;

    @FXML
    private Button btnFornecedor;

    @FXML
    private Button btnProduto;

    @FXML
    private Button btnRegistraVenda;

    @FXML
    private Button btnRelatorioVenda;

    @FXML
    private Button btnVendedor;
    
    @FXML
    private Button MenuPrincipalForne;

    @FXML
    private Button btnClienteFornecedor;

    @FXML
    private Button btnEditarFornecedor;

    @FXML
    private Button btnExcluirFornecedor;

    @FXML
    private Button btnPesquisarFornecedor;

    @FXML
    private Button btnProdutoFornecedor;

    @FXML
    private Button btnRegistraVendaFornecedor;

    @FXML
    private Button btnSalvarFornecedor;

    @FXML
    private Button btnVendedorFornecedor;

	    @FXML
	    void btButtonTeste(ActionEvent event) {
	    	Main.changeScreen("login");
	    }

    @FXML
    void btnTelaCliente(ActionEvent event) {
    	Main.changeScreen("cliente");
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
    void btnTelaRegistraVenda(ActionEvent event) {
    	Main.changeScreen("RegistraVenda");
    }

    @FXML
    void btnTelaRelarioVenda(ActionEvent event) {
    	Main.changeScreen("relatorioVenda");
    }

    @FXML
    void btnTelaVenda(ActionEvent event) {
    	Main.changeScreen("vendedor");
    }
}
