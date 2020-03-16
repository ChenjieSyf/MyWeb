package com.example.demo.test.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumberAdd {

    public static volatile boolean carryFlag = false;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;

        //循环
        ListNode result = new ListNode(0);
        while (tempNode1 != null || tempNode2 != null) {
            ListNode temp = getTail(result);
            int bitNumber = addTwoNumber(tempNode1, tempNode2);
            if (bitNumber > 9) {
                temp.val = bitNumber % 10;
                carryFlag = true;
            } else {
                temp.val = bitNumber;
            }


            tempNode1 = tempNode1.next;
            tempNode2 = tempNode2.next;


            if (carryFlag || (tempNode1 != null || tempNode2 != null)) {
                if (tempNode1 == null) {
                    tempNode1 = new ListNode(0);
                }

                if (tempNode2 == null) {
                    tempNode2 = new ListNode(0);
                }

                getTail(result).next = new ListNode(0);
            }

        }


        return result;

    }

    public ListNode getTail(ListNode head) {

        if (head == null) {
            return null;
        }

        //找到最后一个节点
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public int addTwoNumber(ListNode l1, ListNode l2) {
        try {
            return Optional.ofNullable(l1).orElse(new ListNode(0)).val +
                    Optional.ofNullable(l2).orElse(new ListNode(0)).val +
                    (carryFlag ? 1 : 0)
                    ;

        } finally {
            carryFlag = false;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l11 = new ListNode(0);
        ListNode l111 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l211 = new ListNode(4);
        new TwoNumberAdd().addTwoNumbers(l1, l11);
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}