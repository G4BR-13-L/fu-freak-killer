y = { f(x) | x E A, p(x) }


par = { x | x E N, x % 2 == 0 }

impar = { 2x + 1 | x E N }

> De stream de volta para collection é collect

### Operações básicas

| Comando | Operação    |
| ------- | ----------- |
| Map     | S -> T      |
| Filter  | S -> {v, f} |
| Reduce  | S * S -> s  |
| Collect | ??          |
| Consume | S-> void    |


```java
double media = produtos
    .stream()
    .filter( p −> p instanceof BemDeConsumo )
    .mapToInt( Produto :: getQuant ) // Method reference
    .average()
    .getAsDouble() ;
```



