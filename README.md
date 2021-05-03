# Persistência de dados com MongoDB

## Organização do projeto

<br>

#### src/main/kotlin/com/creditas/trust/currencyconversion/**controller**
Contém os arquivos controllers: 

 * **CurrencyConversionController**: Responsável pelo endpoint que recebe a entrada para ser convertida pelo sistema

 * **ExchengeRateController** : Responsável pelo endpoint que consegue buscar, ler, adicionar e deletar  as taxas de câmbio no banco


#### src/main/kotlin/com/creditas/trust/currencyconversion/**data**/**models**/**ExchangeRate**
Contém a data class ExchangeRate marcado como @Document, contendo as informações a serem salvas:
* id -> atributo para dizer qual é a moeda (AUD, BRL, USD, EUR ou IRR)
* aud -> atributo por conter a taxa de cambio da moeda dita no id para a moeda AUD
* brl -> atributo por conter a taxa de cambio da moeda dita no id para a moeda BRL
* eur -> atributo por conter a taxa de cambio da moeda dita no id para a moeda EUR
* irr -> atributo por conter a taxa de cambio da moeda dita no id para a moeda IRR 
* usd -> atributo por conter a taxa de cambio da moeda dita no id para a USD 

#### src/main/kotlin/com/creditas/trust/currencyconversion/**data**/**repository**/**ExchengeRateRepository**
Repositorio responsavél por implementar um MongoRepository para a persistência de dados

#### src/main/kotlin/com/creditas/trust/currencyconversion/**service**/**ExchangeRageService**
Arquivo contendo a classe " **_class ExchangeRageService(val repository: ExchengeRateRepository)_**  ", onde implementa as regras de negocio para salvar as taxas de cambio no banco, buscar uma taxa pelo id, buscar todas as taxas, teletar uma taxa 