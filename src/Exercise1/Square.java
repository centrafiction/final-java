package Exercise1;

public class Square extends Shape {
    public Square(int shapeSize){
        // CONSTRUCTOR!!!!!!!!!
        super(shapeSize);
    }
    @Override
    public void draw(){
        int size = getShapeSize();
        //This draws the square but seeing how many columns (i) and rows (j)
        //are need and writes that many asterisks
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
