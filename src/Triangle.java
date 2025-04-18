public class Triangle extends Shape{
    public Triangle(int shapeSize){
        //CONSTRUCTOR >:(
        super(shapeSize);
    }
    @Override
    public void draw(){
        int size = getShapeSize();
        //This draws the triangle by incrementing the amount of asterisks each line
        //thank the lord for right angle tryangle
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
