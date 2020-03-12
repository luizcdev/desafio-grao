# Desafio Grão
Projeto de backend desenvolvido com Spring para cálculo de rendimentos com base na taxa selic

# Requisitos
  - Docker instalado

# Tutorial de instalação
  1) Baixe o projeto e descompacte em uma pasta de sua preferência
  2) Acesse a pasta do projeto
  3) Rode o seguinte comando: docker image build -t [nome imagem] .
     - Em [nome imagen] utilize o nome que desejar
     - Ex: ```docker image build -t desafio-grao .```
     - Atenção para o ponto no final do comando, ele é necessário
     - Esse processo irá compilar o projeto, rodar os testes, gerar o pacote e criar uma imagem no seu computador, por isso, é normal que demore alguns minutos
  4) Após finalizar a criação da imagem rode o seguinte comando : docker container run -p [porta host]:[porta interna] [nome imagem]
     - Em [porta host] informe a porta que o serviço ficará disponível na sua máquina
     - Em [porta interna] informe a porta que o serviço rodará dentro da imagem
     - Em [nome imagem] informe o nome da imagem que foi crida anteriormente
     - Ex: ```docker container run -p 8081:8080 desafio-grao```
    
  # Documentação
    - Disponível através do link host/swagger-ui.html
    - Ex: http://localhost:8081/swagger-ui.html
   
