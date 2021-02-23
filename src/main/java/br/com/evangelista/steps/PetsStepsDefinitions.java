package br.com.evangelista.steps;

import br.com.evangelista.dominio.api.PetApi;
import br.com.evangelista.dominio.entidades.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetsStepsDefinitions {

    private final PetApi petApi;
    private List<Pet> actualPets;

    public PetsStepsDefinitions() {
        petApi = new PetApi();
    }

    @Dado("que eu possua animais avaliable")
    public void queEuPossuaAnimaisAvaliable() throws JsonProcessingException {
        Pet pet = Pet.builder().build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pet);
        System.out.println(json);
    }

    @Quando("eu pesquiso por todos animais {word}")
    public void euPesquisoPorTodosAnimaisDisponiveis(String status) {
        actualPets = petApi.getPetsByStatus(status);
        System.out.println("alalala");
    }

    @Então("eu recebo a lista")
    public void euReceboALista() {
        assertThat(actualPets, is(not(empty())));
    }
}
