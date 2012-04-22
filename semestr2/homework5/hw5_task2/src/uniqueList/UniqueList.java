package uniqueList;

/**
 * use to create UniqueList
 * 
 * @author vladimir-zakharov
 */
public class UniqueList<ElementType> extends List<ElementType> {

    /**
     * insert element into list behind index position
     * 
     * @param index position's number
     * @param value value, which you want to add
     * @throws ExistException This Exception will be trown if an element already
     * exists in the list
     */
    @Override
    public void insert(int index, ElementType value) throws ExistException {
        checkForExistance(value);
        super.insert(index, value);
    }

    /**
     * add element to the head of the list
     * 
     * @param value value, which you want to add
     * @throws ExistException This Exception will be trown if an element already
     * exists in the list
     */
    @Override
    public void addToHead(ElementType value) throws ExistException {
        checkForExistance(value);
        super.addToHead(value);
    }

    /**
     * add element to the tail of the list
     * 
     * @param value value, which you want to add
     * @throws ExistException This Exception will be trown if an element already
     * exists in the list
     */
    @Override
    public void addToEnd(ElementType value) throws ExistException {
        checkForExistance(value);
        super.addToEnd(value);
    }
    
    /**
     * checks value for existance
     * 
     * @param value value, which you want to check
     * @throws ExistException This Exception will be trown if an element already
     * exists in the list
     */
    private void checkForExistance(ElementType value) throws ExistException {
        if (exist(value)) {
            throw new ExistException();
        }
    }
}
