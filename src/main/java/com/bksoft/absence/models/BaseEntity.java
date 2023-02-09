package com.bksoft.absence.models;


import com.bksoft.absence.models.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Objects;

@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        ),
        @TypeDef(
                name = "int-array",
                typeClass = IntArrayType.class
        )
})
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version", nullable = false, columnDefinition = "int default 0")
    @Version()
    @JsonIgnore
    private Integer version;

    protected  void validate(){}

    /*
     * Getters and Setters
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaseEntity)) {
            return false;
        }
        BaseEntity other;
        other = (BaseEntity) object;

        if ((this.getId() == null) || (other.getId() == null)) {
            return false;
        }
        return this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

}

