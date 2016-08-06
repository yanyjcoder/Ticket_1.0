package com.ticket.yanyj.util.test;

import java.awt.*;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import org.junit.Test;

import com.ticket.yanyj.util.StringUtil;
import com.ticket.yanyj.util.TicketUtil;


/**
 * 字符串处理类测试
 * @author yanyj
 * @date 2016年7月30日
 */
public class StringUtilTest {

	@Test
	public void testRemoveNewline() {
		
		System.out.println(0 % 8);
	}

	 public static void main(String[] str){  
	        Frame f = new Frame("颜色转变窗口");  
	        //设置窗体属性  
	        f.setBounds(400,200,400,300);  
	        //设置窗体布局  
	        f.setLayout(new FlowLayout()); 
	        //添加按钮  
	        Button redButton = new Button("红色");  
	        TextArea  area = new TextArea();
	        redButton.addMouseListener(new MouseAdapter() {  
				@Override  
	             public void mouseClicked(MouseEvent e) {  
	            
	            	List<String> strings = StringUtil.removeSpaceCharater(area.getText());
	            	System.out.println(TicketUtil.convertStringToTicketMap(strings).size());
	            }  
	            @Override  
	            public void mouseExited(MouseEvent e) {  
	                // TODO Auto-generated method stub  
	                f.setBackground(Color.WHITE);  
	            }  
	        });  
	        f.add(area);
	        f.add(redButton);  
	        f.setVisible(true);  
	    }  
}
