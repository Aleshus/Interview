import static org.junit.Assert.assertEquals;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class Node<T> {
    public T data;
    public Node<T> next;

    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(T data) {
        this(data, null);
    }

    private static <S>  List<S> reverseList(List<S> list) {
        Collections.reverse(list);
        return list;
    }

    static <S> Node<S> listFromArray(S... values) {

        return reverseList(Arrays.asList(values))
                .stream()
                .skip(1)
                .map(value -> new Node<S>(value))
                .reduce(new Node<S>(values[0]), (nextNode, futureRoot) -> {futureRoot.next = nextNode; return futureRoot;});
    }
}

class Main {
    static <T> boolean anyMatch(Node<T> head, Predicate<T> p) {
        return Optional.ofNullable(head)
                .map(h -> p.test(head.data) ? true : anyMatch(h.next, p))
                .orElse(false);
    }

    static <T> boolean allMatch(Node<T> head, Predicate<T> p) {
        return !anyMatch(head,p.negate());
    }


    public static void main(String[] argv) {
        printNodes(Node.listFromArray(1, 2, 3));
        basicTests();
        arrayOfInts();
    }


    static void printNodes(Node head) {
        System.out.println("Here should be 1 2 3 on each line> ");
        Stream.iterate(head, next -> next.next)
                .takeWhile(node -> node != null)
                .forEach(node -> {
                    System.out.println(node.data);
                });
    }


    public static void basicTests() {
        assertEquals(false, anyMatch(null, __ -> false));
        assertEquals(false, anyMatch(null, __ -> true));
        assertEquals(true, allMatch(null, __ -> false));
        assertEquals(true, allMatch(null, __ -> true));
        System.out.println("BasicTests ok!");
    }


    public static void arrayOfInts() {
        assertEquals(true, anyMatch(Node.listFromArray(1, 2, 3), x -> x > 1));
        assertEquals(false, allMatch(Node.listFromArray(1, 2, 3), x -> x > 1));
        System.out.println("ArrayOfInts  ok!");
    }
}