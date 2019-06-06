package service;

import bean.Job;
import dao.ApplicationDao;
import dao.JobDao;

import java.util.List;

public class JobService {

    public static boolean deleteJobById(int jobId) {
        JobDao.delete(jobId);
        return ApplicationDao.deleteByJobId(jobId);
    }
    public static boolean deletebyId(int memberId) {
        JobDao.deleteById(memberId);
        List<Job> list = JobDao.getJobsPostedBy(memberId);
        for (int i = 0; i < list.size(); i++) {
            ApplicationDao.deleteByJobId(list.get(i).getId());
        }
        return true;
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
