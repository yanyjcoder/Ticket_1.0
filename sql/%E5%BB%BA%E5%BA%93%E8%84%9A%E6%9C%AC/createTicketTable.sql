
USE [ticket_test]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/****** Object:  Table [dbo].[t_ticket]    Script Date: 08/22/2016 16:02:01 ******/
CREATE TABLE [dbo].[t_ticket](
	[ID] [nvarchar](20) NOT NULL,
	[class] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NOT NULL,
	[date] [datetime] NOT NULL,
	[betType] [nvarchar](50) NOT NULL,
	[stake] [real] NOT NULL,
	[team] [nvarchar](50) NOT NULL,
	[jsbf] [nvarchar](50) NOT NULL,
	[endScore] [nvarchar](50) NULL,
	[odds] [real] NOT NULL,
	[gmbl] [real] NOT NULL,
	[deleteFlag] [nchar](10) NOT NULL,
	[profit] [real] NULL,
	[status] [nchar](10) NOT NULL,
 CONSTRAINT [PK__t_ticket__3214EC271920BF5C] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
/****** Object:  Table [dbo].[t_profit]    Script Date: 08/22/2016 16:02:01 ******/
CREATE TABLE [dbo].[t_profit](
	[date] [nvarchar](50) NOT NULL,
	[balance] [real] NOT NULL,
	[bet_amount] [real] NOT NULL,
	[bet_profit] [real] NOT NULL,
 CONSTRAINT [PK_t_profit] PRIMARY KEY CLUSTERED 
(
	[date] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
/****** Object:  Table [dbo].[t_acount]    Script Date: 08/22/2016 16:02:01 ******/
CREATE TABLE [dbo].[t_acount](
	[username] [nchar](10) NOT NULL,
	[password] [nchar](10) NOT NULL,
	[amount] [real] NOT NULL
) ON [PRIMARY]
GO


