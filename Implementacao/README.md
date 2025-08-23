# Lab01S02 - Sistema de Matrículas Universitário

## Descrição do Projeto

Este projeto implementa o modelo estrutural (Diagrama de Classes) do Sistema de Matrículas Universitário desenvolvido em Java, contendo todas as classes, atributos e stubs dos métodos modelados.

## Estrutura do Projeto

```
src/main/java/sistema/
├── Usuario.java              # Classe base abstrata para todos os usuários
├── Secretaria.java           # Classe que representa a Secretaria da Universidade
├── Professor.java            # Classe que representa um Professor
├── Aluno.java               # Classe que representa um Aluno
├── Curso.java               # Classe que representa um Curso
├── Disciplina.java          # Classe que representa uma Disciplina
├── Matricula.java           # Classe que representa uma Matrícula
├── TipoMatricula.java       # Enum para tipos de matrícula (OBRIGATORIA/OPTATIVA)
├── PeriodoMatriculas.java   # Classe que representa um Período de Matrículas
├── SistemaCobrancas.java    # Classe que representa o Sistema de Cobranças
└── SistemaMatriculas.java   # Classe principal do sistema
```

## Classes e Responsabilidades

### 1. Usuario (Classe Abstrata)
- **Responsabilidade**: Classe base para todos os usuários do sistema
- **Atributos**: login, senha, nome, email
- **Métodos**: fazerLogin(), alterarSenha(), getters e setters

### 2. Secretaria (Herda de Usuario)
- **Responsabilidade**: Gerenciar cursos, disciplinas, alunos e períodos de matrícula
- **Atributos**: departamento
- **Métodos**: gerenciarCursos(), gerenciarDisciplinas(), gerenciarAlunos(), etc.

### 3. Professor (Herda de Usuario)
- **Responsabilidade**: Consultar alunos matriculados e disciplinas lecionadas
- **Atributos**: titulacao, disciplinasLecionadas
- **Métodos**: consultarAlunosMatriculados(), visualizarDisciplinasLecionadas()

### 4. Aluno (Herda de Usuario)
- **Responsabilidade**: Realizar e cancelar matrículas, consultar matrículas
- **Atributos**: matricula, curso, matriculas, creditosCursados
- **Métodos**: realizarMatricula(), cancelarMatricula(), consultarMatriculas()

### 5. Curso
- **Responsabilidade**: Representar um curso com suas disciplinas e alunos
- **Atributos**: nome, creditos, disciplinas, alunos
- **Métodos**: adicionarDisciplina(), removerDisciplina(), adicionarAluno()

### 6. Disciplina
- **Responsabilidade**: Gerenciar matrículas e verificar capacidades
- **Atributos**: codigo, nome, creditos, professor, curso, ativa, maxAlunos, matriculas
- **Métodos**: adicionarMatricula(), verificarCapacidade(), verificarMinimoAlunos()

### 7. Matricula
- **Responsabilidade**: Representar uma matrícula de aluno em disciplina
- **Atributos**: aluno, disciplina, tipo, dataMatricula, ativa
- **Métodos**: cancelar(), isAtiva()

### 8. TipoMatricula (Enum)
- **Valores**: OBRIGATORIA, OPTATIVA

### 9. PeriodoMatriculas
- **Responsabilidade**: Controlar períodos de matrícula
- **Atributos**: dataInicio, dataFim, ativo
- **Métodos**: verificarPeriodoAtivo(), ativar(), desativar()

### 10. SistemaCobrancas
- **Responsabilidade**: Processar notificações de matrícula e gerar cobranças
- **Métodos**: receberNotificacaoMatricula(), gerarCobranca(), processarPagamento()

### 11. SistemaMatriculas (Classe Principal)
- **Responsabilidade**: Coordenar todas as operações do sistema
- **Atributos**: usuarios, cursos, disciplinas, periodoAtual, sistemaCobrancas
- **Métodos**: validarCredenciais(), validarPeriodoMatriculas(), notificarCobrancas()

## Regras de Negócio Implementadas

1. **Limite de Matrículas**: Alunos podem se matricular em até 4 disciplinas obrigatórias e 2 optativas
2. **Capacidade de Turma**: Máximo de 60 alunos por disciplina
3. **Disciplina Ativa**: Mínimo de 3 alunos para manter disciplina ativa
4. **Período de Matrículas**: Controle de acesso por período definido
5. **Validação de Login**: Todos os usuários devem ter senhas válidas
6. **Notificação de Cobrança**: Sistema deve notificar cobranças automaticamente

## Relacionamentos entre Classes

- **SistemaMatriculas** gerencia **Usuario**, **Curso**, **Disciplina**, **PeriodoMatriculas**
- **SistemaMatriculas** notifica **SistemaCobrancas**
- **Curso** possui **Disciplina** e **Aluno**
- **Disciplina** possui **Matricula** e é lecionada por **Professor**
- **Aluno** possui **Matricula** e pertence a **Curso**
- **Professor** leciona **Disciplina**
- **Matricula** pertence a **Aluno** e **Disciplina**, tem **TipoMatricula**

## Status da Implementação

- ✅ **Classes criadas** com todos os atributos definidos
- ✅ **Stubs dos métodos** implementados com comentários TODO
- ✅ **Relacionamentos** entre classes estabelecidos
- ✅ **Documentação** completa com JavaDoc
- ⏳ **Implementação completa** dos métodos (próxima sprint)

## Próximos Passos (Lab01S03)

1. Implementar a lógica completa dos métodos marcados com TODO
2. Criar interface de usuário (linha de comando)
3. Implementar persistência em arquivos
4. Testar todas as funcionalidades do sistema
5. Validar regras de negócio implementadas

## Como Compilar e Executar

```bash
# Compilar o projeto
javac -d bin src/main/java/sistema/*.java

# Executar (quando implementado)
java -cp bin sistema.SistemaMatriculas
```

## Observações

- Todos os métodos estão implementados como stubs com comentários TODO
- A estrutura está pronta para a implementação completa na próxima sprint
- O modelo segue fielmente o diagrama de classes criado
- As regras de negócio estão refletidas na estrutura das classes
