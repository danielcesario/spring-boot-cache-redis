package br.com.danielcesario.springbootcacheredis.mapper;

import br.com.danielcesario.springbootcacheredis.domain.model.Plan;
import br.com.danielcesario.springbootcacheredis.gateway.database.entity.PlanEntity;
import br.com.danielcesario.springbootcacheredis.gateway.rest.request.PlanRequest;
import br.com.danielcesario.springbootcacheredis.gateway.rest.response.PlanResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanMapper {

    PlanMapper INSTANCE = Mappers.getMapper(PlanMapper.class);

    Plan planEntityToPlan(PlanEntity planEntity);
    Plan planRequestToPlan(PlanRequest planRequest);
    PlanEntity planToPlanEntity(Plan plan);
    PlanResponse planToPlaResponse(Plan plan);
}
