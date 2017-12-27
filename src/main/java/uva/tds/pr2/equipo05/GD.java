package uva.tds.pr2.equipo05;

/**
 * Implementacion de la clase GD, que es una direccion en grados decimales
 * @author ismpere
 * @author martorb
 */
public class GD{
	/**
	 * Cosntructor por defecto de GD
	 * @param latitud
	 * @param longitud
	 * @assert.pre latitud>-180.00 && latitud<180.00
	 * @assert.pre longitud>-180.00 && longitud<180.00
	 * @throws IllegalArgumentException si latitud==null || longitud ==null
	 */
	public GD(double latitud, double longitud) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Devuelve la latitud de la direccion
	 * @return latitud
	 */
	public double getLatitud() {
		// TODO Auto-generated method stub
		return 0.0;
	}
	/**
	 * Devuelve la longitud de la direccion
	 * @return longitud
	 */
	public double getLongitud() {
		// TODO Auto-generated method stub
		return 0.0;
	}
	/**
	 * Cambia la latitud de la direccion 
	 * @param latitud nueva
	 * @assert.pre latitud>-180.00 && latitud<180.00
	 */
	public void setLatitud(double latitud) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Cambia la longitud de la direccion
	 * @param longitud nueva
	 * @assert.pre longitud>-180.00 && longitud<180.00
	 */
	public void setLongitud(double longitud) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Devuelve la distancia de this a gd en metros
	 * @param gd Direccion a la que queremos calcular la distancia desde this
	 * @return distancia en metros
	 * @assert.pre gd!=null
	 */
	public double getDistanciaAt(GD gd) {
<<<<<<< HEAD
		assert(gd!=null);
		if(gd==this || gd.equals(this))
			return 0.0;

		double distancia;
		double difLat;
		double difLong;
		double a; 
		double b; 
		double c; 
		double d;
		
		difLat = Math.toRadians(gd.getLatitud() - latitud);
		difLong = Math.toRadians(gd.getLongitud() - longitud);
		
		a = Math.pow(Math.sin(difLat/2), 2);
		b = Math.pow(Math.sin(difLong/2), 2);
		c = a + (Math.cos(latitud)*Math.cos(gd.getLatitud())*b);
		d = 2 * Math.atan2(Math.sqrt(c), Math.sqrt(1-c));
		
		distancia = RADIO_TIERRA * d;
		
		return (distancia*1000);
=======
		// TODO Auto-generated method stub
		return 0.0;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	
}