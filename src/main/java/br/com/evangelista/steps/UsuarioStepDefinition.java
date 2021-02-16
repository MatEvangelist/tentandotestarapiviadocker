package br.com.evangelista.steps;

import br.com.evangelista.dominio.api.UserApi;
import br.com.evangelista.dominio.entidades.User;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UsuarioStepDefinition {

    private User expectedUser;
    private final UserApi userApi;

    public UsuarioStepDefinition() {
        userApi = new UserApi();
    }

    @Quando("crio um usuário")
    public void crioUmUsuario() {
        expectedUser = User.builder().build();
        userApi.createUser(expectedUser);
    }

    @Então("o usuário é salvo no sistema")
    public void oUsuarioESalvoNoSistema() {
        String actualUsername = userApi.getNicknameUsuario(expectedUser);
        assertThat(actualUsername, is(expectedUser.getUsername()));
    }
}
