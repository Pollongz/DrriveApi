package com.drrive.DrriveApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_posts")
    private Integer idPost;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    private transient Integer companyId;

    @ManyToOne
    @JoinColumn(name = "id_company")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;
}
