package jpatest.start.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ITEM")
public class Item {
	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;

}
