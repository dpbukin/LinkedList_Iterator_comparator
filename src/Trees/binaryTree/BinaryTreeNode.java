package Trees.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTreeNode<E extends Comparable<E>> implements AbstractBinaryTree<E> {
    private E key;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode(E key, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryTreeNode(E key) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }


    public void insert(E newElement) {
        BinaryTreeNode<E> newNode = new BinaryTreeNode<>(newElement);

        if (this.key == null) {
            // Дерево пусто, устанавливаем новый элемент как корень
            this.key = newElement;
            return;
        }

        BinaryTreeNode<E> parentElement = null;
        BinaryTreeNode<E> childElement = this;

        while (childElement != null) {
            parentElement = childElement;

            // Сравниваем новый элемент с текущим узлом
            int comparisonResult = newElement.compareTo(childElement.key);

            if (comparisonResult < 0) {
                childElement = childElement.getLeftChild();
            } else if (comparisonResult > 0) {
                childElement = childElement.getRightChild();
            } else {
                // Элемент уже существует в дереве, ничего не делаем
                return;
            }
        }

        // Вставляем новый узел в зависимости от результата сравнения
        int comparisonResult = newElement.compareTo(parentElement.key);
        if (comparisonResult < 0) {
            parentElement.setLeftChild(newNode);
        } else {
            parentElement.setRightChild(newNode);
        }
    }


    public void printTree() {
        printTreeMethod(this, 0);
    }

    private void printTreeMethod(BinaryTreeNode<E> node, int level) {
        if (node != null) {
            printTreeMethod(node.getRightChild(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            System.out.println(node.getKey());

            printTreeMethod(node.getLeftChild(), level + 1);
        }
    }




    //------------------------------------------------------------------------------------------------------------------

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    @Override
    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }
    public void setLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();
        asIndentedPreOrderMethod(this, indent, result);
        return result.toString();
    }

    private void asIndentedPreOrderMethod(BinaryTreeNode<E> node, int indent, StringBuilder result) {
        if (node == null) {
            return;
        }

        // Добавляем значение текущего узла
        result.append(" ".repeat(Math.max(0, indent))).append(node.getKey()).append("\n");

        // Рекурсивно вызываем для левого и правого поддеревьев с увеличенным отступом
        asIndentedPreOrderMethod(node.getLeftChild(), indent + 2, result);
        asIndentedPreOrderMethod(node.getRightChild(), indent + 2, result);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        preOrderMethod(this, result);
        return result;
    }

    private void preOrderMethod(BinaryTreeNode<E> node, List<AbstractBinaryTree<E>> result) {
        if (node != null) {
            result.add(node);
            preOrderMethod(node.getLeftChild(), result);
            preOrderMethod(node.getRightChild(), result);
        }
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        inOrderMethod(this, result);
        return result;
    }

    private void inOrderMethod(BinaryTreeNode<E> node, List<AbstractBinaryTree<E>> result) {
        if (node != null) {
            inOrderMethod(node.getLeftChild(), result);
            result.add(node);
            inOrderMethod(node.getRightChild(), result);
        }
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        postOrderMethod(this, result);
        return result;
    }

    private void postOrderMethod(BinaryTreeNode<E> node, List<AbstractBinaryTree<E>> result) {
        if (node != null) {
            postOrderMethod(node.getLeftChild(), result);
            postOrderMethod(node.getRightChild(), result);
            result.add(node);
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        forEachInOrderMethod(this, consumer);
    }

    @Override
    public void printInOrder() {
        AbstractBinaryTree.super.printInOrder();
    }
    private void forEachInOrderMethod(BinaryTreeNode<E> node, Consumer<E> consumer) {
        if (node != null) {
            forEachInOrderMethod(node.getLeftChild(), consumer);
            consumer.accept(node.getKey());
            forEachInOrderMethod(node.getRightChild(), consumer);
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void DFS(Consumer<E> consumer) {
        dfsMethod(this, consumer);
    }

    private void dfsMethod(BinaryTreeNode<E> node, Consumer<E> consumer) {
        if (node != null) {
            dfsMethod(node.getLeftChild(), consumer);
            consumer.accept(node.getKey());
            dfsMethod(node.getRightChild(), consumer);
        }
    }



    @Override
    public void BFS(Consumer<E> consumer) {
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            BinaryTreeNode<E> current = queue.poll();
            consumer.accept(current.getKey());

            if (current.getLeftChild() != null) {
                queue.add(current.getLeftChild());
            }

            if (current.getRightChild() != null) {
                queue.add(current.getRightChild());
            }
        }
    }
}
