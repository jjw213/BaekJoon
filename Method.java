public class Method {

    public static void main(String[] args) {
        /*
         * 메소드
         * 접근제한자 (static) 타입 메소드이름 (파라미터(인수)1, 파라미터(인수)2...){
         *    <명령문 모음>
         *
         *    return..
         *
         * }
         * 만약 메소드의 타입이 void인 경우에는 return문 생략가능
         * 타입을 가지면 return 꼭 존재
         * 메소드는 단 하나의 값만 리턴 (리턴문은 여러개가 될수도 잇다.)
         * 메소드는 동시에 여러값을 리턴할수없음
         * ex) int형 메소드는 4라는 정수와 6이라는 정수를 한꺼번에 리턴할수 없다.
         * 파라미터는 지역변수처럼 사용 (메소드 범위를 벗어나면 파라미터의 이름으로 호출 x)
         *
         * return 을 만나면 메소드가 종료되고, 메소드를 호출한 부분으로 돌아간다.
         *
         */
        System.out.println("호출전");
        callMe(5);
        System.out.println("호출후");

        /*
         * 재귀 메소드 (재귀 함수)
         * 자기 자신을 호출하는 메소드 ==> 반복문
         * 재귀를 사용할 때는 종단 케이스 (언제 끝낼지)
         * 조건을 명확이 해줘야함
         * 메소드의 윗부분에 조건에 따른 리턴문 포함
         * 피보나치 함수
         * 99라는 큰 피보나치 구하기 위해
         * 99보다 작은 98 97,....
         *
         *
         */


    }

    public static void callMe(int n) {
        System.out.println("CallMe");
        if(n==0){
            return;
        }
        callMe(n-1);
        return;
    }
}