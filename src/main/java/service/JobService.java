package service;

import bean.Job;
import dao.JobDao;

import java.util.List;

public class JobService {

    public static boolean deleteJobById(int jobId) {
        return JobDao.delete(jobId);
    }

    public static Job getJobById(int jobId) {
        return JobDao.getById(jobId);
    }

    public static boolean save(Job job) {
        return JobDao.save(job);
    }

    public static boolean editJobPost(Job job) {
        return JobDao.update(job);
    }

    public static List<Job> getAllJobs() {
        return JobDao.getAllJobs();
    }

}
