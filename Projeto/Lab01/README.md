# Lab01 - Sistema de Matrículas Universitário

## Lab01S01 - Modelo de Análise ✅

### Histórias de Usuário

#### 1. Gestão de Cursos e Disciplinas

**Como** Secretaria da Universidade  
**Eu quero** gerenciar cursos e disciplinas  
**Para que** possa organizar a estrutura acadêmica da universidade

**Critérios de Aceitação:**

- Deve ser possível criar, editar e remover cursos
- Cada curso deve ter nome e número de créditos
- Deve ser possível associar disciplinas aos cursos
- Deve ser possível definir professores responsáveis pelas disciplinas

---

**Como** Secretaria da Universidade  
**Eu quero** gerar o currículo para cada semestre  
**Para que** os alunos possam se matricular nas disciplinas disponíveis

**Critérios de Aceitação:**

- Deve ser possível definir o período de matrículas
- Deve ser possível ativar/desativar disciplinas por semestre
- Deve ser possível definir o número máximo de alunos por disciplina (60)

#### 2. Gestão de Alunos

**Como** Secretaria da Universidade  
**Eu quero** cadastrar e gerenciar alunos  
**Para que** possam acessar o sistema de matrículas

**Critérios de Aceitação:**

- Deve ser possível criar, editar e remover cadastros de alunos
- Cada aluno deve ter login e senha únicos
- Deve ser possível associar alunos aos cursos

---

**Como** Aluno  
**Eu quero** fazer login no sistema  
**Para que** possa acessar minhas funcionalidades de matrícula

**Critérios de Aceitação:**

- Deve validar login e senha do aluno
- Deve permitir acesso apenas durante períodos de matrícula
- Deve mostrar mensagem de erro para credenciais inválidas

#### 3. Processo de Matrícula

**Como** Aluno  
**Eu quero** me matricular em disciplinas  
**Para que** possa cursar as disciplinas do semestre

**Critérios de Aceitação:**

- Deve permitir matrícula em até 4 disciplinas obrigatórias (1ª opção)
- Deve permitir matrícula em até 2 disciplinas optativas (alternativas)
- Deve verificar se a disciplina está ativa
- Deve verificar se há vagas disponíveis (máximo 60 alunos)
- Deve impedir matrícula duplicada na mesma disciplina

---

**Como** Aluno  
**Eu quero** cancelar matrículas  
**Para que** possa ajustar minha grade curricular

**Critérios de Aceitação:**

- Deve permitir cancelamento apenas durante o período de matrículas
- Deve confirmar o cancelamento antes de executá-lo
- Deve liberar a vaga para outros alunos

---

**Como** Sistema de Matrículas  
**Eu quero** verificar o número mínimo de alunos  
**Para que** possa ativar ou cancelar disciplinas automaticamente

**Critérios de Aceitação:**

- Deve verificar se há pelo menos 3 alunos matriculados
- Deve cancelar disciplinas com menos de 3 alunos
- Deve notificar alunos sobre disciplinas canceladas

#### 4. Gestão de Professores

**Como** Professor  
**Eu quero** fazer login no sistema  
**Para que** possa acessar informações das disciplinas que leciono

**Critérios de Aceitação:**

- Deve validar login e senha do professor
- Deve mostrar apenas disciplinas associadas ao professor

---

**Como** Professor  
**Eu quero** visualizar a lista de alunos matriculados  
**Para que** possa conhecer minha turma

**Critérios de Aceitação:**

- Deve mostrar todos os alunos matriculados na disciplina
- Deve exibir informações básicas dos alunos (nome, matrícula)
- Deve permitir filtrar por disciplina específica

#### 5. Integração com Sistema de Cobranças

**Como** Sistema de Matrículas  
**Eu quero** notificar o sistema de cobranças  
**Para que** os alunos sejam cobrados pelas disciplinas matriculadas

**Critérios de Aceitação:**

- Deve enviar dados de matrícula após confirmação
- Deve incluir informações do aluno e disciplinas matriculadas
- Deve garantir que a notificação seja enviada apenas uma vez por matrícula

