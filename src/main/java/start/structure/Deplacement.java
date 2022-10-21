package start.structure;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Deplacement extends Pane {

    private HBox rootLayout;   //private BorderPane rootLayout;
    private Pane Deplacement; //scene de jeu

    Mario mario = new Mario(20, 0, 20, 20);
    Echelle echelle1 = new Echelle(50, 100, 20, 50, 0);
    Echelle echelle2 = new Echelle(200, 100, 20, 50, 0);
    ArrayList<Echelle> echelles = new ArrayList<>();
    ArrayList<ArrayList<Double>> coordonneesEchelles = new ArrayList<>();

    Pane jeu;


    public void mouvement() {

        BorderPane root = new BorderPane();

        mario.setLayoutX(20 * 10);
        mario.setLayoutY(130);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(echelle1);
        jeu.getChildren().add(echelle2);
        jeu.getChildren().add(mario);

        System.out.println(echelle1.getLayoutX());


        echelles.add(echelle1);
        echelles.add(echelle2);

        ArrayList<Double> coordonneesEchelle1 = new ArrayList<>();
        coordonneesEchelle1.add(180.0);
        coordonneesEchelle1.add(80.0);
        ArrayList<Double> coordonneesEchelle2 = new ArrayList<>();
        coordonneesEchelle2.add(30.0);
        coordonneesEchelle2.add(80.0);
        coordonneesEchelles.add(coordonneesEchelle1);
        coordonneesEchelles.add(coordonneesEchelle2);

        move(mario, echelles, coordonneesEchelles);

    }


    private void move(Mario p, ArrayList<Echelle> echelles, ArrayList<ArrayList<Double>> coordonneesEchelles) {
        Deplacement.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:
                    System.out.println("Y : " + p.getLayoutY());
                    System.out.println("X : " + p.getLayoutX() + "\n");
                    if (p.collisionEchelle(echelles) && !(p.estEn(coordonneesEchelles))) {
                        p.directionHaut();
                    }
                    break;
                case LEFT:
                    if (!p.estDansEchelle(coordonneesEchelles)) {
                        p.directionGauche();
                    }
                    break;
                case RIGHT:
                    if (!p.estDansEchelle(coordonneesEchelles)) {
                        p.directionDroite(jeu.getWidth());
                    }
                    break;
                case DOWN:
                    if (p.collisionEchelle(echelles) && !(p.estDansBasEchelle(coordonneesEchelles))) {
                        p.directionBas(jeu.getHeight());
                    }
                    break;
                case SPACE:
                    PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(0.5));
                    p.jump();
                    pause.play();
                    pause.setOnFinished(event1 -> p.atterir());
                    break;
            }

        });
    }



}
