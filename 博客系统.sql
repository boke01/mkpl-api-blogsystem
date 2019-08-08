USE Intern_test
GO

CREATE SCHEMA vz04
GO

--文章表
CREATE TABLE vz04.[article](
	[ArticleId] [INT] IDENTITY(1,1) NOT NULL,
	[Headline] [NVARCHAR](50) NOT NULL UNIQUE,
	[Synopsis] [NVARCHAR](500) NOT NULL,
	[Content] [NVARCHAR](2000) NOT NULL,
	[ReadingQuantity] [INT] NOT NULL CONSTRAINT DF_article_ReadingQuantity DEFAULT 0,
	[PictureAddress] [VARCHAR](100) NOT NULL,
	[InUser] [NCHAR](20) NULL,
	[Indate] [datetime] NOT NULL CONSTRAINT DF_article_Indate DEFAULT GETDATE(),
	[LastEditUser] [NCHAR](20) NULL,
	[LastEditDate] [datetime] NOT NULL CONSTRAINT DF_article_LastEditDate DEFAULT GETDATE(),
	[Remarks] [NVARCHAR](50) NULL
	CONSTRAINT [PK_article] PRIMARY KEY CLUSTERED 
	(
		[ArticleId] ASC
	)
)
GO

--评论表
CREATE TABLE vz04.[comment](
	[CommentId] [INT] IDENTITY(1,1) NOT NULL,
	[ArticleId] [INT] NOT NULL,
	[VisitorName] [NCHAR](20) NOT NULL,
	[Email] [VARCHAR](50) NOT NULL,
	[Content] [NVARCHAR](200) NOT NULL,
	[InUser] [NCHAR](20) NULL,
	[Indate] [datetime] NOT NULL CONSTRAINT DF_comment_Indate DEFAULT GETDATE(),
	[LastEditUser] [NCHAR](20) NULL,
	[LastEditDate] [datetime] NOT NULL CONSTRAINT DF_comment_LastEditDate DEFAULT GETDATE(),
	[Remarks] [NVARCHAR](255) NULL
	CONSTRAINT [PK_comment] PRIMARY KEY CLUSTERED 
	(
		[CommentId] ASC
	)
)
GO

--[ArticleId] [Headline] [Synopsis] [Content] [ReadingQuantity] [PictureAddress] [InUser] [Indate] [LastEditUser] [LastEditDate] [Remarks]
--[CommentId] [ArticleId] [VisitorName] [Email] [Content] [InUser] [Indate] [LastEditUser] [LastEditDate] [Remarks] 

--drop table vz04.article
--drop table vz04.comment

select * from vz04.article
select * from vz04.comment

INSERT INTO vz04.article([Headline], [Synopsis], [Content], [ReadingQuantity], [PictureAddress]) VALUES
(N'test2',N'test',N'test',1,'http://baidu.com')

INSERT INTO vz04.comment([ArticleId],[VisitorName],[Email],[Content]) VALUES
(3,N'test','123456@qq.com',N'test')