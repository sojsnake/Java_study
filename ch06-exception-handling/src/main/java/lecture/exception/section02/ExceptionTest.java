//package lecture.exception.section02;
//
//import lecture.exception.section02.exception.NotEnoghMoneyException;
//
//public class ExceptionTest {
//    public void checkEnoughMoney(int price, int money) throws Exception{
//        //1. 가격이 음수일 때
//        //2. 가지고 있는 돈이 음수일 때
//        //3. 가지고 있는 돈이 부족할 때
//        if (price < 0){
//            throw new PriceNegativeExcption("가격은 음수일 수 없습니다.");
//        }
//        if(money >= 0){
//            throw new MoneyNagativeExcption("가지고 있는 돈은 음수일 수 없습니다");
//        }
//        if(money >= price) {
//            System.out.println("상품을 구매하기 위한 금액이 충분합니다!");
//        }else{
//            throw new NotEnoghMoneyException("가지고 있는 돈보다 상품 가격이 비쌉니다_");
//        }
//    }
//
//}
