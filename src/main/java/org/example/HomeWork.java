package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]
     *
     * @param count      максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и
     * длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = iterator();

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value >= upperBound && count != 0) {
                list.add(value);
                count--;
            }
        }
        return list;
    }

    private Node findLeftChild(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Iterator<Integer> iterator() {
        return new Itr(root);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Integer> iterator = iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            sb.append(" ").append(value);
        }
        sb.append("]");
        return sb.toString();
    }

    public class Itr implements Iterator<Integer> {
        private Node it;

        public Itr(Node root) {
            if (root != null) {
                it = findLeftChild(root);
            }
        }

        @Override
        public boolean hasNext() {
            return it != null;
        }

        @Override
        public Integer next() {
            if (it == null) {
                throw new IllegalStateException("No next element");
            }
            Integer result = it.value;
            findNext();

            return result;
        }

        private void findNext() {
            if (it.right != null) {
                it = findLeftChild(it.right);
            } else {
                while (it.parent != null && it.parent.right == it) {
                    it = it.parent;
                }
                it = it.parent;
            }
        }
    }
}
