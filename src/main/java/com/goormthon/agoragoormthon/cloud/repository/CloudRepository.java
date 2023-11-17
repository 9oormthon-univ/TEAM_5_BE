package com.goormthon.agoragoormthon.cloud.repository;

import com.goormthon.agoragoormthon.cloud.domain.Cloud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudRepository extends JpaRepository<Cloud,Long> {

}
