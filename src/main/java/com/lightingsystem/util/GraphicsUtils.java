package com.lightingsystem.util;

import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public final class GraphicsUtils {
    private GraphicsUtils() {
        throw new UnsupportedOperationException();
    }

    public static SVGPath newSvgPath(String content, Paint fill, Paint stroke, double strokeWidth) {
        SVGPath svg = new SVGPath();
        svg.setContent(content);
        svg.setFill(fill);
        svg.setStroke(stroke);
        svg.setStrokeWidth(strokeWidth);
        return svg;
    }

    public static Text newText(double x, double y, String content, Font font, Paint fill) {
        Text txt = new Text(x, y, content);
        txt.setFill(fill);
        txt.setFont(font);
        return txt;
    }
}
