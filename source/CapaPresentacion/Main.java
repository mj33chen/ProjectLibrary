package com.company;

import CapaPresentacion.VistaAsignarTemas;
import CapaPresentacion.VistaColeccionLibros;
import CapaPresentacion.VistaLibro;

import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new VistaColeccionLibros());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

}
