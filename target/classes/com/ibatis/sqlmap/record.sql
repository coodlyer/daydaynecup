use daydaynecup;
create table record (
  rid         BIGINT(20) UNSIGNED NOT NULL,
  device_tag  VARCHAR(50)         NOT NULL,
  am_done     TINYINT(5),
  pm_done     TINYINT(5),
  record_date DATETIME            NOT NULL,
  PRIMARY KEY (rid)
)ENGINE=InnoDB DEFAULT CHARSET utf8;