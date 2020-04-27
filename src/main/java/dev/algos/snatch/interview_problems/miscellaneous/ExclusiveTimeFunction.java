package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.List;
import java.util.Stack;

/**
 * On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.
 * <p>
 * We store logs in timestamp order that describe when a function is entered or exited.
 * <p>
 * Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.
 * <p>
 * A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.
 * <p>
 * The CPU is single threaded which means that only one function is being executed at a given time unit.
 * <p>
 * Return the exclusive time of each function, sorted by their function id.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input:
 * n = 2
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3, 4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
 * Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
 * Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 */
public class ExclusiveTimeFunction {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] arr = new int[n];
        int prevTime = 0;
        Stack<Function> stack = new Stack<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            boolean start = split[1].equals("start");
            if (!stack.isEmpty() && !start) {
                var function = stack.pop();
                arr[id] += time - prevTime;
                if (function.time == prevTime) {
                    arr[id]++;
                }
            } else if (!stack.isEmpty() && start) {
                arr[stack.peek().id] += time - prevTime;
                if (prevTime != stack.peek().time) {
                    arr[stack.peek().id]--;
                }
                stack.push(new Function(id, time, start));
            } else {
                stack.push(new Function(id, time, start));
            }
            prevTime = time;
        }

        return arr;
    }

    static class Function {
        boolean start;
        int id;
        int time;

        public Function(int id, int time, boolean start) {
            this.id = id;
            this.time = time;
            this.start = start;
        }
    }
}
