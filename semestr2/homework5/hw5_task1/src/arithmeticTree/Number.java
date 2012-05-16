package arithmeticTree;

/**
 *
 * @author vladimir-zakharov
 */
public class Number extends TreeElement {
    
    public Number(String string) {
        this.number = string;
    }
    
    @Override
    public void print() {
        System.out.print(number + ' ');
    }
    
    @Override
    public int calculate() {
        return Integer.parseInt(number);
    }
    
    private String number;
}
