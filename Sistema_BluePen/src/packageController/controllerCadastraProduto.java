package packageController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.ProdutoDAO;
import packageModel.Produto;

public class controllerCadastraProduto implements Initializable {

	@FXML
	private Button btnCadastraProduto;

	@FXML
	private Button btnCancelarProduto;
	
	@FXML
    private Button btnMenuPrincipal;

	@FXML
	private TextField textTipoUNCadastraProduto;

	@FXML
	private TextField textCodigoCadastraProduto;

	@FXML
	private TextField textDataFabricacao;

	@FXML
	private TextField textDataValidade;

	@FXML
	private TextField textEstoqueCadastraProduto;

	@FXML
	private TextField textNomeCadastroProduto;

	@FXML
	private TextField textPrecoUNCadastraProduto;

	@FXML
	void ActionBtnCanacelarProduto(ActionEvent event) {

		textNomeCadastroProduto.setText("");
		textCodigoCadastraProduto.setText("");
		textEstoqueCadastraProduto.setText("");
		textPrecoUNCadastraProduto.setText("");
		textTipoUNCadastraProduto.setText("");
		textDataFabricacao.setText("");
		textDataValidade.setText("");
		
		Stage stage = (Stage) btnCancelarProduto.getScene().getWindow();
		stage.close();
	}

	@FXML
	void ActionBtnSalvarProduto(ActionEvent event) {
		if(controllerProduto.ProdutoEditar == null) {
			Produto produto = new Produto();
			produto.setNome(textNomeCadastroProduto.getText());
			produto.setCodigo(textCodigoCadastraProduto.getText());
			produto.setEstoque(textEstoqueCadastraProduto.getText());
			produto.setProcoUN(textPrecoUNCadastraProduto.getText());
			produto.setTipoUN(textTipoUNCadastraProduto.getText());
			produto.setDataFab(textDataFabricacao.getText());
			produto.setDataVal(textDataValidade.getText());
			
			ProdutoDAO Prod = new ProdutoDAO();
			Prod.create(produto);
			
			Stage stage = (Stage) btnCancelarProduto.getScene().getWindow();
			stage.close();
		}
		else {
			Produto produto = new Produto();
			produto.setNome(textNomeCadastroProduto.getText());
			produto.setCodigo(textCodigoCadastraProduto.getText());
			produto.setEstoque(textEstoqueCadastraProduto.getText());
			produto.setProcoUN(textPrecoUNCadastraProduto.getText());
			produto.setTipoUN(textTipoUNCadastraProduto.getText());
			produto.setDataFab(textDataFabricacao.getText());
			produto.setDataVal(textDataValidade.getText());
			
			ProdutoDAO Prod = new ProdutoDAO();
			Prod.update(produto);
			
			Stage stage = (Stage) btnCancelarProduto.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(controllerProduto.ProdutoEditar != null) {
			textNomeCadastroProduto.setText(controllerProduto.ProdutoEditar.getNome());
			textCodigoCadastraProduto.setText(controllerProduto.ProdutoEditar.getCodigo());
			textEstoqueCadastraProduto.setText(controllerProduto.ProdutoEditar.getEstoque());
			textPrecoUNCadastraProduto.setText(controllerProduto.ProdutoEditar.getProcoUN());
			textTipoUNCadastraProduto.setText(controllerProduto.ProdutoEditar.getTipoUN());
			textDataFabricacao.setText(controllerProduto.ProdutoEditar.getDataFab());
			textDataValidade.setText(controllerProduto.ProdutoEditar.getDataVal());
		}
	}
}