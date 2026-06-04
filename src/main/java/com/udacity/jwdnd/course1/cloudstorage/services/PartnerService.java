package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.PartnerMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Partner;

@Service
public class PartnerService {

    private final PartnerMapper partnerMapper;

    public PartnerService(PartnerMapper partnerMapper) {
        this.partnerMapper = partnerMapper;
    }

    public List<Partner> getAllPartners() {
        return partnerMapper.getAllPartners();
    }

    public Partner getPartnerById(Long partnerId) {
        return partnerMapper.getPartnerById(partnerId);
    }

    public int createPartner(Partner partner) {
        return partnerMapper.insert(partner);
    }
}