package br.com.danielcesario.springbootcacheredis.gateway.database.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "t_plan",
        uniqueConstraints = { @UniqueConstraint(name = "uk_plan__code", columnNames = { "code" }) }
)
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private BigDecimal value;

    private Boolean active;

    private LocalDateTime creationDate;
}

