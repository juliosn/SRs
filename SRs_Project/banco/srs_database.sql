-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25-Ago-2023 às 22:52
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `srs_database`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `id_admin` int(11) NOT NULL,
  `num_acesso` int(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `nome_admin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`id_admin`, `num_acesso`, `senha`, `nome_admin`) VALUES
(1, 12345678, '123', 'Roberto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `condominio`
--

CREATE TABLE `condominio` (
  `id_condominio` int(11) NOT NULL,
  `nome_condominio` varchar(40) NOT NULL,
  `cep` int(10) NOT NULL,
  `endereco` varchar(32) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `uf` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `condominio`
--

INSERT INTO `condominio` (`id_condominio`, `nome_condominio`, `cep`, `endereco`, `bairro`, `cidade`, `uf`) VALUES
(1, 'SRs Condominio', 25145, 'Rua Sonho Gaucho', 'Itaquera', 'São Paulo', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `entrada`
--

CREATE TABLE `entrada` (
  `id_entrada` int(11) NOT NULL,
  `id_veiculos` int(11) NOT NULL,
  `data_entrada` date NOT NULL,
  `hora_entrada` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `entrada`
--

INSERT INTO `entrada` (`id_entrada`, `id_veiculos`, `data_entrada`, `hora_entrada`) VALUES
(2, 2, '0000-00-00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `morador`
--

CREATE TABLE `morador` (
  `num_registro` int(11) NOT NULL,
  `id_condominio` int(11) NOT NULL,
  `nome_morador` varchar(40) NOT NULL,
  `numeroAp` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `morador`
--

INSERT INTO `morador` (`num_registro`, `id_condominio`, `nome_morador`, `numeroAp`) VALUES
(1, 1, 'Jõao Felipe dos Santos', '135F'),
(2, 1, 'Testudo foda', '124GAY');

-- --------------------------------------------------------

--
-- Estrutura da tabela `porteiro`
--

CREATE TABLE `porteiro` (
  `id_porteiro` int(11) NOT NULL,
  `id_condominio` int(11) NOT NULL,
  `nome_porteiro` varchar(40) NOT NULL,
  `num_acesso` int(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `turno` enum('manhã','tarde','noite') NOT NULL,
  `situacao` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `porteiro`
--

INSERT INTO `porteiro` (`id_porteiro`, `id_condominio`, `nome_porteiro`, `num_acesso`, `senha`, `turno`, `situacao`) VALUES
(3, 1, 'Leandro Silva Dias', 1234, '1235', 'tarde', 'ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculos`
--

CREATE TABLE `veiculos` (
  `id_veiculos` int(11) NOT NULL,
  `num_registro` int(11) NOT NULL,
  `placa_veiculo` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `veiculos`
--

INSERT INTO `veiculos` (`id_veiculos`, `num_registro`, `placa_veiculo`) VALUES
(2, 1, 'RIO2A18');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_admin`);

--
-- Índices para tabela `condominio`
--
ALTER TABLE `condominio`
  ADD PRIMARY KEY (`id_condominio`);

--
-- Índices para tabela `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`id_entrada`),
  ADD KEY `id_veiculos_fk` (`id_veiculos`);

--
-- Índices para tabela `morador`
--
ALTER TABLE `morador`
  ADD PRIMARY KEY (`num_registro`),
  ADD KEY `id_condominio_fk` (`id_condominio`) USING BTREE;

--
-- Índices para tabela `porteiro`
--
ALTER TABLE `porteiro`
  ADD PRIMARY KEY (`id_porteiro`),
  ADD KEY `id_condominio_fkk` (`id_condominio`) USING BTREE;

--
-- Índices para tabela `veiculos`
--
ALTER TABLE `veiculos`
  ADD PRIMARY KEY (`id_veiculos`),
  ADD KEY `num_registro_fk` (`id_veiculos`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `condominio`
--
ALTER TABLE `condominio`
  MODIFY `id_condominio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `entrada`
--
ALTER TABLE `entrada`
  MODIFY `id_entrada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `porteiro`
--
ALTER TABLE `porteiro`
  MODIFY `id_porteiro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `veiculos`
--
ALTER TABLE `veiculos`
  MODIFY `id_veiculos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `id_veiculos_fk` FOREIGN KEY (`id_veiculos`) REFERENCES `veiculos` (`id_veiculos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `morador`
--
ALTER TABLE `morador`
  ADD CONSTRAINT `id_condominio_fk` FOREIGN KEY (`id_condominio`) REFERENCES `condominio` (`id_condominio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `porteiro`
--
ALTER TABLE `porteiro`
  ADD CONSTRAINT `id_condominio_fkk` FOREIGN KEY (`id_condominio`) REFERENCES `condominio` (`id_condominio`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
