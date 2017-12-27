package uva.tds.pr2.equipo05;

/**
 * 
 * @author ismpere
 * @author martorb
 *
 */
public class Linea{
	/**
	 * Constructor por defecto de la clase Linea
	 * @param id de la Linea
	 * @param p Paradas de la linea
	 * @assert.pre p.length>3
	 * @assert.pre !Parada.existeAlgunaParadaRepetida(p)
	 * @throws IllegalArgumentException si p==null || alguna de las paradas de p es null
	 */
	public Linea(int id, Parada[] p) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Devuelve el identificador de la linea
	 * @return id de la Linea
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Devuelve la lista de paradas de la linea
	 * @return paradas de la Linea
	 */
	public Parada[] getParadas() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve la parada inicial de la linea
	 * @return parada inicio
	 */
	public Parada getParadaInicio() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve la parada final de la linea
	 * @return parada fin
	 */
	public Parada getParadaFin() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Añade una nueva parada a la Linea
	 * @param p Parada a añadir
	 * @assert.pre !contains(p)
	 * @throws IllegalArgumentException si p==null
	 */
	public void addParadaIntermedia(Parada p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Cambia el identificador de la linea
	 * @param id Nuevo identificador de la Linea
	 */
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Cambia la parada ininio de la linea
	 * @param p Nueva parada Inicio
	 * @assert.pre !contains(p)
	 * @assert.pre p.getDistanciaAt(getParadaFin)<100
	 * @throws IllegalArgumentException si p==null
	 */
	public void setParadaInicio(Parada p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Cambia la parada fin de la linea
	 * @param p Nueva parada Fin
	 * @assert.pre !contains(p)
	 * @assert.pre p.getDistanciaAt(getParadaInicio)<100
	 * @throws IllegalArgumentException si p==null
	 */
	public void setParadaFin(Parada p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Añade la parada intermedia en la posicion seleccionada
	 * @param p Parada intermedia a añadir
	 * @param i Posicion en la que se va a añadir
	 * @assert.pre !contains(p)
	 * @assert.pre i>1 && i<getParadas.length
	 * @throws IllegalArgumentException si p==null
	 */
	public void addParadaIntermediaAt(Parada p, int i) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Elimina la parada intermedia de la linea
	 * @param p Parada a eliminar
	 * @assert.pre contains(p)
	 * @assert.pre getParadas.length>3
	 * @assert.pre !p.equals(getParadaInicio) && !p.equals(getParadaFin)
	 * @throws IllegalArgumentException si p==null
	 */
	public void removeParadaIntermedia(Parada p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve una lista de paradas de la linea cercanas a una direccion
	 * La lista estara vacia si no hay ninguna parada cercana
	 * @param gd Direccion desde la que queremos hallar las paradas cercanas
	 * @return paradas cercanas a esa direccion
	 * @throws IllegalArgumentException si gd==null
	 */
	public Parada[] getParadasCercanas(GD gd) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve si hay parads cercanas de esa linea a una direccion
	 * @param gd Direccion desde la que queremos comprobar si hay paradas cercanas
	 * @return existenParadasCercanas
	 * @throws IllegalArgumentException si gd==null
	 */
	public boolean existeParadasCercanas(GD gd) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Devuelve la lista de paradas con correspondencia de this con l
	 * Esta lista estara vacia si no hay ninguna parada con correspondencia con l
	 * @param l Linea con la que queremos hallar las paradas con correspondencia
	 * @return paradas con correspondencia de this con l
	 * @assert.pre !this.equals(l)
	 * @throws IllegalArgumentException si l==null
	 */
	public Parada[] getParadasConCorrespondencia(Linea l) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve si hay o no correspondencia de this con l
	 * @param l Linea con la que queremos hallar si hay correspondencia
	 * @return hayCorrespondencia
	 * @assert.pre !this.equals(l)
	 * @throws IllegalArgumentException si l==null
	 */
	public boolean existeCorrespondencia(Linea l) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Devuelve la lista de paradas con transbordo directo de this con l
	 * Esta lista estara vacia si no hay ninguna parada con transbordo directo
	 * @param l Linea con la que queremos hallar las paradas con transbordo directo
	 * @return paradas con transbordo directo
	 * @assert.pre !this.equals(l)
	 * @throws IllegalArgumentException si l==null
	 */
	public Parada[] getParadasConTransbordoDirecto(Linea l) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve si hay transbordo directo entre this y l
	 * @param l Linea con la que queremos hallar si hay transbordo directo
	 * @return existeTransbordoDirecto
	 * @assert.pre !this.equals(l)
	 * @throws IllegalArgumentException si l==null
	 */
	public boolean existeTransbordoDirecto(Linea l) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Devuelve si la linea contiene una parada
	 * @param p Parada a comprobar que contiene
	 * @return contieneParada
	 * @throws IllegalArgumentException si p==null
	 */
	public boolean contains(Parada p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Comprueba si en una lista (array) existen líneas repetidas
	 * @param lista_lineas lista a comprobar
	 * @return hayLineaRepetida
	 * @throws IllegalArgumentException si lista_lineas==null || alguna de las lineas de la lista es null
	 */
	public static boolean lineasRepetidas(Linea[] lista_lineas){
		// TODO Auto-generated constructor stub
		return false;
	}
	
}