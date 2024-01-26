package study.practice.hm3;

public class UnsignedInteger {
    //实现一个无符号整数类
    private long value;

    public UnsignedInteger(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("UnsignedInteger cannot be negative");
        }
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    // 实现加法操作
    public UnsignedInteger add(UnsignedInteger other) {
        return new UnsignedInteger(this.value + other.value);
    }

    // 实现减法操作
    public UnsignedInteger subtract(UnsignedInteger other) {
        if (this.value < other.value) {
            throw new IllegalArgumentException("Result of subtraction cannot be negative");
        }
        return new UnsignedInteger(this.value - other.value);
    }

    // 其他操作可以类似地实现，如乘法、除法等

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        // 创建无符号整数对象
        UnsignedInteger uint1 = new UnsignedInteger(50);
        UnsignedInteger uint2 = new UnsignedInteger(30);

        // 执行加法和减法
        UnsignedInteger sum = uint1.add(uint2);
        UnsignedInteger difference = uint1.subtract(uint2);

        // 输出结果
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }
}

