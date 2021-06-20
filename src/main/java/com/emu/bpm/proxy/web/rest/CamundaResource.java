package com.emu.bpm.proxy.web.rest;


import com.emu.bpm.proxy.domain.Notification;
import com.emu.bpm.proxy.dtos.*;
import com.emu.bpm.proxy.feign.CamundaMicroServiceProxy;
import com.emu.bpm.proxy.integration.events.publishers.MemberStatusPublisher;
import com.emu.bpm.proxy.integration.events.publishers.NotificationStatusPublisher;
import com.emu.bpm.proxy.utilities.ProxyUtilities;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.emu.common.dto.MemberDto;

import org.emu.common.dto.MemberStatus;
import org.emu.common.dto.bpm.EVENTSTYPES;
import org.emu.common.events.GenericEvent;
import org.emu.common.events.NotificationEvent;

import org.emu.common.status.MemberApprovalStatus;

import org.emu.common.status.NotificationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2021-2022 By Dirac Systems.
 * <p>
 * Created by {@khalid.nouh on 18/3/2021}.
 */

@RestController
@RequestMapping("/api")
@Log4j2
public class CamundaResource {
//    @Value("${basic.camunda.url}")
//    private String basicUrl;
    private final Logger log = LoggerFactory.getLogger(CamundaResource.class);
    @Autowired
    CamundaMicroServiceProxy camundaMicroServiceProxy;
    @Autowired
    MemberStatusPublisher memberStatusPublisher;
    @Autowired
    NotificationStatusPublisher notificationStatusPublisher;
    @Value("${bpm.user}")
    private String bpmUser;
    @Value("${bpm.password}")
    private String bpmPassword;
    @Value("${bpm.token}")
    private String bpmToken;
   // @Autowired
//    BpmnFilesService bpmnFilesService;
//    @Autowired
//    OperationsLogsService operationsLogsService;

    public CamundaResource() {
    }

    @GetMapping("/exception")
    public String getException() {
        return 5 / 0 + "";
    }

