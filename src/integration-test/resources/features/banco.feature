# language: pt

@BancoTeste
#noinspection NonAsciiCharacters
Funcionalidade: Testar as operacoes basicas de banco
  O sistema deve prover operações básicas de banco de forma correta.

  Contexto: Dados de contas cadastradas e associadas ao banco
    Dado que as contas são do Banco do Brasil
      | dono                       | agencia | numero | saldo |
      | Fulano de Tal  Alves       | 1       | 123    | 1000  |
      | Abias Corpus Da Silva      | 1       | 145    | 100   |
      | Antônio Morrendo das Dores | 2       | 222    | 200   |
      | Carabino Tiro Certo        | 2       | 333    | 200   |


  Cenario: Verifica o total de contas criadas
    Dado o calculo do total de contas criadas
    Entao o total de contas e 4


  Cenario: Verifica o total de dinheiro no banco
    Dado o calculo do total de dinheiro
    Entao o total de dinheiro no banco e 1500.00