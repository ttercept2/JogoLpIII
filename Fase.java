
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
public class Fase extends JPanel{
    private Image fundo;
    public Fase(){
        ImageIcon referencia = new ImageIcon("imagens\\konoha.jpg");
        fundo = referencia.getImage();
    }
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo,-100,0,null);
        g.dispose();
    }
}
