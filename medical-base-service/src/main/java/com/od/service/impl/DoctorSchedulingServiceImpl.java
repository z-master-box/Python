package com.od.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.od.entity.DoctorScheduling;
import com.od.mapper.DoctorSchedulingMapper;
import com.od.service.DoctorSchedulingService;

@Service
public class DoctorSchedulingServiceImpl extends ServiceImpl<DoctorSchedulingMapper, DoctorScheduling> implements DoctorSchedulingService {

}

