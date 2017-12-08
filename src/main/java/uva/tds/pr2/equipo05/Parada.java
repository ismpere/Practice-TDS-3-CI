package uva.tds.pr2.equipo05;

/**
 * Implementación de la clae parada
 * @author martorb
 * @author ismpere
 */
public class Parada{

	/**
	 * Constructor por defecto de la clase parada
	 * @param id Identificador de la parada
	 * @param gd Direccion de la parada
	 * @assert.pre id.length>0 && id.length<=50
	 * @throws IllegalArgumentException si gd==null || id==null
	 */
	public Parada(String id, GD gd) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Devuelve identificador de la parada
	 * @return Id Identificador
	 */
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve la direccion de la parada
	 * @return gd direccion
	 */
	public GD getGD() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Cambia el id de la parada
	 * @param id nuevo identificador
	 * @assert.pre id.length>0 && id.length<=50
	 * @throws IllegalArgumentException si id==null
	 */
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Cambia la direccion de la parada
	 * @param gd Nueva direccion
	 * @throws IllegalArgumentException si gd==null
	 */
	public void setGD(GD gd) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve la distancia en metros entre dos paradas
	 * @param p Parada a la que calcular la distancia desde this
	 * @return distancia entre las paradas
	 * @assert.pre !this.equals(p)
	 * @throws IllegalArgumentException si p==null
	 */
	public double getDistanciaEntre(Parada p) {
		// TODO Auto-generated method stub
		return 0.0;
	}
	/**
	 * Devuelve si hay paradas repetidas en una lista de paradas
	 * @param p lista de paradas
	 * @return hayParadasRepetidas
	 * @throws IllegalArgumentException si alguna de las paradas es null
	 */
	public static boolean existeAlgunaParadaRepetida(Parada[] p) {
		// TODO Auto-generated method stub
		return false;
	}
	
}