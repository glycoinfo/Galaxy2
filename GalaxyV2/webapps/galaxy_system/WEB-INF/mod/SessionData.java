package mod;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionData implements HttpSessionBindingListener{
	private static long counter = 0;
	/* �Z�b�V�����J�n���̏��� */
	public SessionData(){
	}
	
	public void valueBound (HttpSessionBindingEvent event){
		counter ++;
		System.out.println("valueBound : " + counter);
	}
	/* �Z�b�V�����I�����̏��� */
	public void valueUnbound(HttpSessionBindingEvent event){
		counter --;
		System.out.println("valueUnBound : " + counter);
	}
	
	public static long getSessionCount(){
		return counter;
	}
}