package jpatest.start;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpatest.start.entity.Item;
import jpatest.start.entity.Member;
import jpatest.start.entity.Order;
import jpatest.start.entity.OrderItem;
import jpatest.start.entity.OrderStatus;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
	private static void logic(EntityManager em) {
//		em.remove(member);
		
		Member insertMember = new Member();
		Member insertMember2 = new Member();
		Order insertOrder = new Order();
		Item insertItem = new Item();
		OrderItem insertOrderItem = new OrderItem();
		
		
		insertMember.setCity("seoul");
		insertMember.setName("jina");
		insertMember.setStreet("gm");
		insertMember.setZipcode("1234");
		
		
		insertMember2.setCity("Gyeonggi-do");
		insertMember2.setName("jane");
		insertMember2.setStreet("street");
		insertMember2.setZipcode("4321");
		
		em.persist(insertMember);
		em.persist(insertMember2);
		
		Member findMember = em.find(Member.class, Long.valueOf(2));
		System.out.println("findMember=" + findMember.getName());
		
		insertOrder.setMember(insertMember);
		insertOrder.setOrderDate(new Date());
		insertOrder.setStatus(OrderStatus.ORDER);
		
		em.persist(insertOrder);
		
		insertItem.setName("thisIsItem");
		insertItem.setPrice(1000);
		insertItem.setStockQuantity(3);
		
		em.persist(insertItem);
		
		insertOrderItem.setItem(insertItem);
		insertOrderItem.setCount(5);
		insertOrderItem.setOrder(insertOrder);
		insertOrderItem.setOrderPrice(3000);
		insertOrder.addOrderItem(insertOrderItem);
		
		em.persist(insertOrderItem);
		
		Order order1 = em.find(Order.class, Long.valueOf(3));
		Member member1 = order1.getMember();
		System.out.println("findMember=" + member1.getName());

		Order order2 = em.find(Order.class, Long.valueOf(3));
		OrderItem orderItem = order2.getOrderItems().get(0);
		Item item = orderItem.getItem();
		System.out.println("findItem=" + item.getName());
		
		
	}
}
