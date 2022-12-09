import java.awt.Image;

import javax.swing.ImageIcon;
public class Adaga {
    private Image adaga;
    private int x,y;
    private int largura,altura;
    private static final int alturaLimit = 900;
    private static int vel = 4;
    private boolean isVisivel;

    public Adaga(int x, int y){
        this.x = x;
        this.y = y;
        isVisivel = true;
    }
    public void load(){
        ImageIcon referencia = new ImageIcon("imagens\\adaga.png");
        adaga = referencia.getImage();

        this.largura = adaga.getWidth(null);
        this.altura = adaga.getHeight(null);
    }
    public void update(){
        this.y += vel;
        if(this.y>alturaLimit){
            isVisivel = false;
        }
    }
    public boolean getVisivel(){
        return this.isVisivel;
    }
    public void setVisivel(boolean isVisivel){
        this.isVisivel = isVisivel;
    }
    public static int getVel(){
        return vel;
    }
    public static void setVel(int velo){
        vel = velo;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Image getImage(){
        return adaga;
    }
}