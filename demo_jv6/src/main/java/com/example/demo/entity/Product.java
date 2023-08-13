package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, length = 50)
    private String ten;

    @Column(nullable = true)
    private String image;

    @Column(nullable = true)
    private Double giaNhap;

    @Column(nullable = true)
    private Double giaBan;

    @Column(nullable = true, length = 50)
    private String moTa;

    @Column(nullable = true, length = 50)
    private String chatLieu;

    @Column(nullable = true)
    private Double dungTich;

    @Column(nullable = true, length = 50)
    private String mauSac;

    @Column
    private Boolean available;

    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();

    @ManyToOne
    @JoinColumn(name = "Categoryid")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

}
