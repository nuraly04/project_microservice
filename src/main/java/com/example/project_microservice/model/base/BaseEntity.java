package com.example.project_microservice.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof BaseEntity entity) || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;

        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
