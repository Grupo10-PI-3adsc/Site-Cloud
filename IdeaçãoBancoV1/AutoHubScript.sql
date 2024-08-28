DROP DATABASE IF EXISTS autohub;
CREATE DATABASE IF NOT EXISTS autohub;
USE autohub;

-- Criação da tabela Clientes
CREATE TABLE Clientes (
    ID_Cliente INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    CPF_CNPJ VARCHAR(20) NOT NULL UNIQUE,
    Endereço VARCHAR(255),
    Telefone VARCHAR(15),
    Email VARCHAR(100),
    Data_Cadastro DATE NOT NULL
);

-- Criação da tabela Veículos
CREATE TABLE Veículos (
    ID_Veículo INT AUTO_INCREMENT PRIMARY KEY,
    Placa VARCHAR(10) NOT NULL UNIQUE,
    Marca VARCHAR(50),
    Modelo VARCHAR(50),
    Ano_Fabricação YEAR,
    Cor VARCHAR(30),
    Número_Chassi VARCHAR(30) UNIQUE,
    ID_Cliente INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);

-- Criação da tabela Serviços
CREATE TABLE Serviços (
    ID_Serviço INT AUTO_INCREMENT PRIMARY KEY,
    Descrição VARCHAR(255) NOT NULL,
    Categoria VARCHAR(50),
    Preço DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Funcionários
CREATE TABLE Funcionários (
    ID_Funcionário INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Cargo VARCHAR(50),
    Data_Contratação DATE,
    Telefone VARCHAR(15),
    Email VARCHAR(100),
    Salário DECIMAL(10, 2)
);

-- Criação da tabela Agendamentos
CREATE TABLE Agendamentos (
    ID_Agendamento INT AUTO_INCREMENT PRIMARY KEY,
    ID_Cliente INT,
    ID_Veículo INT,
    ID_Funcionário INT,
    Data_Hora DATETIME NOT NULL,
    Serviço_Solicitado TEXT,
    Status ENUM('agendado', 'em andamento', 'concluído', 'cancelado') NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente),
    FOREIGN KEY (ID_Veículo) REFERENCES Veículos(ID_Veículo),
    FOREIGN KEY (ID_Funcionário) REFERENCES Funcionários(ID_Funcionário)
);

-- Criação da tabela Transações
CREATE TABLE Transações (
    ID_Transação INT AUTO_INCREMENT PRIMARY KEY,
    ID_Cliente INT,
    ID_Veículo INT,
    ID_Serviço INT,
    ID_Funcionário INT,
    Data_Transação DATETIME NOT NULL,
    Valor_Total DECIMAL(10, 2) NOT NULL,
    Forma_Pagamento ENUM('dinheiro', 'cartão', 'transferência') NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente),
    FOREIGN KEY (ID_Veículo) REFERENCES Veículos(ID_Veículo),
    FOREIGN KEY (ID_Serviço) REFERENCES Serviços(ID_Serviço),
    FOREIGN KEY (ID_Funcionário) REFERENCES Funcionários(ID_Funcionário)
);

-- Criação da tabela Histórico de Manutenção
CREATE TABLE Histórico_de_Manutenção (
    ID_Histórico INT AUTO_INCREMENT PRIMARY KEY,
    ID_Veículo INT,
    Data DATE NOT NULL,
    Descrição_Serviço TEXT,
    Peças_Substituídas TEXT,
    Observações TEXT,
    FOREIGN KEY (ID_Veículo) REFERENCES Veículos(ID_Veículo)
);

-- Criação da tabela Produtos
CREATE TABLE Produtos (
    ID_Produto INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Descrição TEXT,
    Categoria VARCHAR(50),
    Quantidade_Em_Estoque INT NOT NULL,
    Preço_Unitário DECIMAL(10, 2) NOT NULL,
    Fornecedor VARCHAR(100),
    Localização VARCHAR(100),
    Data_Atualização DATE NOT NULL
);

-- Criação da tabela Serviço_Produtos
CREATE TABLE Serviço_Produtos (
    ID_Serviço_Produto INT AUTO_INCREMENT PRIMARY KEY,
    ID_Serviço INT,
    ID_Produto INT,
    Quantidade_Usada INT NOT NULL,
    FOREIGN KEY (ID_Serviço) REFERENCES Serviços(ID_Serviço),
    FOREIGN KEY (ID_Produto) REFERENCES Produtos(ID_Produto)
);

-- Criação da tabela Movimentação de Estoque
CREATE TABLE Movimentação_de_Estoque (
    ID_Movimentação INT AUTO_INCREMENT PRIMARY KEY,
    ID_Produto INT,
    Tipo ENUM('entrada', 'saída', 'ajuste') NOT NULL,
    Quantidade INT NOT NULL,
    Data DATE NOT NULL,
    Motivo TEXT,
    ID_Agendamento INT,
    FOREIGN KEY (ID_Produto) REFERENCES Produtos(ID_Produto),
    FOREIGN KEY (ID_Agendamento) REFERENCES Agendamentos(ID_Agendamento)
);

-- Inserir dados na tabela Clientes
INSERT INTO Clientes (Nome, CPF_CNPJ, Endereço, Telefone, Email, Data_Cadastro) VALUES
('João Silva', '123.456.789-00', 'Rua das Flores, 123', '1234-5678', 'joao.silva@example.com', '2023-01-15'),
('Maria Oliveira', '987.654.321-00', 'Avenida Central, 456', '9876-5432', 'maria.oliveira@example.com', '2023-02-20');

