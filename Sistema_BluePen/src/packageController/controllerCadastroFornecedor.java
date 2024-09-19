package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.FornecedorDAO;
import packageModel.Fornecedor;

public class controllerCadastroFornecedor implements Initializable{

    @FXML
    private Button btnCadastroFornecedor;

    @FXML
    private Button btnCancelarFornecedor;

    @FXML
    private TextField textCNPJCadastraFornecedor;

    @FXML
    private TextField textEmailCadastraFornecedor;

    @FXML
    private TextField textEnderecoCadastraFornecedor;

    @FXML
    private TextField textNomeCadastroFornecedor;

    @FXML
    private TextField textTelefoneCadastraFornecedor;

    @FXML
    void ActionBtnCanacelarCliente(ActionEvent event) {
    	textNomeCadastroFornecedor.setText("");
    	textCNPJCadastraFornecedor.setText("");
    	textEmailCadastraFornecedor.setText("");
    	textTelefoneCadastraFornecedor.setText("");
    	textEnderecoCadastraFornecedor.setText("");
    	
    	Stage stage = (Stage) btnCancelarFornecedor.getScene().getWindow();
		stage.close();
    }

    @FXML
    void ActionBtnSalvarCliente(ActionEvent event) {
    	if(controllerFornecedor.fornecedorEditar == null) {
    		Fornecedor fornecedor = new Fornecedor();
    		fornecedor.setNome(textNomeCadastroFornecedor.getText());
    		fornecedor.setCNPJ(textCNPJCadastraFornecedor.getText());
    		fornecedor.setEmail(textEmailCadastraFornecedor.getText());
    		fornecedor.setTelefone(textTelefoneCadastraFornecedor.getText());
    		fornecedor.setEndereco(textEnderecoCadastraFornecedor.getText());
    		
    		FornecedorDAO forn = new FornecedorDAO();
    		forn.create(fornecedor);
    		
    		Stage stage = (Stage) btnCancelarFornecedor.getScene().getWindow();
    		stage.close();
    	}
    	else {
    		Fornecedor fornecedor = new Fornecedor();
    		fornecedor.setNome(textNomeCadastroFornecedor.getText());
    		fornecedor.setCNPJ(textCNPJCadastraFornecedor.getText());
    		fornecedor.setEmail(textEmailCadastraFornecedor.getText());
    		fornecedor.setTelefone(textTelefoneCadastraFornecedor.getText());
    		fornecedor.setEndereco(textEnderecoCadastraFornecedor.getText());
    		
    		FornecedorDAO forn = new FornecedorDAO();
    		forn.update(fornecedor);
    		
    		Stage stage = (Stage) btnCancelarFornecedor.getScene().getWindow();
    		stage.close();
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(controllerFornecedor.fornecedorEditar != null) {
			textNomeCadastroFornecedor.setText(controllerFornecedor.fornecedorEditar.getNome());
			textCNPJCadastraFornecedor.setText(controllerFornecedor.fornecedorEditar.getCNPJ());
			textEmailCadastraFornecedor.setText(controllerFornecedor.fornecedorEditar.getEmail());
			textTelefoneCadastraFornecedor.setText(controllerFornecedor.fornecedorEditar.getTelefone());
			textEnderecoCadastraFornecedor.setText(controllerFornecedor.fornecedorEditar.getEndereco());
		}
	}
}