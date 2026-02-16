public class List {

    private Node first;
    private int size;

    public List() {
        first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public CharData getFirst() {
        if (first == null) {
            return null;
        }
        return first.cp;
    }

    public void addFirst(char chr) {
        Node newNode = new Node(new CharData(chr));
        newNode.next = first;
        first = newNode;
        size++;
    }

    public String toString() {
        if (size == 0) return "()";
        StringBuilder str = new StringBuilder("(");
        Node current = first;
        while (current != null) {
            str.append(current.cp.toString()).append(" ");
            current = current.next;
        }
        return str.toString().trim() + ")";
    }

    public int indexOf(char chr) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.cp.equals(chr)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void update(char chr) {
        int index = indexOf(chr);
        if (index == -1) {
            addFirst(chr);
        } else {
            Node current = first;
            while (current != null) {
                if (current.cp.equals(chr)) {
                    current.cp.count++;
                    return;
                }
                current = current.next;
            }
        }
    }

    public boolean remove(char chr) {
        Node current = first;
        Node prev = null;
        while (current != null) {
            if (current.cp.equals(chr)) {
                if (prev == null) {
                    first = first.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public CharData get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.cp;
    }

    public CharData[] toArray() {
        CharData[] arr = new CharData[size];
        Node current = first;
        int i = 0;
        while (current != null) {
            arr[i++] = current.cp;
            current = current.next;
        }
        return arr;
    }

    public ListIterator listIterator(int index) {
        if (size == 0) return null;
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return new ListIterator(current);
    }
}