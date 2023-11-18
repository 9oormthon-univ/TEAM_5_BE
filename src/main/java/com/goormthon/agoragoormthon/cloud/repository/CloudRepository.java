package com.goormthon.agoragoormthon.cloud.repository;

import com.goormthon.agoragoormthon.cloud.domain.Cloud;

import com.goormthon.agoragoormthon.cloud.dto.CloudResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloudRepository extends JpaRepository<Cloud,Long> {

    List<Cloud> findByBookClubId(Long bookClubId);

}
