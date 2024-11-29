package com.example.task01;

import java.util.Objects;
import java.util.function.BiConsumer;

public class Pair<F, S> {
    private final F first;
    private final S second;

    // Закрытый конструктор
    private Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    // Статический фабричный метод
    public static <F, S> Pair<F, S> of(F first, S second) {
        return new Pair<>(first, second);
    }

    // Метод для получения первого элемента
    public F getFirst() {
        return first;
    }

    // Метод для получения второго элемента
    public S getSecond() {
        return second;
    }

    // Переопределение equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    // Переопределение hashCode
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public void ifPresent(BiConsumer<? super F, ? super S> action) {
        if (action != null) {
            action.accept(first, second);
        }
    }
}