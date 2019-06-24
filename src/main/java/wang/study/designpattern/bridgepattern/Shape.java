package wang.study.designpattern.bridgepattern;

public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI api){
        drawAPI = api;
    }

    public abstract void draw();
}
