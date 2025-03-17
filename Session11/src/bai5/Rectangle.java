package bai5;

class Rectangle implements Colorable {
    private double length, width;
    private String color;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.color = "No color";
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Rectangle - Length: " + length + ", Width: " + width + ", Color: " + color);
    }
}

