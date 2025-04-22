package Exercise1;

public abstract class Shape {
    private int shapeSize;

    public Shape(int shapeSize) {
        this.shapeSize = shapeSize;
    }
    //Getter Method
    public int getShapeSize() {
        return shapeSize;
    }
    //Setter Method
    public void setShapeSize(int shapeSize) {
        this.shapeSize = shapeSize;
    }
    //This is for the ASCII art representation
    public abstract void draw();
}
