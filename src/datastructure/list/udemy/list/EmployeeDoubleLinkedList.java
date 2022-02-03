package datastructure.list.udemy.list;

import java.util.Objects;

public class EmployeeDoubleLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(final Employee employee) {
        var node = new EmployeeNode(employee);

        if (head == null) {
            tail = node;
        } else {
            head.setPrev(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(final Employee employee) {
        var node = new EmployeeNode(employee);

        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }

        tail = node;
        size++;
    }

    public Employee removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        var node = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            node.next.prev = null;
            head = node.next;
        }

        size--;
        return node.getEmployee();
    }

    public Employee removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        var node = tail;
        if (tail.prev == null) {
            tail = null;
            head = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }

        size--;
        return node.getEmployee();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder("HEAD -> ");
        var node = head;
        while (node != null) {
            builder.append(node).append("\t");
            node = node.next;
        }

        return builder.toString();
    }

    private static final class EmployeeNode {
        private EmployeeNode prev;
        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode getPrev() {
            return prev;
        }

        public void setPrev(EmployeeNode prev) {
            this.prev = prev;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode getNext() {
            return next;
        }

        public void setNext(EmployeeNode next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeNode that = (EmployeeNode) o;
            return Objects.equals(prev, that.prev) && Objects.equals(employee, that.employee) && Objects.equals(next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(prev, employee, next);
        }

        @Override
        public String toString() {
            return employee.toString();
        }
    }

}
