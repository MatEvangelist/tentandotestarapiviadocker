package br.com.evangelista.testes;

import br.com.evangelista.dominio.api.UserApi;
import br.com.evangelista.dominio.entidades.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@DisplayName("Testes para funcionalidades do usuário")
public class UserTestes extends BaseTest {

    UserApi userApi = new UserApi();
    User expectedUser;

    @Test @DisplayName("Um usuário deve poder se registrar no sistema")
    public void deveCriarUmNovoUsuario() {
        expectedUser = User.builder().build();
        userApi.createUser(expectedUser);

        String actualUsername = userApi.getNicknameUsuario(expectedUser);
        assertThat(actualUsername, is(expectedUser.getUsername()));
    }

    @AfterEach
    void deleteNewUser() {
        userApi.deleteUser(expectedUser);
    }



}
