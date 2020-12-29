package jpatest.start.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import antlr.collections.List;
import lombok.Data;

@Entity
@Data
@Table(name="MEMBER")
public class Member {
	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="ZIPCODE")
	private String zipcode;
	
	@OneToMany(mappedBy="member")
	private List<Order> orders = new ArrayList<Order>();
}
