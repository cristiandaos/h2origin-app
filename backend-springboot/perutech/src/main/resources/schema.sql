CREATE TABLE [dbo].[Role] (
  RoleId int IDENTITY(1,1) PRIMARY KEY,
  RoleKey varchar(10) NOT NULL,
  RoleName varchar(100) NOT NULL,
  CreatedBy varchar(100) NOT NULL,
  CreationDate datetime NOT NULL DEFAULT GETDATE(),
  UpdatedBy varchar(100),
  UpdateDate datetime,
  DeletedBy varchar(100),
  DeletionDate datetime
);

CREATE TABLE [dbo].[User] (
  UserId int IDENTITY(1,1) PRIMARY KEY,
  Name varchar(255) NOT NULL,
  LastName varchar(255) NOT NULL,
  Email varchar(100) NOT NULL,
  Phone int NULL,
  Age int NULL,
  Gender char(1) NULL,
  Password varchar(255) NOT NULL,
  RecoveryEmail varchar(255) NOT NULL,
  District varchar(100) NOT NULL,
  CountryOrigin varchar(100) NOT NULL,
  AccountStatus bit DEFAULT 1 NOT NULL,
  RoleId int NOT NULL,
  CreatedBy varchar(100) NOT NULL,
  CreationDate datetime NOT NULL DEFAULT GETDATE(),
  UpdatedBy varchar(100),
  UpdateDate datetime,
  DeletedBy varchar(100),
  DeletionDate datetime,
  CONSTRAINT FK_RoleId FOREIGN KEY (RoleId) REFERENCES Role(RoleId)
);

