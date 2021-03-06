import java.util.Stack;

public class IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA == null || popA == null){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int j = 0;

//        for (int i = 0; i < popA.length; i++) {
//
//            while (j < pushA.length){
//
//                stack.push(pushA[j]);
//
//                if (pushA[j++] == popA[i]){
//                    stack.pop();
//                    break;
//                }
//            }
//
//            // 如果此时栈已空，peek出错！
//            if (popA[i] == stack.peek()) {
//                stack.pop();
//            }
//        }
//
//        if (stack.isEmpty()){
//            return true;
//        }


        for (int i = 0; i < popA.length; i++) {
            while (stack.isEmpty() || popA[i] != stack.peek()){
                if (j == pushA.length){
                    break;
                }

                stack.push(pushA[j++]);
            }

            if (popA[i] != stack.peek()){
                break;
            }

            stack.pop();
        }

        if (stack.isEmpty()){
            return true;
        }

        return false;
    }


    // 我喜欢这种写法
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length == 0 ||
                popA.length == 0){
            return false;
        }

        Stack<Integer> s = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++){
            s.push(pushA[i]);
            while(!s.empty() && s.peek() == popA[popIndex]){
                s.pop();
                popIndex++;
            }
        }

        return s.empty();
    }
    
    public static void main(String[] args){
        IsPopOrder isPopOrder = new IsPopOrder();
        
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        int[] popB = {4, 3, 5, 1, 2};
        int[] popC = {5, 4, 3, 2, 1};

        int[] popE = {1};
        int[] pushE = {1};

        int[] popF = {5, 4};

        int[] popG = {1, 2, 3, 4, 5, 6};

//        boolean isPop = isPopOrder.IsPopOrder(pushE, popE);
        boolean isPop = isPopOrder.IsPopOrder2(pushA, popB);

        System.out.println("isPop = " + isPop);
        
    }
}

