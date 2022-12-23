# Aula 06/05

- Exceções e serialização
## Serialização
````javascript
JSON.stringfy()
JSON.parse()
`````

> Polimorfismo parametrico
>> Parametrizar o dado ou Parametrizar com um objeto de código ```Comparator```

### Exemplo: Veiculo
````java
public class Veiculo implements Sreializable{}
````

### Serializando por conta propria:
````java
public void sakvarBinario(DataOutputStream arq){
    arq.writeUTF(this.placa);
    arq.writeDouble(this.kmRodados);
    arq.writeDouble(this.valorVenda);
    // pronto kabou
}
````
> Para ler...
````java
public static Veiculo sakvarBinario(DataInputStream arq){
    /*String placa = arq.readUTF();
    double km = arq.readDouble();
    double valor = arq.readDouble();
    return new Veiculo(placa, km, valor);*/

    return new Veiculo(arq.readUTF(), arq.readDouble(), arq.readDouble());
}
````

A interface ```Serializable```possui metodos estáticos que não precisam ser implementados, mas é necessário um numero de série. para garantir a convergencia e compatibilidade entre objetos. "Se voce mexer em qualquer coisa da classe, voce muda o numero de série"
```java
private static final long serialVersionUID = 20221L
```
