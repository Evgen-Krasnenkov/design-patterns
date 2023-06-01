package com.kras;

import org.junit.jupiter.api.Test;

class XMLReportVisitorTest {
    @Test
    void givenShapes_whenExport_thenXMLForms() {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        XMLReportVisitor reportVisitor = new XMLReportVisitor();
        String export = reportVisitor.export(dot, circle, compoundShape);
        System.out.println(export);
    }

}