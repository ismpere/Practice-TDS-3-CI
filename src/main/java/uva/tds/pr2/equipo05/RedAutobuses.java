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
	
	HashMap<Integer,Linea> mapaLineas=new HashMap<>();
	
	/**
	 * Constructor por defecto de la clase RedAutobuses
	 * @param listaLineas Lista (array) que contiene las líenas iniciales de la red
	 * @assert.pre lista_lineas!=null && lista_lineas.length>1
	 * @assert.pre !Linea.lineasRepetidas(lista_lineas)
	 * @assert.pre lista_lineas[] !contains null
	 */
	public RedAutobuses(Linea[] listaLineas){
		assert(listaLineas!=null && listaLineas.length>1);
		assert(!Linea.lineasRepetidas(listaLineas));
		assert(!Arrays.asList(listaLineas).contains(null));
		
		for(int i=0; i<listaLineas.length;i++){
			mapaLineas.put(listaLineas[i].getId(),listaLineas[i]);
		}
	}
	
	/**
	 * Devuelve una línea de la red a partir de su identificador
	 * @param id Número que identifica la línea
	 * @return líneaBuscada
	 * @assert.pre contains(id)
	 */
	public Linea getLinea(int id){
		assert(contains(id));
		return mapaLineas.get(id);
	}
	
	/**
	 * Añade una línea a la red 
	 * @param linea Línea a añadir
	 * @assert.pre linea!=null 
	 * @assert.pre !red.contains(linea)
	 */
	public void addLinea(Linea linea){
		assert(linea!=null);
		assert(!contains(linea));
		mapaLineas.put(linea.getId(), linea);
	}
	
	/**
	 * Elimina una línea de la red
	 * @param linea Línea a eliminar
	 * @assert.pre linea!=null && this.contains(linea)
	 * @assert.pre getLineas.length>2
	 * @assert.post !(red.contains(linea)) && red.getAllLineas.length>1
	 */
	public void deleteLinea(Linea linea){
		assert(linea!=null && mapaLineas.size()>2);
		assert(contains(linea));
		mapaLineas.remove(linea.getId());
	}
	
	/**
	 * Devuelve la lista (array) de todas las líneas de la red
	 * @return lineas_red[]
	 */
	public Linea[] getAllLineas(){
		Linea[] lineasRed=new Linea[mapaLineas.size()];
		int i=0;
		for(Entry<Integer,Linea> entr: mapaLineas.entrySet()) {
			lineasRed[i]=entr.getValue();
			i++;
		}
		return lineasRed;
	}
	
	/**
	 * Devuelve una lista (array) con las líneas que tienen alguna parada dentro de la región indicada
	 * @param direccion Punto dede el que se buscan líneas con parada cercana
	 * @param radio (en metros) Distancia máxima desde la dirección indicada hasta alguna parada de las líneas buscadas
	 * @return lineasEncontradas[]
	 * @assert.pre direccion!=null
	 * @assert.pre radio>=0
	 */
	public Linea[] getLineasConParadasCercanas(GD direccion, double radio){
		assert(direccion!=null);
		assert(radio>=0);
		ArrayList<Linea> res=new ArrayList<>();
		for(Entry<Integer,Linea> entr: mapaLineas.entrySet()) {
			if(entr.getValue().existeParadasCercanas(direccion,radio)){
				res.add(entr.getValue());
			}
		}
		Linea[] lineasEncontradas=new Linea[res.size()];
		return res.toArray(lineasEncontradas);
	}
	
	/**
	 * Comprueba si la red contiene una determinada línea
	 * @param linea Linea a buscar
	 * @return contieneLinea
	 * @assert.pre linea!=null
	 */
	public boolean contains(Linea linea){
		assert(linea!=null);
		return mapaLineas.containsKey(linea.getId());
	}
	
	/**
	 * Devuelve si contiene una linea con identificador id
	 * @param id identificador de la linea
	 * @return contieneLineaConId
	 */
	public boolean contains(int id) {
		return mapaLineas.containsKey(id);
	}
	
	/**
	 * Devuelve si hay Lineas con paradas cercanas a una direccion con un radio de distancia maxima
	 * @param dirección Direccion
	 * @param radio Distancia máxima hasta una parada de otra línea
	 * @return existenLineasConparadasCercanas
	 * @assert.pre direccion!=null
	 * @assert.pre radio>=0
	 */
	public boolean existenLineasConParadasCercanas(GD direccion, double radio) {
		assert(direccion!=null);
		assert(radio>=0);
		boolean res=false;
		for(Entry<Integer,Linea> entr: mapaLineas.entrySet()) {
			if(entr.getValue().existeParadasCercanas(direccion,radio)){
				res=true;
				break;
			}
		}
		return res;
	}	
}