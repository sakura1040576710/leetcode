package LinkedList;

import java.io.*;

/**
 * LinkedList 输入输出
 */
public class LinkedListIO {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static ListNode input() throws IOException {
        String str = br.readLine();
        String[] values = str.substring(1, str.length() - 1).split(",");
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (String value : values) {
            p.next = new ListNode(Integer.parseInt(value));
            p = p.next;
        }
        return dummy.next;
    }

    public static ListNode[] inputMulti() throws IOException {
        String str = br.readLine();
        String[] values = str.substring(2,str.length()-2).split("],\\[");
        ListNode[] res = new ListNode[values.length];
        int index = 0;
        for (String value : values) {
            String[] v = value.split(",");
            ListNode ans = new ListNode(-1);
            ListNode p = ans;
            for (String val : v) {
                p.next = new ListNode(Integer.parseInt(val));
                p = p.next;
            }
            res[index++] = ans.next;
        }
        return res;
    }

    public static void output(ListNode dummy) throws IOException {
        ListNode p = dummy;
        while (p != null) {
            bw.write(p.val + " ");
            p = p.next;
        }
        bw.write("\n");
    }

    public static void destroy() throws IOException {
        bw.flush();
        br.close();
        bw.close();
    }
}
