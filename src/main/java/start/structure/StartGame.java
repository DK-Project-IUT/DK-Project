package start.structure;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class StartGame extends Application {
    private Scene s;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        // Creer une scène avec un bouton commencer, quand se bouton est cliqué le jeu se
        // lance
        primaryStage = stage;
        primaryStage.setTitle("Koala Rock");
        primaryStage.setResizable(false);
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        borderPane.setStyle("-fx-background-radius: 30;");
        Image backgroundImg = new Image("src/main/resources/menuScreen.png");
        borderPane.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                null)));
        Scene scene = new Scene(borderPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


        Label label = new Label("Koala Rock");
        label.setFont(new Font("Arial", 50));
        label.setTextFill(Color.BLACK);
        label.setLayoutX(150);
        label.setLayoutY(150);
        pane.getChildren().add(label);

        Button demarrerPartie = new Button("Commencer");

        demarrerPartie.setFont(new Font("Arial", 20));
        demarrerPartie.setTextFill(Color.BLACK);
        demarrerPartie.setStyle("-fx-background-radius: 30;");
        demarrerPartie.setLayoutX(250);
        demarrerPartie.setLayoutY(250);

        pane.getChildren().add(demarrerPartie);

        demarrerPartie.setOnMouseClicked(event -> {
            try {
                demarrerJeu(stage);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void demarrerJeu(Stage stage) throws IOException, InterruptedException {

        BorderPane root = new BorderPane();
        Mario mario = new Mario(20, -10, 30, 30);
        Echelle echelle1 = new Echelle(400, 485, 25, 80);
        Echelle echelle2 = new Echelle(200, 408, 25, 80);
        Echelle echelle3 = new Echelle(500, 331, 25, 80);
        Echelle echelle4 = new Echelle(100, 255, 25, 80);
        Echelle echelle5 = new Echelle(500, 177, 25, 80);

        EchelleBroken eb1 = new EchelleBroken(300, 331, 25, 80);
        EchelleBroken eb2 = new EchelleBroken(240, 177, 25, 80);

        DonkeyKong dk = new DonkeyKong(60, 80, 100, 100);
        Fond fond = new Fond(0, 0, 600, 600);
        Tonneaux tonneau1 = new Tonneaux(20, -10, 20, 20);
        Tonneaux tonneau2 = new Tonneaux(20, -10, 20, 20);
        Tonneaux tonneau3 = new Tonneaux(20, -10, 20, 20);
        Tonneaux tonneau4 = new Tonneaux(20, -10, 20, 20);
        Tonneaux tonneau5 = new Tonneaux(20, -10, 20, 20);
        tonneau1.setLayoutY(-30);
        tonneau2.setLayoutY(-30);
        tonneau3.setLayoutY(-30);
        tonneau4.setLayoutY(-30);
        tonneau5.setLayoutY(-30);
        // décompte du temps
        // Tonneaux tonneau2 = new Tonneaux(20, 160, 20, 20);

        mario.setLayoutX(20 * 10);
        mario.setLayoutY(545);

        // panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(600, 600);
        jeu.getChildren().add(fond);
        jeu.getChildren().add(echelle1);
        jeu.getChildren().add(echelle2);
        jeu.getChildren().add(echelle3);
        jeu.getChildren().add(echelle4);
        jeu.getChildren().add(echelle5);
        jeu.getChildren().add(eb1);
        jeu.getChildren().add(eb2);
        jeu.getChildren().add(mario);
        jeu.getChildren().add(dk);
        jeu.getChildren().add(tonneau1);
        jeu.getChildren().add(tonneau2);
        jeu.getChildren().add(tonneau3);
        jeu.getChildren().add(tonneau4);
        jeu.getChildren().add(tonneau5);

        System.out.println(echelle1.getLayoutX());

        //////////////////////// Echelle
        // Attribution des coordonnées etc des échelles
        ArrayList<Echelle> echelles = new ArrayList<>();
        echelles.add(echelle1);
        echelles.add(echelle2);
        echelles.add(echelle3);
        echelles.add(echelle4);
        echelles.add(echelle5);
        ArrayList<ArrayList<Double>> coordonneesEchelles = new ArrayList<>();
        ArrayList<Double> coordonneesEchelle1 = new ArrayList<>();
        coordonneesEchelle1.add(380.0); // x
        coordonneesEchelle1.add(468.0); // y
        ArrayList<Double> coordonneesEchelle2 = new ArrayList<>();
        coordonneesEchelle2.add(180.0);
        coordonneesEchelle2.add(391.0);
        ArrayList<Double> coordonneesEchelle3 = new ArrayList<>();
        coordonneesEchelle3.add(475.0);
        coordonneesEchelle3.add(314.0);
        ArrayList<Double> coordonneesEchelle4 = new ArrayList<>();
        coordonneesEchelle4.add(75.0);
        coordonneesEchelle4.add(237.0);
        ArrayList<Double> coordonneesEchelle5 = new ArrayList<>();
        coordonneesEchelle5.add(475.0);
        coordonneesEchelle5.add(160.0);

        coordonneesEchelles.add(coordonneesEchelle1);
        coordonneesEchelles.add(coordonneesEchelle2);
        coordonneesEchelles.add(coordonneesEchelle3);
        coordonneesEchelles.add(coordonneesEchelle4);
        coordonneesEchelles.add(coordonneesEchelle5);

        //////////////////////// EchelleBroken
        ArrayList<EchelleBroken> echellesBrokens = new ArrayList<>();
        echellesBrokens.add(eb1);
        echellesBrokens.add(eb2);

        ArrayList<Double> coordonneesEchelleBroken1 = new ArrayList<>();
        coordonneesEchelleBroken1.add(275.0);
        coordonneesEchelleBroken1.add(314.0);
        ArrayList<Double> coordonneesEchelleBroken2 = new ArrayList<>();
        coordonneesEchelleBroken2.add(220.0);
        coordonneesEchelleBroken2.add(160.0);

        coordonneesEchelles.add(coordonneesEchelleBroken1);
        coordonneesEchelles.add(coordonneesEchelleBroken2);

        ////////////////////////////////////////////////

        // Tonneaux (faudra penser à essayer de le foutre dans la classe Tonneaux nan ?)
        ArrayList<Tonneaux> tonneaux = new ArrayList<>();
        tonneaux.add(tonneau1);
        tonneaux.add(tonneau2);
        tonneaux.add(tonneau3);
        tonneaux.add(tonneau4);
        tonneaux.add(tonneau5);
        tonneau1.moveTonneaux(coordonneesEchelles, dk);
        tonneau1.setLayoutY(160);
        dk.lance(tonneau1);
        final IntegerProperty i = new SimpleIntegerProperty(0);
        final int[] x = {1};
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(6), event -> {
            i.set(i.get() + 1);
            if (x[0] < 5) {
                tonneaux.get(x[0]).moveTonneaux(coordonneesEchelles, dk);
                tonneaux.get(x[0]).setLayoutY(160);
                dk.lance(tonneaux.get(x[0]));
                System.out.println("dedans");
                x[0]++;
            } else {
                System.out.println("plus dedans");

            }

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        AnimationTimer collisionTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (mario.collisionTonneaux(tonneaux) == -1) {
                    // try {
                    supprimerEléments(jeu, tonneaux, echelles, echellesBrokens, mario, dk);
                    // restartGame(stage);
                    // } catch (IOException | InterruptedException e) {
                    // // TODO Auto-generated catch block
                    // e.printStackTrace();
                    // }

                } else if (mario.collisionTonneaux(tonneaux) == 1) {
                    System.out.println("+1");

                }

                if (mario.getLayoutX() == 400 && mario.getLayoutY() == 160) {
                    try {
                        restartGame(stage);
                    } catch (IOException | InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        // Fin Start Game //
        collisionTimer.start();
        root.setCenter(jeu);
        s = new Scene(root);
        move(mario, echelles, echellesBrokens, coordonneesEchelles);
        stage.setScene(s);
        stage.show();
    }

    public void supprimerEléments(Pane jeu, ArrayList<Tonneaux> tonneaux, ArrayList<Echelle> echelles, ArrayList<EchelleBroken> echellesBrokens, Mario mario, DonkeyKong dk) {
        jeu.getChildren().removeAll(tonneaux);
        jeu.getChildren().removeAll(echelles);
        jeu.getChildren().removeAll(echellesBrokens);
        jeu.getChildren().removeAll(mario);
        jeu.getChildren().removeAll(dk);
    }

    public void restartGame(Stage stage) throws IOException, InterruptedException {
        Pane root = new Pane();
        Pane jeu = new Pane();
        jeu.setPrefSize(600, 600);
        jeu.setStyle("-fx-background-color: #000000;");
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
        jeu.getChildren().clear();
        root.getChildren().clear();
        start(stage);
    }

    /**
     * Méthode qui permet le mouvement de Mario
     *
     * @param mario
     * @param echelles
     * @param echellesBrokens
     * @param coordonneesEchelles
     */
    private void move(Mario mario, ArrayList<Echelle> echelles, ArrayList<EchelleBroken> echellesBrokens, ArrayList<ArrayList<Double>> coordonneesEchelles) {
        s.setOnKeyPressed((KeyEvent event) -> {
            mario.tomberEtage();
            switch (event.getCode()) {
                case UP:
                    // System.out.println("X : " + mario.getLayoutX());
                    // System.out.println("Y : " + mario.getLayoutY() + "\n");
                    if (mario.collisionEchelle(echelles) && !(mario.estEn(coordonneesEchelles))) {
                        mario.directionHaut();
                        mario.setEstSurEchelle(true);
                    }
                    if (mario.collisionEchelleBroken(echellesBrokens) && !(mario.estEnBroken(coordonneesEchelles))) {
                        mario.directionHaut();
                        mario.setEstSurEchelle(true);
                    }
                    break;
                case LEFT:
                    if (!mario.estDansEchelle(coordonneesEchelles)) {
                        mario.directionGauche();
                        mario.setEstSurEchelle(false);
                    }
                    break;
                case RIGHT:
                    if (!mario.estDansEchelle(coordonneesEchelles)) {
                        mario.directionDroite(s.getWidth());
                        mario.setEstSurEchelle(false);
                    }
                    break;
                case DOWN:
                    if (mario.collisionEchelle(echelles) && !(mario.estDansBasEchelle(coordonneesEchelles))) {
                        mario.directionBas(s.getHeight());
                    }
                    if (mario.collisionEchelleBroken(echellesBrokens) && !(mario.estDansBasEchelle(coordonneesEchelles))) {
                        mario.directionBas(s.getHeight());
                    }
                    mario.setEstSurEchelle(false);
                    break;
                case SPACE:
                    if (!mario.isEstEnSaut()) {
                        PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(0.6));
                        mario.jump();
                        mario.setaEuSonScore(false);
                        pause.play();
                        pause.setOnFinished(event1 -> mario.atterir());
                        break;
                    }

                case A:
                    System.out.println(mario.getLayoutX());
                    System.out.println(mario.getLayoutY());
                    System.out.println(mario.getScore());
            }
        });
    }
}