#### 6. Gestão de Períodos de Matrícula

**Como** Secretaria da Universidade  
**Eu quero** definir períodos de matrícula  
**Para que** controle quando os alunos podem se matricular

**Critérios de Aceitação:**

- Deve permitir definir data de início e fim do período
- Deve bloquear matrículas fora do período definido
- Deve permitir múltiplos períodos por semestre

---

**Como** Sistema de Matrículas  
**Eu quero** controlar o acesso durante períodos de matrícula  
**Para que** apenas alunos autorizados possam se matricular

**Critérios de Aceitação:**

- Deve verificar se está dentro do período de matrículas
- Deve mostrar mensagem clara quando fora do período
- Deve permitir visualização de disciplinas mesmo fora do período

### Regras de Negócio Identificadas

1. **Limite de Matrículas**: Alunos podem se matricular em até 4 disciplinas obrigatórias e 2 optativas
2. **Capacidade de Turma**: Máximo de 60 alunos por disciplina
3. **Disciplina Ativa**: Mínimo de 3 alunos para manter disciplina ativa
4. **Período de Matrículas**: Controle de acesso por período definido
5. **Validação de Login**: Todos os usuários devem ter senhas válidas
6. **Notificação de Cobrança**: Sistema deve notificar cobranças automaticamente

### Atores Identificados

1. **Secretaria da Universidade**: Gerencia cursos, disciplinas, alunos e períodos
2. **Aluno**: Realiza matrículas e consulta informações
3. **Professor**: Consulta lista de alunos matriculados
4. **Sistema de Cobranças**: Recebe notificações de matrículas (sistema externo)

### Casos de Uso Principais

1. **Gerenciar Cursos e Disciplinas**
2. **Gerenciar Alunos**
3. **Fazer Login**
4. **Realizar Matrícula**
5. **Cancelar Matrícula**
6. **Consultar Alunos Matriculados**
7. **Definir Período de Matrículas**
8. **Notificar Sistema de Cobranças**

---

## Lab01S02 - Projeto Estrutural ✅

### Diagrama de Classes

O diagrama de classes foi criado em `diagramaClasses.puml` e representa a estrutura completa do sistema, incluindo:

- **11 Classes principais** com todos os atributos e métodos
- **1 Enum** para tipos de matrícula
- **Relacionamentos** entre todas as classes
- **Regras de negócio** refletidas na estrutura

### Projeto Java

O projeto Java foi criado na pasta `Implementacao/` com:

- **11 Classes Java** com todos os atributos definidos
- **Stubs dos métodos** implementados com comentários TODO
- **Documentação completa** com JavaDoc
- **Estrutura pronta** para implementação completa

#### Classes Implementadas:

1. **Usuario** (abstrata) - Classe base para todos os usuários
2. **Secretaria** - Gerencia cursos, disciplinas, alunos e períodos
3. **Professor** - Consulta alunos matriculados e disciplinas lecionadas
4. **Aluno** - Realiza e cancela matrículas
5. **Curso** - Representa um curso com disciplinas e alunos
6. **Disciplina** - Gerencia matrículas e verifica capacidades
7. **Matricula** - Representa uma matrícula de aluno em disciplina
8. **TipoMatricula** (enum) - OBRIGATORIA ou OPTATIVA
9. **PeriodoMatriculas** - Controla períodos de matrícula
10. **SistemaCobrancas** - Processa notificações e gera cobranças
11. **SistemaMatriculas** - Classe principal que coordena o sistema

### Status da Sprint S02

- ✅ **Diagrama de Classes** criado e documentado
- ✅ **Projeto Java** estruturado com todas as classes
- ✅ **Atributos** definidos conforme modelo
- ✅ **Stubs dos métodos** implementados
- ✅ **Documentação** completa do projeto

### Próximos Passos (Lab01S03)

1. Implementar a lógica completa dos métodos marcados com TODO
2. Criar interface de usuário (linha de comando)
3. Implementar persistência em arquivos
4. Testar todas as funcionalidades do sistema
5. Validar regras de negócio implementadas
