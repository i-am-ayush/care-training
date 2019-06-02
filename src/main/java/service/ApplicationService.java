package service;

import bean.Application;
import bean.Job;
import dao.ApplicationDao;

import java.util.List;

public class ApplicationService {

    public static boolean deleteApplicationById(int appId){
        return ApplicationDao.deleteByApplicationId(appId);
    }

    public static List<Application> getAllApplicationByJobId(int jobId){
        return ApplicationDao.getAllApplicationByJobId(jobId);
    }

    public static List<Job> getNotAppliedJobs(int memberId){
        return ApplicationDao.getNotAppliedJobsList(memberId);
    }

    public static boolean apply(Application application){
        return ApplicationDao.save(application);
    }
}
