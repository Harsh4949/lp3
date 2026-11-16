import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingGreedy {

    static class Job {
        String jobId;
        int deadline;
        int profit;

        Job(String jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void schedule(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt((Job j) -> j.profit).reversed());

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        String[] slot = new String[maxDeadline + 1];
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int i = Math.min(job.deadline, maxDeadline); i > 0; i--) {
                if (slot[i] == null) {
                    slot[i] = job.jobId;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled jobs:");
        for (int i = 1; i < slot.length; i++) {
            System.out.print(slot[i] + " ");
        }
        System.out.println();
        System.out.println("Total Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job("J1", 2, 100),
            new Job("J2", 1, 19),
            new Job("J3", 2, 27),
            new Job("J4", 1, 25),
            new Job("J5", 3, 15)
        };

        schedule(jobs);
    }
}
