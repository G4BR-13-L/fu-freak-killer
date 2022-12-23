
```java

- int dia
- int mes
- int ano
- int diasMes[]

- int dia;
- int mes;
- int ano;
- int diasMes[]
+ Data(int dia, int mes, int ano)
+ Data(int dia, int mes)
+ Data(int dia)
+ Data()
- void setData(int dia, int mes, int ano)
+ void proximoDia()
+ void adicionarDias(int dias)
- void corrigirData()
+ boolean validarDia()
- void configuraAnoBisexto()
+ boolean eAnoBisexto()
+ String diaDaSemana()
+ int diasNoMes()
+ String porExtenso()
+ String getDataFormatada()
+ int getDia()
- void setDia(int dia)
+ int getMes()
- void setMes(int mes)
+ int getAno()
- void setAno(int ano)
}

```