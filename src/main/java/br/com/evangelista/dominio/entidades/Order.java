package br.com.evangelista.dominio.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private int id;
    private int petID;
    private int quantity;
    private String shipData;
    private String status;
    private boolean complete;
}
