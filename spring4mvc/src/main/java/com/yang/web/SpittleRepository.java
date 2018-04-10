package com.yang.web;

import com.yang.data.spittle;

import java.util.List;

/**
 * Created by CS on 2018/4/8.
 */
public interface SpittleRepository {
    List<spittle> findSpittles(long max,int count);
}
