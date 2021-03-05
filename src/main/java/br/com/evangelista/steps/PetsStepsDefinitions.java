package br.com.evangelista.steps;

import br.com.evangelista.dominio.api.PetApi;
import br.com.evangelista.dominio.entidades.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetsStepsDefinitions {

    private final PetApi petApi;
    private List<Pet> actualPets;

    public PetsStepsDefinitions() {
        petApi = new PetApi();
    }

//    @Dado("que eu possua animais available")
//    public void queEuPossuaAnimaisAvaliable() throws JsonProcessingException {
//        Pet pet = Pet.builder().build();
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(pet);
//        System.out.println(json);
//    }

    @Dado("que eu possua animais {word}")
    public void queEuPossuaAnimaisPorStatus(String status) {
        actualPets = petApi.getPetsByStatus(status);
    }

    @Quando("eu pesquiso por todos animais {word}")
    public void euPesquisoPorTodosAnimaisDisponiveis(String status) {
        actualPets = petApi.getPetsByStatus(status);
        System.out.println("alalala");
    }

    @Então("eu recebo a lista de animais avaliable")
    public void euReceboAListaDeAnimaisAvailable() {
        assertThat(actualPets, is(not(empty())));
    }

    @E("eu recebo uma outra lista de animais {word}")
    public void euReceboUmaOutraListaDeAnimaisAvailable(String status) {
        Response actualPetsResponse = petApi.getPetsResponseByStatus(status);

        actualPets = actualPetsResponse.body().jsonPath().getList("", Pet.class);

        actualPetsResponse
            .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                    "size()", is(actualPets.size()),
                    "findAll{it.status=='"+status+"'}.size()", is(actualPets.size()));
    }

    @Então("eu recebo a lista com {} animal/animais")
    public void euReceboAListaComAnimais(int petsQuantidade) {
        //noinspection deprecation
        Assert.assertThat(actualPets, is(petsQuantidade));
    }

    @Dado("que eu não possua animais {word}")
    public void queEuNaoPossuaAnimaisSold(String status) {
        petApi.deletePetsBySatus(status);
    }
}
