SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+02:00";

DROP TABLE IF EXISTS `presentations` CASCADE;

CREATE TABLE `presentations` (
  `id` int(11) NOT NULL,
  `folderName` varchar(512) NOT NULL,
  `numberOfSlides` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `presentations`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `presentations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT; 
