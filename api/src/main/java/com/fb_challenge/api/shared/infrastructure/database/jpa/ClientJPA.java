package com.fb_challenge.api.shared.infrastructure.database.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientJPA {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private DocumentJPA document;
    
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private AddressJPA address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ContactJPA> contacts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJPA user;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentJPA getDocument() {
        return document;
    }

    public void setDocument(DocumentJPA document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressJPA getAddress() {
        return address;
    }

    public void setAddress(AddressJPA address) {
        this.address = address;
    }

    public List<ContactJPA> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactJPA> contacts) {
        this.contacts = contacts;
    }

    public UserJPA getUser() {
        return user;
    }

    public void setUser(UserJPA user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
