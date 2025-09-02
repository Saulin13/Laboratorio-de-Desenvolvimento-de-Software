# Lab01S03 - Sistema de Matrículas Universitário - IMPLEMENTAÇÃO COMPLETA

## Descrição do Sistema

Uma universidade informatizou seu sistema de matrículas com as seguintes funcionalidades:

- **Secretaria**: Gera o currículo para cada semestre e mantém informações sobre disciplinas, professores e alunos
- **Cursos**: Cada curso tem nome, número de créditos e é constituído por diversas disciplinas
- **Matrículas**: Alunos podem se matricular em 4 disciplinas obrigatórias e 2 optativas
- **Períodos**: Há períodos específicos para efetuar matrículas
- **Validações**: Disciplina só fica ativa com mínimo de 3 alunos, máximo de 60 alunos
- **Cobranças**: Sistema de cobranças é notificado automaticamente após matrículas
- **Acesso**: Professores podem consultar alunos matriculados em suas disciplinas
- **Segurança**: Todos os usuários têm senhas para validação de login

## Estrutura do Projeto

```
src/main/java/sistema/
├── MenuPrincipal.java           # Interface de usuário completa
├── Usuario.java                 # Classe base abstrata para todos os usuários
├── Secretaria.java              # Gerenciamento de cursos, disciplinas e períodos
├── Professor.java               # Consulta de alunos matriculados
├── Aluno.java                   # Realização e cancelamento de matrículas
├── Curso.java                   # Representação de curso com disciplinas
├── Disciplina.java              # Gerenciamento de matrículas e capacidades
├── Matricula.java               # Representação de matrícula aluno-disciplina
├── TipoMatricula.java           # Enum para tipos de matrícula
├── PeriodoMatriculas.java       # Controle de períodos de matrícula
├── SistemaCobrancas.java        # Processamento de notificações e cobranças
├── SistemaMatriculas.java       # Coordenação central do sistema
└── Banco.java                   # Persistência em arquivos de texto

Arquivos de dados:
├── usuarios.txt                 # Usuários do sistema (ALUNO, PROF, SEC)
├── disciplinas.txt              # Disciplinas disponíveis
├── matriculas.txt               # Matrículas dos alunos
└── periodo.txt                  # Período de matrículas (persistido)
```

## Funcionalidades Implementadas

### **Interface de Usuário Completa (MenuPrincipal)**

#### **Sistema de Login**

- Validação de credenciais para todos os tipos de usuário
- Carregamento automático de dados ao iniciar
- Persistência automática ao sair

#### **Menu do Aluno**

- **Listar disciplinas**: Visualizar todas as disciplinas disponíveis
- **Matricular-se**: Realizar matrícula em disciplina (com validações)
- **Cancelar matrícula**: Cancelar matrícula existente

#### **Menu do Professor**

- **Minhas disciplinas e alunos**: Consultar alunos matriculados em suas disciplinas

#### **Menu da Secretaria**

- **Criar & abrir período**: Definir e ativar período de matrículas
- **Fechar período**: Desativar período de matrículas
- **Finalizar período**: Ativar disciplinas com ≥3 alunos, cancelar demais

### **Sistema de Autenticação**

- Validação de login e senha para todos os usuários
- Diferentes níveis de acesso por tipo de usuário
- Sessão persistente durante execução

### **Persistência de Dados**

- **Carregamento automático**: Usuários, disciplinas e matrículas ao iniciar
- **Salvamento automático**: Todos os dados ao sair do sistema
- **Arquivos de dados**:
  - `usuarios.txt`: Tipos, logins, senhas, nomes e emails
  - `disciplinas.txt`: Códigos, nomes, créditos e professores
  - `matriculas.txt`: Alunos, disciplinas, tipos e status
  - `periodo.txt`: Datas de início/fim e status ativo

### **Validações e Regras de Negócio**

- **Limite de matrículas**: Máximo 4 obrigatórias + 2 optativas por aluno
- **Capacidade de turma**: Máximo 60 alunos por disciplina
- **Disciplina ativa**: Mínimo 3 alunos para manter disciplina ativa
- **Período de matrículas**: Controle de acesso por período definido
- **Validação de login**: Senhas obrigatórias para todos os usuários
- **Notificação automática**: Sistema de cobranças notificado após matrículas

## Usuários de Teste

### **Alunos**

- **aluno1** (Maria Aluna) - senha: 123
- **aluno2** (João Aluno) - senha: 123
- **aluno3** (Carla Aluna) - senha: 123

### **Professor**

- **prof1** (Ana Prof) - senha: 123

### **Secretaria**

- **sec1** (Secretaria) - senha: 123

## Como Executar o Sistema

### **Requisitos**

- JDK 17 ou superior (compatível com JDK 8+)
- Sistema operacional: Windows, Linux ou macOS

### **Compilação**

