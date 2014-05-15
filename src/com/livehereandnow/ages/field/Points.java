
package com.livehereandnow.ages.field;


/**
 *
 * @author mark
 */
public class Points {
    private String title="---";

    public Points() {
    }
    public Points(String str) {
        title=str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points){
        this.points = points;
 
    }
    public void addPoints(int k) {
        this.points += k;
    }    

    @Override
    public String toString() {
        return ""+points ;
    }
    
    public void show(){
        System.out.println(title+" "+  toString());
    }
}
