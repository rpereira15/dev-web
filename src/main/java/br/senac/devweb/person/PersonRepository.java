package br.senac.devweb.person;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer>,
        QuerydslPredicateExecutor<Person>, QuerydslBinderCustomizer<QPerson> {

    List<Person> findAll(Predicate predicate);

    @Override
    default public void customize(QuerydslBindings bindings, QPerson root) {

        bindings.bind(root.nomeCompleto).first((StringPath path, String value) -> path.containsIgnoreCase(value));
        bindings.bind(root.cpf).first((StringPath path, String value) -> path.startsWith(value));

    }
}
