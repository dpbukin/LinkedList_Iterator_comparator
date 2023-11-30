package Trees.BinarySearchTree;

public interface AbstractBinarySearchTree<E extends Comparable<E>> {
    class Node<E> {
        public E value;
        public Node<E> leftChild;
        public Node<E> rightChild;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> leftChild, Node<E> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Node() {
        }


    }

//    Вставляем элемент в бинарное дерево поиска.
    void insert(E element);
//    Проверяем наличие элемента в бинарном дереве поиска.
    boolean contains(E element);

//    Поиск элемента в бинарном дереве поиска.
    AbstractBinarySearchTree<E> search(E element);

//    Возвращаем корневой узел дерева.
    Node<E> getRoot();

//    Возвращаем левое поддерево корневого узла.
    Node<E> getLeft();

//    Возвращаем правое поддерево корневого узла.
    Node<E> getRight();

//    Возвращаем значение корневого узла.
    E getValue();

//    Выполняем обход в порядке inorder и возвращаем представление дерева в виде строки.
    String inOrderTraversal();

    void printTree();


}

