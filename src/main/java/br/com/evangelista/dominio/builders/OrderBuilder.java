package br.com.evangelista.dominio.builders;

import br.com.evangelista.dominio.entidades.Order;

public class OrderBuilder {
    private int id;
    private int petId;
    private int quantity;
    private String shipData;
    private String status;
    private boolean complete;

    public OrderBuilder() {
        reset();
    }

    public OrderBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public OrderBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder withshipData(String shipData) {
        this.shipData = shipData;
        return this;
    }

    public OrderBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public OrderBuilder withComplete(boolean complete) {
        this.complete = complete;
        return this;
    }

    public Order build() {
        return new Order(
                id,
                petId,
                quantity,
                shipData,
                status,
                complete
        );
    }

    public void reset() {
        id = 1;
        petId = 30;
        quantity = 1;
        shipData = "20/02/2021";
        status = "approved";
        complete = true;
    }

}
