Projeto: Aplicativo Calculadora de IMC
Disciplina: Programação Orientada a Objetos III  
Autor(a): Luana Figueiredo
Professor(a): Romes Heriberto Pires de Araujo
Mês/Ano: 05/2024

Descrição

- O aplicativo Calculadora de IMC  é uma ferramenta para calcular o Índice de Massa Corporal (IMC) com base nos dados fornecidos pelo usuário. 
Além de calcular o IMC, o aplicativo permite armazenar os resultados em um banco de dados PostgreSQL.

Funcionalidades

- Cálculo do IMC: O usuário pode inserir seu nome, idade, peso e altura para calcular seu IMC;
- Armazenamento de Resultados: Os resultados calculados podem ser armazenados em um banco de dados PostgreSQL;
- Splash Screen: Uma tela de introdução aparece ao iniciar o programa;
- Validação de Entrada: O programa valida se todos os campos obrigatórios foram preenchidos e se os valores numéricos estão no formato correto;
- Interface Gráfica: Interface amigável e intuitiva com uso de Swing para Java.

Pré-requisitos

- Java 11 ou superior;
- Maven;
- PostgreSQL;

Configuração do Banco de Dados

- Certifique-se de que o PostgreSQL está instalado e em execução;
- Atualize o Java Build PATH: 
	1. Clique com o botão direito sobre a pasta do projeto;
	2. Selecione Propriedades;
	3. Procure a opção Java Build Path, aba Libraries;
	4. Clique sobre o arquivo `postgresql-42.7.3.jar - C:\Users\luana\eclipse-workspace\calc_imc` e depois no botão Edit;
	5. Isso abrirá o explorador de arquivo do seu computador, vá até a pasta do projeto, localize e selecione o arquivo `postgresql-42.7.3.jar`.
- Atualize as credenciais de conexão (banco de dados, usuario e senha) com o banco de dados no arquivo DatabaseHelper.java, caso seja necessário;
- Estrutura da tabela de armazenamento dos resultados: 
	CREATE TABLE IF NOT EXISTS imc_records(
	            `id` SERIAL PRIMARY KEY, " 
	            `nome` VARCHAR(100) NOT NULL,
	            `idade` INT NOT NULL,
	            `peso` DOUBLE PRECISION NOT NULL, 
	            `altura` DOUBLE PRECISION NOT NULL, 
	            `imc` DOUBLE PRECISION NOT NULL, 
	            `data` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);

Compilação e Execução

- Compile o projeto usando Maven:
- cd calc_imc
- mvn clean package

Execute o projeto
- java -jar target/calc_imc-1.0-SNAPSHOT.jar ou tente executar o executável do projeto imc.jar

Uso
- Selecione o arquivo imc.jar;
- Ao iniciar o programa, uma tela de introdução (Splash Screen) será exibida por alguns segundos.
- Preencha os campos com seu nome, idade, peso e altura.
- Clique no botão para calcular o IMC.
- O resultado será automaticamente salvo no banco de dados.

Tratamento de Erros
- Campos Vazios: O programa verificará se todos os campos obrigatórios foram preenchidos. Se algum campo estiver vazio, uma mensagem de aviso será exibida.
- Formato de Entrada Inválido: Se os valores de peso ou altura não estiverem no formato numérico válido, uma mensagem de erro será exibida.

