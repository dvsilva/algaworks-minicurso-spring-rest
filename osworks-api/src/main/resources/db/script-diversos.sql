-- migration 002 original comando
alter table cliente rename column telefone to fone;

-- inserindo clientes
INSERT INTO `osworks`.`cliente` (`nome`, `email`, `fone`) VALUES ('João da Silva', 'joaodasilva@gmail.com', '34 9999-3333');
INSERT INTO `osworks`.`cliente` (`nome`, `email`, `fone`) VALUES ('Maria Abadia', 'maria@algaworks.com', '11 8888-333');
