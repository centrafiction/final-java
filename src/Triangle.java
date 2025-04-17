public class Triangle extends Shape{
    public Triangle(int shapeSize){
        super(shapeSize);
    }
    @Override
    public void draw(){
        int size = getShapeSize();

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
