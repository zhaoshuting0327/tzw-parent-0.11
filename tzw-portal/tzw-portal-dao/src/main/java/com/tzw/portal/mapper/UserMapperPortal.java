package com.tzw.portal.mapper;


import com.tzw.portal.pojo.Score;
import com.tzw.portal.pojo.User;

import java.math.BigInteger;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface UserMapperPortal {

   User findUserById(BigInteger tzw_user_id);

   BigInteger jianMoney(BigInteger tzw_user_id);
   BigInteger addMoney(BigInteger tzw_user_id);
   BigInteger addScore(BigInteger tzw_user_id);
   BigInteger jianScore(BigInteger tzw_user_id);

   void addQianDaoScore(Score score);

   void updateSign(User user);

}
