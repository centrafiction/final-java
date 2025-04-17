public class Square extends Shape{
    public Square(int shapeSize){
        super(shapeSize);
    }
    @Override
    public void draw(){
        int size = getShapeSize();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
