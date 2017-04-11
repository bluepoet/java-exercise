package net.bluepoet.exercise.lambda;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by daumkakao on 2017. 4. 7..
 */
public class Camera {
    private Function<Color, Color> filter;

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);

        return processedColor;
    }

    public void setFilter(final Function<Color, Color>... filters) {
        this.filter = Stream.of(filters)
                .reduce((filter, next) -> filter.compose(next))
                .orElse(color -> color);
    }

    public Camera() {
        setFilter();
    }

    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = (filterInfo) ->
                System.out.println(String.format("with %s: %s", filterInfo,
                        camera.capture(new Color(200, 100, 200))));
        printCaptured.accept("no filter");

        camera.setFilter(Color::brighter);
        printCaptured.accept("brighter filter");

        camera.setFilter(Color::brighter, Color::darker);
        printCaptured.accept("brighter && darker filter");
    }
}
