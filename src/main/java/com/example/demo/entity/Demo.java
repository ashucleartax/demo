package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by ashutoshpandey on 11/05/18.
 */
@Entity
@Table(name = "property")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@ToString
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @NotNull
    @Getter
    @Setter
    private String externalId;

    @CreationTimestamp
    @Getter
    private Timestamp createdAt;

    @UpdateTimestamp
    @Getter @Setter
    private Timestamp updatedAt;


}
