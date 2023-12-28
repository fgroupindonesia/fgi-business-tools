
package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author staff
 */
public class DateHelper {
    
    public static final int FORMAT_COMPUTER = 1;
    public static final int FORMAT_HUMAN = 2;
    
    
    public static String getDateNow(int format){
        
        SimpleDateFormat sdf;
        
        if(format == FORMAT_COMPUTER){
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }else{
            sdf = new SimpleDateFormat("dd-MM-yyyy");
        }
        
        return sdf.format(new Date());
        
    }
    
}
