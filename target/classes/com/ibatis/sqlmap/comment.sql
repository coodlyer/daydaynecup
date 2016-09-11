create DATABASE if not EXISTS daydaynecup;
use daydaynecup;
create Table comment(
   comment_id bigint(20) unsigned not null auto_increment,
   device_tag VARCHAR (50) not null,
   content text not null,
   vote_num int(10),
   gmt_create datetime not null,
   PRIMARY KEY (comment_id)
)ENGINE =InnoDB DEFAULT CHARSET=utf8;