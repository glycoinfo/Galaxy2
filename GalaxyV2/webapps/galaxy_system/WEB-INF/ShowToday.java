import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class ShowToday
{
	public int nowY,Y;
	public int nowMO,MO;
	public int nowD,D;
	public int nowH,H;
	public int nowMI,MI;
	private Calendar cal;

    public ShowToday(){
		cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
		nowY = cal.get(Calendar.YEAR);
        nowMO = (cal.get(Calendar.MONTH)+1);
        nowD = cal.get(Calendar.DATE);
        nowH = cal.get(Calendar.HOUR);
        nowMI = cal.get(Calendar.MINUTE);
		Y = cal.get(Calendar.YEAR);
        MO = (cal.get(Calendar.MONTH)+1);
        D = cal.get(Calendar.DATE);
        H = cal.get(Calendar.HOUR);
        MI = cal.get(Calendar.MINUTE);
    }
	public void showdate(){
		System.out.println();
		System.out.println(nowY + "/" + nowMO + "/" + nowD + " " + nowH + ":" + nowMI);
		System.out.println(Y + "/" + MO + "/" + D + " " + H + ":" + MI);
	}
	public void resetdate(){
		cal.set(nowY,nowMO-1,nowD,nowH,nowMI);
	}
	public void adddate(int num){
		cal.add(Calendar.DATE,num);
		Y = cal.get(Calendar.YEAR);
        MO = (cal.get(Calendar.MONTH)+1);
        D = cal.get(Calendar.DATE);
        H = cal.get(Calendar.HOUR);
        MI = cal.get(Calendar.MINUTE);
		resetdate();
	}

    public static void main(String args[])
    {
        ShowToday showtoday = new ShowToday();
		showtoday.showdate();
		showtoday.adddate(10);
		showtoday.showdate();
		showtoday.resetdate();
		showtoday.adddate(5);
		showtoday.showdate();
        // showtoday.demo();
    }

    public void demo()
    {
        System.out.println(easyDateFormat("dd MMMMM yyyy"));
        System.out.println(easyDateFormat("yyyyMMdd"));
        System.out.println(easyDateFormat("dd.MM.yy"));
        System.out.println(easyDateFormat("MM/dd/yy"));
        System.out.println(easyDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z"));
        System.out.println(easyDateFormat("EEE, MMM d, ''yy"));
        System.out.println(easyDateFormat("h:mm a"));
        System.out.println(easyDateFormat("H:mm:ss:SSS"));
        System.out.println(easyDateFormat("K:mm a,z"));
        System.out.println(easyDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa"));
    }

    public String easyDateFormat(String s)
    {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
        String s1 = simpledateformat.format(date);
        return s1;
    }
}
