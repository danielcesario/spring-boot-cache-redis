package br.com.danielcesario.springbootcacheredis.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Plan implements Serializable {

    private String code;

    private String name;

    private BigDecimal value;

    private Boolean active;

    private LocalDateTime creationDate;

}
