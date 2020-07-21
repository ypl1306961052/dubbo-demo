package com.ypl.test.mysql;
/*
作者：yangp
创建时间：2020/7/21-13:51-2020
*/


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ParamHandler
 * @Package com.ypl.test.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 13:51
 */


public interface  SqlConvert {

    SqlConvertResult convertSql(String sql,Object params);
}
