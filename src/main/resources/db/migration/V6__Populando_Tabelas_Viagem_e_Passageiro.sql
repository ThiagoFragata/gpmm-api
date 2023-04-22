INSERT INTO `viagem` (`id`, `destino`, `numero_apolice_seguro`, `quilometragem_chegada`, `quilometragem_saida`, `uri_apolice_seguro`, `motorista_id`, `solicitacao_id`, `transporte_id`) VALUES
	(1, 'Itacoatiara/Manaus/Itacoatiara', 'B1547899', NULL, 120879, '/arquivos/xdrweweww2.pdf', 4, 1, 1);

INSERT INTO `passageiro` (`viagem_id`, `pessoa_id`) VALUES
	(1, 2),
	(1, 5),
	(1, 4);

INSERT INTO `viagem` (`id`, `destino`, `numero_apolice_seguro`, `quilometragem_chegada`, `quilometragem_saida`, `uri_apolice_seguro`, `motorista_id`, `solicitacao_id`, `transporte_id`) VALUES
	(2, 'Itacoatiara/AM 010 KM 65/Itacoatiara', 'B15478110', NULL, 120950, '/arquivos/xdrweweww3.pdf', 4, 2, 1);

INSERT INTO `passageiro` (`viagem_id`, `pessoa_id`) VALUES
	(2, 10),
	(2, 17),
	(2, 19);

INSERT INTO `viagem` (`id`, `destino`, `numero_apolice_seguro`, `quilometragem_chegada`, `quilometragem_saida`, `uri_apolice_seguro`, `motorista_id`, `solicitacao_id`, `transporte_id`) VALUES
	(3, 'Itacoatiara/AM 010 KM 180/Itacoatiara', 'B1547874', NULL, 879945, '/arquivos/xdrweweww4.pdf', 3, 3, 2);

INSERT INTO `passageiro` (`viagem_id`, `pessoa_id`) VALUES
	(3, 1),
	(3, 2),
	(3, 5),
	(3, 6),
	(3, 7),
	(3, 10),
	(3, 11),
	(3, 12),
	(3, 13),
	(3, 14),
	(3, 15),
	(3, 16),
	(3, 17),
	(3, 18),
	(3, 19);

