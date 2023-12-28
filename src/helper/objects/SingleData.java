
package helper.objects;

/**
 *
 * @author staff
 */
public class SingleData {
    
    String tgl;
    String appProfile;
    String sn;
    
    public SingleData(String snNa, String appNa, String tglNa){
        sn = snNa;
        appProfile = appNa;
        tgl = tglNa;
    }
    
    public String toString(){
        return sn + ";" + appProfile + ";" + tgl;
    }
    
    
}
