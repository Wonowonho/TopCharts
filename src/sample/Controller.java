package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Label txt;
    @FXML
    private TableView<TableRowDataModel> myTableView;
    @FXML
    private TableColumn<TableRowDataModel, String> charts;
    @FXML
    private TableColumn<TableRowDataModel, String> woy;
    @FXML
    private TableColumn<TableRowDataModel, String> album;

    @FXML

    ObservableList<TableRowDataModel> myList = FXCollections.observableArrayList();


    @FXML
    private Button melonClick;

    @FXML
    private Button bugsClick;

    @FXML
    private Button appleClick;

    @FXML
    private Button gennieClick;

    @FXML
    private Button mnetClick;

    @FXML private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButtonAction(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(" Do you really want to close the running program?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            // get a handle to the stage
            Stage stage = (Stage) closeButton.getScene().getWindow();
            // do what you have to do
            stage.close();
        } else {
            // ... user chose CANCEL or closed the dialog

        }
    }

    @FXML
    WebView webView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        woy.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        charts.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        album.setCellValueFactory(cellData -> cellData.getValue().albumProperty());

        myTableView.setPlaceholder(new Label("Which one do you want to see? Just Click!!"));
        myTableView.setItems(myList);

        myTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TableRowDataModel>() {
            @Override
            public void changed(ObservableValue<? extends TableRowDataModel> observable, TableRowDataModel oldValue, TableRowDataModel newValue) {
                //oldVlue와 newValue를 사용할 수 있지만 Select된 Row가 다시 눌리는 이벤트는 받지 못한다..
                if(myTableView.getSelectionModel().getSelectedItem() != null) {
                    TableRowDataModel model = myTableView.getSelectionModel().getSelectedItem();
                    System.out.println(model.nameProperty().getValue());
                    WebEngine webEngine = webView.getEngine();
                    webEngine.load("https://www.youtube.com/results?search_query=" + model.nameProperty().getValue());
                }
            }
        });

        melonClick.addEventHandler (MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                myTableView.getItems().removeAll(myList);
                for(String s[] : melonmusic.melonList()) {
                    myTableView.getItems().add(
                            new TableRowDataModel(new SimpleStringProperty(s[0]), new SimpleStringProperty(s[1]),new SimpleStringProperty(s[2]))
                    );
                }
            }
        });

        bugsClick.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                myTableView.getItems().removeAll(myList);
                for(String s[] : bugsmusic.bugsList()) {
                    myTableView.getItems().add(
                            new TableRowDataModel(new SimpleStringProperty(s[0]), new SimpleStringProperty(s[1]),  new SimpleStringProperty(s[2]))
                    );
                }
            }
        });

        gennieClick.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                myTableView.getItems().removeAll(myList);
                for(String s[] : genniemusic.gennieList()) {
                    myTableView.getItems().add(
                            new TableRowDataModel(new SimpleStringProperty(s[0]), new SimpleStringProperty(s[1]), new SimpleStringProperty(s[2]))
                    );
                }
            }
        });

        mnetClick.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                myTableView.getItems().removeAll(myList);
                for(String s[] : mnetmusic.mnetList()) {
                    myTableView.getItems().add(
                            new TableRowDataModel(new SimpleStringProperty(s[0]), new SimpleStringProperty(s[1]), new SimpleStringProperty(s[2]))
                    );
                }
            }
        });


        appleClick.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                myTableView.getItems().removeAll(myList);
                for(String s[] : applemusic.appleList()) {
                    myTableView.getItems().add(
                            new TableRowDataModel(new SimpleStringProperty(s[0]), new SimpleStringProperty(s[1]), new SimpleStringProperty(s[2]))
                    );
                }
            }
        });
    }
}