package Trees.BinarySearchTree;
public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    //    Вставляем элемент в бинарное дерево поиска.
    @Override
    public void insert(E element) {
        root = insertRecursiveMethod(root, element);
    }

    private Node<E> insertRecursiveMethod(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        }

        int compareResult = element.compareTo(node.value);

        if (compareResult < 0) {
            // Элемент меньше текущего узла, вставляем в левое поддерево
            node.leftChild = insertRecursiveMethod(node.leftChild, element);
        } else if (compareResult > 0) {
            // Элемент больше текущего узла, вставляем в правое поддерево
            node.rightChild = insertRecursiveMethod(node.rightChild, element);
        } else {
            // Элемент уже существует в дереве, ничего не делаем
        }

        return node;
    }


    //    Проверяем наличие элемента в бинарном дереве поиска.
    @Override
    public boolean contains(E element) {
        return containsRecursiveMethod(root, element);
    }
    private boolean containsRecursiveMethod(Node<E> node, E element) {
        if (node == null) {
            return false;
        }

        int compareResult = element.compareTo(node.value);

        if (compareResult < 0) {
            return containsRecursiveMethod(node.leftChild, element);
        } else if (compareResult > 0) {
            return containsRecursiveMethod(node.rightChild, element);
        } else {
            return true;
        }
    }



    //    Поиск элемента в бинарном дереве поиска.
    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> foundNode = searchRecursiveMethod(root, element);
        return foundNode != null ? new BinarySearchTree<>(foundNode) : new BinarySearchTree<>(null);
    }

    private Node<E> searchRecursiveMethod(Node<E> node, E element) {
        if (node == null || element == null) {
            return null;
        }

        int compareResult = element.compareTo(node.value);

        if (compareResult < 0) {
            return searchRecursiveMethod(node.leftChild, element);
        } else if (compareResult > 0) {
            return searchRecursiveMethod(node.rightChild, element);
        } else {
            // Найден узел с искомым элементом
            return node;
        }
    }


    //    Возвращаем корневой узел дерева.
    @Override
    public Node<E> getRoot() {
        return root;
    }

    //    Возвращаем левое поддерево корневого узла.
    @Override
    public Node<E> getLeft() {
        return root != null ? root.leftChild : null;
    }

    //    Возвращаем правое поддерево корневого узла.
    @Override
    public Node<E> getRight() {
        return root != null ? root.rightChild : null;
    }

    //    Возвращаем значение корневого узла.
    @Override
    public E getValue() {
        return root != null ? root.value : null;
    }

    //    Выполняем обход в порядке inorder и возвращаем представление дерева в виде строки.
    public String inOrderTraversal() {
        StringBuilder result = new StringBuilder();
        inOrderTraversalMethod(root, result);
        return (String) result.toString().trim();
    }

//    Обход начинается с указанного узла и продолжается в следующем порядке:
//    левое поддерево, текущий узел, правое поддерево.
    private void inOrderTraversalMethod(Node<E> node, StringBuilder result) {
        if (node != null) {
            // Рекурсивно обходим левое поддерево
            inOrderTraversalMethod(node.leftChild, result);
            // Добавляем значение текущего узла к результату
            result.append(node.value).append(" ");
            // Рекурсивно обходим правое поддерево
            inOrderTraversalMethod(node.rightChild, result);
        }
    }

    //      Метод для удаления поддерева, начинающегося с заданного слова
    public void deleteSubtree(E element) {
        root = deleteSubtreeMethod(root, element);
    }

    private Node<E> deleteSubtreeMethod(Node<E> node, E element) {
        if (node == null) {
            return null;
        }

        int compareResult = element.compareTo(node.value);

        if (compareResult < 0) {
            node.leftChild = deleteSubtreeMethod(node.leftChild, element);
        } else if (compareResult > 0) {
            node.rightChild = deleteSubtreeMethod(node.rightChild, element);
        } else {
            // Нашли узел для удаления
            node.leftChild = null;
            node.rightChild = null;
            return null; // Удаляем узел, возвращаем null
        }

        return node;
    }
    @Override
    public void printTree() {
        printTreeMethod(root, 0);
    }

    // Этот метод будет рекурсивно выводить дерево на экран
    // Дерево обходится в порядке справа-корень-лево, чтобы корректно вывести его структуру
    private void printTreeMethod(Node<E> node, int level) {
        if (node != null) {
            printTreeMethod(node.rightChild, level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("          ");
            }



            System.out.println(node.value);

            printTreeMethod(node.leftChild, level + 1);
        }
    }
}

