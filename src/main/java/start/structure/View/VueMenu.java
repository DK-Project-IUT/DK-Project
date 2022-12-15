package start.structure.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import start.structure.stockage.Session;

import java.io.IOException;

public class VueMenu {

    private final VueJeu vueJeu = new VueJeu();


    public void demarrerMenu(Stage stage) {
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

/////////// BOUTON ///////////
        Label nameGame = new Label("Koala Rock");
        nameGame.getStyleClass().add("nameGame");
        nameGame.setLayoutX(355);
        nameGame.setLayoutY(100);

        Button demarrerPartie = new Button("Mode Classic");
        demarrerPartie.getStyleClass().add("buttonEcran");
        demarrerPartie.setLayoutX(541);
        demarrerPartie.setLayoutY(350);

        Button demarrerInfinit = new Button("Mode Infini");
        demarrerInfinit.getStyleClass().add("buttonEcran");
        demarrerInfinit.setLayoutX(554);
        demarrerInfinit.setLayoutY(430);

        Button monCompte = new Button("Mon Compte");
        monCompte.getStyleClass().add("buttonEcran");
        monCompte.setLayoutX(940);
        monCompte.setLayoutY(500);

        Button connexionRegister = new Button("Connexion/Inscription");
        connexionRegister.getStyleClass().add("buttonEcran");
        connexionRegister.setLayoutX(900);
        connexionRegister.setLayoutY(580);

        Button meilleurScore = new Button("Meilleurs Score");
        meilleurScore.getStyleClass().add("buttonEcran");
        meilleurScore.setLayoutX(100);
        meilleurScore.setLayoutY(500);

        Button parametre = new Button("Paramètres");
        parametre.getStyleClass().add("buttonEcran");
        parametre.setLayoutX(120);
        parametre.setLayoutY(580);

        Button quitter = new Button("Quitter");
        quitter.getStyleClass().add("buttonEcran");
        quitter.setLayoutX(575);
        quitter.setLayoutY(580);


        ///////// IMAGE ///////////
        Label menuScreen = new Label();
        Image image = new Image("file:src/main/resources/ImageMenu.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720);
        imageView.setFitWidth(1280);
        menuScreen.setGraphic(imageView);

        Label labelError = new Label();
        labelError.getStyleClass().add("LabelError");
        labelError.setLayoutX(510);
        labelError.setLayoutY(590);


        pane.getChildren().add(menuScreen);
        pane.getChildren().add(labelError);
        pane.getChildren().addAll(demarrerPartie, demarrerInfinit);
        pane.getChildren().addAll(parametre, connexionRegister, meilleurScore, monCompte, quitter);
        pane.getChildren().add(nameGame);


        /**
         * Permet de lancer le jeu en mode classique
         * @param event
         */
        demarrerPartie.setOnMouseClicked(event -> {
            try {
                vueJeu.demarrerJeu(stage, "Normal");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        /**
         * Permet de lancer le jeu en mode infini
         * @param event
         */
        demarrerInfinit.setOnMouseClicked(event -> {
            try {
                vueJeu.demarrerJeu(stage, "Infini");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        /**
         * Permet d'ouvrir la fenêtre de paramétrage
         * @param event
         */
        parametre.setOnMouseClicked(event -> {
            VueParametre vueParametre = new VueParametre();
            vueParametre.show();
        });

        /**
         * Permet d'ouvrir la fenêtre de connexion
         * @param event
         */
        connexionRegister.setOnMouseClicked(event -> {
            VueConnexion vueConnexion = new VueConnexion();
            vueConnexion.show();
        });

        /**
         * Permet d'ouvrir la fenêtre de meilleur score
         * @param event
         */
        meilleurScore.setOnMouseClicked(event -> {
            VueMeilleurScore vueMeilleurScore = new VueMeilleurScore();
            vueMeilleurScore.show();
        });

        monCompte.setOnMouseClicked(event -> {
            labelError.setText("");
            if (Session.getInstance().isConnected()) {
                VueCompte vueCompte = new VueCompte();
                vueCompte.show();
            } else {
                labelError.setText("Veuillez vous connecter");
            }
        });

        quitter.setOnMouseClicked(event -> {
            stage.close();
        });
    }
}
