public class Perm {
    public static void main(String[] args) {
        /*
            순열은 순서를 신경쓴다. 중복 허용하지 않는다.
            1,2 != 2,1
            1, 2, 3 != 3, 2, 1

         */
        int[] arr={1,2,3,4};
        int[] output=new int[4];
        boolean[] visited = new boolean[4];
        permutation(arr,output,visited,0,4,4);
    }
    /*
        내가 몇개를 골랐는지 기억해놓은 변수 depth
        n개 중에 r개를 뽑아서 줄을 세우겠다 int n, int r
        boolean[] visited => 이미 내가 줄을 세운 원소인가
        visited[i] = true 이미 선택
        visited[i] = false 선택한 적 없음
        int[] output -> 지금까지 내가 선택한 원소를 줄로 세워놓은 배열
        depth =0 이면 output[] ={ , , }
        depth =1 이면 output[] ={1, , } or {2, , } or {3, , }
        depth =2 이면 output[] ={1,2, } or {1,3, } or {2,1, } or {2,3, } or {3,1, } or {3,2, }
        depth =3 이면 output[] ={1,2,3} or {1,3,2} or {2,1,3} or {2,3,1} or {3,1,2} or {3,2,1}

     */
    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth,int n, int r){
        //종단조건
        //depth -> 내가 현재 고른 개수 (output의 인덱스)
        //r-> 내가 맨 처음에 고르기로 한 개수
        if(depth==r){
            for (int i=0;i<n;i++){
                System.out.print("순열 : "+output[i]+ " ");
            }
            System.out.println();
            return;
        }


        //재귀함수 실행될 때마다 다시 0부터 시작해서 고를 수 있는지 없는지 확인한후에 줄세우기
        //visited[i]!=true이면 이 원소를 사용한적이 없다.
        for(int i=0;i<n;i++){
            if(!visited[i]){
                //i번째 원소를 줄을 세운 적이 없으니 줄 세워봄
                visited[i]=true;
                output[depth]=arr[i];
                //다음으로 가서 줄을 세울지 말지 결정하도록 재귀함수 호출
                permutation(arr,output,visited,depth+1,n,r);

                // i번 째 원소 줄에 세워놓고 경우의 수를 세었다.
                // i번째 원소를 사용 안 한 것으로 되돌려 놓고 다른 재귀함수 permutation에서 사용할 수 있도록 false로 바꿔줌
                visited[i]= false;
            }
        }
    }
}
