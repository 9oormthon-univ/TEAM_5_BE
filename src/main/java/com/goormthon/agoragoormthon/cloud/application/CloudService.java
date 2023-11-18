package com.goormthon.agoragoormthon.cloud.application;

import com.goormthon.agoragoormthon.cloud.domain.Cloud;
import com.goormthon.agoragoormthon.cloud.dto.CloudResponseDto;
import com.goormthon.agoragoormthon.cloud.repository.CloudRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CloudService {

    private final CloudRepository cloudRepository;
    public Cloud createCloud(Long bookClubId) {
        Cloud cloud = Cloud.builder()
                .bookClubId(bookClubId)
                .style(1)
                .build();

        return cloudRepository.save(cloud);
    }

    public Cloud updateCloudStyle(Long id, int newStyle) {
        Cloud cloud = cloudRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cloud not found with id: " + id));
        cloud.setStyle(newStyle);
        return cloudRepository.save(cloud);
    }

    public List<CloudResponseDto> getCloudsByBookClubId(Long bookClubId) {
        List<Cloud> clouds = cloudRepository.findByBookClubId(bookClubId);
        return clouds.stream()
                .map(cloud -> new CloudResponseDto(cloud.getId(), cloud.getStyle()))
                .collect(Collectors.toList());
    }
}
