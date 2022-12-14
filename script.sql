USE [master]
GO
/****** Object:  Database [PLayfair]    Script Date: 15/10/2022 6:32:55 CH ******/
CREATE DATABASE [PLayfair]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PLayfair', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PLayfair.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PLayfair_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PLayfair_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PLayfair] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PLayfair].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PLayfair] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PLayfair] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PLayfair] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PLayfair] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PLayfair] SET ARITHABORT OFF 
GO
ALTER DATABASE [PLayfair] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PLayfair] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PLayfair] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PLayfair] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PLayfair] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PLayfair] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PLayfair] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PLayfair] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PLayfair] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PLayfair] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PLayfair] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PLayfair] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PLayfair] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PLayfair] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PLayfair] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PLayfair] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PLayfair] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PLayfair] SET RECOVERY FULL 
GO
ALTER DATABASE [PLayfair] SET  MULTI_USER 
GO
ALTER DATABASE [PLayfair] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PLayfair] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PLayfair] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PLayfair] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PLayfair] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PLayfair] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PLayfair', N'ON'
GO
ALTER DATABASE [PLayfair] SET QUERY_STORE = OFF
GO
USE [PLayfair]
GO
/****** Object:  Table [dbo].[tb_Student]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Student](
	[studentID] [nvarchar](10) NOT NULL,
	[fullName] [nvarchar](max) NULL,
	[sex] [nvarchar](10) NULL,
	[phoneNumer] [nvarchar](12) NULL,
	[mail] [nvarchar](max) NULL,
	[address] [nvarchar](max) NULL,
 CONSTRAINT [PK_tb_Student] PRIMARY KEY CLUSTERED 
(
	[studentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_Subject]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Subject](
	[subID] [nvarchar](10) NOT NULL,
	[subName] [nvarchar](max) NULL,
	[subCredits] [int] NULL,
 CONSTRAINT [PK_tb_Subject] PRIMARY KEY CLUSTERED 
(
	[subID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_Teacher]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Teacher](
	[teacherID] [nvarchar](10) NOT NULL,
	[userName] [nvarchar](20) NOT NULL,
	[fullName] [nvarchar](max) NULL,
	[sex] [nvarchar](15) NULL,
	[phoneNumer] [nvarchar](12) NULL,
	[mail] [nvarchar](max) NULL,
	[address] [nvarchar](max) NULL,
 CONSTRAINT [PK_tb_Teacher] PRIMARY KEY CLUSTERED 
(
	[teacherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_Transcript]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_Transcript](
	[teacherID] [nvarchar](10) NOT NULL,
	[studentID] [nvarchar](10) NOT NULL,
	[subID] [nvarchar](10) NOT NULL,
	[point] [float] NULL,
 CONSTRAINT [PK_tb_Transcript] PRIMARY KEY CLUSTERED 
(
	[teacherID] ASC,
	[studentID] ASC,
	[subID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_User]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_User](
	[userName] [nvarchar](20) NOT NULL,
	[passWord] [nvarchar](max) NOT NULL,
	[role] [int] NOT NULL,
 CONSTRAINT [PK_tb_User] PRIMARY KEY CLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[tb_Student] ([studentID], [fullName], [sex], [phoneNumer], [mail], [address]) VALUES (N'CONG', N'Đỗ Thành Công', N'Nam', N'0654897321', N'456@gmail.com', N'Việt Nam')
INSERT [dbo].[tb_Student] ([studentID], [fullName], [sex], [phoneNumer], [mail], [address]) VALUES (N'HAU', N'Nguyễn Đức Hậu', N'Nam', N'0654897321', N'789@gmail.com', N'Việt Nam')
GO
INSERT [dbo].[tb_Subject] ([subID], [subName], [subCredits]) VALUES (N'DEV', N'Công nghệ phần mềm', 3)
INSERT [dbo].[tb_Subject] ([subID], [subName], [subCredits]) VALUES (N'MATH', N'Đại số tuyến tính', 6)
GO
INSERT [dbo].[tb_Teacher] ([teacherID], [userName], [fullName], [sex], [phoneNumer], [mail], [address]) VALUES (N'CONG', N'ehtppzwoio', N'Đỗ Thành Công', N'Nam', N'0321354671', N'123@gmail.com', N'Việt Nam')
INSERT [dbo].[tb_Teacher] ([teacherID], [userName], [fullName], [sex], [phoneNumer], [mail], [address]) VALUES (N'CONG1', N'ehtppzwoio', N'Đỗ Thành Công Ngu', N'Nam', N'0321354671', N'123@gmail.com', N'Việt Nam')
INSERT [dbo].[tb_Teacher] ([teacherID], [userName], [fullName], [sex], [phoneNumer], [mail], [address]) VALUES (N'CONG2', N'qoopebftba', N'Đỗ Thành Công Ngu', N'Nam', N'0321354671', N'123@gmail.com', N'Việt Nam')
INSERT [dbo].[tb_Teacher] ([teacherID], [userName], [fullName], [sex], [phoneNumer], [mail], [address]) VALUES (N'HAU', N'ehtppzwoio', N'Nguyễn Đức Hậu', N'Nam', N'0321354671', N'123@gmail.com', N'Việt Nam')
GO
INSERT [dbo].[tb_Transcript] ([teacherID], [studentID], [subID], [point]) VALUES (N'HAU', N'CONG', N'MATH', 7)
INSERT [dbo].[tb_Transcript] ([teacherID], [studentID], [subID], [point]) VALUES (N'HAU', N'HAU', N'DEV', 7.5)
GO
INSERT [dbo].[tb_User] ([userName], [passWord], [role]) VALUES (N'ehtppzwoio', N'ehtppzwoio', 2)
INSERT [dbo].[tb_User] ([userName], [passWord], [role]) VALUES (N'lgnkio', N'ehtppzwoio', 1)
INSERT [dbo].[tb_User] ([userName], [passWord], [role]) VALUES (N'qoopebftba', N'fepfpfqa', 2)
GO
ALTER TABLE [dbo].[tb_Teacher]  WITH CHECK ADD  CONSTRAINT [FK_tb_Teacher_tb_User] FOREIGN KEY([userName])
REFERENCES [dbo].[tb_User] ([userName])
GO
ALTER TABLE [dbo].[tb_Teacher] CHECK CONSTRAINT [FK_tb_Teacher_tb_User]
GO
ALTER TABLE [dbo].[tb_Transcript]  WITH CHECK ADD  CONSTRAINT [FK_tb_Transcript_tb_Student] FOREIGN KEY([studentID])
REFERENCES [dbo].[tb_Student] ([studentID])
GO
ALTER TABLE [dbo].[tb_Transcript] CHECK CONSTRAINT [FK_tb_Transcript_tb_Student]
GO
ALTER TABLE [dbo].[tb_Transcript]  WITH CHECK ADD  CONSTRAINT [FK_tb_Transcript_tb_Subject] FOREIGN KEY([subID])
REFERENCES [dbo].[tb_Subject] ([subID])
GO
ALTER TABLE [dbo].[tb_Transcript] CHECK CONSTRAINT [FK_tb_Transcript_tb_Subject]
GO
ALTER TABLE [dbo].[tb_Transcript]  WITH CHECK ADD  CONSTRAINT [FK_tb_Transcript_tb_Teacher] FOREIGN KEY([teacherID])
REFERENCES [dbo].[tb_Teacher] ([teacherID])
GO
ALTER TABLE [dbo].[tb_Transcript] CHECK CONSTRAINT [FK_tb_Transcript_tb_Teacher]
GO
/****** Object:  StoredProcedure [dbo].[deleteStudent]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteStudent] 
(
		@STUDENT NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Student
where studentID= @STUDENT;
END;
GO
/****** Object:  StoredProcedure [dbo].[deleteSubject]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteSubject] 
(
		@SUBID NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Subject
where subID= @SUBID;
END;
GO
/****** Object:  StoredProcedure [dbo].[deleteTeacher]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteTeacher] 
(
		@TEACHERID NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Teacher
where teacherID= @TEACHERID;
END;
GO
/****** Object:  StoredProcedure [dbo].[deleteTranscript]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteTranscript]
(
		@TEACHERID NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Transcript
where teacherID=@TEACHERID;
END;
GO
/****** Object:  StoredProcedure [dbo].[deleteUser]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteUser] 
(
	@USER NVARCHAR(20)
)AS
BEGIN
DELETE FROM tb_User 
where userName= @USER;
END;
GO
/****** Object:  StoredProcedure [dbo].[editStudent]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[editStudent] 
	(
		@STUDENTID NVARCHAR(10),
		@FULLNAME NVARCHAR(MAX),
		@SEX NVARCHAR (10),
		@PHONENUMBER NVARCHAR (12),
		@MAIL NVARCHAR(MAX),
		@ADDRESS NVARCHAR(MAX)
	)
AS
Begin
	UPDATE tb_Student
	SET fullName=@FULLNAME, sex=@SEX, phoneNumer=@PHONENUMBER, mail=@MAIL, address=@ADDRESS
	WHERE studentID = @STUDENTID;
end;
GO
/****** Object:  StoredProcedure [dbo].[editSubject]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[editSubject]
	(
		@SUBID NVARCHAR(10),
		@SUBNAME NVARCHAR(MAX),
		@SUBCREDITS INT
	)
AS
Begin
	UPDATE tb_Subject
	SET subName=@SUBNAME, subCredits=@SUBCREDITS
	WHERE subID = @SUBID;
end;
GO
/****** Object:  StoredProcedure [dbo].[editTeacher]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[editTeacher] 
	(
		@TEACHERID NVARCHAR(10),
		@USERNAME NVARCHAR(20),
		@FULLNAME NVARCHAR(MAX),
		@SEX NVARCHAR (15),
		@PHONENUMBER NVARCHAR (12),
		@MAIL NVARCHAR(MAX),
		@ADDRESS NVARCHAR(MAX)
	)
AS
Begin
	UPDATE tb_Teacher
	SET userName= @USERNAME, fullName=@FULLNAME, sex=@SEX, phoneNumer=@PHONENUMBER, mail=@MAIL, address=@ADDRESS
	WHERE teacherID = @TEACHERID;
end;
GO
/****** Object:  StoredProcedure [dbo].[editTranscript]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[editTranscript]
	(
		@TEACHERID NVARCHAR(10),
		@STUDENTID NVARCHAR(10),
		@SUBID NVARCHAR(10),
		@POINT FLOAT
	)
AS
Begin
	UPDATE tb_Transcript
	SET point=@POINT
	WHERE teacherID=@TEACHERID and studentID=@STUDENTID and subID= @SUBID;
end;
GO
/****** Object:  StoredProcedure [dbo].[insertStudent]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[insertStudent] 
	(
		@STUDENTID NVARCHAR(10),
		@FULLNAME NVARCHAR(MAX),
		@SEX NVARCHAR (10),
		@PHONENUMBER NVARCHAR (12),
		@MAIL NVARCHAR(MAX),
		@ADDRESS NVARCHAR(MAX)
	)
AS
Begin
	insert into tb_Student
	values (@STUDENTID,@FULLNAME,@SEX,@PHONENUMBER,@MAIL,@ADDRESS);
end;
GO
/****** Object:  StoredProcedure [dbo].[insertSubject]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[insertSubject] 
	(
		@SUBID NVARCHAR(10),
		@SUBNAME NVARCHAR(MAX),
		@SUBCREDITS INT
	)
AS
Begin
	insert into tb_Subject
	values (@SUBID,@SUBNAME,@SUBCREDITS);
end;
GO
/****** Object:  StoredProcedure [dbo].[insertTeacher]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[insertTeacher] 
	(
		@TEACHERID NVARCHAR(10),
		@USERNAME NVARCHAR(20),
		@FULLNAME NVARCHAR(MAX),
		@SEX NVARCHAR (15),
		@PHONENUMBER NVARCHAR (12),
		@MAIL NVARCHAR(MAX),
		@ADDRESS NVARCHAR(MAX)
	)
AS
Begin
	insert into tb_Teacher
	values (@TEACHERID,@USERNAME,@FULLNAME,@SEX,@PHONENUMBER,@MAIL,@ADDRESS);
end;
GO
/****** Object:  StoredProcedure [dbo].[insertTranscript]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE  [dbo].[insertTranscript]
	(
		@TEACHERID NVARCHAR(10),
		@STUDENTID NVARCHAR(10),
		@SUBID NVARCHAR(10),
		@POINT FLOAT
	)
AS
Begin
	insert into tb_Transcript
	values (@TEACHERID,@STUDENTID,@SUBID,@POINT);
end;
GO
/****** Object:  StoredProcedure [dbo].[SP_Login]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_Login]
(
	@USERNAME NVARCHAR(20),
    @PASSWORD NVARCHAR(MAX)
)
as
BEGIN
	SELECT * FROM tb_User WHERE Username = @USERNAME AND [Password] = @PASSWORD
END
GO
/****** Object:  StoredProcedure [dbo].[SP_Register]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_Register]
    (
    @USERNAME NVARCHAR(20),
    @PASSWORD NVARCHAR(MAX),
    @ROlES INT
)
as
BEGIN
    INSERT INTO [dbo].[tb_User]
    VALUES (@USERNAME, @PASSWORD, @ROlES)
END
GO
/****** Object:  StoredProcedure [dbo].[student]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[student] AS
Begin
	Select *
	from tb_Student
end;
GO
/****** Object:  StoredProcedure [dbo].[sub]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sub] AS
Begin
	Select *
	from tb_Subject
end;
GO
/****** Object:  StoredProcedure [dbo].[teacher]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[teacher] AS
Begin
	Select *
	from tb_Teacher
end;
GO
/****** Object:  StoredProcedure [dbo].[transcript]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[transcript] AS
Begin
	Select *
	from tb_Transcript
end;
GO
/****** Object:  StoredProcedure [dbo].[username_role]    Script Date: 15/10/2022 6:32:55 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[username_role] AS
Begin
	Select userName, role
	from tb_User
end;
GO
USE [master]
GO
ALTER DATABASE [PLayfair] SET  READ_WRITE 
GO
