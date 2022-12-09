
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
//import java.awt.event.ActionListener.actionPerformed;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Fase extends JPanel implements ActionListener{
    private Image fundo;
    private Image chao;
    private Ninja ninja;
    private Timer timer;
    private List<Adaga> adaga;

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
        timer = new Timer(3,this);
        timer.start();
        inicializaAdagas();
    }

    public void inicializaAdagas(){
        int cordenadas [] = new int [70];
        adaga = new ArrayList<Adaga>();

        for(int i = 0; i<cordenadas.length;i++){
            int x = (int)(Math.random()*710);
            int y = (int)(Math.random()*8000+600);
            adaga.add(new Adaga(x,-y));
        }
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo,-100,0,null);
        graficos.drawImage(chao,0,-220,null);
        graficos.drawImage(ninja.getNinja(),ninja.getX(),ninja.getY(),this);
        for (int i = 0; i < adaga.size();i++){
            Adaga in = adaga.get(i);
            in.load();
            graficos.drawImage(in.getImage(), in.getX(), in.getY(),this);
        }
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        ninja.update();
        for (int i = 0; i < adaga.size();i++){
            Adaga in = adaga.get(i);
            if(in.getVisivel()){
                in.update();
            }else {
                adaga.remove(i);
            }
        }
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
