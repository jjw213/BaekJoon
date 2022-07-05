import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2606 {
    static ArrayList<Integer>[] arr;
    static Queue<Integer> q = new LinkedList<>();
    static int cnt = 0;
    static int worm = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        boolean[] visited = new boolean[N];

        //arr[] 초기화
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken()) - 1;
            int next = Integer.parseInt(st.nextToken()) - 1;
            arr[node].add(next);
            arr[next].add(node);
        }
        //q에 arr[0]부터 삽입
        bfs(0, visited);

        //출력
        System.out.println(worm - 1);
    }

    public static void bfs(int i, boolean[] visited) {

        if (visited[i]) //이미 방문한 노드이면 return
            return;

        worm++;

        //i 노드와 연결되어있는 노드들 get으로 꺼내서 q에 담기
        while (cnt < arr[i].size()) {
            q.add(arr[i].get(cnt));
            cnt++;
        }
        visited[i] = true; // 방문한 노드 visited 표시
        cnt = 0;
        while (!q.isEmpty()) { //q 가 텅 빌 때까지 .poll()
            int qp = q.poll();
            bfs(qp, visited);
        }
    }

}
