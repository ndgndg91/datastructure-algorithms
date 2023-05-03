package datastructure.algorithms.algorithms.programers.hash;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BestAlbum {
    private static final String[] GENRES = {"classic", "pop", "classic", "classic", "pop"};
    private static final int[] PLAYS = {500, 600, 150, 800, 2500};
    private static final int[] RESULT = {4,1,3,0};

    public static void main(String[] args) {
        int[] result = bestAlbum(GENRES, PLAYS);

        for (int i : result) {
            System.out.print(i + "\t");
        }
    }

    private static int[] bestAlbum(String[] genres, int[] plays) {
        List<Node> nodes = new LinkedList<>();
        for (int i = 0; i < genres.length; i++) {
            Node node = new Node(genres[i], plays[i], i);
            nodes.add(node);
        }

        Collections.sort(nodes);

        List<Integer> answer = new ArrayList<>();
        Map<String, Long> groupByGenreMap = nodes.stream()
                .collect(groupingBy(Node::getGenre))
                .entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().stream().mapToLong(Node::getPlayCount).sum()));
        List<GenreSummary> genreSummaries = new ArrayList<>();
        for (Map.Entry<String, Long> entry : groupByGenreMap.entrySet()) {
            long totalPlayCount = groupByGenreMap.get(entry.getKey());
            GenreSummary genreSummary = new GenreSummary(entry.getKey(), totalPlayCount);
            genreSummaries.add(genreSummary);
        }

        Collections.sort(genreSummaries);

        for (GenreSummary summary : genreSummaries) {
            List<Integer> collect = nodes.stream()
                    .filter(n -> n.getGenre().equals(summary.getName()))
                    .skip(0)
                    .limit(2)
                    .map(Node::getOriginIndex)
                    .collect(Collectors.toList());
            answer.addAll(collect);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class GenreSummary implements Comparable<GenreSummary>{
        private final String name;
        private final Long totalPlayCount;

        public GenreSummary(String name, long totalPlayCount) {
            this.name = name;
            this.totalPlayCount = totalPlayCount;
        }

        public String getName() {
            return name;
        }

        public long getTotalPlayCount() {
            return totalPlayCount;
        }

        @Override
        public int compareTo(GenreSummary genreSummary) {
            return genreSummary.totalPlayCount.compareTo(this.totalPlayCount);
        }
    }

    private static class Node implements Comparable<Node>{
        private final String genre;
        private final Long playCount;
        private final int originIndex;

        protected Node(String genre, long playCount, int originIndex) {
            this.genre = genre;
            this.playCount = playCount;
            this.originIndex = originIndex;
        }

        public String getGenre() {
            return genre;
        }

        public long getPlayCount() {
            return playCount;
        }

        public int getOriginIndex() {
            return originIndex;
        }

        @Override
        public int compareTo(Node node) {
            return node.playCount.compareTo(this.playCount);
        }
    }
}
