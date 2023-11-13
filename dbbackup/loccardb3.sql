-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13-Nov-2023 às 19:53
-- Versão do servidor: 5.5.27
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `loccardb3`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `cpf` varchar(18) NOT NULL,
  `endereco` varchar(60) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `cep` varchar(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cpf`, `endereco`, `telefone`, `email`, `cep`) VALUES
(1, 'tonilson', '765436000', 'Qr 311 Cj 8 Lote 22', '61983753695', 'tonilsonmanoel@gmail.com', '865342'),
(3, 'Marcos Heitor Farias', '452.428.580-60', 'Rua Cacau', '(96) 3724-4979', 'marcos_farias@onset.com.br', '68908-786'),
(5, 'Raul Pietro', '021.253.396-76', 'Rua K', '(82) 99789-8962', 'raul-barbosa78@vizzacchi.com.br', '57010-795'),
(8, 'Pedro', '778.125.443-05', 'QR 311 ch4', '61983753695', 'pedro@gotmail.com', '72307108'),
(12, 'Manoel', '152.154.656-00', 'QR 122', '61983753655', 'maonel@gmail.com', '64641-565'),
(19, 'Rita Clara Gomes', '056.452.474-34', 'Rua Parecis', '(43) 99605-5918', 'ritaclaragomes@gmail.com', '86183-200');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cores`
--

CREATE TABLE `cores` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cores`
--

INSERT INTO `cores` (`id`, `nome`) VALUES
(1, 'Preto'),
(2, 'Azul'),
(3, 'Vermelho'),
(6, 'Branco'),
(9, 'Prata');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(18) NOT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `cep` varchar(9) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `codigoverificador` varchar(10) DEFAULT NULL,
  `perfil` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`id`, `nome`, `cpf`, `endereco`, `cep`, `telefone`, `email`, `senha`, `codigoverificador`, `perfil`) VALUES
(10, 'Administrador', '754.546.465-65', 'Teste', '87651-222', '(61) 98654-35', 'admin@admin.com', 'admin123', NULL, 1),
(4, 'Sheldon Cooper ', '076.245.744-03', 'QR 311 Cj 8 Lote  50', '7230710', '61983753644', 'shelson@gmail.com', 'tonix1999', NULL, NULL),
(15, 'Tonilsonx', '888.55.44.56', 'QR 311 Conjunto 8', '72307-108', '61983753695', 'tonilsonx360@gmail.com', '@admin99', '239082', NULL),
(7, 'Joao ', '122.255.255-55', 'QR 321 cj3', '72307108', '6198354653', 'joao2@gmail.com', 'joao123', NULL, NULL),
(16, 'Tonilson Silva', '888554646', 'QR 311 Conjunto 8', '75333-555', '6198355466', 'tnnovidades@gmail.com', '@admin', '1004789', NULL),
(18, 'Tonilson Manoel', '054.546.578-98', 'QR 355 Samambaia', '72308-565', '(61) 98654-9999', 'tonilsonmanoel@gmail.com', '@admin123', NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacoes`
--

CREATE TABLE `locacoes` (
  `id` int(11) NOT NULL,
  `data_inicio` date NOT NULL,
  `data_termino` date NOT NULL,
  `valor_diaria` decimal(10,2) DEFAULT NULL,
  `valor_locacao` decimal(10,2) DEFAULT NULL,
  `valor_pago` decimal(10,2) DEFAULT NULL,
  `status_locacao` varchar(45) DEFAULT NULL,
  `veiculos_id` int(11) DEFAULT NULL,
  `clientes_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `locacoes`
--

INSERT INTO `locacoes` (`id`, `data_inicio`, `data_termino`, `valor_diaria`, `valor_locacao`, `valor_pago`, `status_locacao`, `veiculos_id`, `clientes_id`) VALUES
(27, '2023-06-06', '2023-06-19', '35.00', '280.00', '11.00', 'ENCERRADO', 8, 1),
(33, '2023-10-28', '2023-11-10', '40.00', '350.00', '15.00', 'ALUGADO', 2, 1),
(32, '2023-06-09', '2023-06-14', '40.00', '160.00', '160.00', 'ENCERRADO', 16, 12),
(24, '2023-06-05', '2023-06-10', '15.00', '60.00', '60.00', 'ENCERRADO', 9, 8),
(25, '2023-06-06', '2023-06-10', '20.00', '120.00', '55.50', 'ENCERRADO', 11, 12),
(26, '2023-06-06', '2023-06-10', '35.00', '150.00', '0.00', 'ENCERRADO', 3, 5),
(34, '2023-11-04', '2023-11-06', '2.00', '4.00', '7.50', 'ALUGADO', 8, 8),
(35, '2023-11-06', '2023-11-15', '3.50', '4.00', '15.00', 'ENCERRADO', 13, 8),
(36, '2023-11-12', '2023-11-13', '35.00', '110.15', '2.50', 'ALUGADO', 9, 12),
(37, '2023-11-12', '2023-11-14', '55.55', '355.33', '5.00', 'ALUGADO', 3, 5),
(38, '2023-11-13', '2023-11-14', '10.50', '50.00', '0.00', 'ENCERRADO', 11, 8),
(39, '2023-11-13', '2023-11-15', '20.00', '115.00', '5.00', 'ALUGADO', 11, 12),
(41, '2023-11-13', '2023-11-15', '45.00', '120.00', '50.00', 'ALUGADO', 17, 19);

-- --------------------------------------------------------

--
-- Estrutura da tabela `marcas`
--

CREATE TABLE `marcas` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `marcas`
--

INSERT INTO `marcas` (`id`, `nome`) VALUES
(1, 'FIAT'),
(2, 'Volkswagen '),
(3, 'Chevrolet'),
(6, 'Hyundai'),
(7, 'Renault '),
(11, 'JEEP'),
(12, 'Peugeot');

-- --------------------------------------------------------

--
-- Estrutura da tabela `modelos`
--

CREATE TABLE `modelos` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `marcas_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `modelos`
--

INSERT INTO `modelos` (`id`, `nome`, `marcas_id`) VALUES
(1, 'fastback', 1),
(2, 'Uno Way', 1),
(3, 'Gol 1.0', 2),
(5, 'S10', 3),
(7, 'HB20', 6),
(9, 'Kwid', 7),
(10, 'Renagade', 9),
(14, '208 Like', 12),
(13, 'Renegade', 11);

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculos`
--

CREATE TABLE `veiculos` (
  `id` int(11) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `ano` int(11) NOT NULL,
  `disponibilidade` varchar(60) NOT NULL,
  `modelos_id` int(11) DEFAULT NULL,
  `cores_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `veiculos`
--

INSERT INTO `veiculos` (`id`, `placa`, `ano`, `disponibilidade`, `modelos_id`, `cores_id`) VALUES
(16, 'KSA-5521', 2022, 'DISPONIVEL', 13, 6),
(2, '150255', 2018, 'ALUGADO', 2, 2),
(3, '21531153', 2015, 'ALUGADO', 3, 3),
(4, '555-8543', 2018, 'DISPONIVEL', 1, 2),
(8, '555-7574', 2019, 'ALUGADO', 5, 3),
(13, 'DLA-2131', 2023, 'DISPONIVEL', 2, 1),
(9, '222-4565', 2022, 'DISPONIVEL', 7, 2),
(10, '555-2177', 2011, 'ALUGADO', 7, 3),
(11, 'BRA-1E23', 2022, 'ALUGADO', 9, 6),
(17, 'CMG-6533', 2023, 'ALUGADO', 14, 9);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `cores`
--
ALTER TABLE `cores`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `locacoes`
--
ALTER TABLE `locacoes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `clientes_id` (`clientes_id`),
  ADD KEY `veiculos_id` (`veiculos_id`);

--
-- Índices para tabela `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `modelos`
--
ALTER TABLE `modelos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `marcas_id` (`marcas_id`);

--
-- Índices para tabela `veiculos`
--
ALTER TABLE `veiculos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `modelos_id` (`modelos_id`),
  ADD KEY `cores_id` (`cores_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `cores`
--
ALTER TABLE `cores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de tabela `locacoes`
--
ALTER TABLE `locacoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de tabela `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `modelos`
--
ALTER TABLE `modelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `veiculos`
--
ALTER TABLE `veiculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
