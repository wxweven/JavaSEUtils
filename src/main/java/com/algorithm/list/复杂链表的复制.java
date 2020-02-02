package com.algorithm.list;

public class 复杂链表的复制 {
    // 根据原始结点A在其后面创建A'。
    public void cloneNodes(ListNode head) {
        ListNode node = head;
        while (node != null) {
            //创建clonedNode结点即A'结点使其指向原始链表中A结点的下一结点B,不过A'的sibling设置为null
            ListNode clonedNode = new ListNode();
            clonedNode.val = node.val;
            clonedNode.next = node.next;
            clonedNode.sibling = null;

            //将A结点指向A’结点
            node.next = clonedNode;
            //使node指向A的下一结点B并以此循环修改(此时中间已将克隆结点A‘插入了原始列表)
            node = clonedNode.next;
        }
    }

    //设置每个结点的sibling(注：sibling为空结点不做修改)
    public void connectSiblingNodes(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode clonedNode = node.next;
            if (node.sibling != null) {
                clonedNode.sibling = node.sibling.next;
            }
            node = clonedNode.next;
        }
    }

    //上面的三步合起来即为复杂链表的复制
    public ListNode clone(ListNode pHead) {
        cloneNodes(pHead);
        connectSiblingNodes(pHead);
        return 提取链表偶数位节点.getEvenHead(pHead);
    }
}
