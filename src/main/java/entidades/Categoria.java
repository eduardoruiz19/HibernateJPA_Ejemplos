package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	

	@Column(name = "denominacion")
	private String denominacion;


	@ManyToMany(mappedBy="categorias")  // nombre como aparece en la lista del Objeto articulo
	private List<Articulo> articulos = new ArrayList<Articulo>();

	
	public Categoria(String denominacion) {
		
		this.denominacion = denominacion;
	}


	public Categoria() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<Articulo> getArticulos() {
		return articulos;
	}


	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	
	
}
