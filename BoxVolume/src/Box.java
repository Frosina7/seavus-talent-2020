public class Box {

    private Integer height;
    private Integer width;
    private Integer depth;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Box() {
    }

    ;

    public Box(Integer height, Integer width, Integer depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public Integer findVolume() {
        return height * width * depth;
    }


}
