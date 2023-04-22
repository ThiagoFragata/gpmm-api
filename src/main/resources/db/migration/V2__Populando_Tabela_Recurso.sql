INSERT INTO `recurso` (`id`, `descricao`) VALUES
	(1, 'Pickup Nissan'),
	(2, 'Van Mercedes-Benz'),
	(3, 'Auditório geral'),
	(4, 'Mini auditório'),
	(5, 'Sala de reunião'),
	(6, 'Projeto de slide 01'),
	(7, 'Projeto de slide 02'),
	(8, 'Notebook Dell 01'),
	(9, 'Mesa de som Behringer');

INSERT INTO `equipamento` (`numero_patrimonio`, `tipo`, `id`) VALUES
	('2001547', 'PROJETOR', 6),
	('2001548', 'PROJETOR', 7),
	('2001521', 'NOTEBOOK', 8),
	('2001530', 'MESASOM', 9);

INSERT INTO `local` (`identificacao`, `total_de_assento`, `id`) VALUES
	('A101', 200, 3),
	('A210', 30, 4),
	('C101', 20, 5);
	
INSERT INTO `transporte` (`placa`, `total_de_assentos`, `id`) VALUES
	('HTG-1262', 4, 1),
	('IAD-2304', 16, 2);