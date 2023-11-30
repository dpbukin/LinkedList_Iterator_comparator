package Trees.BinarySearchTree;

public class Main {

//    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>(null);

        tree.insert("Груша");
        tree.insert("Банан");
        tree.insert("Виноград");
        tree.insert("Арбуз");
        tree.insert("Картошка");
        tree.insert("Капуста");
        tree.insert("Дыня");
        tree.insert("Банан");
        tree.insert("Морковь");



//        tree.insert("Ford");
//        tree.insert("Chevrolet");
//        tree.insert("Honda");
//        tree.insert("Audi");
//        tree.insert("BMW");
//        tree.insert("Mercedes");
//        tree.insert("Kia");
//        tree.insert("Toyota");
//        tree.insert("Tesla");

        tree.printTree();
        System.out.println();

        // Формируем предложение из слов дерева
        String sentence = tree.inOrderTraversal();
        System.out.println("Предложение из слов: " + sentence);

        // Проверяем наличие слов в дереве
        System.out.println("Есть ли слово 'BMW': " + tree.contains("BMW")); // true
        System.out.println("Есть ли слово 'Lexus': " + tree.contains("Lexus")); // false

        // Проверяем поиск
        AbstractBinarySearchTree<String> searchResult = tree.search("Tesla");
        System.out.println("Искомое поддерево: " + searchResult.inOrderTraversal());

        // Удаляем поддерево, начинающееся с заданного слова
        tree.deleteSubtree("Арбуз");
        String updatedSentence = tree.inOrderTraversal();
        System.out.println("Результат удаления поддерева: " + updatedSentence);

        System.out.println();
        tree.printTree();


    }
}
