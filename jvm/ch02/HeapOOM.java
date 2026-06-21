package jvm.ch02;


import java.util.ArrayList;
import java.util.List;
// jvm option 추가: -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvm/ch02/heapoom.hprof
public class HeapOOM {
    static List<byte[]> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            list.add(new byte[1024 * 1024]); // 1MB씩 계속 저장
        }
    }
}
