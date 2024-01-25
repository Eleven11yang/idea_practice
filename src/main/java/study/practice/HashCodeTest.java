package study.practice;

public class HashCodeTest {
    public static void main(String args[]) {
        String Str = new String("www.runoob.com");
        System.out.println("字符串的哈希码为 :" + Str.hashCode() );
        Integer num  = 15;
        int hashCode = num.hashCode();
        System.out.println("整数的哈希码为 :" + hashCode );
    }
}
