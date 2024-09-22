package org.example;

/**
 * Логику класса не менять, все изменения делаем в Homework классе
 * Двоичное дерево поиска (англ. binary search tree, BST) — это двоичное дерево,
 * обладающее дополнительными свойствами:
 * значение левого потомка меньше значения родителя,
 * а значение правого потомка больше значения родителя для каждого узла дерева;
 * оба поддерева — левое и правое — являются двоичными деревьями поиска.
 */
public class BinaryIntSearchTree {

    protected Node root;

    public boolean add(int element) {
        if (root == null) {
            root = new Node(element);
            return true;
        }

        return root.add(element);
    }

    static class Node {
        Node left;
        Node right;
        int value;
        Node parent = null;

        public Node(int element) {
            this.value = element;
        }

        public boolean add(int element) {
            if (value == element) {
                return false;
            }
            if (element < value) {
                //left
                if (left == null) {
                    left = new Node(element);
                    left.parent = this;
                    return true;
                }
                return left.add(element);
            }
            //right
            if (right == null) {
                right = new Node(element);
                right.parent = this;
                return true;
            }
            return right.add(element);
        }
    }
}
