package com.od.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.od.entity.DoctorScheduling;
import com.od.entity.OrderAppointment;
import com.od.result.Result;
import com.od.result.ResultFactory;
import com.od.service.DoctorSchedulingService;
import com.od.service.OrderAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Don.Zhang
 * @since 2020/12/3
 */
@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorSchedulingService doctorSchedulingService;
    @Autowired
    private OrderAppointmentService orderAppointmentService;

    @RequestMapping("page")
    public Result doctorsPage(Integer currPage, Integer pageSize) {
        return ResultFactory.buildSuccessResult(doctorSchedulingService.page(new Page<>(currPage, pageSize)));
    }

    @RequestMapping("getDoctor")
    public Result getDoctor(@RequestParam Integer id) {
        return ResultFactory.buildSuccessResult(doctorSchedulingService.getById(id));
    }

    @RequestMapping("add")
    public Result addOrder(@RequestBody OrderAppointment orderAppointment) {
        orderAppointment.setAppointmentDate(new Date());
        orderAppointment.setCreateDatetime(new Date());
        DoctorScheduling scheduling = doctorSchedulingService.getById(orderAppointment.getDoctorSchedulingId());
        if (scheduling.getNum() <= 0) {
            return ResultFactory.buildFailResult("排号已满");
        }
        DoctorScheduling build = DoctorScheduling.builder().id(scheduling.getId()).num(scheduling.getNum() - 1).total(scheduling.getTotal() + 1).build();
        doctorSchedulingService.updateById(build);
        orderAppointmentService.save(orderAppointment);
        return ResultFactory.buildSuccessResult("预约成功");
    }

    @RequestMapping("order")
    public Result orderList(Integer currPage, Integer pageSize) {
        return ResultFactory.buildSuccessResult(orderAppointmentService.page(new Page<>(currPage, pageSize)));
    }
}
