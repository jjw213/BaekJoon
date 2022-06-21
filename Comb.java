public class Comb {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        boolean[] visited = new boolean[4];
        combination(arr,visited,0,4,4);
    }
    /*
        1 2 3 4 중에 2개 고르기
        1. 뽑는다 -> 1개만 더 뽑으면 됨
            뽑지않는다 -> 나머지 2개 중에서 다 뽑아야함
        2. 뽑는다 -> 1을 선택하고 2도 뽑은거면 2개 다 뽑음 끝.
            뽑지 않는다 -> 1을 선택하고 2를 뽑지 않아서 1개 더 뽑아야함.

        종단점
        지금까지 내가 몇개 뽑았는지 확인 -> 2개 뽑았다 -> 2개의 수 출력
        2개 미만 -> 출력 안 함.
        3개 이상 -> 출력 안 함.

     */
    //조합을 재귀함수 이용해서 구현
    /*
        boolean[] check // visited -> i 번째를 내가 선택했는지 안 했는지 확인할 수 있도록하는 배열
        check[1] == true -> 1번 째 인덱스에 있는 원소를 선택했다.
        check[1] == false -> 1번 째 인덱스에 있는 원소를 선택 안 했다.

        int depth -> 내가 몇번째 (depth)번째 원소를 선택할지 안할지 결정할 차례
        depth를 종단 조건에 이용
        depth==1 이면 첫번째 원소를 선택할지 말지 결정할 차례
        .
        .
        depth==4 이면 네번째 원소를 선택할지 말지 결정할 차례
        4개의 원소를 각자 선택할지 말지 결정했기 때문에 지금까지 내가 골랐던 원소 출력하기
        그 중에 내가 2개를 고른게 맞다면 출력
        2개 아닌 개수만큼 골랐다면 무시
        우리가 총 몇개 중에 고를건지 (총 원소의 개수)
        우리가 고를게 몇 개 남았는지(선택할 수 있는 원소의 개수) int r
        선택할 대상이 담긴 배열 int[] arr
     */
    public static void combination(int[] arr, boolean[] visited, int depth,int n,int r){
        if(depth==n){
            //끝까지 옴
            //내가 고른게 2개, 내가 선택할 수 있는거 0개
            if(r==0){
                //지금까지 내가 골라왔던거 출력
                //반복문을 통해 visited 배열을 검사 -> true인 인덱스의 arr에서 출력
                for(int i=0;i<n;i++){
                    // 고른 원소 출력
                    if(visited[i]){
                        System.out.print(arr[i]+" ");
                    }
                }
                System.out.println();
            }
            return;
        }
        //depth번째에 있는 원소를 골랐다.
        visited[depth] =true;

        //고른 다음 원소를 선택할 지 말지 결정해야한다.
        combination(arr,visited,depth+1,n,r-1);

        //depth번째에 있는 원소를 고르지 않았다.
        visited[depth ]= false;

        combination(arr,visited,depth+1,n,r);
    }
}
