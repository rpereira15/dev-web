package br.senac.devweb.person;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

public interface PersonRepresentation {

    @Getter
    @Setter
    @Builder
    class ListaPerson {
        private Integer id;
        private String nomeCompleto;

        private static ListaPerson from(Person person) {
            return ListaPerson.builder()
                    .id(person.getId())
                    .nomeCompleto(person.getNomeCompleto())
                    .build();
        }

        public static List<ListaPerson> from(List<Person> personList) {
            return personList.stream().map(ListaPerson::from).collect(Collectors.toList());
        }
    }


    @Getter
    @Builder
    class Detalhes {
        private Integer id;
        private String nomeCompleto;
        private String cpf;
        private String fone;
        private String rg;
        private String endereco;
    }
}
