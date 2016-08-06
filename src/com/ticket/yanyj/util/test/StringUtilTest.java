package com.ticket.yanyj.util.test;

import java.awt.*;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import org.junit.Test;

import com.ticket.yanyj.util.StringUtil;
import com.ticket.yanyj.util.TicketUtil;


/**
 * �ַ������������
 * @author yanyj
 * @date 2016��7��30��
 */
public class StringUtilTest {

	@Test
	public void testRemoveNewline() {
		
		System.out.println(0 % 8);
	}

	 public static void main(String[] str){  
	        Frame f = new Frame("��ɫת�䴰��");  
	        //���ô�������  
	        f.setBounds(400,200,400,300);  
	        //���ô��岼��  
	        f.setLayout(new FlowLayout()); 
	        //��Ӱ�ť  
	        Button redButton = new Button("��ɫ");  
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
