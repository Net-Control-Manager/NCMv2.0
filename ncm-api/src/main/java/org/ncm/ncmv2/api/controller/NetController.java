package org.ncm.ncmv2.api.controller;

import org.ncm.ncmv2.api.dto.CreateNetRequest;
//import org.ncm.ncmv2.domain.model.dao.NetDao;
//import org.ncm.ncmv2.app.service.NetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NetController {
//    private final NetService netService;
//
//    @PostMapping("/groups/{groupId}/nets")
//    @ResponseStatus(HttpStatus.CREATED)
//    public NetDto create(@PathVariable UUID groupId, @Valid @RequestBody CreateNetRequest req) {
//        return netService.create(groupId, req);
//    }
//
//    @GetMapping("/groups/{groupId}/nets")
//    public Page<NetDto> listByGroup(@PathVariable UUID groupId, @PageableDefault(size = 20, sort = "startTime", direction = Sort.Direction.DESC) Pageable pageable) {
//        return netService.listByGroup(groupId, pageable);
//    }
//
//    @PostMapping("/nets/{netId}:close")
//    public NetDto close(@PathVariable UUID netId) {
//        return netService.close(netId);
//    }
}
