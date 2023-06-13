// DROP TABLE IF EXISTS closed_voting_site.USER_ADMIN

CREATE TABLE closed_voting_site.admin (
    ID bigint(20) auto_increment NOT NULL,
    ADMIN_EMAIL varchar(100) NOT NULL,
    ADMIN_PASSWORD varchar(100) NOT NULL,
    ADMIN_NAME varchar(100) NOT NULL,
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    STATUS_CD varchar(4) NOT NULL,
    AUTH_CD varchar(4) NOT NULL,
    COMPANY_ID bigint(20) NOT null,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='관리자';


CREATE TABLE closed_voting_site.user (
    ID bigint(20) auto_increment NOT NULL,
    QR_CODE varchar(100) NOT NULL,
    USER_PASSWORD varchar(100) NOT NULL,
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    STATUS_CD varchar(4) NOT NULL,
    COMPANY_ID bigint(20) NOT null,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='사용자(투표자)';


CREATE TABLE closed_voting_site.company (
    ID bigint(20) auto_increment NOT NULL,
    COMPANY_NAME varchar(100) NOT NULL,
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    STATUS_CD varchar(4) NOT NULL,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='기관';


CREATE TABLE closed_voting_site.post (
    ID bigint(20) auto_increment NOT NULL,
    POST_TITLE varchar(100) NOT NULL,
    POST_SUB_TITLE varchar(100),
    POST_NOTE varchar(3000),
    POST_TYPE_CD varchar(4) NOT NULL,
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    START_DTIME datetime NOT NULL,
    END_DTIME datetime NOT NULL,
    STATUS_CD varchar(4) NOT NULL,
    COMPANY_ID bigint(20) NOT null,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='게시물';


CREATE TABLE closed_voting_site.content(
    ID bigint(20) auto_increment NOT NULL,
    CONTENT_TITLE varchar(100) NOT NULL,
    CONTENT_SUB_TITLE varchar(100),
    CONTENT_NOTE varchar(300),
    CONTENT_IMG_ID bigint(20),
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    STATUS_CD varchar(4) NOT NULL,
    POST_ID bigint(20) NOT null,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='컨텐츠';


CREATE TABLE closed_voting_site.common(
    ID bigint(20) auto_increment NOT NULL,
    CODE varchar(4) NOT NULL,
    CODE_MANE varchar(100) NOT NULL,
    UPPER_CD varchar(4),
    CODE_VALUE1 varchar(100),
    CODE_VALUE2 varchar(100),
    CODE_NOTE varchar(300),
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    STATUS_CD varchar(4) NOT NULL,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='공통코드';


CREATE TABLE closed_voting_site.voting_info(
    ID bigint(20) auto_increment NOT NULL,
    USER_ID bigint(20) NOT null,
    POST_ID bigint(20) NOT null,
    CONTENT_ID bigint(20) NOT null,
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='투표 정보';


CREATE TABLE closed_voting_site.content_img(
    ID bigint(20) auto_increment NOT NULL,
    CONTENT_ID bigint(20) NOT null,
    IMG_ORIGINAL_PATH varchar(300),
    IMG_ORIGINAL_NAME varchar(300),
    IMG_SAVED_PATH varchar(300),
    IMG_SAVED_NAME varchar(300),
    CREAT_DTIME datetime NOT NULL,
    CREAT_ADMIN_ID bigint(20) NOT NULL,
    UPDATE_DTIME datetime NOT NULL,
    UPDATE_ADMIN_ID bigint(20) NOT NULL,
    PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='컨텐츠 이미지';
