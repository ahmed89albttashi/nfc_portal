package com.nfc.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.A1Attachment;


@Repository
public interface AttachmentRepository extends CrudRepository<A1Attachment, Long>{

}
