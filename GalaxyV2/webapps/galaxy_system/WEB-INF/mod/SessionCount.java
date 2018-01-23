package mod;

import javax.servlet.http.*;

public final class SessionCount implements HttpSessionListener
{
	private static int count = 0;
	//コンストラクタ
	public void SessionCount(){
	}
	
	public void sessionCreated(HttpSessionEvent se){
		count++;
		System.out.println("アクセス = " + count);
	}
	
	public void sessionDestroyed(HttpSessionEvent se){
		count --;
		System.out.println("ログアウト = " + count);
	}
	
	public static int getSessionCount(){
		return count;
	}
}
	