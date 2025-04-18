import java.util.Random;

public class Exercise1 {
    public static void main(String[] args) {
        Random rdn = new Random();
        // Use Random rdn to create an array of the number of shapes
        int numShapes = rdn.nextInt(11) + 10;
        Shape[] shapes = new Shape[numShapes];

        // This is to put random shapes into the array7
        for (int i = 0; i < shapes.length; i++){
            int shapeSize = rdn.nextInt(9) +2;
            boolean isSquare = rdn.nextBoolean();
        //Randomly picks from the array whether it will be a square or triangle
            if (isSquare) {
                shapes[i] = new Square(shapeSize);
                System.out.println("Shape " + (i + 1) + ": Square (Size " + shapeSize + ")");
            } else {
                shapes[i] = new Triangle(shapeSize);
                System.out.println("Shape " + (i + 1) + ": Triangle (Size " + shapeSize + ")");
            }
            //draws shapes and a new line to separate
            shapes[i].draw();
            System.out.println();
        }
    }
}