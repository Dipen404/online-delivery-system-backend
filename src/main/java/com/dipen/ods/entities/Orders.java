package com.dipen.ods.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dipen.ods.models.PaymentStatus;
import com.dipen.ods.models.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", nullable = false, updatable = false)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "order_date")
	private Date date;
	private Status status;
	private PaymentStatus payment;

}
