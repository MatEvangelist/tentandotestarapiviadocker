# language: pt
# enconding: utf-08

  Funcionalidade: Gerenciamento de pedidos

    @DeleteExtraPets
    Cenário: Cliente cria um pedido na loja
      Dado que eu possua animal available
      Quando faço o pedido desse animal
      Então o pedido é aprovado
