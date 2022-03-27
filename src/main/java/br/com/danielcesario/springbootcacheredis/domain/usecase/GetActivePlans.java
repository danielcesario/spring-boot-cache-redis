package br.com.danielcesario.springbootcacheredis.domain.usecase;

import br.com.danielcesario.springbootcacheredis.domain.model.Plan;
import br.com.danielcesario.springbootcacheredis.gateway.database.reposioty.PlanEntityRepository;
import br.com.danielcesario.springbootcacheredis.mapper.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetActivePlans {

    private final PlanEntityRepository planEntityRepository;

    @Cacheable(value = "planCache")
    public List<Plan> execute() {
        return planEntityRepository.findAllByActiveIsTrueOrderByCreationDateDesc()
                .stream()
                .map(PlanMapper.INSTANCE::planEntityToPlan)
                .collect(Collectors.toList());
    }

}
