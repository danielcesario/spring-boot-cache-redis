package br.com.danielcesario.springbootcacheredis.domain.usecase;

import br.com.danielcesario.springbootcacheredis.domain.model.Plan;
import br.com.danielcesario.springbootcacheredis.gateway.database.reposioty.PlanEntityRepository;
import br.com.danielcesario.springbootcacheredis.gateway.rest.request.PlanRequest;
import br.com.danielcesario.springbootcacheredis.mapper.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;

@Service
@Transactional
@RequiredArgsConstructor
public class CreatePlan {

    private final PlanEntityRepository planEntityRepository;

    @CacheEvict(value = "planCache", allEntries = true)
    public Plan execute(PlanRequest request) {
        Plan planToSave = PlanMapper.INSTANCE.planRequestToPlan(request);
        planToSave.setCreationDate(LocalDateTime.now(UTC));

        return PlanMapper.INSTANCE.planEntityToPlan(
                planEntityRepository.save(
                        PlanMapper.INSTANCE.planToPlanEntity(planToSave)));
    }
}
