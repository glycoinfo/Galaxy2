import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import  java.io.PrintWriter;
import  java.io.IOException;
import  javax.servlet.GenericServlet;
import  javax.servlet.ServletConfig;
import  javax.servlet.ServletContext;
import  javax.servlet.ServletRequest;
import  javax.servlet.ServletResponse;
import  javax.servlet.ServletException;



public class AccessFilter implements Filter{
	// private Logformat lf;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
		String remoteAddr = req.getRemoteAddr();
		// lf = new Logformat();
		System.out.println(remoteAddr + "����̃A�N�Z�X");
		
		if(remoteAddr.startsWith("192.168.100") || remoteAddr.equals("127.0.0.1")){
			System.out.println("�A�N�Z�XOK");
			// lf.log("���O�C�����܂��� : " + remoteAddr);
			// �J�n���Ԏ擾
    		long startTime = System.currentTimeMillis();
    		// ���X�v������Ă������\�[�X���Ăяo���܂�
    		chain.doFilter(req, res);
    		// �I�����Ԏ擾
    		long stopTime = System.currentTimeMillis();

  	 	 	// ���N�G�X�g��URI���擾
    		String name = "";
    		if (req instanceof HttpServletRequest) {
      			name = ((HttpServletRequest)req).getRequestURI();
    		}
    		// �\��
    		System.out.println(name + ": " + (stopTime - startTime) + "�~���b");
		}else{
			System.out.println("�A�N�Z�X����");
			// lf.log("�A�N�Z�X���ۂ��܂��� : " + remoteAddr);
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req,res);
		}
	}
	public void init(FilterConfig config) throws ServletException{
	}
	public void destroy(){
	}
}
