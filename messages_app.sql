--
-- Base de datos: `messages_app`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `messages`
--

CREATE TABLE `messages` (
  `id_message` int(10) NOT NULL,
  `id_user` int(6) NOT NULL,
  `message` varchar(280) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `messages`
--

INSERT INTO `messages` (`id_message`, `id_user`, `message`, `date`) VALUES
(1, 2, 'hola mundo, mi primer message', '2019-11-07 14:54:13'),
(3, 2, 'ola k ase', '2019-11-07 14:58:16'),
(4, 2, 'probando mi red social', '2019-11-07 14:59:12'),
(5, 1, 'hola santiago', '2019-11-07 15:02:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `users` (
  `id_user` int(7) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pw` varchar(32) NOT NULL,
  `full_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `email`, `pw`, `full_name`) VALUES
(1, 'usuario2@gmail.com', 'aca0c4983f0e917afae1929ee75c1cc1', 'luisa osorio'),
(2, 'exactlimon@gmail.com', '9adb7bea5c8e4350f5151cd135ab3042', 'santi bernal');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id_message`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `messages`
--
ALTER TABLE `messages`
  MODIFY `id_message` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;