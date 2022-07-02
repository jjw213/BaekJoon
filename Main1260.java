import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1260 {
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();

    static ArrayList<Integer> print_arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        // 입력받은 N 값의 크기만큼 노드 개수 ArrayList 만들기
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            // 양방향 그래프이기 때문에
            // 3 1 입력 받았다고 가정하면
            // arr[3] 이 1과 연결 되며
            // 이 말은 arr[1] 도 3과 연결된다와 같은 뜻
            arr[num].add(next);
            arr[next].add(num);
        }
        for (int i = 0; i <= N; i++) {
            arr[i].sort(null);
        }
        boolean[] visited = new boolean[N];
        stack.add(V);
        dfs(arr, visited, V);
        for (int i = print_arr.size(); i > 0; i--) {
            System.out.print(print_arr.get(i - 1) + " ");
        }
        System.out.println();
        Arrays.fill(visited, false);
        bfs(arr, visited, V);
    }

    public static void dfs(ArrayList<Integer>[] arr, boolean[] visited, int v) {
        //arr[v]의 size 동안 get 해오는데
        //queue와 다르게 모두 stack에 push 하는게 아니라 값 하나 꺼내고 visited 검사하고
        //false 이면 stack에 담고 true이면 다음 값 꺼내고 하는 식으로
        visited[v - 1] = true; // 현재 노드 번호 v 를 방문했다고 표시
        stack.add(v);
        for (int i = 0; i < arr[v].size(); i++) {
            if (!visited[arr[v].get(i) - 1]) {
                dfs(arr, visited, arr[v].get(i));
            }
        }

//        while (!stack.isEmpty())
            print_arr.add(stack.pop());
        return;
    }

    public static void bfs(ArrayList<Integer>[] arr, boolean[] visited, int v) {

        for (int i = 0; i < arr[v].size(); i++) {
            if (!visited[arr[v].get(i) - 1]) {
                queue.add(arr[v].get(i));
                visited[arr[v].get(i) - 1] = true;
            }
        }

        visited[v - 1] = true;
        System.out.print(v);
        if (queue.isEmpty()) return;
        System.out.print(" ");
        v = queue.poll();
        bfs(arr, visited, v);
    }
}
