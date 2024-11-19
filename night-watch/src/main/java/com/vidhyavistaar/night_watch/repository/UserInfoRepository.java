package com.vidhyavistaar.night_watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vidhyavistaar.night_watch.entity.UserInfo;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
    Optional<UserInfo> findByName(String username);
}
