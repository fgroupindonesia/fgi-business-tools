/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author staff
 */


/**
 *
 * @author asus
 */
public class Conditional {
    private String column;
    private String value;
    private boolean alike;

    public Conditional(){
        
    }
    
    public Conditional(String c, int v){
        column = c;
        value = "" + v;
    }
    
    public Conditional(String c, String v){
        column = c;
        value = v;
    }
    
     public Conditional(String c, String v, boolean b){
        column = c;
        value = v;
        alike = b;
    }
    
    /**
     * @return the column
     */
    public String getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(String column) {
        this.column = column;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the alike
     */
    public boolean isAlike() {
        return alike;
    }

    /**
     * @param alike the alike to set
     */
    public void setAlike(boolean alike) {
        this.alike = alike;
    }
}

