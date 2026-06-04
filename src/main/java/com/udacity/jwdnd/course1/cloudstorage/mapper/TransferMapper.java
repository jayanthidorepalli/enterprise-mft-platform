package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.model.Transfer;

@Mapper
public interface TransferMapper {

    @Select("SELECT * FROM TRANSFERS")
    List<Transfer> getAllTransfers();

    @Select("SELECT * FROM TRANSFERS WHERE transfer_id = #{transferId}")
    Transfer getTransferById(Long transferId);

    @Insert("INSERT INTO TRANSFERS (partner_id, uploaded_by, file_name, file_type, file_size, status, s3_key, validation_message) "
            + "VALUES (#{partnerId}, #{uploadedBy}, #{fileName}, #{fileType}, #{fileSize}, #{status}, #{s3Key}, #{validationMessage})")
    @Options(useGeneratedKeys = true, keyProperty = "transferId")
    int insert(Transfer transfer);
}