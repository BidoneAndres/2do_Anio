import java.util.HashMap;
import java.util.Map;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private Map<Equipo,Integer> goles;
    private Estado estado;
    
    /**
     * Crea cada encuentro en base a los equipos indicados y
     * establece el estado del partido a NoDisputado().
     * Los goles se registran en un mapa donde la clave es el
     * equipo y el valor es la cantidad de goles.
     * 
     * @param equipo1 Uno de los equipos.
     * @param equipo2 El otro de los equipos.
     */
    public Partido (Equipo equipo1, Equipo equipo2){
        // TODO Implementar constructor (inicializar colecciones)
        // No modificar la siguiente linea
        estado = new NoDisputado();
        this.equipo1=equipo1;//Registro el primer equipo.
        this.equipo2=equipo2;//Registro el segundo equipo.
        goles= new HashMap<Equipo, Integer>();//Inicializo el mapa que lleva la contabilidad de los goles.
        goles.put(equipo1,0);//Añado los equipos al mapa.
        goles.put(equipo2,0);
    }

    /**
     * Anota un gol al equipo que lo haya realizado a través
     * del objeto en el campo estado. Tambien debe registrar
     * el gol en sus estadisticas el equipo correspondiente.
     * 
     * @param e El equipo que hizo el gol.
     */
    public void addGol (Equipo e) {
        // TODO Implementar cuenta de goles
        estado.addGol(e);
        e.addGol();
        
    }

    /**
     * Establece el estado del partido a EnJuego.
     */
    public void setEnJuego () {
        estado = new EnJuego();
        System.out.println("El partido a comenzado!!! ("+equipo1.getNombre()+" vs "+equipo2.getNombre()+")");
    }

    /**
     * Establece el estado del partido en Finalizado
     * y actualiza estadisticas de partidos disputados
     * y puntajes de cada equipo.
     */
    public void setFinalizado () {
        // TODO Implementar actualizacion de partidos disputados y puntajes
        // No modificar la siguiente linea
        System.out.println("El partido a finalizado " +equipo1.getNombre()+"["+goles.getOrDefault(equipo1,0)+"-"+goles.getOrDefault(equipo2,0)+"]"+equipo2.getNombre());
        estado = new Finalizado();
        equipo1.addPartidosDisputados();
        equipo2.addPartidosDisputados();
        estado.CalcularPuntajes();
    }

    /**
     * Devuelve verdadero si el partido está en estado finalizado.
     * 
     * @return boolean true si el partido ha finalizado.
     */
    public boolean isFinalizado(){
        
        return estado.isFinalizado();
    }

    public String toString () {
        return estado.toString();
    }

    // Patron state
    private abstract class Estado {
        /**
         * Devuelve los goles por equipo del partido.
         * Ej.: Goleadores 1 - SuperGol 2
         * 
         * @return String Los goles por equipo del partido.
         */
        public String toString () {
            return equipo1.getNombre() + " " + goles.get(equipo1).toString() + " - " + equipo2.getNombre() + " " + goles.get(equipo2).toString();
        }
        public void addGol (Equipo e) {
            throw new IllegalStateException(this.toString());
        }
        public void CalcularPuntajes (){
            throw new IllegalStateException(this.toString());
        }
        public boolean isFinalizado () {
            return false;
        }
    }

    private class NoDisputado extends Estado {
        public String toString () {
            return "Partido no disputado - (" + equipo1.getNombre() + " vs " + equipo2.getNombre() + ")";
        }
    }

    private class EnJuego extends Estado {
        public String toString () {
            return "En juego: " + super.toString();
        }
        @Override
        public void addGol (Equipo e) {
            goles.replace(e, goles.get(e) + 1);
            System.out.println("GOOOOOOOLLL!!! Del equipo "+e.getNombre()+"!!!!");
        }
    }

    private class Finalizado extends Estado {
        public String toString () {
            return "Finalizado: " + super.toString();
        }

        /**
         * Otorga 3 puntos al equipo ganador y 0 al equipo perdedor.
         * En caso de empate otorga 1 punto a cada equipo.
         * (addPuntoje() de Equipo)
         */
        public void CalcularPuntajes (){
            // TODO Implementar la asignacion de puntajes a los equipos
            if(goles.getOrDefault(equipo1,0)>goles.getOrDefault(equipo2,0)){
                equipo1.addPuntaje(3);//Comparamos la cantidad de goles por equipo, y le sumamos 3 al que haya convertido la mayor cantidad.
            }else if(goles.getOrDefault(equipo1,0)<goles.getOrDefault(equipo2,0)){
                equipo2.addPuntaje(3);
            }else if(goles.getOrDefault(equipo1,0)==goles.getOrDefault(equipo2,0)){
                equipo1.addPuntaje(1);
                equipo2.addPuntaje(1);//Comparamos que la cantidad de goles convertidos sean iguales y lo son.
            }
            
        }

        @Override
        public boolean isFinalizado () {
            return true;
        }
    }
}
