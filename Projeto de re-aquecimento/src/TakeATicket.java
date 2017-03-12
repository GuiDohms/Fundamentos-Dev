import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.Modality;
import java.util.Locale;
import javafx.scene.media.AudioClip;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class TakeATicket extends Application{

	private TextField tfNome,tfIdade;//,tfDestino,tfQtdCaixas;
    private TextField tfDlgId,tfDlgDataPrev,tfDlgDestino,tfDlgQtdCaixas;
    private TextField tfDlgQtNormal,tfDlgQtRefrigerada,tfDlgQtPerecivel;
    private Stage dlgStage;
    private DatePicker dpDataDia;
    private TextField tfVeiculo, tfOrdemTransporte;
  
    public TakeATicket(){
    }

    @Override
    public void start(Stage primaryStage) {
        // Define o grid basico
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Define o título do form
        Text tfTitulo = new Text("Seja Bem-Vindo ao Banco:");
        tfTitulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(tfTitulo, 0, 0, 2, 1);    
       
        // Cria e posiciona 
        grid.add(new Label("Data:"), 0, 1);
        dpDataDia = new DatePicker();
        grid.add(dpDataDia,1,1); 
        grid.add(new Label("Nome:"), 0, 2);
        tfNome = new TextField();
        grid.add(tfNome, 1, 2); 
        grid.add(new Label("Idade:"), 0, 3);
        tfIdade = new TextField();
        grid.add(tfIdade, 1, 3); 
        
        // Define os botoes
        Button btOK= new Button();
        btOK.setText("OK");
        btOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Line.getInstance() == null){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Voce Ja possui Senha!");
                    alert.showAndWait();
                }else{
                    //exibeDados();
                }
            }
        });

        Button btNext = new Button();
        btNext.setText(">>");
        btNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Pedidos.getInstance().getProximo() == null){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Este é o ultimo pedido!");
                    alert.showAndWait();
                }else{
                    //exibeDados();
                }
            }
        });
        Button btNextOrdem = new Button();
        btNextOrdem.setText(">");
        btNextOrdem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Pedidos.getInstance().getProximo() == null){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Este é a ultima ordem!");
                    alert.showAndWait();
                }else{
                    //exibeDados();
                }
            }
        });
        Button btPrevOrdem = new Button();
        btPrevOrdem.setText("<");
        btPrevOrdem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Pedidos.getInstance().getAnterior()== null){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Atenção !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Este é a primeira ordem!");
                    alert.showAndWait();
                }else{
                    //exibeDados();
                }
            }
        });
        
        Button btEntreg = new Button();
        btEntreg.setText("Entregue");
        btEntreg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                criaDialogoPedido();
            }
        });
        
        Button btAtrasado = new Button();
        btAtrasado.setText("Atrasados");
        btAtrasado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                criaDialogoPedido();
            }
        });
        
        Button btSucesso = new Button();
        btSucesso.setText("Sucesso");
        btSucesso.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                criaDialogoPedido();
            }
        });
        
        Button btOcupado = new Button();
        btOcupado.setText("Ocupado");
        btOcupado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                criaDialogoPedido();
            }
        });
        
        Button btLucro = new Button();
        btLucro.setText("$$$$");
        btLucro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                criaDialogoPedido();
            }
        });

        Button btView = new Button();
        btView.setText("Visualizar");
        btView.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                criaDialogoPedido();
            }
        });

        Button btClose = new Button();
        btClose.setText("Fechar");
        btClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });
        
        // Agrupa os botoes em um HBox e posiciona
        HBox hbBtn = new HBox(30);
        hbBtn.getChildren().add(btPrev);
        hbBtn.getChildren().add(btNext);
        grid.add(hbBtn, 0, 7);
        HBox hbBtn2 = new HBox(30);
        hbBtn2.getChildren().add(btPrevOrdem);
        hbBtn2.getChildren().add(btNextOrdem);
        grid.add(hbBtn2, 3, 2);
        HBox hbView = new HBox(30);
        hbView.setAlignment(Pos.BOTTOM_RIGHT);
        hbView.getChildren().add(btView);
        grid.add(hbView, 1, 7);
        HBox hbEntreg = new HBox(30);
        hbEntreg.setAlignment(Pos.BOTTOM_LEFT);
        hbEntreg.getChildren().add(btEntreg);
        grid.add(hbEntreg, 0, 9);
        HBox hbAtrasado = new HBox(30);
        hbAtrasado.setAlignment(Pos.BOTTOM_LEFT);
        hbAtrasado.getChildren().add(btAtrasado);
        grid.add(hbAtrasado, 1, 9);
        HBox hbSucesso = new HBox(30);
        hbSucesso.setAlignment(Pos.BOTTOM_LEFT);
        hbSucesso.getChildren().add(btSucesso);
        grid.add(hbSucesso, 0, 10);
        HBox hbOcupado = new HBox(30);
        hbOcupado.setAlignment(Pos.BOTTOM_LEFT);
        hbOcupado.getChildren().add(btOcupado);
        grid.add(hbOcupado, 1, 10);
        HBox hbLucro = new HBox(30);
        hbLucro.setAlignment(Pos.BOTTOM_LEFT);
        hbLucro.getChildren().add(btLucro);
        grid.add(hbLucro, 0, 11);
        HBox hbClose = new HBox(30);
        hbClose.setAlignment(Pos.BOTTOM_RIGHT);
        hbClose.getChildren().add(btClose);
        grid.add(hbClose,1,11);

        // Adiciona o painel a cena e exibe        
        Scene scene = new Scene(grid);
        primaryStage.setTitle("So vai - Transportadora");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	
}
