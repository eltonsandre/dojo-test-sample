# language: pt

@ContaTeste
#noinspection NonAsciiCharacters
Funcionalidade: Testar as operacoes basicas de conta
  O sistema deve prover o saque e deposito na conta de forma correta.
  Seguindo as seguintes restrições:
  1 - Só libera o saque, se o valor do saque for menor ou igual ao valor do saldo disponível na conta
  2 - Só libera o deposito, se o valor do deposito for menor ou igual ao valor do limite disponível na conta

  Esquema do Cenario: Validar saque e deposito do <dono>
    Dados que a conta criada com os seguintes dados
      | dono   | banco   | agencia   | numero   | limite   | saldo   |
      | <dono> | <banco> | <agencia> | <numero> | <limite> | <saldo> |
    Quando o dono realiza o deposito no valor de R$<deposito> em conta
    E sacar o valor de R$<primeiro saque>
    E sacar o valor de R$<segundo saque>
    Entao deverá ter em conta o saldo de R$<saldo esperado>

    Exemplos:
      | dono   | banco     | agencia | numero | limite | saldo | deposito | primeiro saque | segundo saque | saldo esperado |
      | Brendo | itau      | 12      | 111    | 1.000  | 0.00  | 100.00   | 10.00          | 10.00         | 80.00          |
      | Hiago  | santander | 23      | 222    | 1.000  | 0.00  | 200.00   | 10.00          | 10.00         | 180.00         |
      | Enzo   | agibank   | 2       | 123    | 1.000  | 0.00  | 200.00   | 10.00          | 10.00         | 180.00         |