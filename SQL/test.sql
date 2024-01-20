-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Jan 2024 pada 10.43
-- Versi server: 10.4.25-MariaDB
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmahasiswa`
--

CREATE TABLE `tmahasiswa` (
  `NIRM` varchar(9) NOT NULL,
  `NamaMahasiswa` varchar(50) NOT NULL,
  `TglLahir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tmahasiswa`
--

INSERT INTO `tmahasiswa` (`NIRM`, `NamaMahasiswa`, `TglLahir`) VALUES
('213111234', 'Natasha', '1990-01-01'),
('213111235', 'Erens', '1992-04-09'),
('213111236', 'Kristian', '1994-07-18'),
('213111237', 'Hana', '1996-10-27');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmatakuliah`
--

CREATE TABLE `tmatakuliah` (
  `KodeMK` varchar(5) NOT NULL,
  `NamaMataKuliah` varchar(50) NOT NULL,
  `Pengajar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tmatakuliah`
--

INSERT INTO `tmatakuliah` (`KodeMK`, `NamaMataKuliah`, `Pengajar`) VALUES
('MK-01', 'Matematika', 'Kent'),
('MK-03', 'Statistika', 'Chloe'),
('MK-05', 'Aljabar', 'Kenny'),
('MK-07', 'Pancasila', 'Linda');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tnilai`
--

CREATE TABLE `tnilai` (
  `NIRM` varchar(9) NOT NULL,
  `kodeMK` varchar(5) NOT NULL,
  `Grade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tnilai`
--

INSERT INTO `tnilai` (`NIRM`, `kodeMK`, `Grade`) VALUES
('213111234', 'MK-01', 70),
('213111235', 'MK-01', 40),
('213111236', 'MK-03', 80),
('213111234', 'MK-05', 78);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tmahasiswa`
--
ALTER TABLE `tmahasiswa`
  ADD PRIMARY KEY (`NIRM`);

--
-- Indeks untuk tabel `tmatakuliah`
--
ALTER TABLE `tmatakuliah`
  ADD PRIMARY KEY (`KodeMK`);

--
-- Indeks untuk tabel `tnilai`
--
ALTER TABLE `tnilai`
  ADD KEY `nilai_to_mahasiswa` (`NIRM`),
  ADD KEY `nilai_to_matakuliah` (`kodeMK`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tnilai`
--
ALTER TABLE `tnilai`
  ADD CONSTRAINT `nilai_to_mahasiswa` FOREIGN KEY (`NIRM`) REFERENCES `tmahasiswa` (`NIRM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nilai_to_matakuliah` FOREIGN KEY (`kodeMK`) REFERENCES `tmatakuliah` (`KodeMK`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
