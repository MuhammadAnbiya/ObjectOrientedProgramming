// import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// /**
//  * Write a description of class CarActor here.
//  * 
//  * @author (your name) 
//  * @version (a version number or a date)
//  */
// public class CarActor extends Actor{
//     Car c1;
//     CarActor(){
//         c1 = new Car();
//     }
    
//     public void act(){
        
//     move();
//     }
    
//     public void move() {
//     int x = getX();
//     int y = getY();

//     if (Greenfoot.isKeyDown("left")) {
//         x -= c1.getSpeed();
//         setDirection(false);
//     }
//     if (Greenfoot.isKeyDown("right")) {
//         x += c1.getSpeed();
//         setDirection(true);
//     }
//     if (Greenfoot.isKeyDown("space")) {
//         c1.IncreaseSpeed();
//     }

//     setLocation(x, y);
//     }

//     private boolean facingRight = true;

//     public void setDirection(boolean toRight) {
//         if (toRight != facingRight) {
//             GreenfootImage img = getImage();
//             img.mirrorHorizontally();
//             setImage(img);
//             facingRight = toRight;
//         }
//     }

// }
