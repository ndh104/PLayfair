CREATE PROCEDURE username_role AS
Begin
	Select userName, role
	from tb_User
end;

exec [dbo].[username_role]

CREATE PROCEDURE deleteUser 
(
	@USER NVARCHAR(20)
)AS
BEGIN
DELETE FROM tb_User 
where userName= @USER;
END;

exec deleteUser;

CREATE PROCEDURE teacher AS
Begin
	Select *
	from tb_Teacher
end;

exec teacher;

CREATE PROCEDURE insertTeacher 
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

exec insertTeacher;

CREATE PROCEDURE deleteTeacher 
(
		@TEACHERID NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Teacher
where teacherID= @TEACHERID;
END;

exec deleteTeacher;

CREATE PROCEDURE editTeacher 
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

CREATE PROCEDURE student AS
Begin
	Select *
	from tb_Student
end;

exec student;

CREATE PROCEDURE insertStudent 
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

CREATE PROCEDURE editStudent 
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

CREATE PROCEDURE deleteStudent 
(
		@STUDENT NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Student
where studentID= @STUDENT;
END;

CREATE PROCEDURE sub AS
Begin
	Select *
	from tb_Subject
end;

exec sub;

CREATE PROCEDURE insertSubject 
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

CREATE PROCEDURE editSubject
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

CREATE PROCEDURE deleteSubject 
(
		@SUBID NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Subject
where subID= @SUBID;
END;

CREATE PROCEDURE transcript AS
Begin
	Select *
	from tb_Transcript
end;

exec transcript;

CREATE PROCEDURE  insertTranscript
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

CREATE PROCEDURE editTranscript
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

CREATE PROCEDURE deleteTranscript
(
		@TEACHERID NVARCHAR(10)
)AS
BEGIN
DELETE FROM tb_Transcript
where teacherID=@TEACHERID;
END;
