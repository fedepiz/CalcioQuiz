package fedepiz.calcioquiz.model;

import java.io.Serializable;

/**
 * Created by Federico on 14/7/15.
 */
public class Pair<T,U> implements Serializable{
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first.toString() + "," + second.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Pair) {
            Pair otherPair = (Pair)other;
            return  otherPair.getFirst().equals(this.getFirst()) &&
                    otherPair.getSecond().equals(this.getSecond());
        }
        return false;
    }
}
