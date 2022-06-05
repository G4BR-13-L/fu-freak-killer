# EX05  - Escola de Idiomas
### Gabriel Victor Couto Martins de Paula
> - Engenharia de Software
> - Laboratório de Programação Modular


## Diagrama
<img src="Diagrama.png"/>

## Metodos e Atributos das classes
### classe Aluno

```java
+ class Aluno {
- static int QUANTIDADE_DE_ALUNOS = 0;
- int[] atividades;
- int frequencia;
- int matricula;
- String nome;

+ Aluno(String nome, int qtdAtividades)
+ Aluno(String nome)
- void gerarNumeroDeMatricula()
- void incrementarQuantidadeDeAlunos()
+ void darNota(int ativdade, int valor)
- static int converterParaPositivo(int num)
- static boolean validarNota(int nota)
+ int somaNotas(int[] arrayDeNotas)
+ int somaNotas()
+ void zerarNotas()
+ void darPresenca()
+ void conteudoAssistido(int c)
+ void conteudoAssistido()
+ void setNotasAtv(int[] Atvs)
+ void setFrequencia(int frequencia)
+ String getNome()
+ int getFrequencia()
+ String getMatricula()
+ int getSomaDasNotas()
+ String toString()
}
```

### classe Turma 
```java
+ abstract class Turma {
- LinkedList<Aluno> alunos = new LinkedList<>();
- String codigoDaTurma;

+ Turma(String codigo)
+ static boolean validarCodigo(String codigoDaTurma)
+ abstract int getQuantidadeDeAtividades();
+ void matricular(String nomeNovato)
# abstract void addAluno(Aluno novato)
+ String getCodigoDaTurma()
+ int getQuantidadeAlunos()
+ Aluno getAluno(int i)
+ void setCodigoDaTurma(String codigo)
+ abstract String getRelatorio(); 
+ LinkedList<Aluno> getAlunos()
}
```

### classe TurmaComNota
```java
+ class TurmaPresencial extends TurmaComNota {
- int qtdAtividades;
+ static final int QUANTIDADE_DE_ATIVIDADES = 4;

+ TurmaComNota(String codigo, int qtdAtividades)
+ void setQtdAtividades(int qtdAtividades)
+ int getQuantidadeDeAtividades()
+ double getMediaDeNotas()
+ abstract Aluno alunoDeMelhorDesempenho();
}
```

### classe TurmaPresencial 
```java
+ class TurmaPresencial extends TurmaComNota {
+ static final int PONTUACAO_TOTAL = 100;
+ static final int QUANTIDADE_DE_AULAS = 20;
+ static final int QUANTIDADE_DE_ALUNOS = 20;

+ TurmaPresencial(String codigo, int qtdAtividades)
+ void matricular(String nomeNovato)
# void addAluno(Aluno novato)
+ Aluno alunoDeMelhorDesempenho()
+ double getMediaDeFrequencia()
- static String getSituacaoDoAluno(Aluno a)
+ String getRelatorio()
}
```

### classe TurmaEAD 
```java
+ class TurmaEAD extends TurmaComNota  {
+ TurmaEAD(String codigo, int qtdAtividades)
# void addAluno(Aluno novato)
+ Aluno alunoDeMelhorDesempenho()
- static String getSituacaoDoAluno(Aluno a)
+ String getRelatorio()
}
```

### classe CursoLivre 
```java
+ class CursoLivre extends Turma  {

+ CursoLivre(String codigo, int qtdMateriais)
- void setQtdMateriais(int qtdMateriais2)
+ int getQuantidadeDeAtividades()
# void addAluno(Aluno novato)
+ String getRelatorio()
}
```


### classe Escola
```java
+ class Escola {
- LinkedList<Turma> turmas = new LinkedList<>();

+ int getQuantidadeDeTurmas()
+ void adicionarTurma(Turma novaTurma)
+ String relatorioListaDeTurmas()
}

```

