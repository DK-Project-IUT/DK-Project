package start.structure.Model;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Echelle extends Group {

    private final Rectangle collision;
    private Rectangle echelle;

    /**
     * Constructeur de la classe Echelle
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Echelle(int x, int y, int width, int height) {
        this.echelle = new Rectangle(x, y, width, height);
        this.collision = new Rectangle(x - 10, y - 35, (width + 20), (height + 35));
     //   collision.setFill(Paint.valueOf("red"));
        echelle.setFill(new ImagePattern(new Image("echelle2.png")));
        collision.setOpacity(0.5);
        this.getChildren().add(echelle);
        this.getChildren().add(collision);
    }

    public static int getLargeurCollision() {
        return 15;
    }

    public Rectangle getEchelle() {
        return echelle;
    }

    public void setEchelle(Rectangle echelle) {
        this.echelle = echelle;
    }
}