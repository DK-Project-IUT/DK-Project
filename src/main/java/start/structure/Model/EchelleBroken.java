package start.structure.Model;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class EchelleBroken extends Group {

    private final Rectangle echelle;
    private final Rectangle collision;
    private static String choixEchelleBroken = "echelle_broken_koala.png";

    /**
     * Constructeur de la classe EchelleBroken
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public EchelleBroken(int x, int y, int width, int height) {
        this.echelle = new Rectangle(x, y, width, height);
        this.collision = new Rectangle(x - 10, y, (width + 20), (height));
        collision.setFill(Paint.valueOf("red"));
        echelle.setFill(new ImagePattern(new Image(choixEchelleBroken)));
        collision.setOpacity(0);
        this.getChildren().add(echelle);
        this.getChildren().add(collision);
    }

    public static String getChoixEchelleBroken() {
        return choixEchelleBroken;
    }

    public static void setChoixEchelleBroken(String choixEchelleBroken) {
        EchelleBroken.choixEchelleBroken = choixEchelleBroken;
    }
}