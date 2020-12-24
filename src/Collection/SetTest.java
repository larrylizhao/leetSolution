package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("String100");
        set.add("String432");
        set.add("String3");
        set.add("String20");
        set.add("String5");
        System.out.println("HashSet 不保证顺序");
        set.forEach(e-> System.out.print(e+" "));
        System.out.println();
        System.out.println();


        //LinkedHashSet会保证元素的添加顺序
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("String1");
        set2.add("String5");
        set2.add("String3");
        set2.add("String4");
        set2.add("String2");
        System.out.println("LinkedHashSet 会保证元素的添加顺序");
        set2.forEach(e-> System.out.print(e+" "));
        System.out.println();
        System.out.println();


        //TreeSet保证元素自然顺序
        Set<String> set3 = new TreeSet<>();
        set3.add("String100");
        set3.add("String5");
        set3.add("String4");
        set3.add("String2");
        set3.add("String3");
        System.out.println("TreeSet 保证元素自然顺序");
        set3.forEach(e-> System.out.print(e+" "));
        System.out.println();
    }
}
