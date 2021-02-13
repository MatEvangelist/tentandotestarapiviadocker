package br.com.evangelista.dominio.entidades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "matevangelista";
    @Builder.Default
    private String firstName = "Mathews";
    @Builder.Default
    private String lastName = "Evangelista";
    @Builder.Default
    private String email = "mathews.pee@gmail.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "11975668010";
    @Builder.Default
    private int userStatus = 1;

}
