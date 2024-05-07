package ru.edu.springdata.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Категория книг. На пр. Health, History, IT
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq")
    @SequenceGenerator(name="category_id_seq", sequenceName = "CATEGORIES_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
}
