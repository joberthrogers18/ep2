package view;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import model.Potencias;

public class TrianguloPoten extends JPanel {

    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int potenciaativa;
    private int potenciareativa;
   

    public TrianguloPoten(int valor_potenciaativa, int valor_potenciareativa) {
        this.potenciaativa = valor_potenciaativa/100;
        this.potenciareativa = valor_potenciareativa/100;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw white background
        g2.setColor(Color.WHITE);
        g2.fillRect(50,0,360,300);
        g2.setColor(Color.BLACK);

       g2.drawLine(50, 150,410, 150);
       g2.drawLine(230, 0, 230 , 300 );
       g2.setColor(lineColor.red); 																
       g2.drawLine(230,150,230 + potenciaativa,150 );
       g2.setColor(lineColor.blue);
       g2.drawLine(230 + potenciaativa,150,230 + potenciaativa,150 - potenciareativa);
       g2.setColor(lineColor.orange);
       g2.drawLine(230 ,150,230 + potenciaativa,150 - potenciareativa );
       
       
   }
    
}