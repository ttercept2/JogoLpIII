
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
//import java.awt.event.ActionListener.actionPerformed;
import java.awt.event.*;  
import javax.swing.*;

public class Fase extends JPanel implements ActionListener{
    private Image fundo;
    private Image chao;
    private Ninja ninja;
    private Timer timer;

    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon referencia = new ImageIcon("imagens\\konoha.jpg");
        fundo = referencia.getImage();
        ImageIcon referencia2 = new ImageIcon("imagens\\layer.png");
        chao = referencia2.getImage();
        ninja = new Ninja();
        ninja.load();
        addKeyListener(new TecladoAdapter());
        timer = new Timer(5,this);
        timer.start();
    }
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo,-100,0,null);
        graficos.drawImage(chao,0,-220,null);
        graficos.drawImage(ninja.getNinja(),ninja.getX(),ninja.getY(),this);
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        ninja.update();
        repaint();
    }
    private class TecladoAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            ninja.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            ninja.keyRelease(e);
        }
    }

}
