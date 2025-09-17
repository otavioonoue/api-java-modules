package com.fb_challenge.api.shared.infrastructure.database.jpa;

import java.util.UUID;

import com.fb_challenge.api.shared.infrastructure.database.type.DocumentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
public class DocumentJPA {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false)
    private DocumentType documentType;
    
    @Column(unique = true, nullable = false)
    private String number;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientJPA client;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ClientJPA getClient() {
        return client;
    }

    public void setClient(ClientJPA client) {
        this.client = client;
    }
}
