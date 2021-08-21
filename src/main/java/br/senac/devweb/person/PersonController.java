package br.senac.devweb.person;

import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("person")
@AllArgsConstructor
@NoArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    @RequestMapping("")
    public ResponseEntity<List<PersonRepresentation.ListaPerson>> getAllPerson(
            @QuerydslPredicate(root = Person.class) Predicate predicate) {

        return ResponseEntity.ok(PersonRepresentation.ListaPerson.from(this.personService.getListaPerson(predicate)));
    }







    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<PersonRepresentation.Detalhes> getPerson(@PathVariable("id") Integer id) {

        Person person = this.personService.getPerson(id);

        return ResponseEntity.ok(PersonRepresentation.Detalhes.builder()
                .id(person.getId())
                .nomeCompleto(person.getNomeCompleto())
                .cpf(person.getCpf())
                .endereco(person.getEndereco())
                .fone(person.getFone())
                .rg(person.getRg())
                .build());
    }

    @PostMapping
    public ResponseEntity<Person> salvarPerson(@Valid @RequestBody Person person) {
        Person novaPerson = this.personService.salvar(person);
        return ResponseEntity.ok(novaPerson);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> atualizaPerson(@PathVariable("id") Integer id,
                                                 @Valid @RequestBody Person person) {
        Person oldPerson = this.personService.getPerson(id);
        oldPerson.setCpf(person.getCpf());
        oldPerson.setNomeCompleto(person.getNomeCompleto());

        Person updatedPerson = this.personService.salvar(oldPerson);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Integer id) {
        this.personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

}