```bash
# Navegar para o diretório da implementação
cd Implementacao

# Compilar todas as classes
javac -d bin src/main/java/sistema/*.java

# Ou compilar individualmente
javac -d bin src/main/java/sistema/Usuario.java
javac -d bin src/main/java/sistema/Aluno.java
javac -d bin src/main/java/sistema/Professor.java
javac -d bin src/main/java/sistema/Secretaria.java
javac -d bin src/main/java/sistema/Disciplina.java
javac -d bin src/main/java/sistema/Matricula.java
javac -d bin src/main/java/sistema/PeriodoMatriculas.java
javac -d bin src/main/java/sistema/SistemaMatriculas.java
javac -d bin src/main/java/sistema/SistemaCobrancas.java
javac -d bin src/main/java/sistema/Banco.java
javac -d bin src/main/java/sistema/MenuPrincipal.java
```

### **Execução**

```bash
# Executar o sistema principal
java -cp bin sistema.MenuPrincipal

# Ou executar a classe principal diretamente
java -cp bin sistema.MenuPrincipal
```

### **Fluxo de Uso**

1. **Inicialização**: Sistema carrega dados automaticamente
2. **Login**: Digite login e senha de um usuário de teste
3. **Menu específico**: Acesso às funcionalidades do tipo de usuário
4. **Operações**: Realize as operações disponíveis no menu
5. **Saída**: Sistema salva automaticamente todos os dados

## Arquitetura do Sistema

### **Camadas Implementadas**

- **Apresentação**: `MenuPrincipal` (interface de usuário completa)
- **Serviços**: `SistemaMatriculas`, `SistemaCobrancas`
- **Domínio**: `Aluno`, `Professor`, `Disciplina`, `Matricula`, `PeriodoMatriculas`
- **Persistência**: `Banco` (leitura/escrita de arquivos)

### **Padrões de Design**

- **MVC**: Separação entre interface, lógica de negócio e dados
- **Singleton**: Sistema centralizado de matrículas
- **Factory**: Criação de usuários por tipo
- **Observer**: Notificação automática de cobranças

## Funcionalidades por Tipo de Usuário

### **👨‍🎓 Aluno**

- ✅ Visualizar disciplinas disponíveis
- ✅ Realizar matrícula em disciplina
- ✅ Cancelar matrícula existente
- ✅ Consultar suas matrículas ativas
- ✅ Validação de limites de matrícula

### **👨‍🏫 Professor**

- ✅ Visualizar disciplinas que leciona
- ✅ Consultar alunos matriculados
- ✅ Acesso apenas às suas disciplinas

### **👩‍💼 Secretaria**

- ✅ Criar e abrir período de matrículas
- ✅ Fechar período de matrículas
- ✅ Finalizar período (ativar/cancelar disciplinas)
- ✅ Gerenciar configurações do sistema

## Regras de Negócio Implementadas

### **Matrículas**

- **Limite por aluno**: Máximo 4 disciplinas obrigatórias + 2 optativas
- **Capacidade de turma**: Máximo 60 alunos por disciplina
- **Disciplina ativa**: Mínimo 3 alunos para manter ativa
- **Período de matrículas**: Controle de acesso por período

### **Validações**

- **Login obrigatório**: Todos os usuários devem se autenticar
- **Período ativo**: Matrículas só podem ser feitas em período aberto
- **Capacidade**: Verificação de vagas disponíveis
- **Limites**: Controle de número máximo de matrículas por aluno

### **Persistência**

- **Carregamento automático**: Dados restaurados ao iniciar
- **Salvamento automático**: Estado persistido ao sair
- **Arquivos de dados**: Formato CSV simples e legível
- **Período persistido**: Configuração mantida entre execuções

## Status da Implementação

### **✅ COMPLETAMENTE IMPLEMENTADO (Lab01S03)**

- ✅ **Interface de usuário** completa via MenuPrincipal
- ✅ **Sistema de autenticação** funcional
- ✅ **Todas as funcionalidades** implementadas e testadas
- ✅ **Persistência de dados** em arquivos funcionando
- ✅ **Validações de regras** de negócio implementadas
- ✅ **Tratamento de erros** e validações
- ✅ **Sistema executável** e funcional
- ✅ **Documentação** completa e atualizada

### **Funcionalidades Principais**

- ✅ Login e autenticação de usuários
- ✅ Matrícula e cancelamento de disciplinas
- ✅ Consulta de alunos e disciplinas
- ✅ Gerenciamento de períodos de matrícula
- ✅ Validação de regras de negócio
- ✅ Persistência automática de dados
- ✅ Interface de usuário intuitiva

## Testes e Validação

### **Cenários Testados**

1. **Login de usuários**: Todos os tipos funcionando
2. **Matrícula de alunos**: Validações de limite e capacidade
3. **Cancelamento**: Remoção de matrículas existentes
4. **Períodos**: Criação, abertura e fechamento
5. **Persistência**: Carregamento e salvamento de dados
6. **Validações**: Regras de negócio aplicadas corretamente

### **Arquivos de Dados**

- **usuarios.txt**: Usuários de teste configurados
- **disciplinas.txt**: 5 disciplinas de exemplo
- **matriculas.txt**: Matrículas de teste
- **periodo.txt**: Período de matrículas persistido
