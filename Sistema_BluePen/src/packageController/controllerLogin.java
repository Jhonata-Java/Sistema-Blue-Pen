package packageController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import packageControle.VendedorDAO;
import packageModel.Vendedor;

public class controllerLogin {

	@FXML
    private ToggleButton VerSenha;
    
    @FXML
    private Button btLogin;

    @FXML
    private PasswordField textPassword;
    
    @FXML
    private TextField txtSenha;
    
    @FXML
    private TextField textSenha;

    @FXML
    private TextField textUser;

    public static Vendedor vendedor = new Vendedor();
    @FXML
    void btButtonTeste(ActionEvent event) {
    	textPassword.setVisible(true);
    	VendedorDAO v = new VendedorDAO();
    	 
    	vendedor = v.autenticarUser(textUser.getText(), textPassword.getText());
    	
    	if(vendedor.getPassword() != null && vendedor.getCPF() != null) {
    		Alert saudacao = new Alert(Alert.AlertType.CONFIRMATION);
    		saudacao.setHeaderText("Saudações");
    		saudacao.setTitle("Bem vindo!");
    		saudacao.setContentText("Seja bem vindo de volta" + vendedor.getNome()+"!");
    		saudacao.show();
    		Main.changeScreen("main");
    	}
    	else {
    		Alert erro = new Alert(Alert.AlertType.ERROR);
    		erro.setTitle("Falha ao realizar login");
    		erro.setHeaderText("Erro");
    		erro.setContentText("Usuario ou senha incorreta! verifique as informações!");
    		erro.show();
    	}
    }
    @FXML
    void visualizaSenha(ActionEvent event) {
    	if(VerSenha.isSelected()) {
    	textSenha.setText(textPassword.getText());
    	textPassword.setVisible(false);
    	textSenha.setVisible(true);
    	}
    	else {
    		textPassword.setText(textSenha.getText());
    		textPassword.setVisible(true);
    		textSenha.setVisible(false);
    	}
    }
}
