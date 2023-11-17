package com.goormthon.agoragoormthon.cloud.application;

import com.goormthon.agoragoormthon.cloud.domain.Cloud;
import com.goormthon.agoragoormthon.cloud.repository.CloudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CloudService {

    private final CloudRepository cloudRepository;
    public Cloud createCloud(Long bookClubId) {
        Cloud cloud = Cloud.builder()
                .bookClubId(bookClubId)
                .style("1")
                .build();

        return cloudRepository.save(cloud);
    }
}
