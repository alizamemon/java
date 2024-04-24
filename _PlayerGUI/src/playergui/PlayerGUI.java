package playergui;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerGUI extends Application {
    private ObservableList<Player> players;
    private TableView<Player> playerTable;
    private TextField nameField;
    private TextField ageField;
    private TextField nationalityField;
    private TextField playerIdField;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        players = FXCollections.observableArrayList();
        playerTable = new TableView<>();
        
        TableColumn<Player, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        
        TableColumn<Player, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        
        TableColumn<Player, String> nationalityColumn = new TableColumn<>("Nationality");
        nationalityColumn.setCellValueFactory(cellData -> cellData.getValue().nationalityProperty());
        
        TableColumn<Player, Integer> playerIdColumn = new TableColumn<>("Player ID");
        playerIdColumn.setCellValueFactory(cellData -> cellData.getValue().playerIdProperty().asObject());
        
        playerTable.getColumns().addAll(nameColumn, ageColumn, nationalityColumn, playerIdColumn);
        playerTable.setItems(players);
        
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addPlayer());
        
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deletePlayer());
        
        GridPane inputGridPane = new GridPane();
        inputGridPane.setHgap(10);
        inputGridPane.setVgap(10);
        
        Label nameLabel = new Label("Name:");
        nameField = new TextField();
        
        Label ageLabel = new Label("Age:");
        ageField = new TextField();
        
        Label nationalityLabel = new Label("Nationality:");
        nationalityField = new TextField();
        
        Label playerIdLabel = new Label("Player ID:");
        playerIdField = new TextField();
        
        inputGridPane.add(nameLabel, 0, 0);
        inputGridPane.add(nameField, 1, 0);
        inputGridPane.add(ageLabel, 0, 1);
        inputGridPane.add(ageField, 1, 1);
        inputGridPane.add(nationalityLabel, 0, 2);
        inputGridPane.add(nationalityField, 1, 2);
        inputGridPane.add(playerIdLabel, 0, 3);
        inputGridPane.add(playerIdField, 1, 3);
        
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addButton, deleteButton);
        
        VBox mainBox = new VBox(10);
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(playerTable, inputGridPane, buttonBox);
        
        Scene scene = new Scene(mainBox);
        
        primaryStage.setTitle("Player Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void addPlayer() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String nationality = nationalityField.getText();
        int playerId = Integer.parseInt(playerIdField.getText());
        
        Player player = new Player(name, age, nationality, playerId);
        players.add(player);
        
        player.insertInformation(); // Call the insertInformation() method to store player information in the database
    }
    
    private void deletePlayer() {
        Player selectedPlayer = playerTable.getSelectionModel().getSelectedItem();
        if (selectedPlayer != null) {
            players.remove(selectedPlayer);
            
            selectedPlayer.deleteInformation(); // Call the deleteInformation() method to remove player information from the database
        }
    }
}


