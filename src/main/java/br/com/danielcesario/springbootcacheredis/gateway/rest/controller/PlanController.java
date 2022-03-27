package br.com.danielcesario.springbootcacheredis.gateway.rest.controller;

import br.com.danielcesario.springbootcacheredis.domain.model.Plan;
import br.com.danielcesario.springbootcacheredis.domain.usecase.CreatePlan;
import br.com.danielcesario.springbootcacheredis.domain.usecase.GetActivePlans;
import br.com.danielcesario.springbootcacheredis.gateway.rest.request.PlanRequest;
import br.com.danielcesario.springbootcacheredis.gateway.rest.response.PlanResponse;
import br.com.danielcesario.springbootcacheredis.mapper.PlanMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/plans")
@AllArgsConstructor
public class PlanController {

    private final CreatePlan createPlan;
    private final GetActivePlans getActivePlans;

    @PostMapping
    ResponseEntity<PlanResponse> create(@RequestBody PlanRequest request) {
        Plan createdPlan = createPlan.execute(request);
        URI uri = URI.create("/plans/" + createdPlan.getCode());
        return ResponseEntity.created(uri).body(PlanMapper.INSTANCE.planToPlaResponse(createdPlan));
    }

    @GetMapping
    ResponseEntity<List<PlanResponse>> getActive() {
        List<Plan> activePlans = getActivePlans.execute();
        return ResponseEntity.ok(
                activePlans.stream()
                        .map(PlanMapper.INSTANCE::planToPlaResponse)
                        .collect(Collectors.toList()));
    }
}
