package br.com.danielcesario.springbootcacheredis.gateway.rest.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PlanRequest {

    @NotBlank
    private String code;

    @NotBlank
    @Min(3)
    private String name;

    @Positive
    @NotNull
    private BigDecimal value;

    @NotNull
    private Boolean active;

}