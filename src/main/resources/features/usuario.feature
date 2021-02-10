#language: pt
# enconding: utf-08

Funcionalidade: Gerenciamento de um usuário na Pet Store

  Cenário: Criar um usuário na loja refletindo o negócio
  Quando crio um usuário
  Então o usuário é salvo no sistema

#  Cenário: Criar um usuário na loja
#    Quando faço um POST com os seguintes valores:
#      | id         | 10                    |
#      | username   | matevangelista        |
#      | firstName  | Mathews               |
#      | lastName   | Evangelista           |
#      | email      | mathews.pee@gmail.com |
#      | password   | 12345                 |
#      | phone      | 11975668010           |
#      | userStatus | 1                     |
#    Então quando faço um GET, o usuário criado é retornado
#      E recebo o status code 200



#  Cenário: Criar um usuário na loja usando docstring
#    Quando faço um POST com a seguinte docstring:
#    """json
#  {
#  "id": 0,
#  "username": "string",
#  "firstName": "string",
#  "lastName": "string",
#  "email": "string",
#  "password": "string",
#  "phone": "string",
#  "userStatus": 0
#  }
#  """
#    Então quando faço um GET, o usuário criado é retornado