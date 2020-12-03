package com.od.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.od.entity.OrderAppointment;
import com.od.mapper.OrderAppointmentMapper;
import com.od.service.OrderAppointmentService;

@Service
public class OrderAppointmentServiceImpl extends ServiceImpl<OrderAppointmentMapper, OrderAppointment> implements OrderAppointmentService {

}

