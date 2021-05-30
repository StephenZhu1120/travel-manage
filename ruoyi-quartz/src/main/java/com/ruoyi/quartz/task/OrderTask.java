package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.travel.domain.OrderBasic;
import com.ruoyi.travel.service.IOrderBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("orderTask")
public class OrderTask {

    @Autowired
    private IOrderBasicService orderBasicService;

    @Scheduled(cron = "0 20 13 * * ?")
    public void setOrderFinish(){
        OrderBasic orderBasic = new OrderBasic();
        orderBasic.setOrderStatus(1L);
        orderBasic.setTravelTime(DateUtils.getNowDate());
        List<OrderBasic> orderBasicList = orderBasicService.selectOrderBasicList(orderBasic);
        if(orderBasicList.size() > 0)
            for(int i=0; i<orderBasicList.size(); i++){
                orderBasicList.get(i).setOrderStatus(6L);
                orderBasicService.updateOrderBasic(orderBasicList.get(i));
            }
    }

    @Scheduled(cron = "0 20 13 * * ?")
    public void setOrderCancel(){
        OrderBasic orderBasic = new OrderBasic();
        orderBasic.setOrderStatus(0L);
        orderBasic.setTravelTime(DateUtils.getNowDate());
        List<OrderBasic> orderBasicList = orderBasicService.selectOrderBasicList(orderBasic);
        if(orderBasicList.size() > 0)
            for(int i=0; i<orderBasicList.size(); i++){
                orderBasicList.get(i).setOrderStatus(2L);
                orderBasicService.updateOrderBasic(orderBasicList.get(i));
            }
    }
}
