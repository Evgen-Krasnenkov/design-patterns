package com.kras;

public class XMLReportVisitor implements Visitor {
    public String export(Shape... shapes) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"uft-8\"?>" + "\n");
        for (Shape shape :
                shapes) {
            stringBuilder.append(shape.accept(this)).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String visitDot(Dot dot) {
        return "<dot>" + "\n" +
                "   <id>" + dot.getId() + "/<id>" + "\n" +
                "   <x>" + dot.getX() + "</x>" + "\n" +
                "   <y>" + dot.getY() + "</y>" + "\n" +
                "</dot>";
    }

    @Override
    public String visitCircle(Circle circle) {
        return "<circle>" + "\n" +
                "    <id>" + circle.getId() + "</id>" + "\n" +
                "    <x>" + circle.getX() + "</x>" + "\n" +
                "    <y>" + circle.getY() + "</y>" + "\n" +
                "    <radius>" + circle.getRadius() + "</radius>" + "\n" +
                "</circle>";
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return "<rectangle>" + "\n" +
                "    <id>" + rectangle.getId() + "</id>" + "\n" +
                "    <x>" + rectangle.getX() + "</x>" + "\n" +
                "    <y>" + rectangle.getY() + "</y>" + "\n" +
                "    <width>" + rectangle.getWidth() + "</width>" + "\n" +
                "    <height>" + rectangle.getHeight() + "</height>" + "\n" +
                "</rectangle>";
    }

    @Override
    public String visitCompoundShape(CompoundShape compoundShape) {
        return "<compound_shape>" + "\n" +
                "   <id>" + compoundShape.getId() + "</id>" + "\n" +
                exportCompoundShapes(compoundShape) +
                "</compound_shape>";
    }

    private String exportCompoundShapes(CompoundShape compoundShape) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Shape shape :
                compoundShape.children) {
            String childXml = shape.accept(this);
            childXml = "   " + childXml.replace("\n", "\n   ")  + "\n";
            stringBuilder.append(childXml);
        }
        return stringBuilder.toString();
    }
}
