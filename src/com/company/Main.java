package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger child : nestedList) {
            q.offer(child);
        }
        int depth = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int s = 0; s < size; s++) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) {
                    res += curr.getInteger() * depth;
                    continue;
                }
                for (NestedInteger child : curr.getList()) {
                    q.offer(child);
                }
            }
            depth++;
        }
        return res;
    }
}