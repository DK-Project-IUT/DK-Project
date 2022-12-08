package start.structure.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class VueDemarrage {

    private VueJeu vueJeu = new VueJeu();


    public void screenStart() {
        Stage stage = new Stage();
        stage.setTitle("Koala Rock");
        stage.setResizable(false);
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        borderPane.setCenter(pane);

        pane.setStyle("-fx-border-color: green ;");
        borderPane.setStyle("-fx-background-color: transparent ;");


        Scene scene = new Scene(borderPane, 1280, 720);
        scene.getStylesheets().add("file:src/main/resources/css/style.css");
        stage.setScene(scene);
        stage.show();


        Label nameGame = new Label("Koala Rock");
        nameGame.getStyleClass().add("nameGame");
        nameGame.setLayoutX(355);
        nameGame.setLayoutY(100);

        Button demarrerPartie = new Button("Commencer");
        demarrerPartie.getStyleClass().add("buttonEcran");
        demarrerPartie.setLayoutX(541);
        demarrerPartie.setLayoutY(570);

        Button demarrerInfinit = new Button("Commencer en mode infini");

        demarrerInfinit.setFont(new Font("Arial", 20));
        demarrerInfinit.setTextFill(Color.BLACK);
        demarrerInfinit.setStyle("-fx-background-radius: 30;");
        demarrerInfinit.setLayoutX(482);
        demarrerInfinit.setLayoutY(530);

        Label menuScreen = new Label();
        Image image = new Image("file:src/main/resources/ImageMenu.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        menuScreen.setGraphic(imageView);
        pane.getChildren().add(menuScreen);

        pane.getChildren().add(demarrerPartie);
        pane.getChildren().add(demarrerInfinit);
        pane.getChildren().add(nameGame);


        demarrerPartie.setOnMouseClicked(event -> {
            try {
                vueJeu.demarrerJeu(stage,"Normal");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        demarrerInfinit.setOnMouseClicked(event -> {
            try {
                vueJeu.demarrerJeu(stage,"Infini");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
