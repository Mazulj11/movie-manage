-- MySQL dump 10.13  Distrib 8.3.0, for Linux (x86_64)
--
-- Host: localhost    Database: movie_manage_db
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` bigint NOT NULL,
  `budget` bigint DEFAULT NULL,
  `genres` varchar(255) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `overview` varchar(255) DEFAULT NULL,
  `poster_path` varchar(512) DEFAULT NULL,
  `production_companies` varchar(255) DEFAULT NULL,
  `production_countries` varchar(255) DEFAULT NULL,
  `release_date` datetime(6) DEFAULT NULL,
  `revenue` bigint DEFAULT NULL,
  `runtime` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `vote_average` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,25000000,'Drama','http://www.warnerbros.com/movies/shawshank-redemption/','Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.','https://thegoodwillblog.in/wp-content/uploads/2023/07/d56b2942bc24e60043c79b061040c63d43ba529f0db1feff055e3b7a4dcc28ce._ur19201080_.jpg?w=1568','Castle Rock Entertainment, Warner Bros.','United States','1994-10-14 00:00:00.000000',28341469,142,'Released','The Shawshank Redemption',9),(2,6000000,'Crime, Drama','https://www.paramountmovies.com/movies/godfather-the','The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.','https://communist.red/wp-content/uploads/2022/08/godfather.png.webp','Paramount Pictures, Alfran Productions','United States','1972-03-24 00:00:00.000000',245066411,175,'Released','The Godfather',9),(3,185000000,'Action, Crime, Drama','https://www.warnerbros.com/dark-knight','When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.','https://m.media-amazon.com/images/S/pv-target-images/92d5aa88921788f14d4cf89f98b0db5f8381a965e0feeb0a21d1a32636b00d77.jpg','Warner Bros., Legendary Entertainment, Syncopy','United States','2008-07-18 00:00:00.000000',1004558444,152,'Released','The Dark Knight',9),(4,22000000,'Biography, Drama, History','https://www.uphe.com/movies/schindlers-list','In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.','https://scontent.fsjj1-1.fna.fbcdn.net/v/t39.30808-6/347810629_230562502919543_3424924236468411895_n.jpg?stp=dst-jpg_p180x540&_nc_cat=103&ccb=1-7&_nc_sid=5f2048&_nc_ohc=c5znpgS9xMMQ7kNvgGzsvij&_nc_ht=scontent.fsjj1-1.fna&oh=00_AYCon3O_Ij91YZsz3CBBhLwK-bpfRBkXmKews4n_mdqxKw&oe=665D5507','Universal Pictures, Amblin Entertainment','United States','1993-12-15 00:00:00.000000',321306305,195,'Released','Schindler\'s List',9),(5,94000000,'Action, Adventure, Drama','https://www.lordoftherings.net/film/the-return-of-the-king','Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.','https://beam-images.warnermediacdn.com/BEAM_LWM_DELIVERABLES/ad704585-6774-4d37-8c61-1bd41154173f/893d52c9771f2390e0166a1eba386ccbf68cd488.jpg?host=wbd-images.prod-vod.h264.io&partner=beamcom','New Line Cinema, WingNut Films','United States','2003-12-17 00:00:00.000000',1118888979,201,'Released','The Lord of the Rings: The Return of the King',9),(6,8000000,'Crime, Drama','https://www.miramax.com/movie/pulp-fiction/','The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.','https://beam-images.warnermediacdn.com/BEAM_LWM_DELIVERABLES/04d2059a-0056-4693-93cd-5fd1b7b02d4e/394696225b571c335b42a7a9329992b5f33ba8fb.jpg?host=wbd-images.prod-vod.h264.io&partner=beamcom','Miramax, A Band Apart','United States','1994-10-14 00:00:00.000000',213928762,154,'Released','Pulp Fiction',9),(7,93000000,'Action, Adventure, Drama','https://www.lordoftherings.net/film/the-fellowship-of-the-ring','A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.','https://m.media-amazon.com/images/S/pv-target-images/8f8fcc7680562055d10c1baa5be07d44780ecab56acc4de6948f416665a3a805.jpg','New Line Cinema, WingNut Films','United States','2001-12-19 00:00:00.000000',887824213,178,'Released','The Lord of the Rings: The Fellowship of the Ring',9),(8,55000000,'Drama, Romance','https://www.paramountmovies.com/movies/forrest-gump','The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.','https://m.media-amazon.com/images/S/pv-target-images/28ad5a615d61071e9d1aebbf684c89fcc3a8c5b3528d8ba778bb13198764d840.jpg','Paramount Pictures','United States','1994-07-06 00:00:00.000000',67822628,142,'Released','Forrest Gump',9),(9,63000000,'Drama','https://www.foxmovies.com/movies/fight-club','An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.','https://m.media-amazon.com/images/S/pv-target-images/3a8dc5e86501b0984857b20522d74f95217865cd9ab1ebac6a3b6f4b2b43bb50.jpg','20th Century Fox, Regency Enterprises','United States','1999-10-15 00:00:00.000000',100853753,139,'Released','Fight Club',9),(10,160000000,'Action, Adventure, Sci-Fi','https://www.warnerbros.com/inception','A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.','https://m.media-amazon.com/images/S/pv-target-images/21b2db2dbd1ecefe8e6d6578dd6f8c054da0cfc801d008b54167c81a7eaa0356.jpg','Warner Bros., Legendary Entertainment, Syncopy','United States','2010-07-16 00:00:00.000000',829895144,148,'Released','Inception',9),(11,63000000,'Action, Sci-Fi','https://www.warnerbros.com/matrix','A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.','https://www.elegant.hr/app/uploads/2021/08/ures_featured_image-1024x456.jpg','Warner Bros., Village Roadshow Pictures, Groucho II Film Partnership','United States','1999-03-31 00:00:00.000000',465343787,136,'Released','The Matrix',9),(12,25000000,'Biography, Crime, Drama','https://www.warnerbros.com/movies/goodfellas','The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.','https://m.media-amazon.com/images/M/MV5BYjllYzEzZDUtMmUxMi00MjEwLWFiYTQtNTg5OWY1MTlhYjI0XkEyXkFqcGdeQW1pYnJ5YW50._V1_.jpg','Warner Bros.','United States','1990-09-21 00:00:00.000000',46836394,146,'Released','Goodfellas',9),(13,79000000,'Action, Adventure, Drama','https://www.lordoftherings.net/film/the-two-towers','While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\'s new ally, Saruman, and his hordes of Isengard.','https://beam-images.warnermediacdn.com/BEAM_LWM_DELIVERABLES/1b73bd19-1229-4e5f-986a-ae38ac0f5476/0ec2443c6453941ace8685e85beae22916775f56.jpg?host=wbd-images.prod-vod.h264.io&partner=beamcom','New Line Cinema, WingNut Films','United States','2002-12-18 00:00:00.000000',926287400,179,'Released','The Lord of the Rings: The Two Towers',9),(14,19000000,'Crime, Drama, Thriller','https://www.mgm.com/movies/the-silence-of-the-lambs','A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.','https://m.media-amazon.com/images/S/pv-target-images/aa06c45c32304aa3c9c2758d683b0735042f65de98f5dc5a6da8cf629e286829.jpg','Orion Pictures','United States','1991-02-01 00:00:00.000000',272742922,119,'Released','The Silence of the Lambs',9),(15,33000000,'Crime, Drama, Mystery','https://www.newline.com/#!/se7en','Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpaQbxm-wxrIlUPG1EiD0PRclwoYjyAWnUuA&s','New Line Cinema, Cecchi Gori Pictures','United States','1995-09-22 00:00:00.000000',327311859,127,'Released','Se7en',9),(16,6000000,'Crime, Drama, Mystery','https://www.mgm.com/movies/the-usual-suspects','A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.','https://facts.net/wp-content/uploads/2023/06/32-facts-about-the-movie-the-usual-suspects-1687249683.jpg','PolyGram Filmed Entertainment, Spelling Films','United States','1995-07-19 00:00:00.000000',23341568,106,'Released','The Usual Suspects',9);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_seq`
--

DROP TABLE IF EXISTS `movie_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_seq`
--

LOCK TABLES `movie_seq` WRITE;
/*!40000 ALTER TABLE `movie_seq` DISABLE KEYS */;
INSERT INTO `movie_seq` VALUES (401);
/*!40000 ALTER TABLE `movie_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mateo.zulj@fpmoz.sum.ba',_binary '\0','Mateo','Zulj','$2a$10$VJlUwMZVJabuk9tePX642O299Sxnkb6OuD2jL5zElOJxjeXHO6h4a','ROLE_USER'),(2,'admin@admin.com',_binary '\0','Admin','User','$2a$10$031GHKTrDxgirgQ5LuXGteG5FKvdf5rd3YT5sCyH6xXxRfujOUFYm','ROLE_USER'),(52,'mateo.zulj11@gmail.com',_binary '\0','Mateo','Zulj','$2a$10$qp/aQqy4YHn2kSRN4ZcdLuCJFV.D3DaOq24i4EJDzHWhbmHvB2Jzm','ROLE_USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (151);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-31  7:25:46
