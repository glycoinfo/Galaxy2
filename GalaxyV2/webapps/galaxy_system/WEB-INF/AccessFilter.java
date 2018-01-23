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
		System.out.println(remoteAddr + "からのアクセス");
		
		if(remoteAddr.startsWith("192.168.100") || remoteAddr.equals("127.0.0.1")){
			System.out.println("アクセスOK");
			// lf.log("ログインしました : " + remoteAddr);
			// 開始時間取得
    		long startTime = System.currentTimeMillis();
    		// 元々要求されていたリソースを呼び出します
    		chain.doFilter(req, res);
    		// 終了時間取得
    		long stopTime = System.currentTimeMillis();

  	 	 	// リクエストのURIを取得
    		String name = "";
    		if (req instanceof HttpServletRequest) {
      			name = ((HttpServletRequest)req).getRequestURI();
    		}
    		// 表示
    		System.out.println(name + ": " + (stopTime - startTime) + "ミリ秒");
		}else{
			System.out.println("アクセス拒否");
			// lf.log("アクセス拒否しました : " + remoteAddr);
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req,res);
		}
	}
	public void init(FilterConfig config) throws ServletException{
	}
	public void destroy(){
	}
}
