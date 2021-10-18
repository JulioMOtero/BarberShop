# BarberShop
Um projeto pessoal para testar meus conhecimentos com spring  

####Inserir/deletar cliente || 2 endpoints  /cadastro(post)  /delete

####CLIENTE 

nome | telefone | qtd cortes promo
A cada 10 cortes de barba ou cabelo o prox corte do cliente é gratis
desmarca horario || endpoint /desmarcar/{nomecliente}

####AGENDAMENTO
- 1 - cabelo 
- 2 - barba
- 3 - ambos

####BARBEIRO 
comissao 10% por corte
marcar horario || post

agenda do dia (barbeiro) ||endpoint /agenda
- {
  [
    nome 
    produto 
    horario
]
  }