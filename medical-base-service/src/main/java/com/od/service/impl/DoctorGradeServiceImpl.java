package com.od.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.od.mapper.DoctorGradeMapper;
import com.od.entity.DoctorGrade;
import com.od.service.DoctorGradeService;

@Service
public class DoctorGradeServiceImpl extends ServiceImpl<DoctorGradeMapper, DoctorGrade> implements DoctorGradeService {

}

