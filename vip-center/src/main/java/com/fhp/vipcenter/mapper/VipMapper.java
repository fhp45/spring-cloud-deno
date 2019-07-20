package com.fhp.vipcenter.mapper;

import com.fhp.vipcenter.domain.Vip;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VipMapper {

    boolean isVip(int userId);

    Integer vipLevel(int userId);

    void register(Vip vip);

    void delete(int userId);

    void update(Vip vip);

}
