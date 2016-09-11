package com.common;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by 祎婷 on 2014/11/29.
 */
public class SessionContext {
    private static SessionContext instance;
    private HashMap<String,HttpSession> sessionHashMap;
    private SessionContext(){
        sessionHashMap = new HashMap<String, HttpSession>();
    }
    public static SessionContext getInstance(){
        if (instance == null){
            instance = new SessionContext();
        }
        return instance;
    }
    public synchronized void AddSession(HttpSession session){
        if (session != null){
            sessionHashMap.put(session.getId(),session);
        }
    }
    public synchronized void DelSession(HttpSession session){
        if (session != null){
            sessionHashMap.remove(session.getId());
//            if (session.getAttribute("userid") != null){
//                sessionHashMap.remove(session.getAttribute("userid").toString());
//            }

        }


    }
    public synchronized HttpSession getSession(String session_id){
        if (session_id == null){
            return null;
        }
        return sessionHashMap.get(session_id);
    }
    public HashMap getSessionMap(){
        return sessionHashMap;
    }
    public void setMymap(HashMap sessionHashMap){
        this.sessionHashMap = sessionHashMap;
    }

}
