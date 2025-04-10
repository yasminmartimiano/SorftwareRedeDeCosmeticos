# Documentação de Alterações no Banco de Dados

**Projeto:** Sistema para as Lojas Rede  
**Grupo responsável pelo banco original:** Grupo do Isaque Joabe 
**Grupo desenvolvedor das alterações:** Lívia e Yasmin
**Data de início:** 07/04/2025

---

## 1. Objetivo

Este documento tem como finalidade registrar todas as modificações realizadas no banco de dados original fornecido pelo grupo do Isaque Joabe, a fim de adaptar a estrutura para o novo sistema implementado em Java com Spring Boot.

---

## 2. Estrutura Original do Banco

- Tabelas existentes:
    - `Categorias`
    - `Produtos`
    - `Fornecedores`
    - `Entrada`
    - `Saia`
    - `Funcionarios`
    - `Inventario`
    - `notas_fiscais`
    - `Clientesw`
    - `Enderecosw`
    - `Pedidos`
    - `carrinho`
    - `Pagamentos`
    - `retirada`
    - `Cliente_lj`
    - `Servicos`
    - `Funcionarios_lj`
    - `Agendamentos`
    - `Vendas`
    - `ItensVenda`
    - `transacao`
    - `notas_fisc`


- Relações principais:
    - Cada `usuario` pode ter várias `transacoes`
    - Cada `transacao` pertence a uma `categoria`

---

## 3. Alterações Realizadas

### 3.1. Renomeação de Tabelas

- `usuarios` → `clientes`  
  *Motivo:* O termo "cliente" reflete melhor o novo domínio da aplicação.

---

### 3.2. Novas Tabelas Criadas

- `cartoes_credito`  
  Campos: `id`, `numero_cartao`, `bandeira`, `limite`, `cliente_id`  
  *Motivo:* Gerenciar os cartões de crédito dos clientes vinculados ao sistema.

---

### 3.3. Novas Colunas Adicionadas

- Na tabela `transacoes`:
    - Adicionado `descricao` (VARCHAR)
    - Adicionado `status` (ENUM: 'PENDENTE', 'PAGA', 'ATRASADA')

---

### 3.4. Exclusão de Campos

- Tabela `categorias`  
  *Motivo:* Não é mais utilizado na nova interface.

---

### 3.5. Relações Atualizadas

- Criada nova relação: `clientes` → `cartoes_credito` (OneToMany)
- Atualizada a foreign key `transacoes.cliente_id` para refletir renomeação de `usuarios`

---

## 4.   Scripts de Alteração

**Script SQL (exemplo simplificado):**

```sql
ALTER TABLE usuarios RENAME TO clientes;

CREATE TABLE cartoes_credito (
  id BIGINT PRIMARY KEY,
  numero_cartao VARCHAR(16),
  bandeira VARCHAR(20),
  limite DECIMAL(10,2),
  cliente_id BIGINT,
  FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);