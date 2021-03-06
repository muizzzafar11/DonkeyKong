import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Goomba extends Actor
{   private int movingDirection = -1;
    private int frames = 1;
    private int animationCounter = 0;

    //setting images
    private GreenfootImage Goomba1 = new GreenfootImage("Enemies0.png");
    private GreenfootImage Goomba2 = new GreenfootImage("Enemies1.png");
    private GreenfootImage Goomba3 = new GreenfootImage("Enemies2.png");
    private GreenfootImage Goomba4 = new GreenfootImage("Enemies3.png");

    public void act() 
    {   
        if(getX() <= 0)
        { //remove if offscreen
            getWorld().removeObject(this);
        }else {

            animationCounter++; //change frame based on direction
            if(movingDirection == -1 && animationCounter% 14 == 0){
                Animation();  
                //}
            }

            if(movingDirection == 1 && animationCounter% 14 == 0){//show frame based on direction
                Animation2();  
            }

            if(getX() < 200)
            {
                movingDirection = 1;
            } 
            if(getX() > 600)
            {   
                movingDirection = -1;
            }

        
            setLocation(getX(), getY() + 1);
            while(isTouching(Floor.class)) //stops goomba from falling through
            { 
                setLocation(getX() + (movingDirection), getY() - 1);

            }
            
            if(isTouching(PreciseMario.class)) {//removed if mario touches it
            getWorld().removeObject(this);
          }
            // while(isTouching(Floor.class))
            // {
                // setLocation(getX() - (movingDirection), getY() - 1);

            // }
        }      
    }

    public void Animation(){ //sets image based on frame
        if(frames == 1){
            setImage(Goomba1);
        }

        if(frames == 2){
            setImage(Goomba2);
            frames = 1;
            return;
        }

        frames ++;
    }

    public void Animation2(){
        if(frames == 1){
            setImage(Goomba3);
        }

        if(frames == 2){
            setImage(Goomba4);
            frames = 1;
            return;
        }

        frames ++;
    }
}
