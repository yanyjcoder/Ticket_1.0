package com.ticket.yanyj.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
 private static final Logger logger = Logger.getLogger("");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String page ;
	private String rows ;
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
	private String render(String text, String contentType)
	  {
	    try
	    {
	      HttpServletResponse response = ServletActionContext.getResponse();
	      response.setContentType(contentType);
	      response.getWriter().write(text);
	    }
	    catch (IOException e)
	    {
	      logger.error(e.getMessage(), e);
	    }
	    return null;
	  }
	  
	  public String renderText(String text)
	  {
	    return render(text, "text/plain;charset=UTF-8");
	  }

}
