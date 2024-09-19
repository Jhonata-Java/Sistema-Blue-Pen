package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.VendedorDAO;
import packageModel.Vendedor;

public class controllerCadastraVendedor implements Initializable {

	@FXML
	private Button btnCadastraVendedor;

	@FXML
	private Button btnCancelarVendedor;

	@FXML
	private TextField textCPFCadastraVendedor;

	@FXML
	private TextField textDataContratacao;

	@FXML
	private TextField textEmailCadastraVendedor;

	@FXML
	private TextField textEnderecoCadastraProduto;

	@FXML
	private TextField textNascimentoCadastraVendedor;

	@FXML
	private TextField textNomeCadastroVendedor;

	@FXML
	private TextField textTelefoneCadastraVendedor;

	@FXML
	void ActionBtnCadastraVendedor(ActionEvent event) {
		if (controllerVendedor.vendedorEditar == null) {
			Vendedor vend = new Vendedor();
			vend.setNome(textNomeCadastroVendedor.getText());
			vend.setCPF(textCPFCadastraVendedor.getText());
			vend.setEmail(textEmailCadastraVendedor.getText());
			vend.setTelefone(textTelefoneCadastraVendedor.getText());
			vend.setDataNasc(textNascimentoCadastraVendedor.getText());
			vend.setDataCont(textDataContratacao.getText());
			vend.setEndereco(textEnderecoCadastraProduto.getText());
			VendedorDAO vend1 = new VendedorDAO();
			vend1.create(vend);
			
			Stage stage = (Stage) btnCancelarVendedor.getScene().getWindow();
			stage.close();
		}
		else {
			Vendedor vend = new Vendedor();
			vend.setNome(textNomeCadastroVendedor.getText());
			vend.setCPF(textCPFCadastraVendedor.getText());
			vend.setEmail(textEmailCadastraVendedor.getText());
			vend.setTelefone(textTelefoneCadastraVendedor.getText());
			vend.setDataNasc(textNascimentoCadastraVendedor.getText());
			vend.setDataCont(textDataContratacao.getText());
			vend.setEndereco(textEnderecoCadastraProduto.getText());
			VendedorDAO vend1 = new VendedorDAO();
			vend1.update(vend);
			
			Stage stage = (Stage) btnCancelarVendedor.getScene().getWindow();
			stage.close();
		}
	}

	@FXML
	void ActionBtnCanacelarVendedor(ActionEvent event) {
		textNomeCadastroVendedor.setText("");
		textCPFCadastraVendedor.setText("");
		textEmailCadastraVendedor.setText("");
		textTelefoneCadastraVendedor.setText("");
		textNascimentoCadastraVendedor.setText("");
		textDataContratacao.setText("");
		textEnderecoCadastraProduto.setText("");
		
		Stage stage = (Stage) btnCancelarVendedor.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(controllerVendedor.vendedorEditar != null) {
			textNomeCadastroVendedor.setText(controllerVendedor.vendedorEditar.getNome());
			textCPFCadastraVendedor.setText(controllerVendedor.vendedorEditar.getCPF());
			textEmailCadastraVendedor.setText(controllerVendedor.vendedorEditar.getEmail());
			textTelefoneCadastraVendedor.setText(controllerVendedor.vendedorEditar.getTelefone());
			textNascimentoCadastraVendedor.setText(controllerVendedor.vendedorEditar.getDataNasc());
			textDataContratacao.setText(controllerVendedor.vendedorEditar.getDataCont());
			textEnderecoCadastraProduto.setText(controllerVendedor.vendedorEditar.getEndereco());
		}
	}

}
