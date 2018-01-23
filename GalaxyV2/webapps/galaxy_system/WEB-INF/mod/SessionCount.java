package mod;

import javax.servlet.http.*;

public final class SessionCount implements HttpSessionListener
{
	private static int count = 0;
	//�R���X�g���N�^
	public void SessionCount(){
	}
	
	public void sessionCreated(HttpSessionEvent se){
		count++;
		System.out.println("�A�N�Z�X = " + count);
	}
	
	public void sessionDestroyed(HttpSessionEvent se){
		count --;
		System.out.println("���O�A�E�g = " + count);
	}
	
	public static int getSessionCount(){
		return count;
	}
}
	