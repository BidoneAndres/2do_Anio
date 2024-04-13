

 
public class Equipo implements Comparable<Equipo> {
    private String nombre;
    private Integer puntaje;
    private Integer partidosDisputados;
    private Integer goles;

    /**
     * Representa a los equipos que participan del torneo.
     * El nombre debe guardarse sin espacios en blanco al
     * principio y al final.
     * 
     * @param nombre El nombre del equipo de futbol.
     */
    public Equipo (String nombre) {
        // TODO Implementar constructor
        this.nombre=nombre;//Esta funcion es utilizada para sacar los espacios al principio y al final del nombre.
        puntaje=0;
        goles=0;
        partidosDisputados=0;
    }
    /**
     * Devuelve la informacion estadistica del equipo.
     * 
     * Ej.: Para el equipo "Goleadores" que lleva jugados 4 partidos
     *      con 7 puntos y 6 goles debe devolver la cadena
     * 
     *      Equipo: Golazo
     *              Puntaje: 7
     *              Partidos: 4
     *              Goles: 6
     * 
     * @return String La informacion sobre el equipo de futbol
     */
    public String getInformacionEquipo() {
        // TODO implementar el string correspondiente
        return "Equipo: \nNombre: "+nombre+"\nPartidos Disputados: "+ partidosDisputados+"\nGoles: "+goles+"\nPuntaje: "+puntaje;
    }
    
    public String getNombre () {
        return nombre;
    }

    /**
     * Incrementa en uno la cantidad de goles realizados
     * por el equipo.
     */
    public void addGol () {
        // TODO Implementar cuenta de goles
        goles+=1;
    }

    public Integer getGoles() {
        return goles;
    }

    /**
     * Incrementa el puntaje acumulado por el equipo
     * durante el torneo.
     * 
     * @param puntaje El puntaje a incrementar.
     */
    public void addPuntaje(Integer puntaje) {//Sumo la cantidad de puntos segun el resulatado del partido.
        // TODO Implementar suma de puntaje
        this.puntaje+=puntaje;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    /**
     * Incrementa en uno la cantidad de partidos jugados
     * por el equipo.
     */
    public void addPartidosDisputados() {
        // TODO Implementar cuenta de partidos jugados
        partidosDisputados+=1;
    }

    public Integer getPartidosDisputados() {
        return partidosDisputados;
    }

    /**
     * Devuelve la informacion acerca del equipo.
     * 
     * @return String La informacion acerca del equipo.
     */
    @Override
    public String toString () {
        return getInformacionEquipo();
    }

    /**
     * Resuelve el ordenamiento en las colecciones.
     * Ordena primero por puntos, luego por cantidad de goles 
     * partidos disputados y, finalmente, por nombre.
     */
    public int compareTo (Equipo e) {
        int r;
        r = getPuntaje().compareTo(e.getPuntaje());
        if (r == 0) {
            r = getGoles().compareTo(e.getGoles());
        }
        if (r == 0) {
            r = getPartidosDisputados().compareTo(e.getPartidosDisputados());
        }
        if (r == 0) {
            r = getNombre().compareTo(e.getNombre());
        }
        // La inversion de signo es para cambiar orden
        return -r;
    }

}
