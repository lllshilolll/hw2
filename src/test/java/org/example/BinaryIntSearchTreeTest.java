package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class BinaryIntSearchTreeTest {

    @Test
    void add() {
        BinaryIntSearchTree tree = new BinaryIntSearchTree();

        tree.add(5);

        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);
    }

    @Test
    void parentTest() {
        BinaryIntSearchTree tree = new BinaryIntSearchTree();
        tree.add(5);
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);

        Assertions.assertNull(tree.root.parent);
        Assertions.assertEquals(tree.root.left.parent, tree.root);
        Assertions.assertEquals(tree.root.right.parent, tree.root);
        Assertions.assertEquals(tree.root.left.right.parent, tree.root.left);
    }

    @Test
    void iteratorBinaryIntSearchTreeTest() {
        HomeWork tree = new HomeWork();
        tree.add(5);
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);

        Assertions.assertEquals(tree.toString(), "[ 0 1 2 3 4 5 6 7 8 9 10]");

        HomeWork tree2 = new HomeWork();
        tree2.add(5);
        tree2.add(3);
        tree2.add(1);
        tree2.add(2);
        tree2.add(4);
        tree2.add(8);
        tree2.add(7);
        tree2.add(6);
        tree2.add(10);
        tree2.add(9);
        Assertions.assertEquals(tree2.toString(), "[ 1 2 3 4 5 6 7 8 9 10]");
    }

    @Test
    void findMaxDigitsTest() {
        HomeWork tree = new HomeWork();
        tree.add(5);
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);
        List<Integer> list = tree.findMaxDigits(3, 5);
        List<Integer> assertionList = new ArrayList<>();
        assertionList.add(5);
        assertionList.add(6);
        assertionList.add(7);

        Assertions.assertEquals(list, assertionList);

        HomeWork tree2 = new HomeWork();
        tree2.add(5);
        tree2.add(3);
        tree2.add(1);
        tree2.add(2);
        tree2.add(4);
        tree2.add(8);
        tree2.add(7);
        tree2.add(6);
        tree2.add(10);
        tree2.add(9);
        List<Integer> list2 = tree2.findMaxDigits(5, 0);
        List<Integer> assertionList2 = new ArrayList<>();
        assertionList2.add(1);
        assertionList2.add(2);
        assertionList2.add(3);
        assertionList2.add(4);
        assertionList2.add(5);

        Assertions.assertEquals(list2, assertionList2);

        List<Integer> list3 = tree2.findMaxDigits(10, 10);
        List<Integer> assertionList3 = new ArrayList<>();
        assertionList3.add(10);

        Assertions.assertEquals(list3, assertionList3);


        List<Integer> list4 = tree2.findMaxDigits(0, 5);
        Assertions.assertEquals(list4, new ArrayList<>());
    }
}