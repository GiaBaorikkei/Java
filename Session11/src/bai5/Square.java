package bai5;

class Square implements Colorable {
    private double side;
    private String color;

    public Square(double side) {
        this.side = side;
        this.color = "No color";
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Square - Side: " + side + ", Color: " + color);
    }
}

