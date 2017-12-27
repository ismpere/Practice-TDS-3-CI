package uva.tds.pr2.equipo05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * 
 * @author ismpere
 * @author martorb
 *
 */
public class Linea{
	
	private int id;
	private ArrayList<Parada> paradas;
	/**
	 * Constructor por defecto de la clase Linea
	 * @param id de la Linea
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
	}
	/**
	 * Devuelve el identificador de la linea
	 * @return id de la Linea
	 */
	public int getId() {
		return id;
	}
	/**
	 * Devuelve la lista de paradas de la linea
	 * @return paradas de la Linea
	 */
	public Parada[] getParadas() {
		Parada[] p = new Parada[paradas.size()];
		
		paradas.toArray(p);
		
		return p;
	}
	/**
	 * Devuelve la parada inicial de la linea
	 * @return parada inicio
	 */
	public Parada getParadaInicio() {
		return paradas.get(0);
	}
	/**
	 * Devuelve la parada final de la linea
	 * @return parada fin
	 */
	public Parada getParadaFin() {
		return paradas.get(paradas.size()-1);
	}
	/**
	 * Añade una nueva parada a la Linea
	 * @param p Parada a añadir
	 * @assert p!=null
	 * @assert.pre !contains(p)
	 */
	public void addParadaIntermedia(Parada p) {
		assert(p!=null);
		assert(!contains(p));
		
		double dMin;
		double dAux1; 
		double dAux2;
		int iP = 1;
		
		dAux1 = p.getDistanciaEntre(paradas.get(0));
		dAux2 = p.getDistanciaEntre(paradas.get(1));
		dMin = dAux1 + dAux2;
		
		for(int i=1; i<paradas.size()-1; i++){
			dAux1 = p.getDistanciaEntre(paradas.get(i));
			dAux2 = p.getDistanciaEntre(paradas.get(i+1));
			if((dAux1+dAux2)<dMin){
				dMin = dAux1+dAux2;
				iP = i+1;
			}	
		}
		addParadaIntermediaAt(p, iP+1);
	}
	/**
	 * Cambia el identificador de la linea
	 * @param id Nuevo identificador de la Linea
	 */
	public void setId(int id) {
		this.id = id;
		
	}
	/**
	 * Cambia la parada ininio de la linea
	 * @param p Nueva parada Inicio
	 * @assert.pre p!=null && !contains(p)
	 * @assert.pre p.getDistanciaAt(getParadaFin)<100
	 */
	public void setParadaInicio(Parada p) {
		assert(p!=null && !contains(p));
		assert(p.getDistanciaEntre(getParadaFin())<100);
		
		paradas.add(0, p);
	}
	/**
	 * Cambia la parada fin de la linea
	 * @param p Nueva parada Fin
	 * @assert.pre p!=null && !contains(p)
	 * @assert.pre p.getDistanciaAt(getParadaInicio)<100
	 */
	public void setParadaFin(Parada p) {
		assert(p!=null && !contains(p));
		assert(p.getDistanciaEntre(getParadaInicio())<100);
		
		paradas.add(p);
	}
	/**
	 * Añade la parada intermedia en la posicion seleccionada
	 * @param p Parada intermedia a añadir
	 * @param i Posicion en la que se va a añadir
	 * @assert.pre p!=null && !contains(p)
	 * @assert.pre i>1 && i<getParadas.length
	 */
	public void addParadaIntermediaAt(Parada p, int i) {
		assert(p!=null && !contains(p));
		assert(i>1 && i<paradas.size()+1);
		
		paradas.add(i-1, p);
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
		assert(p!=null && contains(p));
		assert(paradas.size()>3);
		assert(!p.equals(getParadaInicio()) && !p.equals(getParadaFin()));
		
		paradas.remove(p);
	}
	/**
	 * Devuelve una lista de paradas de la linea cercanas a una direccion
	 * La lista estara vacia si no hay ninguna parada cercana
	 * @param gd Direccion desde la que queremos hallar las paradas cercanas
	 * @return paradas cercanas a esa direccion
	 * @assert.pre gd!=null
	 */
	public Parada[] getParadasCercanas(GD gd) {
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
	}
	/**
	 * Devuelve si hay parads cercanas de esa linea a una direccion
	 * @param gd Direccion desde la que queremos comprobar si hay paradas cercanas
	 * @return existenParadasCercanas
	 * @assert.pre gd!=null
	 */
	public boolean existeParadasCercanas(GD gd) {
		assert(gd!=null);
		boolean e = false;
		for(int i=0; i<paradas.size(); i++){
			if(gd.getDistanciaAt(paradas.get(i).getGD())<200){
				e = true;
				break;
			}
		}
		return e;
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
	}
	/**
	 * Devuelve si hay o no correspondencia de this con l
	 * @param l Linea con la que queremos hallar si hay correspondencia
	 * @return hayCorrespondencia
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
	}
	/**
	 * Devuelve la lista de paradas con transbordo directo de this con l
	 * Esta lista estara vacia si no hay ninguna parada con transbordo directo
	 * @param l Linea con la que queremos hallar las paradas con transbordo directo
	 * @return paradas con transbordo directo
	 * @assert.pre l!=null
	 */
	public Parada[] getParadasConTransbordoDirecto(Linea l) {
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
	}
	/**
	 * Devuelve si hay transbordo directo entre this y l
	 * @param l Linea con la que queremos hallar si hay transbordo directo
	 * @return existeTransbordoDirecto
	 * @assert.pre l!=null
	 */
	public boolean existeTransbordoDirecto(Linea l) {
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
	}
	/**
	 * Devuelve si la linea contiene una parada
	 * @param p Parada a comprobar que contiene
	 * @return contieneParada
	 * @assert.pre p!=null
	 */
	public boolean contains(Parada p) {
		assert(p!=null);
		return paradas.contains(p);
	}
	 
	/**
	 * Comprueba si en una lista (array) existen líneas repetidas
	 * @param lista_lineas lista a comprobar
	 * @return hayLineaRepetida
	 * @assert.pre l!=null
	 * @assert.pre l[] !contains null
	 */
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
}