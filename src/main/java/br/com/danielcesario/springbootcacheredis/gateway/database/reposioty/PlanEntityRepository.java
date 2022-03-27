package br.com.danielcesario.springbootcacheredis.gateway.database.reposioty;

import br.com.danielcesario.springbootcacheredis.gateway.database.entity.PlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanEntityRepository extends CrudRepository<PlanEntity, Long> {

    List<PlanEntity> findAllByActiveIsTrueOrderByCreationDateDesc();

}
