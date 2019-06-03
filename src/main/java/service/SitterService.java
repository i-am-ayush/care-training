package service;

import bean.Application;
import bean.Job;
import bean.Sitter;
import dao.ApplicationDao;
import dao.JobDao;
import dao.SitterDao;
import dto.SitterProfileHome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SitterService {
    public static Sitter getSitterById(int id){
        Sitter sitter= SitterDao.getById(id);
        return sitter;
    }
    public static boolean registerSitter(Sitter sitter){
        return SitterDao.save(sitter);
    }
    public static List<SitterProfileHome> allAppliedJobBySitter(int memberId){
        List<Application> listApplication= ApplicationDao.getAllApplicationById(memberId);
        List<Job> listJob=new ArrayList<>();
        List<Map<String, Object>> listMap=new ArrayList<>();
        List<SitterProfileHome> sitterProfileHomeList=new ArrayList<>();
        for(int i=0;i<listApplication.size();i++){
            listJob.add(JobDao.getById(listApplication.get(i).getJobId()));
            Map<String,Object> tempMap=new HashMap<>();
           SitterProfileHome sitterProfileHome=new SitterProfileHome();
           sitterProfileHome.setApplicationId(listApplication.get(i).getApplicationId());
           sitterProfileHome.setExpectedPay(listApplication.get(i).getExpectedPay());
           sitterProfileHome.setPayPerHour(JobDao.getById(listApplication.get(i).getJobId()).getPayPerHour());
           sitterProfileHome.setStatus(String.valueOf(listApplication.get(i).getStatus()));
           sitterProfileHome.setTitle(JobDao.getById(listApplication.get(i).getJobId()).getTitle());
           sitterProfileHomeList.add(sitterProfileHome);
            tempMap.put("applicationId",listApplication.get(i).getApplicationId());
            tempMap.put("title",JobDao.getById(listApplication.get(i).getJobId()).getTitle() );
            tempMap.put("payPerHour",JobDao.getById(listApplication.get(i).getJobId()).getPayPerHour());
            tempMap.put("status", listApplication.get(i).getStatus());
            tempMap.put("expectedPay", listApplication.get(i).getExpectedPay());
            listMap.add(tempMap);
        }
        return sitterProfileHomeList;


    }

    public static void editProfile(Sitter sitter){
        System.out.println("Function called");
        SitterDao.update(sitter);
        System.out.println("Function executed");
    }
}