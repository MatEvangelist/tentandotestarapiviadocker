#language: pt
# enconding: utf-08

Funcionalidade: Gerenciamento de um usuário na Pet Store

  @wip
  Cenário: Criar um usuário na loja
    Quando faço um POST para /v3/user com os seguintes valores:
      | id         | 10                    |
      | username   | matevangelista        |
      | firstName  | Mathews               |
      | lastName   | Evangelista           |
      | email      | mathews.pee@gmail.com |
      | password   | 12345                 |
      | phone      | 11975668010           |
      | userStatus | 1                     |
    Então quando faço um GET para /v3/user/matevangelista, o usuário criado é retornado


  @quarentine
  Cenário: Criar um usuário na loja usando docstring
    Quando faço um POST para /v3/user com a seguinte docString:
    """json
  {
  "id": 11,
  "username": "zawahiri",
  "firstName": "Mathiaos",
  "lastName": "Pereira",
  "email": "zawahiri@gmail.com",
  "password": "54321",
  "phone": "11974025064",
  "userStatus": 1
  }
  """
    Então quando faço um GET para /v3/user/zawahiri, o usuário criado é retornado


  Cenário: Criar um usuário na loja refletindo o negócio
    Quando crio um usuário
    Então o usuário é salvo no sistema
