package packageController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.ClienteDAO;
import packageModel.Cliente;

public class controllerCadastraCliente implements Initializable {

	@FXML
	private Button btnCancelarCliente;

	@FXML
	private Button btnSalvarCliente;

	@FXML
	private ChoiceBox<String> choiceTipoJuritico;

	@FXML
	private TextField textCPF_CNPJCadastraCliente;

	@FXML
	private TextField textEmailCadastraCliente;

	@FXML
	private TextField textEnderecoCadastraCliente;

	@FXML
	private TextField textNascimentoCadastraCliente;

	@FXML
	private TextField textNomeCadastroCliente;

	@FXML
	private TextField textTelefoneCadastraCliente;

	@FXML
	private TextField textDataPrimComp;

	@FXML
	void ActionBtnCanacelarCliente(ActionEvent event) {

		textNomeCadastroCliente.setText("");
		textCPF_CNPJCadastraCliente.setText("");
		textEmailCadastraCliente.setText("");
		textTelefoneCadastraCliente.setText("");
		textNascimentoCadastraCliente.setText("");
		textDataPrimComp.setText("");
		textEnderecoCadastraCliente.setText("");
		choiceTipoJuritico.setValue(null);
		
		Stage stage = (Stage) btnCancelarCliente.getScene().getWindow();
		stage.close();
	}

	@FXML
	void ActionBtnSalvarCliente(ActionEvent event) {
		if (controllerCliente.clienteEditar == null) {
			Cliente cliente = new Cliente();
			cliente.setNome(textNomeCadastroCliente.getText());
			cliente.setCPF_CNPJ(textCPF_CNPJCadastraCliente.getText());
			cliente.setEmail(textEmailCadastraCliente.getText());
			cliente.setTelefone(textTelefoneCadastraCliente.getText());
			cliente.setDataNasc(textNascimentoCadastraCliente.getText());
			cliente.setDataPriCom(textDataPrimComp.getText());
			cliente.setEndereco(textEnderecoCadastraCliente.getText());
			cliente.setTipoJur(choiceTipoJuritico.getValue().toString());
			ClienteDAO cliet = new ClienteDAO();
			cliet.create(cliente);

			Stage stage = (Stage) btnCancelarCliente.getScene().getWindow();
			stage.close();
		} else {
			Cliente cliente = new Cliente();
			cliente.setNome(textNomeCadastroCliente.getText());
			cliente.setCPF_CNPJ(textCPF_CNPJCadastraCliente.getText());
			cliente.setEmail(textEmailCadastraCliente.getText());
			cliente.setTelefone(textTelefoneCadastraCliente.getText());
			cliente.setDataNasc(textNascimentoCadastraCliente.getText());
			cliente.setDataPriCom(textDataPrimComp.getText());
			cliente.setEndereco(textEnderecoCadastraCliente.getText());
			cliente.setTipoJur(choiceTipoJuritico.getValue().toString());
			
			ClienteDAO clit = new ClienteDAO();
			clit.update(cliente);

			Stage stage = (Stage) btnCancelarCliente.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		choiceTipoJuritico.getItems().add("PJ");
		choiceTipoJuritico.getItems().add("PF");

		
		if (controllerCliente.clienteEditar != null) {
			textNomeCadastroCliente.setText(controllerCliente.clienteEditar.getNome());
			textCPF_CNPJCadastraCliente.setText(controllerCliente.clienteEditar.getCPF_CNPJ());
			textEmailCadastraCliente.setText(controllerCliente.clienteEditar.getEmail());
			textTelefoneCadastraCliente.setText(controllerCliente.clienteEditar.getTelefone());
			textNascimentoCadastraCliente.setText(controllerCliente.clienteEditar.getDataNasc());
			textDataPrimComp.setText(controllerCliente.clienteEditar.getDataPriCom());
			textEnderecoCadastraCliente.setText(controllerCliente.clienteEditar.getEndereco());
		}
	}
}
