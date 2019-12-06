package book_manager_stringutil;

import static org.fusesource.jansi.Ansi.ansi;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

import org.fusesource.jansi.Ansi;

/**
 * @author jungdo
 */
public class LibrarySystemStringUtil {
    
    public static String thousandSep(int code)
    {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        return  numberFormat.format(code);
    }
    
    public static void debugPrint(final int text)
    {
        debugPrint(text + "", 10);
    }
    
    public static void debugPrint(final long text)
    {
        debugPrint(text + "", 10);
    }
  
    public static void debugPrint(final String text)
    {
        debugPrint(text, 10);
    }
    
    public static void debugPrint(final Exception e)
    {
        debugPrint(e.toString(), 10);
    }
    
    public static void debugPrint(final String text, final int color)
    {
    	//System.out.println("<" + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ">" + " - " + text);
    	System.out.println(text); 
    }
    
  
    
    public static void print(final String text, final int color)
    {
        System.out.println("\033[01;" + 37 + "m" + ("<" + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ">") + "\033[01;" + color + "m" + " - " + Thread.currentThread().getId() + " - " + text);
    }