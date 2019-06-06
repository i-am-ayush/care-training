package service;

import bean.Member;
import dao.JobDao;
import dao.MemberDao;

import java.util.LinkedList;
import java.util.List;

public class MemberService {
    public static boolean authenticate(String emailId, String password) {
        Member m=MemberDao.getByEmailIdAndPassword(emailId, password);
        if(m!=null){
            return true;
        }
        else{
            return false;
        }

    }

    public static  int getMemberIdByEmail(String emailId){
        Member member=MemberDao.getByEmailId(emailId);
        return member.getId();
    }
    public static Member getMemberById(int id){
        Member member=MemberDao.getById(id);
        return member;
    }
    public static boolean deleteMemberById(int id){
       MemberDao.delete(id);
       JobService.deletebyId(id);
       return true;
    }

    public static List<Member> search(String email){
        List<Member> allResult = MemberDao.getAllEmail(email);
        List<Member> allActiveResult = new LinkedList<>();
        for(Member result : allResult){
            if(result.getStatus().equals(Member.Status.ACTIVE)){
                allActiveResult.add(result);
            }
        }
        return allActiveResult;
    }

}