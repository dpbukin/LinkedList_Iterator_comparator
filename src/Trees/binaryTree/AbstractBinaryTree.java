package Trees.binaryTree;

import java.util.List;
import java.util.function.Consumer;
public interface AbstractBinaryTree<E> {

    // Возвращает ключ узла
    E getKey();

    // Возвращает левое поддерево узла
    AbstractBinaryTree<E> getLeftChild();

    // Возвращает правое поддерево узла
    AbstractBinaryTree<E> getRightChild();

    // Устанавливает ключ узла
    void setKey(E key);

    // Возвращает дерево в виде строки в порядке preOrder с указанным отступом в 2 для каждого внутреннего уровня
    String asIndentedPreOrder(int indent);

    // Возвращает дерево в порядке preOrder (прямой обход)
    List<AbstractBinaryTree<E>> preOrder();

    // Возвращает дерево в порядке inOrder (центрированный обход)
    List<AbstractBinaryTree<E>> inOrder();

    // Возвращает дерево в порядке postOrder (обратный обход)
    List<AbstractBinaryTree<E>> postOrder();

    // Применяет Consumer<E> к каждому узлу в порядке inOrder
    // Используется для выполнения операции над каждым элементом дерева
    void forEachInOrder(Consumer<E> consumer);

    // Печатает элементы в отсортированном порядке (inOrder)
    default void printInOrder() {
        forEachInOrder(element -> System.out.println(element));
    }

    void DFS(Consumer<E> consumer);

    void BFS(Consumer<E> consumer);

}
