package uva.tds.pr2.equipo05;

import java.util.ArrayList;

/**
 * Implementación de la clae parada
 * @author martorb
 * @author ismpere
 */
public class Parada{
	
	private String id;
	private GD gd;
	/**
	 * Constructor por defecto de la clase parada
	 * @param id Identificador de la parada
	 * @param gd Direccion de la parada
	 * @assert.pre id.length>0 && id.length<=50
	 * @throws IllegalArgumentException si gd==null || id==null
	 */
	public Parada(String id, GD gd) {
		if(id==null || gd==null)
			throw new IllegalArgumentException();
		
		assert(id.length()>0 && id.length()<=50);
		
		this.id = id;
		this.gd = gd;
	}
	
	/**
	 * Devuelve identificador de la parada
	 * @return Id Identificador
	 */
	public String getId() {
		return id;
	}

	/**
	 * Devuelve la direccion de la parada
	 * @return gd direccion
	 */
	public GD getGD() {
		return gd;
	}
	/**
	 * Cambia el id de la parada
	 * @param id nuevo identificador
	 * @assert.pre id.length>0 && id.length<=50
	 * @throws IllegalArgumentException si id==null
	 */
	public void setId(String id) {
		if(id==null)
			throw new IllegalArgumentException();
		
		assert(id.length()>0 && id.length()<=50);
		
		this.id = id;
	}
	/**
	 * Cambia la direccion de la parada
	 * @param gd Nueva direccion
	 * @throws IllegalArgumentException si gd==null
	 */
	public void setGD(GD gd) {
		if(gd==null)
			throw new IllegalArgumentException();
		
		this.gd = gd;
	}
	/**
	 * Devuelve la distancia en metros entre dos paradas
	 * @param p Parada a la que calcular la distancia desde this
	 * @return distancia entre las paradas
	 * @throws IllegalArgumentException si p==null
	 */
	public double getDistanciaEntre(Parada p) {
		if(p==null)
			throw new IllegalArgumentException();
		
		if(p==this)
			return 0.0;
		
		return gd.getDistanciaAt(p.getGD());
	}
	/**
	 * Devuelve si hay paradas repetidas en una lista de paradas
	 * @param p lista de paradas
	 * @return hayParadasRepetidas
	 * @throws IllegalArgumentException si alguna de las paradas es null
	 */
	public static boolean existeAlgunaParadaRepetida(Parada[] p) {
		if(p==null)
			throw new IllegalArgumentException();
		
		if(p.length<2)
			return false;
		else{
			boolean repetida = false;
			ArrayList<Parada> conjuntoAux = new ArrayList<>();
			
			for(int i=0; i<p.length; i++){
				if(conjuntoAux.contains(p[i]))
					repetida = true;
				else
					conjuntoAux.add(p[i]);
			}
			return repetida;
		}
	}
	
	@Override
	public boolean equals(Object other){
	    if (other == null) 
	    	return false;
	    if (other == this) 
	    	return true;
	    if (!(other instanceof Parada))
	    	return false;
	    
	    return gd.equals(((Parada)other).getGD());
	}
}