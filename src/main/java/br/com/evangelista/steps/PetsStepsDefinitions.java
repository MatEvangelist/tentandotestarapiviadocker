package br.com.evangelista.steps;

import br.com.evangelista.dominio.entidades.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class PetsStepsDefinitions {

    @Dado("que eu possua animais avaliable")
    public void queEuPossuaAnimaisAvaliable() throws JsonProcessingException {
        Pet pet = Pet.builder().build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pet);
        System.out.println(json);
    }

    @Quando("eu pesquiso por todos animais disponíveis")
    public void euPesquisoPorTodosAnimaisDisponiveis() {
    }

    @Então("eu recebo a lista")
    public void euReceboALista() {
    }
}
