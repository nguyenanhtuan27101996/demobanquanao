-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: thoitrang
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitiethoadon` (
  `mahoadon` int(11) NOT NULL,
  `machitietsanpham` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `giatien` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mahoadon`,`machitietsanpham`),
  KEY `fk_chitiethoadon_chitietsanpham_idx` (`machitietsanpham`),
  CONSTRAINT `fk_chitiet_hoadon` FOREIGN KEY (`mahoadon`) REFERENCES `hoadon` (`mahoadon`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_chitiethoadon_chitietsanpham` FOREIGN KEY (`machitietsanpham`) REFERENCES `chitietsanpham` (`machitietsanpham`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (5,4,1,'185,000'),(5,5,1,'185,000'),(5,6,1,'185,000');
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietkhuyenmai`
--

DROP TABLE IF EXISTS `chitietkhuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietkhuyenmai` (
  `makhuyenmai` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  PRIMARY KEY (`makhuyenmai`,`masanpham`),
  KEY `fk_chitiekhuyenmai_sanpham_idx` (`masanpham`),
  CONSTRAINT `fk_chitiekhuyenmai_sanpham` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_chitiet_khuyenmai` FOREIGN KEY (`makhuyenmai`) REFERENCES `khuyenmai` (`makhuyenmai`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietkhuyenmai`
--

LOCK TABLES `chitietkhuyenmai` WRITE;
/*!40000 ALTER TABLE `chitietkhuyenmai` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietkhuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietsanpham`
--

DROP TABLE IF EXISTS `chitietsanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietsanpham` (
  `machitietsanpham` int(11) NOT NULL AUTO_INCREMENT,
  `masanpham` int(11) DEFAULT NULL,
  `masize` int(11) DEFAULT NULL,
  `mamau` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `ngaynhap` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`machitietsanpham`),
  KEY `fk_chitiet_sanpham_idx` (`masanpham`),
  KEY `fk_chitiet_size_idx` (`masize`),
  KEY `fk_chitiet_mau_idx` (`mamau`),
  CONSTRAINT `fk_chitiet_mau` FOREIGN KEY (`mamau`) REFERENCES `mausanpham` (`mamau`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_chitiet_sanpham` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_chitiet_size` FOREIGN KEY (`masize`) REFERENCES `sizesanpham` (`masize`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietsanpham`
--

LOCK TABLES `chitietsanpham` WRITE;
/*!40000 ALTER TABLE `chitietsanpham` DISABLE KEYS */;
INSERT INTO `chitietsanpham` VALUES (4,1,1,1,15,'24/11/2017'),(5,1,2,2,10,'24/11/2017'),(6,1,3,1,8,'24/11/2017'),(10,2,1,1,30,'24/11/2017'),(11,2,1,2,20,'24/11/2017'),(12,2,2,2,10,'24/11/2017'),(17,3,1,1,5,'24/11/2017'),(18,3,1,2,3,'24/11/2017'),(19,3,2,1,5,'24/11/2017'),(20,3,3,2,3,'24/11/2017'),(21,4,1,1,4,'24/11/2017'),(22,4,1,2,6,'24/11/2017'),(23,4,2,1,5,'24/11/2017'),(24,5,1,1,6,'24/11/2017'),(25,6,1,2,7,'24/11/2017'),(26,7,1,1,7,'24/11/2017'),(27,7,2,1,7,'24/11/2017'),(28,7,3,2,8,'24/11/2017'),(29,7,2,2,8,'24/11/2017'),(30,8,1,1,7,'24/11/2017'),(31,9,1,2,7,'24/11/2017'),(32,10,2,2,5,'24/11/2017'),(33,11,3,1,4,'24/11/2017'),(34,12,1,1,5,'24/11/2017'),(35,13,1,5,5,'24/11/2017'),(36,14,1,3,5,'24/11/2017'),(37,15,1,2,4,'24/11/2017'),(38,16,1,2,3,'24/11/2017'),(39,17,1,2,4,'24/11/2017'),(40,18,2,2,6,'24/11/2017'),(41,19,1,2,6,'24/11/2017'),(42,20,2,3,4,'24/11/2017'),(43,21,1,5,6,'24/11/2017');
/*!40000 ALTER TABLE `chitietsanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chucvu` (
  `machucvu` int(11) NOT NULL AUTO_INCREMENT,
  `tenchucvu` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`machucvu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'Nhân Viên'),(2,'Admin'),(3,'Người Dùng');
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmucsanpham`
--

DROP TABLE IF EXISTS `danhmucsanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhmucsanpham` (
  `madanhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(100) DEFAULT NULL,
  `hinhdanhmuc` text,
  PRIMARY KEY (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmucsanpham`
--

LOCK TABLES `danhmucsanpham` WRITE;
/*!40000 ALTER TABLE `danhmucsanpham` DISABLE KEYS */;
INSERT INTO `danhmucsanpham` VALUES (1,'Áo sơ mi',NULL),(2,'Áo thun',NULL),(3,'Quần short',NULL),(4,'Đồ kiểu',NULL),(5,'Áo khoác',NULL),(6,'Áo đôi',NULL),(7,'Áo sơ mi Adachi Nữ',NULL),(8,'Quần tây',NULL),(9,'Quần jean Adachi Nam',NULL);
/*!40000 ALTER TABLE `danhmucsanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoadon` (
  `mahoadon` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhachhang` varchar(100) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `diachikhachhang` varchar(200) DEFAULT NULL,
  `tinhtrang` bit(1) DEFAULT NULL,
  `ngaylap` varchar(50) DEFAULT NULL,
  `hinhthucgiaohang` varchar(45) DEFAULT NULL,
  `ghichu` text,
  PRIMARY KEY (`mahoadon`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (5,'Nguyá»n Anh Tuáº¥n','01636218566','Sá» 4 Thá»¥y KhuÃª','\0',NULL,'Giao hÃ ng táº­n nÆ¡i','Giao nhanh nhÃ©');
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khuyenmai` (
  `makhuyenmai` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhuyenmai` varchar(200) DEFAULT NULL,
  `thoigianbatdau` varchar(50) DEFAULT NULL,
  `thoigianketthuc` varchar(50) DEFAULT NULL,
  `mota` text,
  `hinhkhuyenmai` text,
  `giagiam` int(11) DEFAULT NULL,
  PRIMARY KEY (`makhuyenmai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mausanpham`
--

DROP TABLE IF EXISTS `mausanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mausanpham` (
  `mamau` int(11) NOT NULL AUTO_INCREMENT,
  `tenmau` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mamau`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mausanpham`
--

LOCK TABLES `mausanpham` WRITE;
/*!40000 ALTER TABLE `mausanpham` DISABLE KEYS */;
INSERT INTO `mausanpham` VALUES (1,'Xanh Dương'),(2,'Xám'),(3,'Trắng'),(4,'Hồng'),(5,'Xanh Dương'),(6,'Xanh Lá'),(7,'Xanh Ngọc');
/*!40000 ALTER TABLE `mausanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhanvien` (
  `manhanvien` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(30) DEFAULT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `gioitinh` bit(1) DEFAULT NULL,
  `cmnd` char(14) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `machucvu` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tendangnhap` varchar(50) DEFAULT NULL,
  `matkhau` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`manhanvien`),
  KEY `fk_nhanvien_chucvu_idx` (`machucvu`),
  CONSTRAINT `fk_nhanvien_chucvu` FOREIGN KEY (`machucvu`) REFERENCES `chucvu` (`machucvu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Nguyễn Anh Tuấn','Số 4 ngách 460/64 Thụy Khuê, Tây Hồ, Hà Nội','','013255852','01636218566',2,'nguyenanhtuan27101996@gmail.com','nguyenanhtuan','123456'),(2,NULL,NULL,'\0',NULL,NULL,NULL,'tranhaiduong@gmail.com','tranhaiduong@gmail.com','1234'),(3,NULL,NULL,'\0',NULL,NULL,NULL,'vuvanhai@gmail.com','vuvanhai@gmail.com','1234'),(5,NULL,NULL,'\0',NULL,NULL,NULL,'hanh@gmail.com','hanh@gmail.com','123');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sanpham` (
  `masanpham` int(11) NOT NULL AUTO_INCREMENT,
  `madanhmuc` int(11) DEFAULT NULL,
  `tensanpham` varchar(100) DEFAULT NULL,
  `giatien` varchar(50) DEFAULT NULL,
  `mota` text,
  `hinhsanpham` text,
  `gianhcho` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`masanpham`),
  KEY `fk_sanpham_danhmuc_idx` (`madanhmuc`),
  CONSTRAINT `fk_sanpham_danhmuc` FOREIGN KEY (`madanhmuc`) REFERENCES `danhmucsanpham` (`madanhmuc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,1,'Sơ Mi Nam No Style TN O01','185,000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','79fb5c06-b673-9300-96da-00140b96c912.jpg','nam'),(2,1,'Sơ Mi Nam No Style TD R02','225,000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','b443d8c7-54cc-4500-4a2e-0013ff9ccb91.jpg','nam'),(3,1,'Sơ Mi Nam No Style TN O02','185,000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','7cb8e2db-a600-9c00-0d22-00140b981d57.jpg','nam'),(4,1,'Sơ Mi Nam No Style TN L01','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn. \n- Điểm nhấn ở túi áo và tay áo\n- Chất liệu Kate mang lại cảm giác thoáng mát.\n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','4364f967-2c49-6600-0912-0013c7dbecf6.jpg','nam'),(5,1,'Sơ Mi Nam No Style TD ST01','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d5ebdfa6-2945-2300-e7fe-0013fe31f537.jpg','nam'),(6,1,'Sơ Mi Nam No Style TN N03','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','71be5178-0fd9-3300-3f2f-001402e4a70d.jpg','nam'),(7,7,'Sơ Mi Adachi / 0012655','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d5ebdfa6-2945-2300-e7fe-0013fe31f537.jpg','nu'),(8,7,'Sơ Mi Adachi / 0012738','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','a4f67968-f23e-0100-8167-00129a10884e.jpg','nu'),(9,7,'Sơ Mi Adachi / 0012658','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','deec8c60-24e0-2400-041b-001266560db2.jpg','nu'),(10,7,'Sơ Mi Adachi / 0012658','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','c115c69d-008c-9900-eea8-00125b42fa42.jpg','nu'),(11,7,'Sơ Mi Nữ Ada / 0011510','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','235dbdd4-3e4c-0601-d255-0011b3196395.jpg','nu'),(12,7,'Sơ Mi Nữ Ada / 0011527','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d0876922-7a1a-1000-d878-0011cac12000.jpg','nu'),(13,5,'Áo Khoác Nam / 0012847','350,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','dbd236b7-632a-4d00-e24c-0012c7cebae9.jpg','nam'),(14,5,'Áo Khoác Nam / 0015281','350,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','f68cced6-1260-1800-8aba-0013f7c75d9d.jpg','nam'),(15,8,'Quần Tây Nam / 0013221','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','bc9c9562-4f7b-5000-3996-00130c201f8b.jpg','nam'),(16,8,'Quần Tây Nam / 0013149','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','1a210540-fc63-4f00-8a10-00130c1f9f3e.jpg','nam'),(17,9,'Quần Kaki Na / 0013761','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','6a77c9a8-65a8-7100-099b-00132237c111.jpg','nam'),(18,9,'Quần Jean Na / 0011530','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','14980579-6ccf-4700-8f83-0011bef478d3.jpg','nam'),(19,9,'Quần Jean Na / 0012764','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','f77d145c-d029-c000-b518-0012843a733b.jpg','nam'),(20,9,'Quần Jean Na / 0013631','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','aa1bf585-0b70-6300-c372-00131679d75e1841-00131679d749.gif','nam'),(21,9,'Quần Kaki Na / 0013757','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','cb3e216d-6429-0100-8fd0-00132239b82b.jpg','nam');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizesanpham`
--

DROP TABLE IF EXISTS `sizesanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sizesanpham` (
  `masize` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`masize`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizesanpham`
--

LOCK TABLES `sizesanpham` WRITE;
/*!40000 ALTER TABLE `sizesanpham` DISABLE KEYS */;
INSERT INTO `sizesanpham` VALUES (1,'M'),(2,'L'),(3,'XL'),(4,'XXL');
/*!40000 ALTER TABLE `sizesanpham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-10 16:12:34
