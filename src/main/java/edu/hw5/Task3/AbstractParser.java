package edu.hw5.Task3;

import java.time.LocalDate;

public abstract class AbstractParser {
    private AbstractParser next;

    //Строительство цепи
    public static AbstractParser link(AbstractParser first, AbstractParser... chain) {
        AbstractParser head = first;
        for (AbstractParser nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    //Проверка у потомков
    public abstract LocalDate check(String date);

    //Запускает проверку в следующем объекте
    protected LocalDate checkNext(String date) {
        if (next == null) {
            return null;
        }
        return (next.check(date));
    }
}
