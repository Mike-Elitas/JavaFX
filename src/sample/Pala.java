package sample;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pala {
    class Posicio {
        int posX;
        int posY;

        public Posicio(int x, int y) {
            this.posX = x;
            this.posY = y;
        }
    }

    Pala.Posicio posicio;
    int velocitat = 10;
    Pane panell;
    Node pala;
    int ample=20;
    int alt=100;

    public Pala(Pane panell, int posX, int posY) {
        posicio = new Pala.Posicio(posX, posY);
        this.panell = panell;
        this.pala = new Rectangle(ample, alt, Color.WHITE);
        posicio.posX = 0;
        posicio.posY = 0;
        this.pala.setLayoutX(posicio.posX);
        this.pala.setLayoutY(posicio.posY);
        this.panell.getChildren().add(this.pala);
    }
    public void mouAmunt() {
        posicio.posY=posicio.posY-this.velocitat;
        this.repinta();
        System.out.println("Amunt pitjat");
    }
    public void mouAbaix() {
        posicio.posY=posicio.posY+this.velocitat;
        this.repinta();
        System.out.println("Abaix pitjat");
    }
    private void repinta() {
        this.pala.setLayoutX(posicio.posX);
        this.pala.setLayoutY(posicio.posY);
    }
}

