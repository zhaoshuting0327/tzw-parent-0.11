package com.tzw.mapper;

import com.tzw.pojo.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface ActiveMapper {


   List<Item> loadChouJiang(Map<String,Object> map);
   List<Item> loadJiFen(Map<String,Object> map);
   List<Item> loadJingPai(Map<String,Object> map);

   int chouJiangCount();
   int jiFenCount();
   int jingPaiCount();


   void deleteChouJiang(BigInteger tzw_item_id);
   void deleteJiFen(BigInteger tzw_item_id);
   void deleteJingPai(BigInteger tzw_item_id);

   void upItemChou(BigInteger tzw_item_id);
   void upItemJi(BigInteger tzw_item_id);
   void upItemJing(BigInteger tzw_item_id);

   Item findcByItemId(BigInteger tzw_item_id);
   Item findjiByItemId(BigInteger tzw_item_id);
   Item findjByItemId(BigInteger tzw_item_id);

   void  updatecByItemId(Choujiang choujiang);
   void  updatejiByItemId(JiFen jiFen);
   void  updatejByItemId(JingPai jingPai);

   void activey_add_commit(Activity activity);
   void activey_update_commit(Activity activity);

   List<Activity> loadActive(Map<String,Object> map);
   int activeCount();

   void active_update_commit(Activity activity);
   Activity findActivityById(BigInteger tzw_activity_id);
}
