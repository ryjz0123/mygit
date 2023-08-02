package com.dao_.test;

import com.dao_.dao.ActorDao;
import com.dao_.domain.Actor;

import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 22:43
 * @注释
 */
public class TestDAO {
    public static void main(String[] args) {
        ActorDao actorDao = new ActorDao();
        Object o = actorDao.queryScalar("select name from actor where id=?",1);
        System.out.println(o);
        List<Actor> actors = actorDao.queryMulti("select * from actor where id > ?", Actor.class, 1);
        for (Actor actor : actors) {
            System.out.println(actor);
        }

    }
}
