import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1931 {
    static int[] cnt;
    static int best=0;
    public static void main(String[] args) throws IOException {
        //각 노드의 끝 시간보다 큰 노드의 시작 시간을 스택에 담는다.
        //담을 때마다 cnt +1 해주고 끝 시간보다 큰 시작시간이 존재하지 않으면
        //다른 노드의 시작 시간으로도 갈 수 있으면 또 cnt 값을 0부터 +1 하는 식으로 해서
        //가장 큰 cnt 값을 그 노드의 cnt 값으로 정한다.
        //모든 노드의 cnt 값을 구한 뒤 가장 큰 cnt 값을 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] room = new ArrayList[N];
        cnt=new int[N];
        //N의 크기만큼 room 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            room[i] = new ArrayList<Integer>();
            room[i].add(start);
            room[i].add(end);
        }

        //다 채웠으니 1번 째 노드부터 cnt 개수 구하기 시작
        for (int j = 0; j < N; j++) {
            int start = room[j].get(0);
            int end = room[j].get(1);
            dfs(start, end, room, N,j);
            cnt[j]=best;
            best=0;
            System.out.println("******************************");
        }
        Arrays.sort(cnt);
        System.out.println(cnt[N-1]);
    }

    public static void dfs(int start, int end, ArrayList<Integer>[] room, int N,int j) {
        cnt[j]++;

        for (int i = 0; i < N; i++) {
            int newStart = room[i].get(0);
            int newEnd = room[i].get(1);
            //이 회의의 종료 시간보다 나중에 시작하는 회의가 있으면
            if (newStart >= end) {
                System.out.println("start : "+start+", end : "+end);
                System.out.println("newStart : "+newStart+", newEnd : "+newEnd);
                System.out.println(cnt[j]+", best = "+best);
                System.out.println("=====================");
                dfs(newStart,newEnd,room,N,j);

            }

            //이 회의가 마지막 회의라면
            if (i == N - 1) {
                if(best<cnt[j])
                    best=cnt[j];
                cnt[j]=0;
                return;
            }
        }
    }
}
