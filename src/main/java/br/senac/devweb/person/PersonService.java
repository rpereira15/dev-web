package br.senac.devweb.person;


import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person salvar(Person salvarPerson) {
        return this.repository.save(salvarPerson);
    }

    public List<Person> getListaPerson(Predicate predicate) {
        return this.repository.findAll(predicate);
    }

    public Person getPerson(Integer id) {
        return this.repository.findById(id).get();
    }

    public void deletePerson(Integer id) {
        this.repository.deleteById(id);
    }
}
