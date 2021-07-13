
package com.emu.bpm.proxy.feign;

import com.emu.bpm.proxy.client.AuthorizedFeignClient;

import com.emu.bpm.proxy.dtos.*;
import feign.Headers;

import org.emu.common.events.GenericEvent;
import org.emu.common.events.NotificationEvent;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2021-2022 By Dirac Systems.
 * <p>
 * Created by {@khalid.nouh on 24/3/2021}.
 */

@AuthorizedFeignClient(name = "camunda-server")
public interface CamundaMicroServiceProxy {
    @GetMapping("/engine-rest/process-definition")
    ProcessDto[] getProcessDefinition(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @PostMapping("/engine-rest/process-definition/key/{key}/start")
    @Headers("Content-Type: application/json")
    StartProcessResponseDto startProcessByKey(@RequestBody StartProcessRequestDto startProcessRequestDto, @PathVariable("key") String key,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @PostMapping("/engine-rest/process-definition/{id}/start")
    StartProcessResponseDto startProcessById(@RequestBody StartProcessRequestDto startProcessRequestDto, @PathVariable("id") String id,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @PostMapping("/engine-rest/process-definition/key/{key}/tenant-id/{tenant-id}/start ")
    ProcessDto startProcessByKeyAndtenant(@PathVariable("key") String key, @PathVariable("tenant-id") String tenantId,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @GetMapping("/engine-rest/task/{id}")
    TaskDto getTaskById(@PathVariable("taskId") String taskId,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @GetMapping("/engine-rest/task")
    TaskDto[] getAllTask(  @RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @GetMapping("/engine-rest/task?assignee={asignee}")
    TaskDto[] getAllTaskByAssignee(@PathVariable("asignee") String asignee,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @GetMapping("/engine-rest/task/{taskId}/variables")
    String getTaskVariablesByTaskId(@PathVariable("taskId") String taskId,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @Headers("Content-Type: application/json")
    @PostMapping("/api/task/{taskId}/{executionId}/complete")
    String CompletesATaskAndUpdatesProcessVariables(@PathVariable("taskId") String taskId, @PathVariable("executionId") String executionId, @RequestBody Map<String, Object> variables,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @PostMapping("/engine-rest/postMessage")
    MessageRequestDto postMessage(@RequestBody MessageRequestDto messageRequestDto,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @PostMapping(value = "/api/createDeployment/{deploymentName}", consumes = "multipart/form-data")
    DeploymentDto createDeployment(@PathVariable("deploymentName") String deploymentName,
                                   @RequestPart("file") MultipartFile mFile);




    @PostMapping("/api/process/startProcessByMessageEvent/{token}")
    void startProcessByMessageEvent(@RequestBody GenericEvent me, @PathVariable("token")String token);


    @PostMapping("/api/events/fireNotificationEvent")
    void fireEvent(@RequestBody NotificationEvent me);


    @DeleteMapping("/engine-rest/deployment/{id}?cascade={cascade}")
    String deleteDeployment(@PathVariable("id") String deploymentId, @PathVariable("cascade") boolean cascade,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @DeleteMapping("/engine-rest/process-definition/key/{key}/delete?cascade={cascade}")
    String deleteDefinitionsByKey(@PathVariable("key") String deploymentKey, @PathVariable("cascade") boolean cascade,@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

    @GetMapping("/api/getAllRunningProcessInstances/{processDefinitionName}")
    List<ProcessInstance>  getAllRunningProcessInstances(@PathVariable("processDefinitionName") String processDefinitionName) ;

}


