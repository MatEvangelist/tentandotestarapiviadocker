# language: pt
# enconding: utf-08

Funcionalidade: Gerenciamento de um animal na loja

  Cenário: Listar somente animais disponíveis para a venda
    Dado que eu possua animais available
    Quando eu pesquiso por todos animais available
    Então eu recebo a lista de animais avaliable
    # Passo dessnecessário, somente para exmeplo
    E eu recebo uma outra lista de animais available

  Cenário: Lista somente os animais pending
    Dado que eu possua animais pending
    Quando eu pesquiso por todos animais pending
    Então eu recebo a lista com 2 animais

  Cenário: Não lista nenhum animal
    Dado que eu não possua animais sold
    Quando eu pesquiso por todos animais sold
    Então eu recebo a lista com 0 animal

  Esquema do Cenario: Lista animais pelo seu status de venda
    Dado que eu não possua animais sold
    Quando eu pesquiso por todos animais <status>
    Então eu recebo a lista com <quantidade> animais

    Exemplos: Animais em estoque
      | status    | quantidade |
      | available | 7          |
      | pending   | 2          |

    Exemplos: Animais sem estoque
      | status | quantidade |
      | sold   | 0          |

  Cenário: Lista animais disponíveis à venda
    Dado que eu possua animais available
    Quando pesquiso por todos animais available
    Então recebo a lista com 7 animais available
    E 3 animais possuem o nome Lion