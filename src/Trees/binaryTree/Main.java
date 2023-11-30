package Trees.binaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.insert(12);
        root.insert(8);
        root.insert(7);
        root.insert(9);
        root.insert(11);
        root.insert(13);

        System.out.println("Бинарное дерево:");
        root.printTree();

        // Выводим дерево в виде строки в порядке preOrder с отступами
        System.out.println("Дерево в виде preorder");
        System.out.println(root.asIndentedPreOrder(0));

        // Выводим дерево в порядке preOrder
        System.out.println("preorder для дерева:");
        root.preOrder().forEach(node -> System.out.print(node.getKey() + " "));
        System.out.println();

        // Выводим дерево в порядке inOrder
        System.out.println("inorder для дерева:");
        root.inOrder().forEach(node -> System.out.print(node.getKey() + " "));
        System.out.println();

        // Выводим дерево в порядке postOrder
        System.out.println("postOrder для дерева::");
        root.postOrder().forEach(node -> System.out.print(node.getKey() + " "));
        System.out.println();

        // Печатаем элементы в отсортированном порядке
        System.out.println("Отсортированное дерево:");
        root.printInOrder();

        System.out.println();

        System.out.println("DFS (обход в глубину):");
        root.DFS(System.out::println);

        System.out.println();

        System.out.println("BFS (обход в ширину):");
        root.BFS(System.out::println);
    }
}
