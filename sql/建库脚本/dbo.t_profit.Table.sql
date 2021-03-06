USE [ticket_test]
GO
/****** Object:  Table [dbo].[t_profit]    Script Date: 08/22/2016 16:02:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
