package mod;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionData implements HttpSessionBindingListener{
	private static long counter = 0;
	/* セッション開始時の処理 */
	public SessionData(){
	}
	
	public void valueBound (HttpSessionBindingEvent event){
		counter ++;
		System.out.println("valueBound : " + counter);
	}
	/* セッション終了時の処理 */
	public void valueUnbound(HttpSessionBindingEvent event){
		counter --;
		System.out.println("valueUnBound : " + counter);
	}
	
	public static long getSessionCount(){
		return counter;
	}
}