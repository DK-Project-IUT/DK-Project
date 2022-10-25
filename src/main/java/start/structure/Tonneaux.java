package start.structure;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Tonneaux extends Group {
    private final Rectangle corps;
    protected final static double LARGEUR_MOITIE_TONNEAUX = 5;
    protected final static double LARGEUR_TONNEAUX = LARGEUR_MOITIE_TONNEAUX * 2;

    /**
     * Constructeur de la classe Tonneaux
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Tonneaux(int x, int y, int width, int height) {
        corps = new Rectangle(x, y, width, height);
        corps.setFill(Paint.valueOf("brown"));
        corps.setFill(new ImagePattern(new Image("tonneau1.png")));

        this.getChildren().add(corps);
    }

    /**
     * Méthode qui permet tonneaux direction Droite
     * @param largeurJeu
     */
    public void directionDroite(double largeurJeu) {
        setLayoutX(getLayoutX() + LARGEUR_TONNEAUX / 5);
    }

    /**
     * Méthode qui permet tonneaux direction Gauche
     */
    public void directionGauche() {
        setLayoutX(getLayoutX() - LARGEUR_TONNEAUX / 5);
    }

    /**
     * Méthode qui permet de faire bouger le tonneaux vers le bas
     */
    public void directionBas() {
        setLayoutY(getLayoutY() + LARGEUR_TONNEAUX / 5);
    }

    /**
     * Méthode qui permet la collision echelle avec tonneaux
     * @param coordonneesEchelles
     * @return
     */
    public boolean collisionEchelleTonneau(ArrayList<ArrayList<Double>> coordonneesEchelles) {
        for (int i = 0; i < coordonneesEchelles.size(); i++) {
            Double coordoneesX = coordonneesEchelles.get(i).get(0);
            Double coordonneesY = (coordonneesEchelles.get(i).get(1));
            if (coordoneesX % 2 == 1) {
                coordoneesX++;
            }
            if (coordonneesY % 2 == 1) {
                coordonneesY++;
            }
            if (this.getLayoutX() == coordoneesX && this.getLayoutY() == coordonneesY + 10) {
                return true;
            }
        }
        return false;
    }

    public void tombe() {

    }
}