package uva.tds.pr2.equipo05;

import java.util.*;
import java.util.Map.Entry;


/**
 * 
 * @author martorb
 * @author ismpere
 *
 */
public class RedAutobuses {
	
	HashMap<Integer,Linea> mapa_lineas=new HashMap<>();
	
	/**
	 * Constructor por defecto de la clase RedAutobuses
	 * @param lista_lineas Lista (array) que contiene las líenas iniciales de la red
	 * @assert.pre lista_lineas.length>1
	 * @assert.pre !Linea.lineasRepetidas(lista_lineas)
	 * @throws IllegalArgumentException si lista_lineas==null || alguna de las lineas de la lista es null
	 */
	public RedAutobuses(Linea[] lista_lineas){
		assert(lista_lineas.length>1);
		assert(Linea.lineasRepetidas(lista_lineas));
		for(int i=0; i<lista_lineas.length;i++){
			mapa_lineas.put(lista_lineas[i].getId(),lista_lineas[i]);
		}
	}
	
	/**
	 * Devuelve una línea de la red a partir de su identificador
	 * @param id Número que identifica la línea
	 * @return líneaBuscada
	 * @assert.pre this.contains(id)
	 */
	public Linea getLinea(int id){
		assert(mapa_lineas.containsKey(id));
		Linea res=mapa_lineas.get(id);
		return res;
	}
	
	/**
	 * Añade una línea a la red 
	 * @param linea Línea a añadir
	 * @assert.pre !red.contains(linea)
	 * @throws IllegalArgumentException si linea==null
	 */
	public void addLinea(Linea linea){
		assert(!this.contains(linea));
		mapa_lineas.put(linea.getId(), linea);
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
		assert(this.contains(linea));
		assert(mapa_lineas.size()>2);
		mapa_lineas.remove(linea.getId());
	}
	
	/**
	 * Devuelve la lista (array) de todas las líneas de la red
	 * @return lineas_red[]
	 */
	public Linea[] getAllLineas(){
		Linea[] lineas_red=new Linea[mapa_lineas.size()];
		int i=0;
		for(Entry<Integer,Linea> entr: mapa_lineas.entrySet()) {
			lineas_red[i]=entr.getValue();
			i++;
		}
		return lineas_red;
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
		assert(radio>=0);
		ArrayList<Linea> res=new ArrayList<>();
		for(Entry<Integer,Linea> entr: mapa_lineas.entrySet()) {
			if(entr.getValue().existeParadasCercanas(direccion,radio)){
				res.add(entr.getValue());
			}
		}
		Linea[] lineas_encontradas=new Linea[res.size()];
		return res.toArray(lineas_encontradas);
	}
	
	/**
	 * Comprueba si la red contiene una determinada línea
	 * @param linea
	 * @return contieneLinea
	 * @throws IllegalArgumentException si linea==null
	 */
	public boolean contains(Linea linea){
		return mapa_lineas.containsKey(linea.getId());
	}
	/**
	 * Devuelve si contiene una linea con identificador id
	 * @param id identificador de la linea
	 * @return contieneLineaConId
	 */
	public boolean contains(int id) {
		return mapa_lineas.containsKey(id);
	}
	/**
	 * Devuelve si hay Lineas con paradas cercanas a una direccion con un radio de distancia maxima
	 * @param gd Direccion
	 * @param radio de distancia
	 * @return existenLineasConparadasCercanas
	 * @assert.pre radio>=0
	 * @throws IllegalArgumentException si gd==null
	 */
	public boolean existenLineasConParadasCercanas(GD direccion, double radio) {
		assert(radio>=0);
		boolean res=false;
		for(Entry<Integer,Linea> entr: mapa_lineas.entrySet()) {
			if(entr.getValue().existeParadasCercanas(direccion,radio)){
				res=true;
			}
		}
		return res;
	}	
}