package start.structure.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import start.structure.Model.*;
import start.structure.RessourcesAccess;
import start.structure.metier.manager.ScoreManager;
import start.structure.stockage.Session;

import java.io.IOException;
import java.util.Objects;

public class VueParametre {
    private static String choixPersonnage = "Panda";
    private static String choixEnnemi = "Koala";


    public void VueParametre(Stage stage) throws IOException {

            Pane pane = new Pane();
            Scene scene = new Scene(pane, 1280, 720);
            scene.getStylesheets().add(String.valueOf(RessourcesAccess.class.getResource("css/style.css")));

            /////////////// ComboBox ///////////////
            ComboBox<String> comboBoxJoueurPrincipale = new ComboBox<>();
            comboBoxJoueurPrincipale.getItems().addAll("Panda");
            comboBoxJoueurPrincipale.setValue("Panda");
            if (Session.getInstance().getLogin() != null) {
                if (ScoreManager.getInstance().getHighScoreByLogin(Session.getInstance().getLogin()) != null) {
                    if (ScoreManager.getInstance().getHighScoreByLogin(Session.getInstance().getLogin()).getScore() > 10) {
                        comboBoxJoueurPrincipale.getItems().add("Samurai");
                    }
                }
            }

            ComboBox<String> comboBoxPersonnageEnnemie = new ComboBox<>();
            comboBoxPersonnageEnnemie.getItems().addAll("Koala");
            comboBoxPersonnageEnnemie.setValue("Koala");

            /**
             * ComboBox pour le choix du personnage
             */
            comboBoxJoueurPrincipale.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                choixPersonnage = newValue;
                if (choixPersonnage.equals("Panda")) {
                    PersonnePrincipale.setPersonnePrincipale("PANDA");
                } else if (choixPersonnage.equals("Samurai")) {
                    PersonnePrincipale.setPersonnePrincipale("SAMURAI");
                }
            });

            /**
             * ComboBox pour le choix de l'ennemie
             */

            if (Session.getInstance().getLogin() != null) {
                if (ScoreManager.getInstance().getHighScoreByLogin(Session.getInstance().getLogin()) != null) {
                    if (ScoreManager.getInstance().getHighScoreByLogin(Session.getInstance().getLogin()).getScore() > 10) {
                        comboBoxPersonnageEnnemie.getItems().add("Ninja");
                    }
                }
            }

            comboBoxPersonnageEnnemie.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                choixEnnemi = newValue;
                if (choixEnnemi.equals("Koala")) {
                    PersonneEnnemie.setChoixPersonnage("KOALA");
                    Fond.setChoixFond("KOALA");
                    Echelle.setChoixEchelle("KOALA");
                    EchelleBroken.setChoixEchelleBroken("KOALA");
                    Objet_Attaque.setChoixObjet("ROCHER");
                } else if (choixEnnemi.equals("Ninja")) {
                    PersonneEnnemie.setChoixPersonnage("NINJA");
                    Fond.setChoixFond("NINJA");
                    Echelle.setChoixEchelle("NINJA");
                    EchelleBroken.setChoixEchelleBroken("NINJA");
                    Objet_Attaque.setChoixObjet("SHURIKANE");
                }
            });

            comboBoxJoueurPrincipale.setLayoutX(300);
            comboBoxJoueurPrincipale.setLayoutY(100);

            comboBoxPersonnageEnnemie.setLayoutX(300);
            comboBoxPersonnageEnnemie.setLayoutY(200);

            // CSS ComboBox //

            comboBoxJoueurPrincipale.getStyleClass().add("buttonEcran");
            comboBoxJoueurPrincipale.setStyle("-fx-font-size: 12px; -fx-pref-width: 130px; -fx-pref-height: 20px;");
            comboBoxPersonnageEnnemie.getStyleClass().add("buttonEcran");
            comboBoxPersonnageEnnemie.setStyle("-fx-font-size: 12px; -fx-pref-width: 130px; -fx-pref-height: 20px;");

            // Texte ComboBox //

            Label labelJoueurPrincipale = new Label("Personnage principal : ");
            labelJoueurPrincipale.setLayoutX(100);
            labelJoueurPrincipale.setLayoutY(110);

            Label labelPersonnageEnnemie = new Label("Personnage ennemie : ");
            labelPersonnageEnnemie.setLayoutX(100);
            labelPersonnageEnnemie.setLayoutY(210);

            // CSS Texte ComboBox //

            labelJoueurPrincipale.getStyleClass().add("LabelUnderButton");
            labelPersonnageEnnemie.getStyleClass().add("LabelUnderButton");

            ////////////////////////////Bouton////////////////////////////
            Label button_Bas = new Label();
            ImageView image_Bas = new ImageView(new Image(Objects.requireNonNull(RessourcesAccess.class.getResourceAsStream("Button/Button_bas.png"))));
            image_Bas.setFitHeight(50);
            image_Bas.setFitWidth(50);
            button_Bas.setGraphic(image_Bas);
            button_Bas.getStyleClass().add("button_Action");
            button_Bas.setLayoutX(200);
            button_Bas.setLayoutY(485);

            Label button_Haut = new Label();
            ImageView image_Haut = new ImageView(new Image(Objects.requireNonNull(RessourcesAccess.class.getResourceAsStream("Button/Button_haut.png"))));
            image_Haut.setFitHeight(50);
            image_Haut.setFitWidth(50);
            button_Haut.setGraphic(image_Haut);
            button_Haut.getStyleClass().add("button_Action");
            button_Haut.setLayoutX(200);
            button_Haut.setLayoutY(400);

            Label button_Gauche = new Label();
            ImageView image_Gauche = new ImageView(new Image(Objects.requireNonNull(RessourcesAccess.class.getResourceAsStream("Button/Button_gauche.png"))));
            image_Gauche.setFitHeight(50);
            image_Gauche.setFitWidth(50);
            button_Gauche.setGraphic(image_Gauche);
            button_Gauche.getStyleClass().add("button_Action");
            button_Gauche.setLayoutX(110);
            button_Gauche.setLayoutY(485);

            Label button_Droite = new Label();
            ImageView image_Droite = new ImageView(new Image(Objects.requireNonNull(RessourcesAccess.class.getResourceAsStream("Button/Button_droite.png"))));
            image_Droite.setFitHeight(50);
            image_Droite.setFitWidth(50);
            button_Droite.setGraphic(image_Droite);
            button_Droite.getStyleClass().add("button_Action");
            button_Droite.setLayoutX(285);
            button_Droite.setLayoutY(485);

            Label button_Espace = new Label();
            ImageView image_Espace = new ImageView(new Image(Objects.requireNonNull(RessourcesAccess.class.getResourceAsStream("Button/Button_espace.png"))));
            image_Espace.setFitHeight(50);
            image_Espace.setFitWidth(200);
            button_Espace.setGraphic(image_Espace);
            button_Espace.getStyleClass().add("button_Action");
            button_Espace.setLayoutX(600);
            button_Espace.setLayoutY(485);
            ////////////////////////////End Bouton////////////////////////////

            ////////////////////////////Texte////////////////////////////

            Label texte_Bas = new Label("Bas");
            texte_Bas.getStyleClass().add("LabelUnderButton");
            texte_Bas.setLayoutX(206);
            texte_Bas.setLayoutY(540);

            Label texte_Haut = new Label("Haut");
            texte_Haut.getStyleClass().add("LabelUnderButton");
            texte_Haut.setLayoutX(204);
            texte_Haut.setLayoutY(455);

            Label texte_Gauche = new Label("Gauche");
            texte_Gauche.getStyleClass().add("LabelUnderButton");
            texte_Gauche.setLayoutX(104);
            texte_Gauche.setLayoutY(540);

            Label texte_Droite = new Label("Droite");
            texte_Droite.getStyleClass().add("LabelUnderButton");
            texte_Droite.setLayoutX(282);
            texte_Droite.setLayoutY(540);

            Label texte_Espace = new Label("Espace");
            texte_Espace.getStyleClass().add("LabelUnderButton");
            texte_Espace.setLayoutX(670);
            texte_Espace.setLayoutY(540);

            ////////////////////////////End Texte////////////////////////////


            Button buttonHide = new Button("quitter et sauvegarder");
            buttonHide.getStyleClass().add("buttonEcran");
            buttonHide.setStyle("-fx-font-size: 12px; -fx-pref-width: 200px; -fx-pref-height: 30px;");


            buttonHide.setLayoutX(350);
            buttonHide.setLayoutY(580);
            buttonHide.setOnAction(event -> {
                stage.hide();
            });
            pane.getChildren().add(buttonHide);
            pane.getChildren().addAll(button_Bas, button_Haut, button_Gauche, button_Droite, button_Espace);
            pane.getChildren().addAll(texte_Bas, texte_Haut, texte_Gauche, texte_Droite, texte_Espace);
            pane.getChildren().addAll(comboBoxPersonnageEnnemie, comboBoxJoueurPrincipale);
            pane.getChildren().addAll(labelJoueurPrincipale, labelPersonnageEnnemie);


            stage.setTitle("Paramètre");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            pane.setStyle("-fx-border-color: white ; -fx-border-width: 10px ; -fx-background-color: black ; -fx-background-radius: 10px ;");

        }
}
