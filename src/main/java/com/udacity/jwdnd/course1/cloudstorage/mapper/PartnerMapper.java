package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.model.Partner;

@Mapper
public interface PartnerMapper {

    @Select("SELECT * FROM PARTNERS")
    List<Partner> getAllPartners();

    @Select("SELECT * FROM PARTNERS WHERE partner_id = #{partnerId}")
    Partner getPartnerById(Long partnerId);

    @Insert("INSERT INTO PARTNERS (partner_name, partner_code, contact_email, status) " +
            "VALUES (#{partnerName}, #{partnerCode}, #{contactEmail}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "partnerId")
    int insert(Partner partner);
}