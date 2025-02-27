/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car{
    private int speed;

    public Car(){
        speed=0;    
    }

    public int IncreaseSpeed(){
        return speed++;
    }
    
    public int DecreaseSpeed(){
        return speed--;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    
}
