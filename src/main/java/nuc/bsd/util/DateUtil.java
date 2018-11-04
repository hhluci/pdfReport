package nuc.bsd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String YMD = "yyyy-MM-dd";
    public static final String YMDHMS = "yyyyMMddHHmmss";
    

    public static SimpleDateFormat sdf = new SimpleDateFormat();

    public static String format(Date date , String pattern) {
    	if(date==null){
    		return "";
    	}
    	sdf.applyPattern(pattern);
    	return sdf.format(date);
    	
    }
    public static String format(Date date) {
        if(date==null){
            return "";
        }
        sdf.applyPattern(YMDHMS);
        return sdf.format(date);
        
    }
    public static String formatYMD(String date) {
    	sdf.applyPattern(YMD);
    	String res = "";
    	try {
			res = sdf.format(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return res;
    }
    public static String format(String date) throws ParseException {

    	sdf.applyPattern(YMDHMS);
    	return sdf.format(sdf.parse(date));
    	
    }
}
