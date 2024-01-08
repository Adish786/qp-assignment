package com.notification.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.notification.entity.EmailHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailHistoryRepository extends PagingAndSortingRepository<EmailHistory, UUID> {

  List<EmailHistory> findAll();

  Optional<EmailHistory> findByMessageId(String messageId);

}