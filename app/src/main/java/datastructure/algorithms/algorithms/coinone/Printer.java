package datastructure.algorithms.algorithms.coinone;

import java.util.*;

/**
 * 제임스가 일하는 사무실에는 문서를 한 번에 하나씩 인쇄할 수 있는 프린터 한 대가 있습니다. 혼자 프린터를 사용할 때는 별
 * 문제가 없지만, 여러 사람이 동시에 프린터를 사용할 때는 어떤 문서를 먼저 인쇄할지 정해야 합니다. 일반적인 프린터의 경우
 * 먼저 요청된 문서를 먼저 인쇄하지만, 제임스는 보다 효율적인 일처리를 위해 다음과 같이 프린터가 인쇄 요청을 처리하는 규
 * 칙을 정했습니다.
 * 1. 인쇄 중 또는 대기 중인 문서가 없을 때 인쇄 요청된 문서는 즉시 인쇄합니다.
 * 2. 인쇄 중 또는 대기 중인 문서가 있을 때 인쇄 요청된 문서는 대기열에 추가합니다.
 * 3. 인쇄 중인 문서가 전부 인쇄된 후 대기열에서 다음 문서를 선택해 인쇄합니다.
 * 3-1. 대기 중인 문서중 페이지 수가 적은 문서부터 인쇄합니다.
 * 3-2. 대기 중인 문서중 페이지 수가 같은 문서가 있을 경우, 먼저 요청된 문서부터 인쇄합니다.
 * 3-3. 현재 인쇄 중인 문서의 인쇄가 끝난 시각과 새로 요청된 문서의 인쇄 요청 시각이 같은 경우, 새로 요청된 문서를
 * 먼저 대기열에 추가한 후 다음에 인쇄해야 될 문서를 선택합니다.
 * 제임스는 프린터가 규칙대로 작동하는지 테스트하기 위해 가상의 인쇄 요청 데이터를 만들어 입력해보려 합니다. 각 인쇄 요
 * 청 데이터는 다음과 같은 형식입니다.
 * [문서 번호, 인쇄 요청 시각, 페이지 수]
 * 단, 인쇄 요청 시각은 0초부터 시작하며, 초 단위로 나타냅니다. 예를 들어 어떤 문서의 인쇄 요청 데이터가 [2, 2, 4]인 경우,
 * 이는 2번 문서가 2초에 인쇄 요청됐으며, 4페이지를 인쇄해야 된다는 의미입니다. 또한 한 페이지를 인쇄하는 데에는 1초가
 * 걸립니다.
 * 인쇄 요청 데이터들이 들어있는 배열 data가 매개변수로 주어질 때, 배열에 인쇄가 완료되는 순서대로 문서 번호를 담아
 * return 하도록 solution 함수를 완성해주세요.
 * 제한사항
 * data는 가로(열) 길이가 3, 세로(행) 길이가 1 이상 100,000 이하인 2차원 배열입니다.
 * data의 원소는 [문서 번호, 인쇄 요청 시각, 페이지 수] 형식입니다.
 * 인쇄할 문서가 N개일 때, 모든 문서에는 1부터 N까지 번호가 하나씩 붙어있습니다.
 * data의 각 행은 문서 번호와 인쇄 요청 시각이 증가하는 순서로 주어집니다.
 * 즉, data의 각 행의 문서 번호는 1부터 N까지 오름차순 형태로 주어지며, 번호가 클수록 나중에 인쇄 요청된 문서
 * 입니다.
 * 인쇄 요청 시각이 같은 문서는 없습니다.
 * 인쇄 요청 시각은 0 이상 100,000,000 이하인 자연수입니다.
 * 페이지 수는 1 이상 100,000 이하인 자연수입니다.
 * 문서를 대기열에 추가하거나, 다음 인쇄할 문서를 선택하는데 걸리는 시간은 없다고 가정합니다.
 */
public class Printer {

    public int[] solution(int[][] data) {
        var index = 0;
        var documents = Arrays.stream(data).map(Document::new).toList();
        var queue = new PriorityQueue<Document>();
        var results = new ArrayList<Integer>();

        var time = 0;
        var processingTime = 0;
        Document processing = null;
        while (results.size() != documents.size()) {
            // 시간이 되엇을 때 queue 에 추가
            if (index < documents.size() && documents.get(index).requestTime <= time) {
                if (processing == null) {
                    processing = documents.get(index);
                } else {
                    queue.add(documents.get(index));
                }
                index++;
            }

            // 프린터 처리 로직
            if (processing != null && processing.pageCount <= processingTime) {
                results.add(processing.id);
                processing = null;
                processingTime = 0;
            }

            // 프린터가 놀고 있는 경우 대기열에서 꺼내서 일을 시작한다.
            if (processing == null && !queue.isEmpty()) {
                processing = queue.poll();
            }

            if (processing != null) {
                processingTime++;
            }

            // 시간 증가
            time++;
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private class Document implements Comparable<Document> {
        private int id;
        private int requestTime;
        private int pageCount;

        public Document(int[] request) {
            this.id = request[0];
            this.requestTime = request[1];
            this.pageCount = request[2];
        }

        @Override
        public int compareTo(Document document) {
            if (pageCount < document.pageCount) {
                return -1;
            } else if (pageCount == document.pageCount){
                if (requestTime < document.requestTime) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}
