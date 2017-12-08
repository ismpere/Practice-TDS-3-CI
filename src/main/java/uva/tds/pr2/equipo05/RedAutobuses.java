package uva.tds.pr2.equipo05;

/**
 * 
 * @author martorb
 * @author ismpere
 *
 */
public class RedAutobuses {
	
	/**
	 * Constructor por defecto de la clase RedAutobuses
	 * @param lista_lineas Lista (array) que contiene las líenas iniciales de la red
	 * @assert.pre lista_lineas.length>1
	 * @assert.pre !Linea.lineasRepetidas(lista_lineas)
	 * @throws IllegalArgumentException si lista_lineas==null || alguna de las lineas de la lista es null
	 */
	public RedAutobuses(Linea[] lista_lineas){
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Devuelve una línea de la red a partir de su identificador
	 * @param id Número que identifica la línea
	 * @return líneaBuscada
	 * @assert.pre this.contains(id)
	 * @assert.post red.contains(linea) && linea.getId()==id
	 */
	public Linea getLinea(int id){
		// TODO Auto-generated constructor stub
		return null;
	}
	
	/**
	 * Añade una línea a la red 
	 * @param linea Línea a añadir
	 * @assert.pre !red.contains(linea)
	 * @throws IllegalArgumentException si linea==null
	 */
	public void addLinea(Linea linea){
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Elimina una línea de la red
	 * @param linea Línea a eliminar
	 * @assert.pre this.contains(linea)
	 * @assert.pre getLineas.length>2
	 * @assert.post !(red.contains(linea)) && red.getAllLineas.length>1
	 * @throws IllegalArgumentException si linea==null
	 */
	public void deleteLinea(Linea linea){
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Devuelve la lista (array) de todas las líneas de la red
	 * @return lineasRed[]
	 */
	public Linea[] getAllLineas(){
		// TODO Auto-generated constructor stub
		return null;
	}
	
	/**
	 * Devuelve una lista (array) con las líneas que tienen alguna parada dentro de la región indicada
	 * @param direccion Punto dede el que se buscan líneas con parada cercana
	 * @param radio (en metros) Distancia máxima desde la dirección indicada hasta alguna parada de las líneas buscadas
	 * @return lineasEncontradas[]
	 * @assert.pre radio>=0
	 * @throws IllegalArgumentException si direccion==null
	 */
	public Linea[] getLineasConParadasCercanas(GD direccion, double radio){
		return null;
	}
	
	/**
	 * Comprueba si la red contiene una determinada línea
	 * @param linea
	 * @return contieneLinea
	 * @throws IllegalArgumentException si linea==null
	 */
	public boolean contains(Linea linea){
		// TODO Auto-generated constructor stub
		return false;
	}
	/**
	 * Devuelve si contiene una linea con identificador id
	 * @param id identificador de la linea
	 * @return contieneLineaConId
	 */
	public boolean contains(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Devuelve si hay Lineas con paradas cercanas a una direccion con un radio de distancia maxima
	 * @param gd Direccion
	 * @param radio de distancia
	 * @return existenLineasConparadasCercanas
	 * @assert.pre radio>=0
	 * @throws IllegalArgumentException si gd==null
	 */
	public boolean existenLineasConParadasCercanas(GD gd, double radio) {
		// TODO Auto-generated method stub
		return false;
	}	
}
