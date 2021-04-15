package br.com.evangelista.steps;

import br.com.evangelista.dominio.api.PetApi;
import br.com.evangelista.dominio.api.StoreApi;
import br.com.evangelista.dominio.builders.OrderBuilder;
import br.com.evangelista.dominio.entidades.Order;
import br.com.evangelista.dominio.entidades.Pet;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.is;

public class StoreStepsDefinition {

    PetApi petApi;
    StoreApi storeApi;
    Pet expectedPet;
    Order expectedOrder;


    public StoreStepsDefinition() {
        petApi = new PetApi();
        storeApi = new StoreApi();
    }


    @Dado("que eu possua animal {word}")
    public void queEuPossuaAnimalAvailable(String status) {
        Pet pet = Pet.builder()
                .id(77)
                .status(status)
                .build();

        expectedPet = petApi.createPet(pet);
    }

    @Quando("faço o pedido desse animal")
    public void façoOPedidoDesseAnimal() {
        Order order = new OrderBuilder()
                .withId(222)
                .withPetId(expectedPet.getId())
                .build();

        expectedOrder = storeApi.createOrder(order);
    }

    @Então("o pedido é aprovado")
    public void oPedidoÉAprovado() {
        Response actualOrderResponse = storeApi.getOrder(expectedOrder.getId());
        actualOrderResponse
                .then()
                    .body("id", is(expectedOrder.getId()),
                            "petId", is(expectedPet.getId()),
                            "quantity", is(expectedOrder.getQuantity()),
                            "status", is("approved")
                        );
    }
}
