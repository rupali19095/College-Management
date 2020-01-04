-- MySQL dump 10.13  Distrib 5.7.11, for Win64 (x86_64)
--
-- Host: localhost    Database: projectdb
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminid` varchar(20) DEFAULT NULL,
  `adminpassword` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('Rupali','123'),('Shivali','0412');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admission`
--

DROP TABLE IF EXISTS `admission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admission` (
  `admno` int(11) DEFAULT NULL,
  `admdate` varchar(20) DEFAULT NULL,
  `sname` varchar(30) DEFAULT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `mname` varchar(30) DEFAULT NULL,
  `adr` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dep` varchar(40) DEFAULT NULL,
  `depc` varchar(30) DEFAULT NULL,
  `rollno` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admission`
--

LOCK TABLES `admission` WRITE;
/*!40000 ALTER TABLE `admission` DISABLE KEYS */;
INSERT INTO `admission` VALUES (1,'10/01/17','Rupali','Manoj','Monika','68 A Fatehabd','97654302425','rupali@gmail.com','female',18,'Computer Science','CSE','17_CSE_1'),(2,'10/01/17','Mohit','prem','teena','delhi','98734288397','mohit@gmail.com','male',17,'Computer Science','CSE','17_CSE_2'),(3,'10/01/17','Rahul','Jeet','Shanu','chandigarh','893634221','rahul@gmail.com','male',19,'Electronics and communication','ECE','17_ECE_1'),(4,'10/01/17','Suman','Rajesh','Neeta','Fatehabad','9385045768','suman@gmail.com','female',17,'Information Technology','IT','17_IT_1'),(5,'10/01/17','Rajat','Surendar','anita','Delhi','8743209415','rajat@gmail.com','male',18,'Computer Science','CSE','17_CSE_3'),(6,'10/01/17','Lovepreet','Rahul','Reeta','Chandigarh','9832483535','love@gmail.com','male',19,'Computer Science','CSE','17_CSE_4');
/*!40000 ALTER TABLE `admission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attend`
--

DROP TABLE IF EXISTS `attend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attend` (
  `rollno` varchar(40) DEFAULT NULL,
  `date` varchar(40) DEFAULT NULL,
  `sub` varchar(40) DEFAULT NULL,
  `attend` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attend`
--

LOCK TABLES `attend` WRITE;
/*!40000 ALTER TABLE `attend` DISABLE KEYS */;
INSERT INTO `attend` VALUES ('17_CSE_1','11/01/17','Physics','P'),('17_CSE_3','11/01/17','Physics','P'),('17_CSE_3','11/01/17','Physics','A'),('17_CSE_1','11/01/17','Maths','P'),('17_CSE_2','11/01/17','Maths','P'),('17_CSE_3','11/01/17','Maths','P'),('17_CSE_4','11/01/17','Maths','A'),('17_CSE_1','11/01/17','Maths','P'),('17_CSE_2','11/01/17','Maths','P'),('17_CSE_3','11/01/17','Maths','P'),('17_CSE_4','11/01/17','Maths','A'),('17_CSE_1','04/01/18','Physics','P'),('17_CSE_2','04/01/18','Physics','A'),('17_CSE_3','04/01/18','Physics','P'),('17_CSE_4','04/01/18','Physics','A'),('17_CSE_1','04/01/18','Physics','P'),('17_CSE_2','04/01/18','Physics','A'),('17_CSE_3','04/01/18','Physics','P'),('17_CSE_4','04/01/18','Physics','A'),('17_CSE_1','04/01/18','Physics','P'),('17_CSE_2','04/01/18','Physics','A'),('17_CSE_3','04/01/18','Physics','P'),('17_CSE_4','04/01/18','Physics','A');
/*!40000 ALTER TABLE `attend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedetail`
--

DROP TABLE IF EXISTS `feedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedetail` (
  `receptno` varchar(20) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `rollno` varchar(30) DEFAULT NULL,
  `dep` varchar(40) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL,
  `semfee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedetail`
--

LOCK TABLES `feedetail` WRITE;
/*!40000 ALTER TABLE `feedetail` DISABLE KEYS */;
INSERT INTO `feedetail` VALUES ('1','10/01/17','17_CSE_1','Computer Science',1,50000),('2','10/01/17','17_CSE_1','Computer Science',2,50000),('3','10/01/17','17_CSE_2','Computer Science',1,50000),('4','10/01/17','17_ECE_1','Electronics and communication',1,50000),('5','10/01/17','17_ECE_1','Electronics and communication',2,50000),('6','10/01/17','17_CSE_3','Computer Science',1,50000),('7','10/01/17','17_CSE_3','Computer Science',2,50000),('8','10/01/17','17_IT_1','Information Technology',1,50000),('9','10/01/17','17_CSE_4','Computer Science',1,50000),('10','10/01/17','17_CSE_3','Computer Science',2,50000),('','26/12/17','1001','',1,50000),('12','06/01/18','17_CSE_2','Computer Science',4,50000);
/*!40000 ALTER TABLE `feedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marksentry`
--

DROP TABLE IF EXISTS `marksentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marksentry` (
  `rollno` varchar(30) DEFAULT NULL,
  `dep` varchar(30) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL,
  `sub` varchar(40) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marksentry`
--

LOCK TABLES `marksentry` WRITE;
/*!40000 ALTER TABLE `marksentry` DISABLE KEYS */;
INSERT INTO `marksentry` VALUES ('17_CSE_1','Computer Science',1,'Maths',78),('17_CSE_2','Computer Science',1,'Maths',98),('17_CSE_3','Computer Science',1,'Maths',56),('17_CSE_4','Computer Science',1,'Maths',12);
/*!40000 ALTER TABLE `marksentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password` (
  `opassword` varchar(40) DEFAULT NULL,
  `npassword` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `stud`
--

DROP TABLE IF EXISTS `stud`;
/*!50001 DROP VIEW IF EXISTS `stud`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `stud` AS SELECT 
 1 AS `rollno`,
 1 AS `sname`,
 1 AS `sem`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `stud1`
--

DROP TABLE IF EXISTS `stud1`;
/*!50001 DROP VIEW IF EXISTS `stud1`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `stud1` AS SELECT 
 1 AS `rollno`,
 1 AS `sname`,
 1 AS `sem`,
 1 AS `dep`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `syllabus`
--

DROP TABLE IF EXISTS `syllabus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syllabus` (
  `dep` varchar(40) DEFAULT NULL,
  `depc` varchar(30) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL,
  `subc` varchar(20) DEFAULT NULL,
  `sub` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syllabus`
--

LOCK TABLES `syllabus` WRITE;
/*!40000 ALTER TABLE `syllabus` DISABLE KEYS */;
INSERT INTO `syllabus` VALUES ('Computer Science','CSE',1,'CSE101','Maths'),('Computer Science','CSE',1,'CSE102','Physics'),('Computer Science','CSE',1,'CSE103','Chemistry'),('Computer Science','CSE',1,'CSE104','Human Values'),('Electronics and communication','ECE',1,'ECE101','Maths '),('Electronics and communication','ECE',1,'ECE102','Physics'),('Electronics and communication','ECE',1,'ECE103','Chemistry'),('Electronics and communication','ECE',1,'ECE104','Digital Electronics'),('Information Technology','IT',1,'IT101','Physics'),('Information Technology','IT',1,'IT102','Chemistry'),('Information Technology','IT',1,'IT103','Maths'),('Information Technology','IT',1,'IT104','FOC'),('Mechanical','MACT',1,'MACT101','Maths'),('Mechanical','MACT',1,'MACT102','Physics'),('Mechanical','MACT',1,'MACT103','Chemistry'),('Mechanical','MACT',1,'MACT104','Mechanics'),('Computer Science','CSE',2,'CSE201','Physics'),('Computer Science','CSE',2,'CSE202','Maths'),('Computer Science','CSE',2,'CSE203','EVS'),('Computer Science','CSE',2,'CSE204','C language'),('Electronics and communication','ECE',2,'ECE201','Maths'),('Electronics and communication','ECE',2,'ECE202','Physics'),('Electronics and communication','ECE',2,'ECE203','EVS'),('Electronics and communication','ECE',2,'ECE204','Analog Signals'),('Information Technology','IT',2,'IT201','Maths'),('Information Technology','IT',2,'IT202','Physics'),('Information Technology','IT',2,'IT203','EVS'),('Information Technology','IT',2,'IT204','MP'),('Mechanical','MACT',2,'MACT201','Maths'),('Mechanical','MACT',2,'MACT202','Physics'),('Mechanical','MACT',2,'MACT203','EVS'),('Mechanical','MACT',2,'MACT204','MP'),('Computer Science','CSE',1,'CSE101','Maths'),('Computer Science','CSE',1,'CSE102','Physics'),('Computer Science','CSE',1,'CSE103','Chemistry'),('Computer Science','CSE',1,'CSE104','FOC');
/*!40000 ALTER TABLE `syllabus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `usertype` varchar(40) DEFAULT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `userid` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `dep` varchar(40) DEFAULT NULL,
  `rollno` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Faculty','Sunita','sunita','100','Computer Science','',''),('Student','Rupali','Rupali','123','Computer Science','1001','8130834547'),('Faculty','Aman','Aman','234','Computer Science','','7565847382');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v1`
--

DROP TABLE IF EXISTS `v1`;
/*!50001 DROP VIEW IF EXISTS `v1`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v1` AS SELECT 
 1 AS `rollno`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `viewmarks`
--

DROP TABLE IF EXISTS `viewmarks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viewmarks` (
  `dep` varchar(40) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL,
  `sub` varchar(40) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewmarks`
--

LOCK TABLES `viewmarks` WRITE;
/*!40000 ALTER TABLE `viewmarks` DISABLE KEYS */;
/*!40000 ALTER TABLE `viewmarks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `stud`
--

/*!50001 DROP VIEW IF EXISTS `stud`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `stud` AS select `feedetail`.`rollno` AS `rollno`,`admission`.`sname` AS `sname`,`feedetail`.`sem` AS `sem` from (`admission` join `feedetail`) where (`admission`.`rollno` = `feedetail`.`rollno`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `stud1`
--

/*!50001 DROP VIEW IF EXISTS `stud1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `stud1` AS select `feedetail`.`rollno` AS `rollno`,`admission`.`sname` AS `sname`,`feedetail`.`sem` AS `sem`,`admission`.`dep` AS `dep` from (`admission` join `feedetail`) where (`admission`.`rollno` = `feedetail`.`rollno`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v1`
--

/*!50001 DROP VIEW IF EXISTS `v1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v1` AS select `marksentry`.`rollno` AS `rollno` from `marksentry` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-06 14:41:58
