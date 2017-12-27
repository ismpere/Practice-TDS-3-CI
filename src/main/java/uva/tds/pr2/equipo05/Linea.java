package uva.tds.pr2.equipo05;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

=======
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
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
<<<<<<< HEAD
	 * @param paradas de la linea
	 * @assert.pre paradas!=null && paradas.length>2
	 * @assert.pre paradas[] !contains null
	 * @assert.pre !Parada.existeAlgunaParadaRepetida(paradas)
	 * @assert.pre paradas[0].getDistanciaEntre(paradas[paradas.length-1])<100
	 */
	public Linea(int id, Parada[] paradas) {
		assert(paradas!=null && paradas.length>2);
		assert(!Arrays.asList(paradas).contains(null));
		assert(!Parada.existeAlgunaParadaRepetida(paradas));
		assert(paradas[0].getDistanciaEntre(paradas[paradas.length-1])<100.00);
		
		this.id = id;
		this.paradas = new ArrayList<>(Arrays.asList(paradas));
=======
	 * @param p Paradas de la linea
	 * @assert.pre p.length>3
	 * @assert.pre !Parada.existeAlgunaParadaRepetida(p)
	 * @throws IllegalArgumentException si p==null || alguna de las paradas de p es null
	 */
	public Linea(int id, Parada[] p) {
		// TODO Auto-generated constructor stub
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
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
	 * @assert p!=null
	 * @assert.pre !contains(p)
	 */
	public void addParadaIntermedia(Parada p) {
<<<<<<< HEAD
		assert(p!=null);
		assert(!contains(p));
		
		double dMin;
		double dAux1; 
		double dAux2;
		int iP = 1;
=======
		// TODO Auto-generated method stub
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
		
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
	 * @assert.pre p!=null && !contains(p)
	 * @assert.pre p.getDistanciaAt(getParadaFin)<100
	 */
	public void setParadaInicio(Parada p) {
<<<<<<< HEAD
		assert(p!=null && !contains(p));
		assert(p.getDistanciaEntre(getParadaFin())<100);
=======
		// TODO Auto-generated method stub
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
		
	}
	/**
	 * Cambia la parada fin de la linea
	 * @param p Nueva parada Fin
	 * @assert.pre p!=null && !contains(p)
	 * @assert.pre p.getDistanciaAt(getParadaInicio)<100
	 */
	public void setParadaFin(Parada p) {
<<<<<<< HEAD
		assert(p!=null && !contains(p));
		assert(p.getDistanciaEntre(getParadaInicio())<100);
		
		paradas.add(p);
=======
		// TODO Auto-generated method stub
		
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	/**
	 * Añade la parada intermedia en la posicion seleccionada
	 * @param p Parada intermedia a añadir
	 * @param i Posicion en la que se va a añadir
	 * @assert.pre p!=null && !contains(p)
	 * @assert.pre i>1 && i<getParadas.length
	 */
	public void addParadaIntermediaAt(Parada p, int i) {
<<<<<<< HEAD
		assert(p!=null && !contains(p));
		assert(i>1 && i<paradas.size()+1);
=======
		// TODO Auto-generated method stub
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
		
	}
	/**
	 * Elimina la parada intermedia de la linea
	 * @param p Parada a eliminar
	 * @assert.pre p!=null && contains(p)
	 * @assert.pre getParadas.length>3
	 * @assert.pre !p.equals(getParadaInicio) && !p.equals(getParadaFin)
	 * @throws IllegalArgumentException si p==null
	 */
	public void removeParadaIntermedia(Parada p) {
<<<<<<< HEAD
		assert(p!=null && contains(p));
		assert(paradas.size()>3);
		assert(!p.equals(getParadaInicio()) && !p.equals(getParadaFin()));
		
		paradas.remove(p);
=======
		// TODO Auto-generated method stub
		
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	/**
	 * Devuelve una lista de paradas de la linea cercanas a una direccion
	 * La lista estara vacia si no hay ninguna parada cercana
	 * @param gd Direccion desde la que queremos hallar las paradas cercanas
	 * @return paradas cercanas a esa direccion
	 * @assert.pre gd!=null
	 */
	public Parada[] getParadasCercanas(GD gd) {
<<<<<<< HEAD
		assert(gd!=null);
		Parada[] p;
		if(!existeParadasCercanas(gd)){
			p = new Parada[0];
			return p;
		}else{
			ArrayList<Parada> pa = new ArrayList<>();
			for(int i=0; i<paradas.size(); i++){
				if(gd.getDistanciaAt(paradas.get(i).getGD())<200){
					pa.add(paradas.get(i));
				}
			}
			p = new Parada[pa.size()];
			return pa.toArray(p);
		}
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	/**
	 * Devuelve si hay parads cercanas de esa linea a una direccion
	 * @param gd Direccion desde la que queremos comprobar si hay paradas cercanas
	 * @return existenParadasCercanas
	 * @assert.pre gd!=null
	 */
	public boolean existeParadasCercanas(GD gd) {
<<<<<<< HEAD
		assert(gd!=null);
		boolean e = false;
		for(int i=0; i<paradas.size(); i++){
			if(gd.getDistanciaAt(paradas.get(i).getGD())<200){
				e = true;
				break;
			}
		}
		return e;
=======
		// TODO Auto-generated method stub
		return false;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	
	/**
	 * Devuelve si hay paradas cercanas de esa linea a una direccion y en un radio de distancia dado
	 * @param gd Direccion desde la que queremos comprobar si hay paradas cercanas
	 * @param radio Radio de distancia máxima de la parada hasta las buscadas
	 * @return existenParadasCercanas
	 * @assert.pre gd!=null
	 */
	public boolean existeParadasCercanas(GD gd, double radio) {
		assert(gd!=null);
		assert(radio>0);
		boolean e = false;
		for(int i=0; i<paradas.size(); i++){
			if(gd.getDistanciaAt(paradas.get(i).getGD())<=radio){
				e = true;
				break;
			}
		}
		return e;
	}
	/**
	 * Devuelve la lista de paradas con correspondencia de this con l
	 * Esta lista estara vacia si no hay ninguna parada con correspondencia con l
	 * @param l Linea con la que queremos hallar las paradas con correspondencia
	 * @return paradas con correspondencia de this con l
	 * @assert.pre l!=null
	 */
	public Parada[] getParadasConCorrespondencia(Linea l) {
<<<<<<< HEAD
		assert(l!=null);
		if(l==this || l.equals(this))
			return getParadas();
		
		ArrayList<Parada> pAux = new ArrayList<>();
		Parada[] p = l.getParadas();
		for(int i=0; i<paradas.size(); i++){
			for(int j=0; j<l.getParadas().length; j++){
				if(paradas.get(i).getDistanciaEntre(p[j])<200 && !pAux.contains(paradas.get(i))){
					pAux.add(paradas.get(i));
				}
			}
		}
		p = new Parada[pAux.size()];
		return pAux.toArray(p);
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	/**
	 * Devuelve si hay o no correspondencia de this con l
	 * @param l Linea con la que queremos hallar si hay correspondencia
	 * @return hayCorrespondencia
<<<<<<< HEAD
	 * @assert.pre l!=null
	 */
	public boolean existeCorrespondencia(Linea l) {
		assert(l!=null);
		if(l==this || l.equals(this))
			return true;
		
		boolean e = false;
		Parada[] p = l.getParadas();
		for(int i=0; i<paradas.size(); i++){
			for(int j=0; j<l.getParadas().length; j++){
				if(paradas.get(i).getDistanciaEntre(p[j])<200){
					e = true;
					break;
				}
			}
		}
		return e;
=======
	 * @assert.pre !this.equals(l)
	 * @throws IllegalArgumentException si l==null
	 */
	public boolean existeCorrespondencia(Linea l) {
		// TODO Auto-generated method stub
		return false;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	/**
	 * Devuelve la lista de paradas con transbordo directo de this con l
	 * Esta lista estara vacia si no hay ninguna parada con transbordo directo
	 * @param l Linea con la que queremos hallar las paradas con transbordo directo
	 * @return paradas con transbordo directo
	 * @assert.pre l!=null
	 */
	public Parada[] getParadasConTransbordoDirecto(Linea l) {
<<<<<<< HEAD
		assert(l!=null);
		if(l==this || l.equals(this))
			return getParadas();
		
		ArrayList<Parada> pAux = new ArrayList<>();
		Parada[] p = l.getParadas();
		for(int i=0; i<paradas.size(); i++){
			for(int j=0; j<l.getParadas().length; j++){
				if(paradas.get(i).getGD().equals(p[j].getGD())){
					pAux.add(paradas.get(i));
				}
			}
		}
		p = new Parada[pAux.size()];
		return pAux.toArray(p);
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	/**
	 * Devuelve si hay transbordo directo entre this y l
	 * @param l Linea con la que queremos hallar si hay transbordo directo
	 * @return existeTransbordoDirecto
	 * @assert.pre l!=null
	 */
	public boolean existeTransbordoDirecto(Linea l) {
<<<<<<< HEAD
		assert(l!=null);
		if(l==this || l.equals(this))
			return true;
		
		boolean e = false;
		Parada[] p = l.getParadas();
		for(int i=0; i<paradas.size(); i++){
			for(int j=0; j<l.getParadas().length; j++){
				if(paradas.get(i).getGD().equals(p[j].getGD())){
					e = true;
					break;
				}
			}
		}
		return e;
=======
		// TODO Auto-generated method stub
		return false;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	/**
	 * Devuelve si la linea contiene una parada
	 * @param p Parada a comprobar que contiene
	 * @return contieneParada
	 * @assert.pre p!=null
	 */
	public boolean contains(Parada p) {
<<<<<<< HEAD
		assert(p!=null);
		return paradas.contains(p);
=======
		// TODO Auto-generated method stub
		return false;
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
	}
	 
	/**
	 * Comprueba si en una lista (array) existen líneas repetidas
	 * @param lista_lineas lista a comprobar
	 * @return hayLineaRepetida
	 * @assert.pre l!=null
	 * @assert.pre l[] !contains null
	 */
<<<<<<< HEAD
	public static boolean lineasRepetidas(Linea[] l){
		assert(l!=null);
		assert(!Arrays.asList(l).contains(null));
		
		if(l.length<2)
			return false;
		else{
			boolean repetida = false;
			ArrayList<Linea> conjuntoAux = new ArrayList<>();
			
			for(int i=0; i<l.length; i++){
				if(conjuntoAux.contains(l[i])){
					repetida = true;
					break;
				}
				else
					conjuntoAux.add(l[i]);
			}
			return repetida;
		}
	}
	
	@Override
	/**
	 * @see 
	 */
	public boolean equals(Object other){
	    if (other == null) 
	    	return false;
	    if (other == this) 
	    	return true;
	    if (!(other instanceof Linea))
	    	return false;
	    
	    return paradas.equals(new ArrayList<>(Arrays.asList(((Linea)other).getParadas())));
	}
	
	@Override
	/**
	 * @see
	 */
    public int hashCode() {
        return Objects.hash(id,paradas);
    }
=======
	public static boolean lineasRepetidas(Linea[] lista_lineas){
		// TODO Auto-generated constructor stub
		return false;
	}
	
>>>>>>> 099b9154dd7fbb7ab76e21977741661f744dcf28
}