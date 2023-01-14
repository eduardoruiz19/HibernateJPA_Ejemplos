package entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name="nombre_calle")
	private String nombreCalle;
	
	@Column(name="numero")
	private int numero;

	
	//esto es para bidireccionalidad
	@OneToOne(mappedBy="domicilio")
	private Cliente cliente;
	

	
	public Domicilio() {
		
	}

	
	
	public Domicilio(String nombreCalle, int numero, Cliente cliente) {
		super();
		this.nombreCalle = nombreCalle;
		this.numero = numero;
		this.cliente = cliente;
	}



	public Domicilio(String nombreCalle, int numero) {
		super();
		this.nombreCalle = nombreCalle;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}