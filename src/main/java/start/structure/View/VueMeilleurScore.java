package start.structure.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import start.structure.RessourcesAccess;
import start.structure.metier.entite.Score;
import start.structure.metier.manager.ScoreManager;
import start.structure.stockage.Session;

import java.io.IOException;
import java.util.List;

public class VueMeilleurScore {
    Pane pane = new Pane();

    public void affichageVueMeilleurScore(Stage stage) throws IOException {
        ;
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().add(String.valueOf(RessourcesAccess.class.getResource("css/style.css")));


        Label labelMeilleurScore = new Label("Meilleurs scores");
        labelMeilleurScore.setLayoutX(300);
        labelMeilleurScore.setLayoutY(40);
        labelMeilleurScore.setFont(new javafx.scene.text.Font("Goldman", 40));
        labelMeilleurScore.setTextFill(javafx.scene.paint.Color.WHITE);
        labelMeilleurScore.setUnderline(true);

        Button buttonRetour = new Button("Retour");
        buttonRetour.getStyleClass().add("btnGrey");
        buttonRetour.setLayoutX(430);
        buttonRetour.setLayoutY(550);
        buttonRetour.setOnAction(event -> {
            VueMenu vueMenu = new VueMenu();
            vueMenu.demarrerMenu(stage);
        });

        List<Score> scores = ScoreManager.getInstance().getScores();
        int i = 0;

        while (i < 11 && i < scores.size()) {
            Label labelPseudo;
            if (scores.get(i).getLogin() == null) {
                labelPseudo = new Label("Invité");
            } else {
                labelPseudo = new Label(scores.get(i).getLogin());
            }
            Label labelScore = new Label(String.valueOf(scores.get(i).getScore()));
            Label place = new Label(String.valueOf(i + 1) + ".");

            if (i == 0) {
                labelScore.setTextFill(javafx.scene.paint.Color.GOLD);
                labelPseudo.setTextFill(javafx.scene.paint.Color.GOLD);
                place.setTextFill(javafx.scene.paint.Color.GOLD);
            } else if (i == 1) {
                labelScore.setTextFill(javafx.scene.paint.Color.GRAY);
                labelPseudo.setTextFill(javafx.scene.paint.Color.GRAY);
                place.setTextFill(javafx.scene.paint.Color.GRAY);
            } else if (i == 2) {
                labelScore.setTextFill(javafx.scene.paint.Color.BROWN);
                labelPseudo.setTextFill(javafx.scene.paint.Color.BROWN);
                place.setTextFill(javafx.scene.paint.Color.BROWN);
            } else {
                labelScore.setTextFill(javafx.scene.paint.Color.WHITE);
                labelPseudo.setTextFill(javafx.scene.paint.Color.WHITE);
                place.setTextFill(javafx.scene.paint.Color.WHITE);
            }
/*
            labelScore.setFont(new javafx.scene.text.Font("Arial", 40));
            labelPseudo.setFont(new javafx.scene.text.Font("Goldman", 40));
            place.setFont(new javafx.scene.text.Font("Goldman", 40));
*/
            labelScore.getStyleClass().add("LabelScore");
            labelPseudo.getStyleClass().add("LabelScore");
            place.getStyleClass().add("LabelScore");

            labelPseudo.setLayoutX(310);
            labelPseudo.setLayoutY(115 + 35 * (i + 1));
            labelScore.setLayoutX(610);
            labelScore.setLayoutY(115 + 35 * (i + 1));
            place.setLayoutX(260);
            place.setLayoutY(115 + 35 * (i + 1));

            pane.getChildren().add(labelPseudo);
            pane.getChildren().add(labelScore);
            pane.getChildren().add(place);
            i++;
        }

        pane.setStyle("-fx-border-color: white ; -fx-border-width: 10px ; -fx-background-color: black ; -fx-background-radius: 10px ;");
        pane.getChildren().addAll(labelMeilleurScore, buttonRetour);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            System.out.println("Fermeture de Koala Rock");
            Label alerte = new Label("Voulez vous vraiment \n" + "quitter le jeu ?");
            alerte.getStyleClass().add("LabelError");
            alerte.setLayoutX(520);
            alerte.setLayoutY(250);

            Rectangle rectangle = new Rectangle();
            rectangle.setX(500);
            rectangle.setY(200);
            rectangle.setWidth(300);
            rectangle.setHeight(200);

            rectangle.setArcHeight(50);
            rectangle.setArcWidth(50);
            rectangle.setFill(Color.BLACK);
            rectangle.setEffect(new DropShadow(10, Color.WHITE));

            Button oui = new Button("Oui");
            oui.getStyleClass().add("btnGrey");
            oui.setLayoutX(520);
            oui.setLayoutY(325);

            Button non = new Button("Non");
            non.getStyleClass().add("btnRed");
            non.setLayoutX(720);
            non.setLayoutY(325);

            oui.setOnAction(e -> {
                System.out.println("Deconnexion de l'utilisateur");
                Session.getInstance().disconnect();
                System.out.println("Fermeture du jeu");
                System.exit(0);
            });
            non.setOnAction(e -> {
                pane.getChildren().removeAll(oui, non, rectangle, alerte);
            });
            pane.getChildren().addAll(rectangle, alerte, oui, non);
        });
    }
}
