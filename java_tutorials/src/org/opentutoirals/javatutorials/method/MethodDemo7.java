package org.opentutoirals.javatutorials.method;

import java.io.*; // ����

public class MethodDemo7 {
    public static String numbering(int init, int limit) {
        int i = init;
        String output = "";
        while (i < limit) {
            output += i;
            i++;
        }
        return output;
    }
 
    public static void main(String[] args) {
        String result = numbering(1, 5);
        System.out.println(result);
        try { // ����
            // ���� ���� out.txt ��� ���Ͽ� numbering�̶�� �޼ҵ尡 ��ȯ�� ���� �����մϴ�.
            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
            out.write(result);
            out.close();
        } catch (IOException e) {
        } // ����
    }
}