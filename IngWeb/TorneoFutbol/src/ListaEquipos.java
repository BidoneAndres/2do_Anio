import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class ListaEquipos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaEquipos
{
    // instance variables - replace the example below with your own
    private ArrayList<Equipo> equipos;
    /**
     * Constructor for objects of class ListaEquipos
     */
    public ListaEquipos(){
        equipos=new ArrayList<Equipo>();
        Scanner console=new Scanner(System.in);
        System.out.println("Ingrese la cantidad de equipos\t debe ser par.");
        int cantidad=console.nextInt();
        for(int i=0;i<cantidad;i++){
            setLista(new Equipo("Nombre "+i));
        }
    }
    private void setLista(Equipo e){
        equipos.add(e);
    }
    public List<Equipo> getLista(){
        return equipos;
    }
}