    /**
     * Queries for process definitions that fulfill given parameters.
     * Parameters may be the properties of process definitions, such as the name, key or version
     */
    @ApiOperation(value = "Get All Process Definition in the Camunda server")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful."),
        @ApiResponse(code = 400, message = "Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy. See the Introduction for the error response format.")}
    )
    @GetMapping("/process-definition")
    ProcessDto[] getProcessDefinition() {
        log.info(String.format("Starting to Get All Process Definition in the Camunda server"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);

//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@GetMapping(process-definition/)", "Starting to Get All Process Definition in the Camunda server"));
        ProcessDto[] processDtos = camundaMicroServiceProxy.getProcessDefinition("Basic "+encoding);
        log.info(String.format("Getting All Process Definition in the Camunda server Successfully"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@GetMapping(process-definition/)", "Getting All Process Definition in the Camunda server Successfully"));
        return processDtos;
    }
    /**
     * Starting a process instance at its default initial activity:
     * * start Process By Process Definition key
     */
    @ApiOperation(value = "Start Process By Process Definition key")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful."),
        @ApiResponse(code = 400, message = "The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the Introduction for the error response format"),
        @ApiResponse(code = 404, message = "The instance could not be created due to a non existing process definition key. See the Introduction for the error response format"),
        @ApiResponse(code = 500, message = "The instance could not be created successfully. See the Introduction for the error response format.")
    }
    )
    @PostMapping("/startProcessByKey/{key}")
    StartProcessResponseDto startProcessByKey(@RequestBody StartProcessRequestDto startProcessRequestDto, @PathVariable("key") String key) {
        log.info(String.format("Starting Process By Key in the Camunda server"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);

//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@PostMapping(/startProcessByKey/{key})", "Starting Process By Key in the Camunda server"));
        return camundaMicroServiceProxy.startProcessByKey(startProcessRequestDto, key,"Basic "+encoding);
    }
    /**
     * Starting a process instance at its default initial activity:
     * * start Process By Process Definition Id
     */
    @ApiOperation(value = "Start Process By Process Definition Id")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful."),
        @ApiResponse(code = 400, message = "The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the Introduction for the error response format"),
        @ApiResponse(code = 404, message = "The instance could not be created due to a non existing process definition key. See the Introduction for the error response format"),
        @ApiResponse(code = 500, message = "The instance could not be created successfully. See the Introduction for the error response format.")
    }
    )
    @PostMapping("/startProcessById/{id}")
    StartProcessResponseDto startProcessById(@RequestBody StartProcessRequestDto startProcessRequestDto, @PathVariable("id") String id) {
        log.info(String.format("Starting Process By Key in the Camunda server"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@PostMapping(/startProcessById/{id})", "Starting Process By Id in the Camunda server"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);

        return camundaMicroServiceProxy.startProcessById(startProcessRequestDto, id,"Basic "+encoding);
    }

    /*
    POST /process-definition/key/{key}/tenant-id/{tenant-id}/start (starts the latest version of the process definition for tenant)
    * */
    @PostMapping("/startProcessByKeyAndtenantId/{key}/{tenant-id}")
    ProcessDto startProcessByKeyAndtenant(@PathVariable("key") String key, @PathVariable("tenant-id") String tenantId) {
        log.info(String.format("Starting Process By Key And tenantId in the Camunda server"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@PostMapping(/startProcessByKeyAndtenantId/{key}/{tenant-id})", "Starting Process By Key And tenantId in  the Camunda server"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.startProcessByKeyAndtenant(key, tenantId,"Basic "+encoding);
    }

    /**
     * {@code GET  /taskById/{taskId}} : get taskById.
     *
     * @return
     */
    @ApiOperation(value = "Get All tasks ")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/alltasks")
    TaskDto[] getAllTask() {
        log.info(String.format("Getting All Tasks in the Camunda server"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@GetMapping(/engine-rest/task)", "Getting All Tasks in the Camunda server"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.getAllTask("Basic " + encoding);
    }

    /**
     * {@code GET  /task?assignee={asignee}} :  get All Task By Assignee.
     *
     * @return
     */
    @ApiOperation(value = "Get All Tasks  By Assignee  ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/tasks?assignee={asignee}")
    TaskDto[] getAllTaskByAssignee(@PathVariable("asignee") String asignee){
        log.info(String.format("Getting All Tasks By Assignee in the Camunda server"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@GetMapping(/engine-rest/task)", "Getting All Tasks in the Camunda server"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.getAllTaskByAssignee(asignee,"Basic "+encoding);
    }


    /**
     * {@code POST  /task/{taskId}/complete : CompletesATaskAndUpdatesProcessVariables.
     *
     * @return
     */
    @ApiOperation(value = "Completes A Task And Updates Process Variables  ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully Complete the task"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping(value = "/task/{taskId}/{executionId}/complete",consumes = "application/json")
    String CompletesATaskAndUpdatesProcessVariables(@PathVariable("taskId") String taskId, @PathVariable("executionId") String executionId, @RequestBody Map<String, Object> variables){
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.CompletesATaskAndUpdatesProcessVariables(taskId,executionId,variables,"Basic "+encoding);
    }



    /**
     * {@code GET  /task/{taskId}/variables :  get Task Variables By TaskId.
     *
     * @return
     */
    @ApiOperation(value = "Get All variables  By taskId  ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/task/{taskId}/variables")
    String getTaskVariablesByTaskId (@PathVariable("taskId") String taskId){
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.getTaskVariablesByTaskId(taskId,"Basic "+encoding);
    }


    /**
     * {@code GET  /taskById/{taskId}} : get taskById.
     *
     * @return
     */
    @ApiOperation(value = "Get task by id")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/task/{taskId}")
    public TaskDto getTaskById(@PathVariable("taskId") String taskId) {
        log.info(String.format("Getting A Task By Id in the Camunda server"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@GetMapping(/task/{taskId})", "Getting A Task By Id in the Camunda server"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.getTaskById(taskId,"Basic "+encoding);
    }

    /*
    Correlates a message to the process engine to either trigger a message start event or an intermediate message catching event
    * */
    /**
     * {@code Post  / Correlates a message to the process engine to either trigger a message start event or an intermediate message catching event
     *
     * @return
     */
    @ApiOperation(value = "Correlates a message")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful. The property resultEnabled in the request body was true."),
        @ApiResponse(code = 2014, message = "Request successful. The property resultEnabled in the request body was false (Default)."),
        @ApiResponse(code = 400, message = "If no messageName was supplied. If both tenantId and withoutTenantId are supplied.")}
    )
    @PostMapping("/postMessage")
    MessageRequestDto postMessage(@RequestBody MessageRequestDto messageRequestDto) {
        log.info(String.format("Correlates a message to the process engine"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@PostMapping(/postMessage)", "Correlates a message to the process engine"));
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.postMessage(messageRequestDto,"Basic "+encoding);
    }

    @PostMapping("/startProcessByMessageEvent")
    void fireEvent(@RequestBody GenericEvent genericEvent){

        camundaMicroServiceProxy.startProcessByMessageEvent(genericEvent,bpmToken);
    }

    /**
     * Post Deployment,Create a deployment.
     * POST /deployment/create
     */
    @ApiOperation(value = "Create a deployment in Camunda server")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful.")}
    )
    @PostMapping(path = "/createDeployment/{deploymentName}", consumes = "multipart/form-data")
    public DeploymentDto createDeployment(@PathVariable("deploymentName") String deploymentName, @RequestPart("file") MultipartFile mFile) throws IOException {
        log.info(String.format("Create a deployment in Camunda server"));
//        operationsLogsService.save(LoggingUtilities.createOperationsLogsDTO("@PostMapping(path = /createDeployment/{deploymentName},consumes = multipart/form-data)", "Create a deployment in Camunda server"));
        DeploymentDto deploymentDto = camundaMicroServiceProxy.createDeployment(deploymentName, mFile);


            return deploymentDto;
    }
    /**
     * Delete Definitions By Key
     */
    @ApiOperation(value = "Delete Definitions By Key")
    /*Optional below comments*/
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful.")}
    )
    @DeleteMapping("/process-definition/key/{key}/delete/cascade={cascade}")
    String deleteDefinitionsByKey(@PathVariable("key") String deploymentKey,@PathVariable("cascade") boolean cascade){
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.deleteDefinitionsByKey(deploymentKey,cascade,"Basic "+encoding);
    }

    /**
     * Delete Deployment By Id
     */
    @ApiOperation(value = "Delete Definitions By Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Request successful.")}
    )
    @DeleteMapping("/deleteDeployment/{id}/cascade={cascade}")
    String deleteDeployment(@PathVariable("id") String deploymentId,@PathVariable("cascade") boolean cascade ){
        String encoding = ProxyUtilities.getE(bpmUser,bpmPassword);
        return camundaMicroServiceProxy.deleteDeployment(deploymentId,cascade,"Basic "+encoding);
    }


     @PostMapping("/raiseMemberApprovalEvent/{status}")
    void raiseMemberApprovalEvent(@RequestBody  MemberDto member,@PathVariable("status") MemberApprovalStatus status )
    {
    System.out.println("Member "+member.getFirstName() +"is "+status);

    }


    @PostMapping("/raiseMemberEvent/{status}")
    void raiseMemberEvent(@RequestBody MemberDto member, @PathVariable("status") MemberStatus status )
    {
       memberStatusPublisher.raiseMemberEvent(member,status);
    }

    @PostMapping("/raiseNotificationEvent/{processInstanceId}")
    void raiseNotificationEvent( @RequestBody MemberDto member , @PathVariable("processInstanceId") String processInstanceId )
    {
        Notification notification=new Notification();
        notification.setId(1L);
        notification.setMemberId(member.getId());


        notificationStatusPublisher.raiseNotificationEvent(notification, NotificationStatus.NEW,processInstanceId);
        NotificationEvent notificationEvent=new NotificationEvent();
        notificationEvent.setType("NotificationEvent");
        notificationEvent.setMessageName("NotificationSentEvent");
        notificationEvent.setTraceid(processInstanceId);
        notificationEvent.setEventType(EVENTSTYPES.NOTIFICATION_EVENT);
//        camundaMicroServiceProxy.startProcessByMessageEvent(notificationEvent,bpmToken);

        System.out.println("Member "+member.getFirstName() );
    }

    @GetMapping("/getAllRunningProcessInstances/{processDefinitionName}")
    public List<ProcessInstance>  getAllRunningProcessInstances(String processDefinitionName) {
        return camundaMicroServiceProxy.getAllRunningProcessInstances(processDefinitionName);
    }



}


