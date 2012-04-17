package set;

/**
 * use to create a set
 *
 * @author vladimir-zakharov
 */
public class Set<ElementType> {

    /**
     * constructor for Set
     */
    public Set() {
        this.head = null;
    }

    /**
     * checks existence of the element in the set
     *
     * @param value value, which you check for existence
     * @return true if exists; false if not exists
     */
    public boolean Exist(ElementType value) {
        SetElement temp = head;

        while (temp != null) {
            if (temp.value.equals(value)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /**
     * adds element to the set
     *
     * @param value value, which you want to add
     */
    public void addElement(ElementType value) {
        if (Exist(value)) {
            return;
        }

        SetElement newElement = new SetElement(value, head);
        head = newElement;
    }

    /**
     * deletes an element from the set
     *
     * @param value value, which you want to delete
     * @throws NotFoundElementException This Exception will be trown if an
     * element not found in the set
     */
    public void deleteElement(ElementType value) throws NotFoundElementException {
        if (!Exist(value)) {
            throw new NotFoundElementException();
        }

        if (head.value.equals(value)) {
            head = head.next;
        } else {
            SetElement temp = head.next;
            SetElement prev = head;

            while (temp != null) {
                if (temp.value.equals(value)) {
                    break;
                }
                prev = temp;
                temp = temp.next;
            }

            prev.next = prev.next.next;
        }
    }

    /**
     * intersects the set with another set
     *
     * @param set this is another set
     * @return intersected set
     */
    public Set<ElementType> intersection(Set<ElementType> set) {
        Set<ElementType> resultSet = new Set<ElementType>();

        SetElement temp = head;

        while (temp != null) {
            if (set.Exist(temp.value)) {
                resultSet.addElement(temp.value);
            }
            temp = temp.next;
        }

        return resultSet;
    }

    /**
     * unites the set with another set
     *
     * @param set this is another set
     * @return united set
     */
    public Set<ElementType> union(Set<ElementType> set) {
        Set<ElementType> resultSet = new Set<ElementType>();

        SetElement temp = head;

        while (temp != null) {
            resultSet.addElement(temp.value);
            temp = temp.next;
        }

        temp = set.head;

        while (temp != null) {
            resultSet.addElement(temp.value);
            temp = temp.next;
        }

        return resultSet;
    }

    /**
     * elements of the set
     */
    private class SetElement {

        /**
         * constructor for SetElement
         *
         * @param value value, which you init element
         * @param next link to next element
         */
        private SetElement(ElementType value, SetElement next) {
            this.value = value;
            this.next = next;
        }
        private ElementType value;
        private SetElement next;
    }
    /**
     * head of the set
     */
    private SetElement head;
}
