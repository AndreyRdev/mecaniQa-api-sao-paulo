# MecâniQA API — OAT 3 (JDBC + MySQL)

## O que foi atualizado
- Os sete repositórios (`Cliente`, `Veiculo`, `Pecas`, `Servicos`, `OrdemServico`, `PedidoPecas` e `ItemPedido`) implementam a interface genérica oficial `Repository<T, ID>`.
- As operações CRUD utilizam SQL manual com `PreparedStatement` e JDBC, sem JPA, Hibernate ou Spring Data.
- Os resultados SQL são convertidos por classes dedicadas `*ResultSetMapper` em `Mappers`.
- Foi criada a camada `service`; os Controllers recebem Services por construtor e deixam de acessar os repositórios diretamente.
- O esquema de criação do banco está em `src/main/resources/db/schema-mysql.sql`.

## Configurar o MySQL
1. Inicie o MySQL Server.
2. Execute `src/main/resources/db/schema-mysql.sql` em um cliente MySQL. O script cria o banco `mecaniqa` e as tabelas.
3. Configure no ambiente de execução do IntelliJ:
   - `DB_URL=jdbc:mysql://localhost:3306/mecaniqa?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true`
   - `DB_USER=root` (ou seu usuário MySQL)
   - `DB_PASSWORD=sua_senha`
4. Confirme que o MySQL está ativo e execute `ApiApplication`.

Os repositórios usam JDBC nativo (`DriverManager`, `PreparedStatement`, `ResultSet`) e leem as variáveis `DB_URL`, `DB_USER` e `DB_PASSWORD`. Não coloque a senha real no repositório.

## Teste
Teste os endpoints existentes com a coleção Postman em `src/docs/MecaniQA_Postman_Collection.json`. Os registros de cliente e veículo usados nas ordens de serviço precisam existir previamente no banco.

## Observação sobre a compilação
O ZIP recebido não continha `gradle/wrapper/gradle-wrapper.jar`, então `./gradlew test` não pode ser executado diretamente com o wrapper incluído. Abra o projeto pelo IntelliJ com Gradle instalado/configurado e execute as tarefas de teste/compilação. A compilação de fontes Java foi verificada localmente com stubs das anotações Spring, mas não substitui um teste de integração com Spring Boot e MySQL reais.
