package com.bezkoder.spring.thymeleaf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 128)
    private String fullName;

    @Column(nullable = false, length = 10)
    private String age;

    @ManyToOne
    @JoinColumn(name = "index_id", nullable = false)
    private Indexer indexer;

    // Transient field for form binding
    @Transient
    private Integer indexerId;

    // Getters and Setters
    public Integer getPlayerId() { return playerId; }
    public void setPlayerId(Integer playerId) { this.playerId = playerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public Indexer getIndexer() { return indexer; }
    public void setIndexer(Indexer indexer) { this.indexer = indexer; }

    public Integer getIndexerId() { return indexerId; }
    public void setIndexerId(Integer indexerId) { this.indexerId = indexerId; }
}

