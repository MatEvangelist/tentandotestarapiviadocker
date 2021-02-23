# language: pt
# enconding: utf-08

Funcionalidade: Gerenciamento de um animal na loja
  Cenário: Listar somente animais disponíveis para a venda
    Dado que eu possua animais avaliable
    Quando eu pesquiso por todos animais avaliable
    Então eu recebo a lista