-- Inserir dados na tabela Veículos
INSERT INTO Veículos (Placa, Marca, Modelo, Ano_Fabricação, Cor, Número_Chassi, ID_Cliente) VALUES
('ABC-1234', 'Fiat', 'Uno', 2020, 'Preto', '1F4A1234567890', 1),
('XYZ-5678', 'Honda', 'Civic', 2018, 'Prata', '2H5B0987654321', 2);

-- Inserir dados na tabela Serviços
INSERT INTO Serviços (Descrição, Categoria, Preço) VALUES
('Troca de óleo', 'mecânica', 150.00),
('Reparo de ar-condicionado', 'elétrica', 200.00);

-- Inserir dados na tabela Funcionários
INSERT INTO Funcionários (Nome, Cargo, Data_Contratação, Telefone, Email, Salário) VALUES
('Carlos Pereira', 'Mecânico', '2023-03-01', '3214-5678', 'carlos.pereira@example.com', 3000.00),
('Ana Costa', 'Atendente', '2023-04-10', '4321-8765', 'ana.costa@example.com', 2500.00);

-- Inserir dados na tabela Agendamentos
INSERT INTO Agendamentos (ID_Cliente, ID_Veículo, ID_Funcionário, Data_Hora, Serviço_Solicitado, Status) VALUES
(1, 1, 1, '2024-01-10 09:00:00', 'Troca de óleo', 'agendado'),
(2, 2, 2, '2024-01-15 14:00:00', 'Reparo de ar-condicionado', 'agendado');

-- Inserir dados na tabela Transações
INSERT INTO Transações (ID_Cliente, ID_Veículo, ID_Serviço, ID_Funcionário, Data_Transação, Valor_Total, Forma_Pagamento) VALUES
(1, 1, 1, 1, '2024-01-10 09:00:00', 150.00, 'cartão'),
(2, 2, 2, 2, '2024-01-15 14:00:00', 200.00, 'dinheiro');

-- Inserir dados na tabela Histórico de Manutenção
INSERT INTO Histórico_de_Manutenção (ID_Veículo, Data, Descrição_Serviço, Peças_Substituídas, Observações) VALUES
(1, '2023-12-01', 'Troca de óleo', 'Óleo e filtro', 'Serviço realizado conforme solicitado');

-- Inserir dados na tabela Produtos
INSERT INTO Produtos (Nome, Descrição, Categoria, Quantidade_Em_Estoque, Preço_Unitário, Fornecedor, Localização, Data_Atualização) VALUES
('Óleo 1L', 'Óleo de motor 1 litro', 'peças de motor', 100, 30.00, 'Fornecedor A', 'Prateleira 1', '2023-11-01'),
('Filtro de óleo', 'Filtro de óleo para motores', 'peças de motor', 50, 10.00, 'Fornecedor B', 'Prateleira 2', '2023-11-01');

-- Inserir dados na tabela Serviço_Produtos
INSERT INTO Serviço_Produtos (ID_Serviço, ID_Produto, Quantidade_Usada) VALUES
(1, 1, 1),  -- Troca de óleo usa 1 litro de Óleo 1L
(1, 2, 1);  -- Troca de óleo usa 1 filtro de óleo

-- Inserir dados na tabela Movimentação de Estoque
INSERT INTO Movimentação_de_Estoque (ID_Produto, Tipo, Quantidade, Data, Motivo, ID_Agendamento) VALUES
(1, 'entrada', 100, '2023-11-01', 'Compra de estoque', NULL),
(2, 'entrada', 50, '2023-11-01', 'Compra de estoque', NULL),
(1, 'saída', 1, '2024-01-10', 'Utilizado em serviço', 1),
(2, 'saída', 1, '2024-01-10', 'Utilizado em serviço', 1);


SELECT p.Nome, p.Quantidade_Em_Estoque, m.Tipo, m.Quantidade, m.Data, m.Motivo
FROM Produtos p
LEFT JOIN Movimentação_de_Estoque m ON p.ID_Produto = m.ID_Produto
ORDER BY p.ID_Produto, m.Data;

SELECT h.Data, h.Descrição_Serviço, h.Peças_Substituídas, h.Observações
FROM Histórico_de_Manutenção h
WHERE h.ID_Veículo = 1;

SELECT t.Data_Transação, c.Nome AS Cliente, v.Placa AS Veículo, s.Descrição AS Serviço, t.Valor_Total, t.Forma_Pagamento
FROM Transações t
JOIN Clientes c ON t.ID_Cliente = c.ID_Cliente
JOIN Veículos v ON t.ID_Veículo = v.ID_Veículo
JOIN Serviços s ON t.ID_Serviço = s.ID_Serviço;

SELECT a.Data_Hora, c.Nome AS Cliente, v.Placa AS Veículo, f.Nome AS Funcionário, a.Serviço_Solicitado, a.Status
FROM Agendamentos a
JOIN Clientes c ON a.ID_Cliente = c.ID_Cliente
JOIN Veículos v ON a.ID_Veículo = v.ID_Veículo
JOIN Funcionários f ON a.ID_Funcionário = f.ID_Funcionário;

SELECT c.Nome AS Cliente, v.Placa AS Placa, v.Marca AS Marca, v.Modelo AS Modelo
FROM Clientes c
JOIN Veículos v ON c.ID_Cliente = v.ID_Cliente;


