package robots;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author vladimir-zakharov
 */
public class Main {
    
    /**
     * constructor for class Main
     * @param adjacencyMatrix adjacency matrix of graph
     * @param strucutre structure of the robots
     */
    public Main(int[][] adjacencyMatrix, int[] strucutre) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.structure = strucutre;
    }
    
    /**
     * sets new adjacency matrix of graph
     * and new structure of the robots
     * @param adjacencyMatrix new adjacency matrix of graph
     * @param strucutre new structure of the robots
     */
    public void setNewStructure(int[][] adjacencyMatrix, int[] strucutre) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.structure = strucutre;
    }
    
    /**
     * calculate number of robots
     * @return number of robots
     */
    public int numberOfRobots() {
        int count = 0;
        
        for (int i = 0; i < structure.length; ++i) {
            if (structure[i] == 1) {
                    count++;
            }
        }
        
        return count;
    }
    
    /**
     * returns true if robots can be destroyed
     * else returns false
     * @return true if robots can be destroyed
     * else returns false
     */
    public boolean isSolved() {
        int generalAmount = numberOfRobots();
        
        if (generalAmount == 1) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int firstGroupAmount = 0;
        
        boolean[] coloredVertices = new boolean[structure.length];
        coloredVertices[0] = true;
        queue.offer(0);
        
        if (structure[0] == 1) {
            firstGroupAmount++;
        }
        
        while(!queue.isEmpty()) {
            int currentVertex = queue.remove();
            
            for (int j = 0; j < adjacencyMatrix.length; ++j) {
                if (adjacencyMatrix[currentVertex][j] == 1) {
                    for (int k = 0; k < adjacencyMatrix.length; ++k) {
                        if (adjacencyMatrix[j][k] == 1) {
                            if (!coloredVertices[k]) {
                                coloredVertices[k] = true;
                                queue.offer(k);
                                
                                if (structure[k] == 1) {
                                    firstGroupAmount++;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if (firstGroupAmount == 1) {
            return false;
        }
        
        int secondGroupAmount = generalAmount - firstGroupAmount;
        
        if (secondGroupAmount == 1) {
           return false;
        } else {
            return true;
        }       
    }
    
    /**
     * adjacency matrix of graph
     */
    private int[][] adjacencyMatrix;
    /**
     * displays content of the robots in vertices
     * if 1 - robot exists
     * else 0
     */
    private int[] structure;
}