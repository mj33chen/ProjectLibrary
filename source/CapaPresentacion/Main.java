package com.company;

//import CapaPresentacion.ControladorPresentacion;
import CapaPresentacion.*;


public class PROP_Biblioteca
{
    public static void main(String argc[]) {
        javax.swing.SwingUtilities.invokeLater(
            new Runnable() {
            public void run() {
              ControladorPresentacion controlPre = new ControladorPresentacion();
              controlPre.initPresentation();
        }});
    }

}
/*import javax.swing.*;

public class PROP_Biblioteca {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new VistaLibro());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

}*/
