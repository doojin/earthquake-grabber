DROP DATABASE IF EXISTS earthquake_grabber;

CREATE DATABASE earthquake_grabber
CHARACTER SET utf8;

USE earthquake_grabber;

CREATE TABLE location (
  location_pk INT UNSIGNED NOT NULL AUTO_INCREMENT,
  latitude FLOAT(10, 8) NOT NULL,
  longitude FLOAT(11, 8) NOT NULL,
  PRIMARY KEY (location_pk)
) CHARACTER SET utf8;

CREATE TABLE earthquake (
  earthquake_pk VARCHAR(10) NOT NULL,
  location_fk INT UNSIGNED NOT NULL,
  time DATETIME NOT NULL,
  magnitude FLOAT(4,2) UNSIGNED NOT NULL,
  PRIMARY KEY (earthquake_pk),
  FOREIGN KEY (location_fk) REFERENCES location(location_pk)
) CHARACTER SET utf8;