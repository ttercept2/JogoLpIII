import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
public class Ninja {
    private int x,y;
    private int vel;
    private Image ninja;
    private int largura,altura;

    public Ninja(){
        this.x = 400;
        this.y = 390;
        this.vel = 0;
    }

    public void load(){
        ImageIcon referencia = new ImageIcon("imagens\\charuto.png");
        ninja = referencia.getImage();
        altura = ninja.getHeight(null);
        largura = ninja.getWidth(null);
    }
    public void update(){
        x = x + vel;
    }
    public void keyPressed(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        if(codigo == KeyEvent.VK_LEFT){
            vel = -10;
        }
        if(codigo == KeyEvent.VK_RIGHT){
            vel = +10;
        }
    }
    public void keyRelease(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        if(codigo == KeyEvent.VK_LEFT){
            vel = 0;
        }
        if(codigo == KeyEvent.VK_RIGHT){
            vel = 0;
        }
    }
    public Image getNinja(){
        return ninja;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}