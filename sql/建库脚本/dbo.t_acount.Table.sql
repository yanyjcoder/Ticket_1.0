USE [ticket_test]
GO
/****** Object:  Table [dbo].[t_acount]    Script Date: 08/22/2016 16:02:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_acount](
	[username] [nchar](10) NOT NULL,
	[password] [nchar](10) NOT NULL,
	[amount] [real] NOT NULL
) ON [PRIMARY]
GO
