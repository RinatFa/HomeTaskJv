package org._811286;

// 3. Напишите обобщенный класс Pair, который представляет
// собой пару значений разного типа. Класс должен иметь
// методы getFirst(), getSecond() для получения значений
// каждого из составляющих пары, а также переопределение
// метода toString(), возвращающее строковое представление пары.
public class Pair<T, P> {
    private T first;
    private P second;

    public Pair(T first, P second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public P getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair [first = " + first + ", second = " + second + "]";
    }
}
