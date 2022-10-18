package start.structure;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class StartGame extends Application {
    private Scene s;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Mario mario = new Mario(20, 0, 20, 20);
        Echelle echelle1 = new Echelle(50, 100, 20, 50, 0);
        Echelle echelle2 = new Echelle(200, 100, 20, 50, 0);
        mario.setLayoutX(20 * 10);
        mario.setLayoutY(130);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(echelle1);
        jeu.getChildren().add(echelle2);
        jeu.getChildren().add(mario);

        System.out.println(echelle1.getLayoutX());

        ArrayList<Echelle> echelles = new ArrayList<>();
        echelles.add(echelle1);
        echelles.add(echelle2);

        ArrayList<ArrayList<Double>> coordonneesEchelles = new ArrayList<>();
        ArrayList<Double> coordonneesEchelle1 = new ArrayList<>();
        coordonneesEchelle1.add(180.0);
        coordonneesEchelle1.add(80.0);
        ArrayList<Double> coordonneesEchelle2 = new ArrayList<>();
        coordonneesEchelle2.add(30.0);
        coordonneesEchelle2.add(80.0);
        coordonneesEchelles.add(coordonneesEchelle1);
        coordonneesEchelles.add(coordonneesEchelle2);


        root.setCenter(jeu);
        s = new Scene(root);
        move(mario, echelles, coordonneesEchelles);
        stage.setScene(s);
        stage.show();

    }

    private void move(Mario p, ArrayList<Echelle> echelles, ArrayList<ArrayList<Double>> coordonneesEchelles) {
        s.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:
                    System.out.println("Y : " + p.getLayoutY());
                    System.out.println("X : " + p.getLayoutX() + "\n");
                    if(p.collisionEchelle(echelles) && !(p.estEn(coordonneesEchelles))) {
                        p.directionHaut();
                    }
                    break;
                case LEFT:
                    if(!p.estDansEchelle(coordonneesEchelles)){
                        p.directionGauche();
                    }
                    break;
                case RIGHT:
                    if(!p.estDansEchelle(coordonneesEchelles)){
                        p.directionDroite(s.getWidth());
                    }
                    break;
                case DOWN:
                    if(p.collisionEchelle(echelles)) {
                        p.directionBas(s.getHeight());
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



    public static void main(String[] args) {
        launch();
    }
}