package org.example.smart_schedulerbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.smart_schedulerbackend.model.entity.Remark;

import java.util.List;

@Mapper
public interface RemarkMapper {
    int insertRemark(Remark remark);
    List<Remark> getRemark(Remark remark);
}
