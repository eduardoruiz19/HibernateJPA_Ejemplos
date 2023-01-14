package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Cliente;
import entidades.Domicilio;

public class PersistenceApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploPersistenciaPU");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			/*
			Cliente cliente = new Cliente("nombre","apellido","1234");
		
			Domicilio d= new Domicilio("Calle 5",2040);
			
			cliente.setDomicilio(d);
			d.setCliente(cliente);
			em.persist(cliente);
			
						*/
			/*
			Domicilio dom= em.find(Domicilio.class, 1L);
			Cliente cli = em.find(Cliente.class, 1L);
			System.out.println("cliente de domicilio:"+dom.getCliente().getDni());
			System.out.println("Dokicilio del Cliente:"+cli.getDomicilio().getNombreCalle());
			
			*/
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
