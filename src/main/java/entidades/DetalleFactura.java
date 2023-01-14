package entidades;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name="detalle_factura")
public class DetalleFactura implements Serializable{

	private static final long serialVersionUID = 2523806976031967894L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="subtotal")
	private int subtotal;

	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="fk_factura")
	private Factura factura;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="fk_articulo")
	private Articulo articulo;
	
	
	public DetalleFactura(int cantidad, int subtotal, Factura factura) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public DetalleFactura() {
	
	}

	public DetalleFactura(int cantidad, int subtotal) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	
	
	
	
}
