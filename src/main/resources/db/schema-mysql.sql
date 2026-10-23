-- MecâniQA OAT 3 - esquema inicial MySQL. Execute no banco mecaniqa.
CREATE DATABASE IF NOT EXISTS mecaniqa CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE mecaniqa;

CREATE TABLE IF NOT EXISTS clientes (
  id_cliente BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(150) NOT NULL,
  cpf_cnpj VARCHAR(20) NOT NULL UNIQUE,
  email VARCHAR(150), telefone VARCHAR(30), endereco VARCHAR(200),
  cidade VARCHAR(100), estado VARCHAR(2), cep VARCHAR(12),
  data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao DATETIME NULL
);

CREATE TABLE IF NOT EXISTS veiculos (
  id_veiculo BIGINT PRIMARY KEY AUTO_INCREMENT,
  id_cliente BIGINT NOT NULL,
  placa VARCHAR(10) NOT NULL UNIQUE,
  marca_modelo VARCHAR(120) NOT NULL, ano INT NOT NULL, cor VARCHAR(40),
  numero_motor VARCHAR(80), numero_chassi VARCHAR(80), quilometragem DECIMAL(12,2) NOT NULL DEFAULT 0,
  observacoes TEXT, data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao DATETIME NULL,
  CONSTRAINT fk_veiculo_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE IF NOT EXISTS pecas (
  codigo_unico BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(150) NOT NULL, fornecedor_marca VARCHAR(150), quantidade_estoque INT NOT NULL DEFAULT 0,
  codigo_de_barras VARCHAR(100), preco_custo DECIMAL(12,2) NOT NULL DEFAULT 0,
  preco_venda DECIMAL(12,2) NOT NULL DEFAULT 0, tamanho DECIMAL(10,2), cor VARCHAR(50),
  categoria_peca VARCHAR(40), data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao DATETIME NULL
);

CREATE TABLE IF NOT EXISTS servicos (
  cod_unico BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome_servico VARCHAR(150) NOT NULL, tempo_estimado_minutos INT NOT NULL,
  custo_tabelado DECIMAL(12,2) NOT NULL, data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao DATETIME NULL
);

CREATE TABLE IF NOT EXISTS ordens_servico (
  numero_os BIGINT PRIMARY KEY AUTO_INCREMENT,
  id_cliente BIGINT NOT NULL, id_veiculo BIGINT NOT NULL,
  status VARCHAR(40) NOT NULL DEFAULT 'ABERTO', descricao_problema TEXT,
  observacoes TEXT, valor_total DECIMAL(12,2) NOT NULL DEFAULT 0,
  data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao DATETIME NULL, data_finalizacao DATETIME NULL,
  CONSTRAINT fk_os_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
  CONSTRAINT fk_os_veiculo FOREIGN KEY (id_veiculo) REFERENCES veiculos(id_veiculo)
);

CREATE TABLE IF NOT EXISTS pedidos_pecas (
  numero_pedido BIGINT PRIMARY KEY AUTO_INCREMENT,
  numero_os BIGINT NOT NULL, status VARCHAR(40) NOT NULL DEFAULT 'ORCANDO',
  fornecedor VARCHAR(150), valor_total DECIMAL(12,2) NOT NULL DEFAULT 0,
  valor_pago DECIMAL(12,2) NOT NULL DEFAULT 0, observacoes TEXT,
  data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao DATETIME NULL, data_entrega DATETIME NULL,
  CONSTRAINT fk_pedido_os FOREIGN KEY (numero_os) REFERENCES ordens_servico(numero_os)
);

CREATE TABLE IF NOT EXISTS itens_pedido (
  id_item BIGINT PRIMARY KEY AUTO_INCREMENT,
  numero_pedido BIGINT NOT NULL, codigo_peca BIGINT NOT NULL,
  quantidade INT NOT NULL, preco_unitario DECIMAL(12,2) NOT NULL,
  subtotal DECIMAL(12,2) NOT NULL, observacoes TEXT,
  data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_item_pedido FOREIGN KEY (numero_pedido) REFERENCES pedidos_pecas(numero_pedido) ON DELETE CASCADE,
  CONSTRAINT fk_item_peca FOREIGN KEY (codigo_peca) REFERENCES pecas(codigo_unico)
);

-- Relação muitos-para-muitos entre ordens de serviço e serviços executados.
CREATE TABLE IF NOT EXISTS ordem_servico_servicos (
  numero_os BIGINT NOT NULL, cod_servico BIGINT NOT NULL,
  PRIMARY KEY (numero_os, cod_servico),
  CONSTRAINT fk_oss_os FOREIGN KEY (numero_os) REFERENCES ordens_servico(numero_os) ON DELETE CASCADE,
  CONSTRAINT fk_oss_servico FOREIGN KEY (cod_servico) REFERENCES servicos(cod_unico)
);
