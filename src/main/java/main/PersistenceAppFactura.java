package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceAppFactura {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploPersistenciaPU");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			Factura factura1= new Factura();
			factura1.setNumero(12);
			factura1.setFecha("2023-01-01");
			
			Domicilio dom= new Domicilio("Calle san Martin",1222);
			Cliente cliente = new Cliente("Pablo","Muñoz","15245778");
			

			cliente.setDomicilio(dom);
			dom.setCliente(cliente);  //bidireccionalidad
			
			factura1.setCliente(cliente);
			
			//Creacion de Categorias
			Categoria perecederos = new Categoria("Perecederos"); 
			Categoria lacteos = new Categoria("lacteos");
			Categoria limpieza = new Categoria("Limpieza");
			
			
			//Creacion de Articulos
			Articulo art =new Articulo(200,"Yogurt de Fruta",20);
			Articulo art2 =new Articulo(300,"Detergente Magistra",80);
			
			
			//Hacer las relaciones
			art.getCategorias().add(perecederos);
			art.getCategorias().add(lacteos);
			lacteos.getArticulos().add(art);
			perecederos.getArticulos().add(art);
			
			art2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(art2);
			
			//Crear Detalle de la Factura
			DetalleFactura det1 = new DetalleFactura();
			det1.setArticulo(art);
			det1.setCantidad(1);
			det1.setSubtotal(40);

			//bidereccionalidades
			art.getDetalle().add(det1);
			//bidereccionalidades			
			factura1.getDetalles().add(det1);
			det1.setFactura(factura1);
			
			DetalleFactura det2 = new DetalleFactura();
			det2.setArticulo(art2);
			det2.setCantidad(1);
			det2.setSubtotal(80);
			//bidereccionalidad articulo 2			
			art2.getDetalle().add(det2);
			factura1.getDetalles().add(det2);
			det2.setFactura(factura1);
			
			factura1.setTotal(120);
			
			em.persist(factura1);
			
			em.flush();
			em.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			
		}
		em.close();
		emf.close();
	}
}
