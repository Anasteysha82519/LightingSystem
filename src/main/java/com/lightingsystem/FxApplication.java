package com.lightingsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.lightingsystem.util.GraphicsUtils.newSvgPath;
import static com.lightingsystem.util.GraphicsUtils.newText;

public class FxApplication extends Application {
    @Override
    public void start(Stage stage) {
        var pane = new Pane();
        pane.getChildren().addAll(createApartmentOutline());
        pane.getChildren().addAll(createRoomNames());
        pane.getChildren().addAll(createLamps());

        var scene = new Scene(pane, 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private SVGPath[] createApartmentOutline() {

        return new SVGPath[]{
                newSvgPath("M20 40 h710 v490 h-710 z",
                        Color.web("#666666"),
                        Color.BLACK,
                        2d),
                newSvgPath("M40 60 h140 v25 h10 v-25 "
                                + "h150 v-20 h60 v20 h100 v25 h10 v-25 "
                                + "h200 v450 h-200 v-375 h-10 v25 h-75 v10 "
                                + "h75 v340 h-200 v-340 h75 v-10 h-85 v80 "
                                + "h-25 v10 h25 v260 h-250 v-260 h175 v-10 "
                                + "h-25 v-10 h-10 v10 h-140 v-70 h140 v10 "
                                + "h10 v-45 h-10 v25 h-140 v-100",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M120 510 h75 v20 h-75 v-20 "
                                + "M120 515 h75 v10 h-75 v-10 "
                                + "M130 515 h55 v10 h-55 v-10",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M195 510 h50 v20 h-50 v-20",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M80 530 v70 h200 v-70 h5 v75 h-210 v-75",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M350 510 h100 v20 h-100 v-20 "
                                + "M350 515 h100 v10 h-100 v-10 "
                                + "M360 515 h80 v10 h-80 v-10",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M560 510 h100 v20 h-100 v-20 "
                                + "M560 515 h100 v10 h-100 v-10 "
                                + "M570 515 h80 v10 h-80 v-10",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M400 55 h-60 v50 A70.71 70.71 0 0 0 400 55",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M185 85 v50 h50 A70.71 70.71 0 0 0 185 85",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M185 180 v50 h50 A70.71 70.71 0 0 0 185 180",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M215 245 h50 v50 A70.71 70.71 0 0 1 215 245",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M375 165 h50 v50 A70.71 70.71 0 0 1 375 165",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M505 85 v50 h50 A70.71 70.71 0 0 0 505 85",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M195 510 h50 v-50 A70.71 70.71 0 0 0 195 510",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
        };
    }

    private Text[] createRoomNames() {
        Font labelFont = Font.font("Helvetica", FontWeight.LIGHT, FontPosture.ITALIC, 12);
        Color labelColor = Color.web("#999966");
        return new Text[] {
                newText(45, 75, "Ванная", labelFont, labelColor),
                newText(45, 185, "Туалет", labelFont, labelColor),
                newText(45, 265, "Кухня", labelFont, labelColor),
                newText(195, 75, "Прихожая", labelFont, labelColor),
                newText(515, 75, "Спальня", labelFont, labelColor),
                newText(305, 185, "Гостиная", labelFont, labelColor),
        };
    }

    private SVGPath[] createLamps() {
        return new SVGPath[]{
                newSvgPath("M0,0l-3.473,-15.315c-0.149,-0.658,-0.872,-1.236,-1.547,-1.236h-12.289c-0.675,0,-1.399,0.577,-1.548,1.236"
                                + "l-3.473,15.315c-0.06,0.265,-0.018,0.506,0.118,0.676c0.137,0.171,0.362,0.265,0.633,0.265h3.455v2.607"
                                + "c-0.437,0.237,-0.733,0.7,-0.733,1.231c0,0.773,0.627,1.4,1.4,1.4c0.773,0,1.4-0.627,1.4-1.4c0-0.532,-0.297-0.994,-0.733-1.231v-2.607h16.039"
                                + "c0.272,0,0.497,-0.094,0.633,-0.265C0.018,0.506,0.06,0.265,0,0z"
                                + "M-5.316,12.914h-5.183v-10.639h-1.333v10.639h-5.183c-0.368,0,-0.667,0.298,-0.667,0.667c0,0.368,0.299,0.667,0.667,0.667h11.7"
                                + "c0.368,0,0.667,-0.299,0.667,-0.667C-4.649,13.212,-4.948,12.914,-5.316,12.914z",
                        Color.BLACK,
                        Color.BLACK,
                        0.5d),
                newSvgPath("M0,0c-1.598-1.306-2.618-3.292-2.618-5.517 0-1.118 0.28-2.162 0.739-3.104l-1.098-1.097-6.67,6.671"
                                + "c1.24,0.976 1.115,1.93-0.336,2.86l8.911,8.91h4.367c0.562,0 1.018,0.456 1.018,1.018v1.018h-4.768l-0.011,0.011-0.011-0.011"
                                + "h-7.418v-1.017c0-0.562 0.456-1.018 1.018-1.018h4.367l-8.406-8.405c-1.661,0.712-2.481,0.024-2.446-2.09 0.038-2.249 0.991-2.849 2.839-1.837"
                                + "l6.829-6.829-0.676-0.675c-0.397-0.396-0.397-1.041 0-1.438l2.158-2.158c0.397-0.397 1.042-0.397 1.439,0l2.6,2.602"
                                + "c0.828-0.337 1.729-0.53 2.678-0.53 2.342,0 4.422,1.005 5.719,2.752 0.044,0.011-10.187,9.9-10.224,9.884zM7.873,-6.366c0,0 1.717,2.161 0,3.878"
                                + "s-3.857-0.021-3.857-0.021l3.857-3.857z",
                        Color.BLACK,
                        Color.BLACK,
                        0.5d),
                newSvgPath("M0,0c0.529,2.28,2.568,3.98,5.008,3.98c2.44,0,4.48-1.7,5.008-3.98H0z "
                                + "M16.797,-1.865C16.443,-7.962,11.469,-12.765,5.395,-12.964V-17h-0.777v4.282c-6.07-0.199-11.044,4.604-11.735,10.701"
                                + "c-0.016,0.28,0.086,0.56,0.276,0.762c0.194,0.21,0.47,0.326,0.754,0.326h21.517c0.284,0,0.556-0.116,0.754-0.326"
                                + "C16.711,-1.306,16.812,-1.585,16.797,-1.865z M12.828,-2.606c0-4.063-3.631-7.369-8.095-7.369v-0.777"
                                + "c4.892,0,8.872,3.654,8.872,8.146H12.828z",
                        Color.BLACK,
                        Color.TRANSPARENT,
                        0.0),
                newSvgPath("M0,0l-1.5755,-9.452c-0.148,-0.759,-0.4285,-1.317,-0.8135,-1.317h-9.4525"
                                + "c-0.385,0,-0.7135,0.279,-0.7765,0.6585l-1.5755,9.452c-0.0385,0.2285,0.026,0.4615,0.1755,0.638c0.1495,0.177,0.3695,0.279,0.601,0.279"
                                + "h1.3255c-0.3495,0.7335,-0.538,1.5385,-0.538,2.363c0,3.0395,2.474,5.514,5.514,5.514s5.514,-2.4745,5.514,-5.514"
                                + "c0,-0.8245,-0.1885,-1.6295,-0.538,-2.363h1.3255c0.2315,0,0.4515,-0.102,0.601,-0.279C-0.0335,0.4615,0.031,0.2285,0,0z"
                                + "M-7.0785,7.219c-2.1715,0,-3.9385,-1.767,-3.9385,-3.9385c0,-0.8545,0.2795,-1.6815,0.794,-2.363h6.2895c0.5145,0.6815,0.794,1.5085,0.794,2.363"
                                + "C-3.1395,5.452,-4.9065,7.219,-7.0785,7.219z",
                        Color.BLACK,
                        Color.TRANSPARENT,
                        0.0),
                newSvgPath("M0,0C0.08,0,0.16,0,0.25,0.01V-2.96C0.25,-3.37,-0.09,-3.71,-0.5,-3.71"
                                + "c-0.41,0,-0.75,0.34,-0.75,0.75v2.97C-0.92,-0.67,-0.84,-0.67,-0.75,-0.67"
                                + "c-4.61,0.23,-8.28,4.03,-8.28,8.7v1.94c0,1.1,0.9,2,2,2h13.56c1.1,0,2,-0.9,2,-2v-1.94C8.28,4.03,4.61,0.23,0,0z "
                                + "M2.229,13.628c0.33,0,0.57,0.31,0.49,0.63c-0.38,1.43,-1.68,2.48,-3.22,2.48"
                                + "c-1.54,0,-2.84,-1.05,-3.22,-2.48c-0.08,-0.32,0.16,-0.63,0.49,-0.63H2.229z",
                        Color.BLACK,
                        Color.TRANSPARENT,
                        0.0),
                newSvgPath("M0,0h-4.096c-0.755,0-1.365,0.61-1.365,1.365v4.096h-5.462c-4.832,0-8.83,3.61-9.46,8.272"
                                + "c-11.617,0.632-15.845,5.251-15.845,10.843v1.365c0,0.755,0.61,1.365,1.365,1.365h2.869c0.635,3.112,3.393,5.461,6.689,5.461"
                                + "s6.054-2.35,6.689-5.461h-2.869c0.755,0,1.365-0.61,1.365-1.365v-1.365c0-5.516-4.114-10.078-9.43-10.808"
                                + "c0.59-3.168,3.364-5.576,6.7-5.576h6.827v6.827c0,0.755,0.61,1.365,1.365,1.365h4.096c0.755,0,1.365-0.61,1.365-1.365"
                                + "v-10.096C1.365,0.61,0.755,0,0,0z M-16.555,27.307c-0.564,1.589-2.082,2.731-3.863,2.731s-3.299-1.142-3.863-2.731"
                                + "H-16.555z",
                        Color.BLACK,
                        Color.TRANSPARENT,
                        0.0),
                newSvgPath("M0,0h-7.016v-33.778h10.573l-5.333-20h-11.91l-3.081,11.556h9.72"
                                + "c0.246,0,0.444,0.199,0.444,0.444s-0.198,0.444-0.444,0.444h-9.958l-1.243,4.889h10.573"
                                + "c0.245,0,0.444,0.199,0.444,0.444c0,0.245-0.199,0.444-0.444,0.444h-13.432l-0.535,1.778h10.209v33.778h-10.393"
                                + "c-1.391,0-2.52,1.333-2.52,2.667h20.432C2.465,1.333,1.337,0,0,0z M-0.926,-35.333c0.246,0,0.444,0.199,0.444,0.444"
                                + "c0,0.245-0.198,0.444-0.444,0.444h-1.889c-0.246,0-0.444-0.199-0.444-0.444c0-0.245,0.198-0.444,0.444-0.444H-0.926z"
                                + "M-5.035,-40.666c0-0.245,0.198-0.444,0.444-0.444h1.889c0.246,0,0.444,0.199,0.444,0.444s-0.198,0.444-0.444,0.444h-1.889"
                                + "C-4.836,-40.222,-5.035,-40.421,-5.035,-40.666z",
                        Color.BLACK,
                        Color.TRANSPARENT,
                        0.0),
                newSvgPath("M0,0l-6.145-7.17v-2.805c0-0.59-0.475-1.065-1.065-1.065h-2.135v-2.135c0-0.59-0.475-1.065-1.065-1.065h-1.065v-1.07"
                                + "c0-0.59-0.475-1.065-1.065-1.065s-1.065,0.475-1.065,1.065v1.065h-1.065c-0.59,0-1.065,0.475-1.065,1.065v2.135h-2.135c-0.59,0-1.065,0.475-1.065,1.065"
                                + "v2.805l-6.155,7.175c-0.27,0.315-0.335,0.76-0.16,1.14s0.55,0.62,0.97,0.62h4.265c0,4.115,3.35,7.465,7.465,7.465s7.465-3.35,7.465-7.465h4.265"
                                + "c0.415,0,0.795-0.245,0.97-0.62C0.33,0.76,0.27,0.315,0,0z M-13.61,-12.11h2.135v1.065h-2.135V-12.11z"
                                + " M-6.145,-0.376h-12.8h-3.015l4.57-5.335h9.685l4.57,5.335H-6.145z",
                        Color.BLACK,
                        Color.TRANSPARENT,
                        0.0)
        };
    }

    public static void main(String[] args) {
        launch();
    }
}