USE evidence_db;

CREATE TABLE Person(
`id` INT PRIMARY KEY auto_increment,
`version` varchar(45),
`userName` varchar(255),
`firstName` varchar(55),
`lastName` varchar(55),
`passWord` varchar(55),
`hiringDate` datetime

);
CREATE TABLE `Storage`(
`id` INT PRIMARY KEY auto_increment,
`version` varchar(45),
`evidenceId` INT
);

CREATE TABLE Detective(
`id` INT PRIMARY KEY auto_increment,
`version` varchar(45) NOT NULL,
`personId` INT,
`badgeNumber` varchar(55) NOT NULL,
`rank` varchar(55) NOT NULL,
`armed` tinyint(1) NOT NULL,
`status` varchar(55) NOT NULL,
`criminalId` INT,
`trackEntryId` INT,
foreign key (`personId`) references Person(`id`)
-- foreign key (`criminalId`) references Criminal(`id`),
-- foreign key (`trackEntryId`) references TrackEntry(`id`)
);
CREATE TABLE Evidence(
`id` INT PRIMARY KEY auto_increment,
`version` varchar(45) NOT NULL,
`criminalId` INT,
`storageId` INT,
`number` varchar(55) NOT NULL,
`itemName` varchar(55) NOT NULL,
`note` varchar(55) NOT NULL,
`archired` tinyint(1) NOT NULL,
`trackEntryId` INT,
-- foreign key (`criminalId`) references Criminal(`id`),
foreign key (`storageId`) references `Storage` (`id`)
-- foreign key (`trackEntryId`) references TrackEntry(`id`)
);
CREATE TABLE Criminal(
`id` INT PRIMARY KEY auto_increment,
`version` varchar(45) NOT NULL,
`number` VARCHAR(255) NOT NULL,
`type` VARCHAR(55) NOT NULL,
`shortDescription` varchar(255) NOT NULL,
`detailedDescription` varchar(255) NOT NULL,person
`status` varchar(55) NOT NULL,
`note` varchar(55) NOT NULL,
`evidenceId` INT,
`detectiveId` INT,
FOREIGN KEY (`evidenceId`) REFERENCES Evidence(`id`),
FOREIGN KEY (`detectiveId`) REFERENCES Detective(`id`)
);
CREATE TABLE TrackEntry(
`id` INT PRIMARY KEY auto_increment,
`version` varchar(45) NOT NULL,
`date` datetime NOT NULL,
`evidenceId` INT,
`detectiveId` INT,
`action` varchar(55) NOT NULL,
`reason` varchar(55) NOT NULL,
foreign key (`evidenceId`) references Evidence(`id`),
foreign key (`detectiveId`) references Detective(`id`)
);
ALTER TABLE `Storage` Add foreign key (`evidenceID`) REFERENCES Evidence(`id`);
ALTER TABLE Detective Add foreign key (`criminalId`) references Criminal(`id`);
ALTER TABLE Detective Add foreign key (`trackEntryId`) references TrackEntry(`id`);

ALTER TABLE Evidence Add foreign key (`criminalId`) references Criminal(`id`);
ALTER TABLE Evidence Add foreign key (`trackEntryId`) references TrackEntry(`id`);