CREATE TABLE `parceiro` (
  `id_parceiro` bigint(20) NOT NULL,
  `data_criacao` date NOT NULL,
  `nome_parceiro` varchar(255) NOT NULL,
  `nome_fantasia` varchar(255) NOT NULL,
  `cpf_parceiro` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,	
  `email` varchar(255) NOT NULL,
  `perfil` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `produto` (
  `id_produto` bigint(20) NOT NULL,
  `parceiro` bigint(20) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `creation_date` date NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
-- Indexes for table `parceiro`
--
ALTER TABLE `parceiro`
  ADD PRIMARY KEY (`id_parceiro`);
  
--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`),
  ADD KEY `FK46i4k5vl8wah7feutye9kbpi4` (`parceiro`);

--
-- AUTO_INCREMENT for table `parceiro`
--
ALTER TABLE `parceiro`
  MODIFY `id_parceiro` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` bigint(20) NOT NULL AUTO_INCREMENT;
--

--
-- Constraints for table `parceiro`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FK46i4k5vl8wah7feutye9kbpi4` FOREIGN KEY (`parceiro`) REFERENCES `parceiro` (`id_parceiro`);