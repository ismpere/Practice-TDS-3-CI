package uva.tds.pr2.equipo05;

/**
 * Implementacion de la clase GD, que es una direccion en grados decimales
 * @author ismpere
 * @author martorb
 */
public class GD{
	
	private double latitud;
	private double longitud;
	private static final double RADIO_TIERRA = 6371.00;
	/**
	 * Constructor por defecto de GD
	 * @param latitud
	 * @param longitud
	 * @assert.pre latitud>-180.00 && latitud<180.00
	 * @assert.pre longitud>-180.00 && longitud<180.00
	 */
	public GD(double latitud, double longitud) {
		assert(latitud>-180.00 && latitud<180.00);
		assert(longitud>-180.00 && longitud<180.00);
		
		this.latitud = latitud;
		this.longitud = longitud;
	}
	/**
	 * Devuelve la latitud de la direccion
	 * @return latitud
	 */
	public double getLatitud() {
		return latitud;
	}
	/**
	 * Devuelve la longitud de la direccion
	 * @return longitud
	 */
	public double getLongitud() {
		return longitud;
	}
	/**
	 * Cambia la latitud de la direccion 
	 * @param latitud nueva
	 * @assert.pre latitud>-180.00 && latitud<180.00
	 */
	public void setLatitud(double latitud) {
		assert(latitud>-180.00 && latitud<180.00);
		
		this.latitud = latitud;
	}
	/**
	 * Cambia la longitud de la direccion
	 * @param longitud nueva
	 * @assert.pre longitud>-180.00 && longitud<180.00
	 */
	public void setLongitud(double longitud) {
		assert(longitud>-180.00 && longitud<180.00);
		
		this.longitud = longitud;
	}
	/**
	 * Devuelve la distancia de this a gd en metros
	 * @param gd Direccion a la que queremos calcular la distancia desde this
	 * @return distancia en metros
	 * @throws IllegalArgumentException si gd=null
	 */
	public double getDistanciaAt(GD gd) {
		if(gd==null)
			throw new IllegalArgumentException("gd is null");
		
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
	}
}