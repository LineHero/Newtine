DROP DATABASE IF EXISTS newtine;
CREATE DATABASE IF NOT EXISTS newtine;
USE newtine;

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
	`user_no` int NOT NULL auto_increment,
	`user_id` varchar(20) NOT NULL,
	`user_password` varchar(20) NOT NULL,
	`user_nickname` varchar(20) NOT NULL,
	`user_name` varchar(20) NOT NULL,
	`user_email` varchar(40) NOT NULL,
	`user_phonenumber` varchar(15) NOT NULL,
	`user_isadmin` boolean NOT NULL,
    `user_profile_fileid` varchar(500),
    `user_profile_filename` varchar(200),
    PRIMARY KEY (`user_no`)
);
DROP TABLE IF EXISTS `streak`;
CREATE TABLE IF NOT EXISTS `streak` (
	`user_no` int NOT NULL,
    `health_date` DATE NOT NULL,
    PRIMARY KEY (`user_no`, `health_date`),
    FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);

CREATE TABLE IF NOT EXISTS `bodyprofile` (
	`measure_date` DATE NOT NULL,
	`user_no` int NOT NULL,
	`weight` double NOT NULL,
	`muscle_mass` double NOT NULL,
	`skeletal_muscle_mass` double NOT NULL,
	`bodyfat_percentage` double NOT NULL,
    `height` double NOT NULL,
	PRIMARY KEY (`measure_date`, `user_no`),
	FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);

CREATE TABLE IF NOT EXISTS `userfollowlist` (
  `follow_user_no` int NOT NULL,
  `user_no` int NOT NULL,
  PRIMARY KEY (`follow_user_no`, `user_no`),
  FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);

CREATE TABLE IF NOT EXISTS `mylist` (
  `list_no` int NOT NULL auto_increment,
  `user_no` int NOT NULL,
  `list_title` varchar(100) NOT NULL,
  `list_exp` varchar(1000) NOT NULL,
  `list_rate` double NOT NULL,
  `list_part` int NOT NULL,
  `list_time` int NOT NULL,
  `list_place` int NOT NULL,
  `list_viewcnt` int NOT NULL,
  `list_isofficial` boolean NOT NULL,
  `list_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `list_url` varchar(500),
  PRIMARY KEY (`list_no`, `user_no`),
  FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);

CREATE TABLE IF NOT EXISTS `videos` (
  `video_no` int NOT NULL auto_increment,
  `user_no` int NOT NULL,
  `video_title` varchar(100) NOT NULL,
  `video_url` varchar(300) NOT NULL,
  `video_part` varchar(10) NOT NULL,
  `video_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`video_no`),
  FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);	

CREATE TABLE IF NOT EXISTS `listdetail` (
  `list_no` int NOT NULL,
  `video_no` int NOT NULL,
  PRIMARY KEY (`list_no`, `video_no`),
  FOREIGN KEY (`list_no`) REFERENCES `mylist`(`list_no`) ON DELETE CASCADE,
  FOREIGN KEY (`video_no`) REFERENCES `videos`(`video_no`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `reviews` (
  `review_no` int NOT NULL auto_increment,
  `user_no` int NOT NULL,
  `list_no` int NOT NULL,
  `review_content` varchar(300) NOT NULL,
  `review_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `review_rate` double NOT NULL,
  PRIMARY KEY (`review_no`),
  FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`),
  FOREIGN KEY (`list_no`) REFERENCES `mylist`(`list_no`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `comments` (
  `comment_no` int NOT NULL auto_increment,
  `review_no` int NOT NULL,
  `user_no` int NOT NULL,
  `comment_content` varchar(100) NOT NULL,
  `comment_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_no`),
  FOREIGN KEY (`review_no`) REFERENCES `reviews`(`review_no`) ON DELETE CASCADE,
  FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);