package org.didierdominguez;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HuffmanEncoder {
    public HuffmanEncoder() {
    }

    public void encode(String content) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getFrequency));

        // SPLIT INTO CHARACTERS
        List<String> charactersList = Arrays.asList(content.split("(?!^)"));
        Map<String, Long> characterCounts = charactersList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // SORT IN DESCENDING ORDER
        Map<String, Long> descendingCounts = characterCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(Colors.ANSI_CYAN + "Ascending count: " + Colors.ANSI_RESET + descendingCounts);

        // ADD TO PRIORITY QUEUE AS NODES
        descendingCounts.forEach((key, value) -> queue.add(new Node(String.valueOf(key.charAt(0)), value.intValue())));

        // CREATE HUFFMAN TREE USING PRIORITY QUEUE OF NODES AND TRAVERSE IT TO GET
        // CHARACTER CODING (0, 1)
        while (queue.size() > 1) {
            Node branchZero = queue.poll();
            Node branchOne = queue.poll();

            queue.add(new Node(branchZero, branchOne));
        }
        System.out.println(Colors.ANSI_CYAN + "Encoding: " + Colors.ANSI_RESET);

        queue.peek().traverse("");
        EncodingTable.getInstance().displayData();
    }
}
