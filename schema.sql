-- ============================================
-- Script de creación de base de datos
-- ============================================


CREATE TABLE IF NOT EXISTS usuario (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    clave VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL DEFAULT 'USER',
    token_recuperacion VARCHAR(255),
    token_expiracion DATETIME
    );

-- Tabla Cancion
CREATE TABLE IF NOT EXISTS cancion (
id INT AUTO_INCREMENT PRIMARY KEY,nombre VARCHAR(150) NOT NULL,
    ritmo VARCHAR(50),
    duracion INT COMMENT 'duracion en segundos',
    album VARCHAR(150),
    posicionEnAlbum INT,
    banda VARCHAR(150),
    interprete VARCHAR(150),
    autor VARCHAR(150),
    fechaLanzamiento DATE
    );

-- ============================================
-- Datos iniciales
-- ============================================

INSERT INTO usuario (nombre, email, clave, rol) VALUES
('Administrador', 'admin@cancionweb.com', 'admin123', 'ADMIN'),
('Usuario Prueba', 'usuario@cancionweb.com', 'user123', 'USER');

INSERT INTO cancion (nombre, ritmo, duracion, album, posicionEnAlbum, banda, interprete, autor, fechaLanzamiento) VALUES
('Bohemian Rhapsody', 'Rock', 355, 'A Night at the Opera', 11, 'Queen', 'Freddie Mercury', 'Freddie Mercury', '1975-10-31'),
('Billie Jean', 'Pop', 294, 'Thriller', 6, NULL, 'Michael Jackson', 'Michael Jackson', '1983-01-02'),
('Hotel California', 'Rock', 391, 'Hotel California', 1, 'Eagles', 'Don Henley', 'Don Felder', '1976-12-08'),
('Despacito', 'Reggaeton', 229, 'Vida', 4, NULL, 'Luis Fonsi', 'Luis Fonsi', '2017-01-12'),
('Smells Like Teen Spirit', 'Grunge', 301, 'Nevermind', 1, 'Nirvana', 'Kurt Cobain', 'Kurt Cobain', '1991-09-10'),
('La Bicicleta', 'Vallenato Pop', 217, 'Vida', 3, NULL, 'Carlos Vives', 'Carlos Vives', '2016-04-15');