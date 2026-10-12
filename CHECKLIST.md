# Checklist — VassCommerce

* [x] O controller depende da interface `ProdutoModel`, sem criar implementações concretas com `new`.
* [x] Existem duas implementações de `ProdutoModel` anotadas com `@Service`.
* [x] A seleção da implementação é feita por `@Qualifier`.
* [x] A injeção de dependências é feita pelo construtor, sem `@Autowired` em campos.
* [x] O `ProdutoController` retorna `201 Created`, `200 OK` e `404 Not Found` conforme os testes realizados.
* [x] O cadastro utiliza `@Valid` e validações no `ProdutoCreateRequest`.
* [x] Os erros de validação retornam `400 Bad Request` por meio do `@RestControllerAdvice`.
* [x] O cadastro bem-sucedido retorna o cabeçalho `Location`.
* [x] A listagem permite filtrar produtos por nome e faixa de preço.
