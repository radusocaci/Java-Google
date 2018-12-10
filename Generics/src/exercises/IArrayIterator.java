package exercises;

import java.util.NoSuchElementException;

interface IArrayIterator<T> {
    boolean hasNext()  throws NoSuchElementException;
    T next()  throws NoSuchElementException;
}
