/*
3 (text) Find in deque [10 points] We discussed that using a doubly-linked list, you can search for an
element in O(!
"), the same is true for a deque.
Given an array-based Deque q and an element y, provide an algorithm that finds the position in a deque
in O(!
"). Explain your answer.
Hint: The i-th element from the right it a position i, whereas the i-th position from the left it a position
n-i
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class Question3_Find_in_Deque {
    public static void main(String[] args){
        Deque<String> d = new ArrayDeque<>();

        d.addFirst("a");//1
        d.add("b");//2
        d.add("c");//3
        d.add("d");//4
        d.add("e");//5
        d.add("f");//6
        d.add("g");//7
        d.add("h");//8
        d.add("i");//9
        d.add("j");//10
        d.add("k");//11
        d.add("l");//12
        d.add("m");//13
        d.add("n");//14
        d.add("o");//15
        d.add("p");//16
        d.add("q");//17
        d.add("r");//18
        d.add("s");//19
        d.add("t");//20
        d.add("u");//21
        d.add("v");//22
        d.add("w");//23
        d.add("x");//24
        d.add("y");//25
        d.addLast("z");//26


        System.out.println(findInd(d, "a"));//1
        System.out.println(findInd(d, "f"));//6
        System.out.println(findInd(d, "l"));//12
        System.out.println(findInd(d, "m"));//13
        System.out.println(findInd(d, "s"));//19
        System.out.println(findInd(d, "z"));//26
    }

    public static int findInd(Deque<String> d, String target){
        Deque<String> deck = new ArrayDeque<>(d);
        int aCount = 1;
        int dCount = 0;
        int dSize = deck.size();
        while(!deck.isEmpty()){
            if(deck.pollFirst().equals(target)){
                return aCount;
            }
            if(deck.isEmpty()){
                break;
            }
            if(deck.pollLast().equals(target)){
                return dSize-dCount;
            }
            aCount++;
            dCount++;
        }
        return -1;
    }
}
