-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-10-2023 a las 19:04:37
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_jacquis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `nivel` int(5) DEFAULT NULL,
  `estado_categoria` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `medio_pago` varchar(20) DEFAULT NULL,
  `tipo_cliente` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id_producto` int(11) DEFAULT NULL,
  `id_venta` int(11) DEFAULT NULL,
  `cantidad_producto` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta_online`
--

CREATE TABLE `detalle_venta_online` (
  `id_venta` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `id_prov_log` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` bigint(20) NOT NULL,
  `dui_empleado` bigint(9) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `apellido_dos` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `correo_empleado` varchar(255) DEFAULT NULL,
  `estado_empleado` varchar(10) NOT NULL,
  `empleado_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `dui_empleado`, `nombre`, `apellido`, `apellido_dos`, `direccion`, `correo_empleado`, `estado_empleado`, `empleado_fk`) VALUES
(1, 61607734, 'Julio Antonio', 'Torres', 'Rodriguez', 'Canton Achichilco', 'julioantonio859@gmail.com', 'ACTIVO', 1),
(2, 10146551, 'Luis Fernando', 'Vaquerano', 'Ramos', 'San Vicente, por un arbol', 'vaqueranoramos12@gmail.com', 'INACTIVO', 2),
(3, 123456789, 'Nayellis', 'Morales', 'Quintanilla', 'San Vicente', 'nayellis11@gmail.com', 'ACTIVO', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_producto`
--

CREATE TABLE `estado_producto` (
  `id_producto` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `precio_compra` double DEFAULT NULL,
  `ganancia` double DEFAULT NULL,
  `estado_producto` varchar(20) DEFAULT NULL,
  `precioUventa` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `talla` varchar(20) DEFAULT NULL,
  `estado_producto` tinyint(1) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `fechaInicio` date NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `estado_prov` tinyint(1) NOT NULL,
  `id_repre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor_logistica`
--

CREATE TABLE `proveedor_logistica` (
  `id_pl` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `empresa` varchar(100) DEFAULT NULL,
  `correo_empresa` varchar(100) DEFAULT NULL,
  `matricula` varchar(8) DEFAULT NULL,
  `estado_pl` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representante`
--

CREATE TABLE `representante` (
  `id_repre` int(11) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `fecha_inicio_repre` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tel_empleado`
--

CREATE TABLE `tel_empleado` (
  `id_telefono` bigint(20) NOT NULL,
  `dui_empleado` bigint(9) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tel_pl`
--

CREATE TABLE `tel_pl` (
  `tel_proveedor_logistica` varchar(8) DEFAULT NULL,
  `id_pl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tel_proveedor`
--

CREATE TABLE `tel_proveedor` (
  `id_prov` int(11) DEFAULT NULL,
  `tel_prov` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tel_representante`
--

CREATE TABLE `tel_representante` (
  `telefono` varchar(15) DEFAULT NULL,
  `id_repre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `dui_empleado` bigint(9) NOT NULL,
  `nick_usuario` varchar(100) DEFAULT NULL,
  `clave_usuario` varchar(255) DEFAULT NULL,
  `estado_usuario` tinyint(1) DEFAULT NULL,
  `rol_usuario` varchar(100) DEFAULT NULL,
  `id_emp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `dui_empleado` bigint(9) NOT NULL,
  `metodo_pago` varchar(20) DEFAULT NULL,
  `monto_total` double DEFAULT NULL,
  `fecha_hora` datetime DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_empleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD KEY `detalle_venta_producto_id_producto_fk` (`id_producto`),
  ADD KEY `detalle_venta_venta_id_venta_fk` (`id_venta`);

--
-- Indices de la tabla `detalle_venta_online`
--
ALTER TABLE `detalle_venta_online`
  ADD KEY `detalle_venta_online_venta_id_venta_fk` (`id_venta`),
  ADD KEY `detalle_venta_online_proveedor_logistica_id_pl_fk` (`id_prov_log`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD UNIQUE KEY `empleado_pk2` (`dui_empleado`),
  ADD UNIQUE KEY `empleado_pk` (`correo_empleado`);

--
-- Indices de la tabla `estado_producto`
--
ALTER TABLE `estado_producto`
  ADD KEY `estado_producto_producto_id_producto_fk` (`id_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `producto_proveedor_id_proveedor_fk` (`id_proveedor`),
  ADD KEY `producto_categoria_id_categoria_fk` (`id_categoria`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`),
  ADD KEY `repre_proveedor___fk` (`id_repre`);

--
-- Indices de la tabla `proveedor_logistica`
--
ALTER TABLE `proveedor_logistica`
  ADD PRIMARY KEY (`id_pl`);

--
-- Indices de la tabla `representante`
--
ALTER TABLE `representante`
  ADD PRIMARY KEY (`id_repre`);

--
-- Indices de la tabla `tel_empleado`
--
ALTER TABLE `tel_empleado`
  ADD PRIMARY KEY (`id_telefono`),
  ADD UNIQUE KEY `tel_empleado_pk` (`dui_empleado`);

--
-- Indices de la tabla `tel_pl`
--
ALTER TABLE `tel_pl`
  ADD KEY `tel_pl_proveedor_logistica_id_pl_fk` (`id_pl`);

--
-- Indices de la tabla `tel_proveedor`
--
ALTER TABLE `tel_proveedor`
  ADD KEY `tel_proveedor_proveedor_id_proveedor_fk` (`id_prov`);

--
-- Indices de la tabla `tel_representante`
--
ALTER TABLE `tel_representante`
  ADD KEY `tel_representante_representante_id_repre_fk` (`id_repre`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `usuario_pk` (`dui_empleado`),
  ADD KEY `usuario_empleado_id_empleado_fk` (`id_emp`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD UNIQUE KEY `venta_pk` (`dui_empleado`),
  ADD KEY `venta_cliente_id_cliente_fk` (`id_cliente`),
  ADD KEY `venta_empleado_id_empleado_fk` (`id_empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedor_logistica`
--
ALTER TABLE `proveedor_logistica`
  MODIFY `id_pl` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `representante`
--
ALTER TABLE `representante`
  MODIFY `id_repre` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tel_empleado`
--
ALTER TABLE `tel_empleado`
  MODIFY `id_telefono` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_producto_id_producto_fk` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  ADD CONSTRAINT `detalle_venta_venta_id_venta_fk` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`);

--
-- Filtros para la tabla `detalle_venta_online`
--
ALTER TABLE `detalle_venta_online`
  ADD CONSTRAINT `detalle_venta_online_proveedor_logistica_id_pl_fk` FOREIGN KEY (`id_prov_log`) REFERENCES `proveedor_logistica` (`id_pl`),
  ADD CONSTRAINT `detalle_venta_online_venta_id_venta_fk` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`);

--
-- Filtros para la tabla `estado_producto`
--
ALTER TABLE `estado_producto`
  ADD CONSTRAINT `estado_producto_producto_id_producto_fk` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_categoria_id_categoria_fk` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `producto_proveedor_id_proveedor_fk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `repre_proveedor___fk` FOREIGN KEY (`id_repre`) REFERENCES `representante` (`id_repre`);

--
-- Filtros para la tabla `tel_empleado`
--
ALTER TABLE `tel_empleado`
  ADD CONSTRAINT `tel_emp_fk` FOREIGN KEY (`dui_empleado`) REFERENCES `empleado` (`dui_empleado`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tel_pl`
--
ALTER TABLE `tel_pl`
  ADD CONSTRAINT `tel_pl_proveedor_logistica_id_pl_fk` FOREIGN KEY (`id_pl`) REFERENCES `proveedor_logistica` (`id_pl`);

--
-- Filtros para la tabla `tel_proveedor`
--
ALTER TABLE `tel_proveedor`
  ADD CONSTRAINT `tel_proveedor_proveedor_id_proveedor_fk` FOREIGN KEY (`id_prov`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Filtros para la tabla `tel_representante`
--
ALTER TABLE `tel_representante`
  ADD CONSTRAINT `tel_representante_representante_id_repre_fk` FOREIGN KEY (`id_repre`) REFERENCES `representante` (`id_repre`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_empleado_dui_empleado_fk` FOREIGN KEY (`dui_empleado`) REFERENCES `empleado` (`dui_empleado`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_cliente_id_cliente_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `venta_empleado_dui_empleado_fk` FOREIGN KEY (`dui_empleado`) REFERENCES `empleado` (`dui_empleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
