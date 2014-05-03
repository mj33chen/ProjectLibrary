package Xavier_Navarro_Ciurana;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author xwade
 */
public class DriverLibro {
    
    public static void main(String args[]) throws IOException
	{
                
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (in);
        
        Libro l;
        String r;
        String titulo, autor;
        int id;
        System.out.print("--------------------\n");        
        System.out.print("Selecciona la función a probar:\n");
        System.out.print("1:Mostar titulo:\n");
        System.out.print("2:Mostrar autor:\n");
        System.out.print("3:Mostrar id:\n");
        System.out.print("4:Mostrar Temas:\n");
        System.out.print("5:Añadir Temas:\n");
        System.out.print("6:Eliminar Temas:\n");
        System.out.print("--------------------\n");
  
        while(((r = br.readLine()) != null)){
            switch(Integer.parseInt(r)){
            case 1:
                 System.out.print("El titulo del libro es:: " + l.getTitulo() + "\n");
        }
            
            
        }
    
}
