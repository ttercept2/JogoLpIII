
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
public class Fase extends JPanel{
    private Image fundo;
    private Image chao;
    public Fase(){
        ImageIcon referencia = new ImageIcon("imagens\\konoha.jpg");
        fundo = referencia.getImage();
        ImageIcon referencia2 = new ImageIcon("imagens\\layer.png");
        chao = referencia2.getImage();
    }
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo,-100,0,null);
        graficos.drawImage(chao,0,-220,null);
        g.dispose();
    }
}
