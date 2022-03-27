package br.com.danielcesario.springbootcacheredis.gateway.rest.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PlanResponse {

    private String code;

    private String name;

    private BigDecimal value;

    private Boolean active;

    private LocalDateTime creationDate;

}