package com.nfc.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.Attachment;


@Repository
public interface AttachmentRepository extends CrudRepository<Attachment, Long>{

}
