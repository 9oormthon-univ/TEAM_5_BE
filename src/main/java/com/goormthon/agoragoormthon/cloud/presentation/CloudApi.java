package com.goormthon.agoragoormthon.cloud.presentation;

import com.goormthon.agoragoormthon.cloud.application.CloudService;
import com.goormthon.agoragoormthon.cloud.domain.Cloud;
import com.goormthon.agoragoormthon.cloud.dto.CloudResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clouds")
@RequiredArgsConstructor
public class CloudApi {

    private final CloudService cloudService;
    @PostMapping("/make")
    public ResponseEntity<Cloud> createCloud(@RequestParam Long bookClubId) {
        Cloud cloud = cloudService.createCloud(bookClubId);
        return ResponseEntity.ok(cloud);
    }
    @PatchMapping("/change")
    public ResponseEntity<Cloud> updateCloudStyle(@RequestParam Long id, @RequestParam int style) {
        Cloud updatedCloud = cloudService.updateCloudStyle(id, style);
        return ResponseEntity.ok(updatedCloud);
    }

    @GetMapping
    public ResponseEntity<List<CloudResponseDto>> getCloudsByBookClubId(@RequestParam Long bookClubId) {
        List<CloudResponseDto> cloudDtos = cloudService.getCloudsByBookClubId(bookClubId);
        return ResponseEntity.ok(cloudDtos);
    }

}
