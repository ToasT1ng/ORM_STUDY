package jpatest.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpatest.start.entity.Member;
import jpatest.start.entity.Order;

import org.hibernate.*;

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
//		String id = "id1";
//		Member member = new Member();
//		member.setId(id);
//		member.setUsername("지한");
//		member.setAge(2);
//		
//		em.persist(member);
//		
//		member.setAge(20);
//		
//		Member findMember = em.find(Member.class, id);
//		System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());
//		
//		List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
//		System.out.println("members.size=" + members.size());
		
//		em.remove(member);
		
//		Order order = em.find(Order.class, 1);
		
//		Member member = em.find(Member.class, order.getMemberId());
		
	}
}
