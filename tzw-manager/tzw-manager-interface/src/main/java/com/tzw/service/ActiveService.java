package com.tzw.service;

import com.tzw.pojo.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/9.
 */
public interface ActiveService {


    List<Item>loadChouJiang(Integer cpage, Integer size);
    List<Item> loadJiFen(Integer cpage, Integer size);
    List<Item> loadJingPai(Integer cpage, Integer size);
    List<Activity> loadActive(Integer cpage, Integer size);

    int chouJiangCount();
    int jiFenCount();
    int jingPaiCount();
    int activeCount();

    void deleteChouJiang(BigInteger tzw_item_id);
    void deleteJiFen(BigInteger tzw_item_id);
    void deleteJingPai(BigInteger tzw_item_id);

    Item findcByItemId(BigInteger tzw_item_id);
    Item findjiByItemId(BigInteger tzw_item_id);
    Item findjByItemId(BigInteger tzw_item_id);

    void  updatecByItemId(Choujiang choujiang);
    void  updatejiByItemId(JiFen jiFen);
    void  updatejByItemId(JingPai jingPai);

    void active_add_commit(Activity activity);
    void active_update_commit(Activity activity);

   Activity  findActivityById(BigInteger tzw_activity_id);

}
