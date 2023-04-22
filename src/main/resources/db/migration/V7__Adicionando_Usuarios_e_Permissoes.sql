INSERT INTO `reserva_data`.`permissao` (`descricao`) VALUES ('ROLE_ADMINISTRADOR');
INSERT INTO `reserva_data`.`permissao` (`descricao`) VALUES ('ROLE_GERENTE');
INSERT INTO `reserva_data`.`permissao` (`descricao`) VALUES ('ROLE_MOTORISTA');
INSERT INTO `reserva_data`.`permissao` (`descricao`) VALUES ('ROLE_USUARIO');

INSERT INTO `reserva_data`.`usuario` (`pessoa_id`, `email`, `senha`) VALUES 
	(1, 'sueli@gmail.com', '{bcrypt}$2y$10$pRKppX697RR5lP/RKZzCvuW/J9BiRqfVM6WBXgqIqhvv9I0NFyjWm'),
	(2, 'bruna@gmail.com', '{bcrypt}$2y$10$3lJeyCJL.u1VFPQ1UJWRxesrXmoQacXyo7ggv0sFy6irbK8qB6tyO'),
	(3, 'kevin@gmail.com', '{bcrypt}$2y$10$9s8mPBJSFwbMoDvaPqGm6uK3v5J2HhJ5Ld2d0DIj0RYhQDggxgV4K'),
	(4, 'real@gmail.com', '{bcrypt}$2y$10$iIFOkjOP2gJSCKTAyXGhBukb/bKeK/O0UGtF63RK1seCm6GHmVjGi');

INSERT INTO `reserva_data`.`usuario_permissao` (`id_usuario`, `id_permissao`) VALUES 
(1, 1),
(2, 2),
(3, 4),
(4, 3);	