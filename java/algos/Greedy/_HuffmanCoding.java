package algos.Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = this.right = null;
    }
}

public class _HuffmanCoding {

    /**
     * Huffman Coding algorithm.
     *
     * @param charFrequencies The frequencies of characters.
     * @return The Huffman Code.
     */
    public static String huffmanCoding(int[] charFrequencies) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        // Create a leaf node for each character and add it to the priority queue
        for (int i = 0; i < charFrequencies.length; i++) {
            if (charFrequencies[i] > 0) {
                priorityQueue.offer(new HuffmanNode((char) ('A' + i), charFrequencies[i]));
            }
        }

        // Build the Huffman Tree
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode internalNode = new HuffmanNode('$', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;

            priorityQueue.offer(internalNode);
        }

        // Traverse the Huffman Tree to get Huffman Codes
        return buildHuffmanCodes(priorityQueue.peek(), "");
    }

    private static String buildHuffmanCodes(HuffmanNode root, String code) {
        StringBuilder huffmanCodes = new StringBuilder();

        if (root != null) {
            if (root.data != '$') {
                huffmanCodes.append(root.data).append(": ").append(code).append("\n");
            }

            huffmanCodes.append(buildHuffmanCodes(root.left, code + "0"));
            huffmanCodes.append(buildHuffmanCodes(root.right, code + "1"));
        }

        return huffmanCodes.toString();
    }

    public static void main(String[] args) {
        
        // Example 6: Huffman Coding
        int[] charFrequencies = {5, 9, 12, 13, 16, 45};
        String huffmanCode = huffmanCoding(charFrequencies);
        System.out.println("Huffman Coding: " + huffmanCode);
    }
}
