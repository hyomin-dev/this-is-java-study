package ch06.problems.problem18;

public class ShopService_2 {

    private static ShopService_2 shopService = new ShopService_2();

    private ShopService_2(){

    }

    public static ShopService_2 getInstance(){
        return shopService;
    }


    public static void main(String[] args) {
        ShopService_2 obj1 = ShopService_2.getInstance();
        ShopService_2 obj2 = ShopService_2.getInstance();

        if(obj1 == obj2){
            System.out.println("같은 ShopService_2 객체입니다.");
        }
        else{
            System.out.println("다른 ShopService_2 객체입니다.");
        }
    }
}
