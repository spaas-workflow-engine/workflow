DROP TABLE IF EXISTS wf_resource_deployment;
create table wf_resource_deployment (
    id bigint(20) not null auto_increment comment 'id',
    name varchar(255) comment '部署名称',
    category varchar(255) comment '部署类别',
    code varchar(255) comment 'key' ,
    tenant_id varchar(255) default '' comment '租户id',
    deploy_time datetime comment '部署时间',
    derived_from varchar(64) comment 'derived_from',
    derived_from_root varchar(64) comment 'derived_from_root',
    parent_deployment_id varchar(255) comment '父部署ID',
    engine_version varchar(255) comment '版本',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='部署的流程定义';
DROP TABLE IF EXISTS wf_resource_model;
create table wf_resource_model (
    id bigint(20) not null auto_increment comment 'id',
    rev int comment '乐观锁',
    name varchar(255) comment '名称',
    code varchar(255) comment 'key',
    category varchar(255) comment '类型',
    create_time datetime comment '创建时间',
    last_update_time datetime comment '最后更新时间',
    version int comment '版本',
    meta_info varchar(4000) comment '以 json 格式保存流程定义的信息',
    deployment_id varchar(64) comment '部署 id',
    editor_source_value_id varchar(64) comment '乐观锁',
    editor_source_extra_value_id varchar(64) comment '乐观锁',
    tenant_id varchar(255) default '' comment '租户id',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='模型信息';
DROP TABLE IF EXISTS wf_runtime_execution;
create table wf_runtime_execution (
   id bigint(20) not null auto_increment comment 'id',
    rev int comment '乐观锁',
    proc_inst_id bigint(20) comment '流程实例 id',
    business_key varchar(255) comment '业务主键id',
    parent_id bigint(20) comment '父节点实例 id',
    proc_def_id varchar(64) comment '流程定义id',
    super_exec varchar(64) comment 'super_exec',
    root_proc_inst_id varchar(64) comment '节点实例 id',
    wf_id varchar(255) comment 'wf_id',
    is_wfive tinyint comment '是否存活 ',
    is_concurrent tinyint comment '是否并行 ',
    is_scope tinyint comment 'is_scope',
    is_event_scope tinyint comment 'is_event_scope',
    is_mi_root tinyint comment 'is_mi_root',
    suspension_state tinyint comment '是否挂起 ',
    cached_ent_state int comment '缓存状态',
    tenant_id varchar(255) default '' comment '租户id',
    name varchar(255) comment '流程实例的名称',
    start_wf_id varchar(255) comment 'id',
    start_time datetime comment '开始时间',
    start_user_id varchar(255) comment '启动用户ID',
    lock_time datetime comment '加锁时间',
    is_count_enabled tinyint comment 'is_count_enabled',
    evt_subscr_count int comment 'evt_subscr_count',
    task_count int comment '节点数量',
    job_count int comment '任务数量',
    timer_job_count int comment 'timer_job_count',
    susp_job_count int comment 'susp_job_count',
    deadletter_job_count int comment 'deadletter_job_count',
    var_count int comment 'var_count',
    id_link_count int comment 'id_link_count_',
    callback_id varchar(255) comment 'callback_id',
    callback_type varchar(255) comment 'callback_type',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏时流程执⾏实例表 ';
DROP TABLE IF EXISTS wf_resource_procdef;
create table wf_resource_procdef (
   id bigint(20) not null auto_increment comment 'id',
    rev int comment '乐观锁',
    category varchar(255) comment '类型',
    name varchar(255) comment '乐观锁',
    code varchar(255) not null comment '乐观锁',
    version int not null comment '乐观锁',
    deployment_id varchar(64) comment '乐观锁',
    resource_name varchar(4000) comment 'bpmn 文件名称 ',
    dgrm_resource_name varchar(4000) comment 'png 图片名称  ',
    description varchar(4000) comment '描述',
    has_start_form_key tinyint comment 'start 节点是否存在 formkey',
    has_graphical_notation tinyint comment '描述',
    suspension_state tinyint comment '是否挂起 1 激活 2 挂起',
    tenant_id varchar(255) default '' comment '租户id',
    derived_from varchar(64) comment '租户id',
    derived_from_root varchar(64) comment '租户id',
    derived_version int not null default 0 comment '租户id',
    engine_version varchar(255) comment '引擎版本',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='流程定义数据';
DROP TABLE IF EXISTS wf_evt_log;
create table wf_evt_log (
    id bigint(20) not null auto_increment comment 'id',
    type bigint(20) comment '类型',
    proc_def_id bigint(20) comment '流程定义id',
    proc_inst_id bigint(20) comment '流程实例ID',
    execution_id bigint(20) comment '执行实例ID',
    task_id bigint(20) comment '节点ID',
    time_stamp datetime not null comment '时间',
    user_id varchar(255) comment '用户ID',
    data datetime comment '时间',
    lock_owner varchar(255) comment '加锁人',
    lock_time datetime null comment '加锁时间',
    is_processed tinyint default 0 comment 'is_processed',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='流程时间日志';
DROP TABLE IF EXISTS wf_procdef_info;
create table wf_procdef_info (
	id bigint(20) not null auto_increment comment 'id',
    proc_def_id bigint(20) not null comment '定义ID',
    rev int comment '乐观锁',
    info_json_id bigint(20) comment 'json文件ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='数据信息';
DROP TABLE IF EXISTS wf_runtime_wfinst;
create table wf_runtime_wfinst (
   id bigint(20) not null auto_increment comment 'id',
    rev int default 1 comment '乐观锁',
    proc_def_id bigint(20) not null comment '定义ID',
    proc_inst_id bigint(20) not null comment '实例ID',
    execution_id bigint(20) not null comment '执行实例ID',
    wf_id bigint(20) not null comment 'wf_id',
    task_id bigint(20) comment '节点ID',
    call_proc_inst_id bigint(20) comment 'call_proc_inst_id',
    wf_name varchar(255) comment 'wf_name',
    wf_type varchar(255) not null comment 'wf_type',
    assignee varchar(255) comment '拥有着',
    start_time datetime not null comment '开始时间',
    end_time datetime comment '结束时间',
    duration numeric(19,0) comment 'duration',
    delete_reason varchar(4000) comment '删除原因',
    tenant_id varchar(255) default '' comment '租户ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运行实例';
DROP TABLE IF EXISTS wf_runtime_event_subscr;
create table wf_runtime_event_subscr (
  id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    event_type varchar(255) not null comment '事件类型',
    event_name varchar(255) comment '事件名称',
    execution_id bigint(20) comment '执行ID',
    proc_inst_id bigint(20) comment '实例ID',
    wfivity_id bigint(20) comment 'wfivity_id',
    configuration varchar(255) comment '配置',
    created timestamp(3) not null default current_timestamp(3) comment '创建事件',
    proc_def_id varchar(64) comment '定义ID',
    sub_scope_id varchar(64) comment 'sub_scope_id',
    scope_id varchar(64) comment 'scope_id',
    scope_definition_id varchar(64) comment 'scope_definition_id',
    scope_type varchar(64) comment 'scope_type',
    tenant_id varchar(255) default '' comment '租户ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运行时事件签署';
DROP TABLE IF EXISTS wf_runtime_variable;
create table wf_runtime_variable (
    id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    type varchar(255) not null comment '类型',
    name varchar(255) not null comment '名称',
    execution_id bigint(20) comment '执行实例ID',
    proc_inst_id bigint(20) comment '流程实例ID',
    task_id bigint(20) comment '任务ID',
    scope_id varchar(255) comment '定义表',
    sub_scope_id varchar(255) comment '定义表',
    scope_type varchar(255) comment '定义表',
    bytearray_id varchar(64) comment '资源文件ID',
    double_type double comment 'double',
    long_type bigint comment 'long',
    text varchar(4000) comment 'text',
    text2 varchar(4000) comment 'text2',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='流程参数';
DROP TABLE IF EXISTS wf_runtime_task;
create table wf_runtime_task (
     id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    execution_id bigint(20) comment '执行实例ID',
    proc_inst_id bigint(20) comment '流程实例ID',
    proc_def_id bigint(20) comment '流程定义ID',
    task_def_id bigint(20) comment '节点定义ID',
    scope_id varchar(255) comment 'scope_id',
    sub_scope_id varchar(255) comment 'sub_scope_id',
    scope_type varchar(255) comment 'scope_type',
    scope_definition_id varchar(255) comment 'scope_definition_id',
    name varchar(255) comment '节点定义名称 ',
    parent_task_id bigint(20) comment '父节点实例 ID',
    description varchar(4000) comment '节点定义描述 ',
    task_def_key varchar(255) comment '节点定义的 KEY',
    owner varchar(255) comment '实际签收人 ',
    assignee varchar(255) comment '签收人或委托人',
    delegation varchar(64) comment '委托类型 ',
    priority integer comment '优先级',
    create_time timestamp(3) null comment '创建时间',
    due_date datetime(3) comment '过期时间',
    category varchar(255) comment '类型',
    suspension_state integer comment '是否挂起',
    tenant_id varchar(255) default '' comment '租户ID',
    form_key varchar(255) comment '表单key',
    claim_time datetime(3) comment 'claim_time',
    is_count_enabled tinyint comment 'is_count_enabled',
    var_count integer comment 'var_count',
    id_link_count integer comment '连接数量',
    sub_task_count integer comment 'sub_task_count',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏时任务节点表 ';
DROP TABLE IF EXISTS wf_runtime_job;
create table wf_runtime_job (
    id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    type varchar(255) not null comment '类型',
    lock_exp_time timestamp(3) null comment '锁释放时间',
    lock_owner varchar(255) comment '挂起者 ',
    exclusive boolean comment '是否执行',
    execution_id bigint(20) comment '执行实例ID',
    process_instance_id bigint(20) comment '实例ID',
    proc_def_id bigint(20) comment '流程定义ID',
    element_id varchar(255) comment 'element_id',
    element_name varchar(255) comment 'element_name',
    scope_id varchar(255) comment 'scope_id',
    sub_scope_id varchar(255) comment 'sub_scope_id',
    scope_type varchar(255) comment 'scope_type',
    scope_definition_id varchar(255) comment 'scope_definition_id',
    retries integer comment 'retries',
    exception_stack_id varchar(64) comment 'exception_stack_id',
    exception_msg varchar(4000) comment 'exception_msg',
    duedate timestamp(3) null comment 'duedate',
    duplicate varchar(255) comment 'duplicate',
    handler_type varchar(255) comment 'handler_type',
    handler_cfg varchar(4000) comment 'handler_cfg',
    custom_values_id varchar(64) comment 'custom_values_id',
    create_time timestamp(3) null comment '创建时间',
    tenant_id varchar(255) default '' comment '租户ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏任务数据表';
DROP TABLE IF EXISTS wf_runtime_timer_job;
create table wf_runtime_timer_job (
   id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    type varchar(255) not null comment '类型',
    lock_exp_time timestamp(3) null comment '锁定释放时间',
    lock_owner varchar(255) comment '挂起者',
    exclusive boolean comment '是否执行',
    execution_id bigint(20) comment '执行实例ID',
    process_instance_id bigint(20) comment '实例ID',
    proc_def_id bigint(20) comment '定义ID',
    element_id varchar(255) comment 'element_id',
    element_name varchar(255) comment 'element_name',
    scope_id varchar(255) comment 'scope_id',
    sub_scope_id varchar(255) comment 'sub_scope_id',
    scope_type varchar(255) comment 'scope_type',
    scope_definition_id varchar(255) comment 'scope_definition_id',
    retries integer comment 'retries',
    exception_stack_id varchar(64) comment 'exception_stack_id',
    exception_msg varchar(4000) comment 'exception_msg',
    duedate timestamp(3) null comment 'duedate',
    duplicate varchar(255) comment 'duplicate',
    handler_type varchar(255) comment 'handler_type',
    handler_cfg varchar(4000) comment 'handler_cfg',
    custom_values_id varchar(64) comment 'custom_values_id',
    create_time timestamp(3) null comment '创建时间',
    tenant_id varchar(255) default '' comment '租户ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏时定时任务数据表';
DROP TABLE IF EXISTS wf_runtime_suspended_job;
create table wf_runtime_suspended_job (
    id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    type varchar(255) not null comment '类型',
    exclusive boolean comment '是否执行',
    execution_id bigint(20) comment '执行实例ID',
    process_instance_id bigint(20) comment '实例ID',
    proc_def_id bigint(20) comment '定义ID',
    element_id varchar(255) comment 'element_id',
    element_name varchar(255) comment 'element_name',
    scope_id varchar(255) comment 'scope_id',
    sub_scope_id varchar(255) comment 'sub_scope_id',
    scope_type varchar(255) comment 'scope_type',
    scope_definition_id varchar(255) comment 'scope_definition_id',
    retries integer comment 'retries',
    exception_stack_id varchar(64) comment 'exception_stack_id',
    exception_msg varchar(4000) comment 'exception_msg',
    duedate timestamp(3) null comment 'duedate',
    duplicate varchar(255) comment 'duplicate',
    handler_type varchar(255) comment 'handler_type',
    handler_cfg varchar(4000) comment 'handler_cfg',
    custom_values_id varchar(64) comment 'custom_values_id',
    create_time timestamp(3) null comment '创建时间',
    tenant_id varchar(255) default '' comment '租户ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏挂起任务数据表';
DROP TABLE IF EXISTS wf_runtime_deadletter_job;
create table wf_runtime_deadletter_job (
   id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    type varchar(255) not null comment '类型',
    lock_exp_time timestamp(3) null comment '锁释放时间',
    lock_owner varchar(255) comment '挂起者 ',
    exclusive boolean comment '是否执行',
    execution_id bigint(20) comment '执行实例ID',
    process_instance_id bigint(20) comment '实例ID',
    proc_def_id bigint(20) comment '流程定义ID',
    element_id varchar(255) comment 'element_id',
    element_name varchar(255) comment 'element_name',
    scope_id varchar(255) comment 'scope_id',
    sub_scope_id varchar(255) comment 'sub_scope_id',
    scope_type varchar(255) comment 'scope_type',
    scope_definition_id varchar(255) comment 'scope_definition_id',
    retries integer comment 'retries',
    exception_stack_id varchar(64) comment 'exception_stack_id',
    exception_msg varchar(4000) comment 'exception_msg',
    duedate timestamp(3) null comment 'duedate',
    duplicate varchar(255) comment 'duplicate',
    handler_type varchar(255) comment 'handler_type',
    handler_cfg varchar(4000) comment 'handler_cfg',
    custom_values_id varchar(64) comment 'custom_values_id',
    create_time timestamp(3) null comment '创建时间',
    tenant_id varchar(255) default '' comment '租户ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏无法执行任务表';
DROP TABLE IF EXISTS wf_runtime_history_job;
create table wf_runtime_history_job (
    id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    lock_exp_time timestamp(3) null comment '锁释放时间',
    lock_owner varchar(255) comment '挂起者',
    retries integer comment 'retries',
    exception_stack_id bigint(20) comment 'exception_stack_id',
    exception_msg varchar(4000) comment 'exception_msg',
    handler_type varchar(255) comment 'handler_type',
    handler_cfg varchar(4000) comment 'handler_cfg',
    custom_values_id varchar(64) comment 'custom_values_id',
    adv_handler_cfg_id varchar(64) comment 'adv_handler_cfg_id',
    create_time timestamp(3) null comment '创建时间',
    scope_type varchar(255) comment 'scope_type',
    tenant_id varchar(255) default ''comment '租户ID',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏时历史执行任务表';
DROP TABLE IF EXISTS wf_runtime_identitylink;
create table wf_runtime_identitylink (
   id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    group_id varchar(255) comment '组ID',
    type varchar(255) comment '类型',
    user_id varchar(255) comment '用户id',
    task_id bigint(20) comment '节点实例 ID  ',
    proc_inst_id bigint(20) comment '流程实例ID',
    proc_def_id bigint(20) comment '定义ID',
    scope_id varchar(255) comment 'scope_id',
    scope_type varchar(255) comment 'scope_type',
    scope_definition_id varchar(255) comment 'scope_definition_id',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运⾏时流程⼈员';



DROP TABLE IF EXISTS wf_ge_property;
create table wf_ge_property (
    name varchar(64) comment '名称',
    value varchar(300) comment '值',
    rev integer comment '乐观锁',
    primary key (name)
) engine=innodb default charset=utf8mb4 comment='属性数据表';
DROP TABLE IF EXISTS wf_ge_bytearray;
create table wf_ge_bytearray (
   id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    name varchar(255) comment '名称',
    deployment_id bigint(20) comment '部署ID',
    bytes longblob comment '二进制数据',
    prototype tinyint comment '是否是引擎生成',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='资源数据表';


DROP TABLE IF EXISTS wf_runtime_entitylink;
create table wf_runtime_entitylink (
    id bigint(20) not null auto_increment comment 'id',
    rev integer comment '乐观锁',
    create_time datetime(3) comment '创建时间',
    link_type varchar(255) comment '连接类型',
    scope_id varchar(255) comment 'scope_id',
    scope_type varchar(255) comment 'scope_type',
    scope_definition_id varchar(255) comment 'scope_definition_id',
    ref_scope_id varchar(255) comment 'ref_scope_id',
    ref_scope_type varchar(255) comment 'ref_scope_type',
    ref_scope_definition_id varchar(255) comment 'ref_scope_definition_id',
    hierarchy_type varchar(255) comment 'hierarchy_type',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='运行时连接';

create index wf_idx_ent_lnk_scope on wf_runtime_entitylink(scope_id, scope_type, link_type);
create index wf_idx_ent_lnk_scope_def on wf_runtime_entitylink(scope_definition_id, scope_type, link_type);
insert into wf_ge_property values ('identitylink.schema.version', '6.5.0.2', 1);
insert into wf_ge_property values ('entitylink.schema.version', '6.5.0.2', 1);
insert into wf_ge_property
values ('common.schema.version', '6.5.0.2', 1);

insert into wf_ge_property
values ('next.dbid', '1', 1);
create index wf_idx_job_exception_stack_id on wf_runtime_job(exception_stack_id);
create index wf_idx_job_custom_values_id on wf_runtime_job(custom_values_id);
create index wf_idx_ident_lnk_user on wf_runtime_identitylink(user_id);
create index wf_idx_ident_lnk_group on wf_runtime_identitylink(group_id);
create index wf_idx_ident_lnk_scope on wf_runtime_identitylink(scope_id, scope_type);
create index wf_idx_ident_lnk_scope_def on wf_runtime_identitylink(scope_definition_id, scope_type);

create index wf_idx_timer_job_exception_stack_id on wf_runtime_timer_job(exception_stack_id);
create index wf_idx_timer_job_custom_values_id on wf_runtime_timer_job(custom_values_id);

create index wf_idx_suspended_job_exception_stack_id on wf_runtime_suspended_job(exception_stack_id);
create index wf_idx_suspended_job_custom_values_id on wf_runtime_suspended_job(custom_values_id);

create index wf_idx_deadletter_job_exception_stack_id on wf_runtime_deadletter_job(exception_stack_id);
create index wf_idx_deadletter_job_custom_values_id on wf_runtime_deadletter_job(custom_values_id);

create index wf_idx_job_scope on wf_runtime_job(scope_id, scope_type);
create index wf_idx_job_sub_scope on wf_runtime_job(sub_scope_id, scope_type);
create index wf_idx_job_scope_def on wf_runtime_job(scope_definition_id, scope_type);

create index wf_idx_tjob_scope on wf_runtime_timer_job(scope_id, scope_type);
create index wf_idx_tjob_sub_scope on wf_runtime_timer_job(sub_scope_id, scope_type);
create index wf_idx_tjob_scope_def on wf_runtime_timer_job(scope_definition_id, scope_type);

create index wf_idx_sjob_scope on wf_runtime_suspended_job(scope_id, scope_type);
create index wf_idx_sjob_sub_scope on wf_runtime_suspended_job(sub_scope_id, scope_type);
create index wf_idx_sjob_scope_def on wf_runtime_suspended_job(scope_definition_id, scope_type);

create index wf_idx_djob_scope on wf_runtime_deadletter_job(scope_id, scope_type);
create index wf_idx_djob_sub_scope on wf_runtime_deadletter_job(sub_scope_id, scope_type);
create index wf_idx_djob_scope_def on wf_runtime_deadletter_job(scope_definition_id, scope_type);

insert into wf_ge_property values ('job.schema.version', '6.5.0.2', 1);

create index wf_idx_task_create on wf_runtime_task(create_time);
create index wf_idx_task_scope on wf_runtime_task(scope_id, scope_type);
create index wf_idx_task_sub_scope on wf_runtime_task(sub_scope_id, scope_type);
create index wf_idx_task_scope_def on wf_runtime_task(scope_definition_id, scope_type);

create index wf_idx_runtime_var_scope_id_type on wf_runtime_variable(scope_id, scope_type);
create index wf_idx_runtime_var_sub_id_type on wf_runtime_variable(sub_scope_id, scope_type);
create index wf_idx_event_subscr_config_ on wf_runtime_event_subscr(configuration);
create index wf_idx_exec_buskey on wf_runtime_execution(business_key);
create index wf_idx_exec_root on wf_runtime_execution(root_proc_inst_id);
create index wf_idx_variable_task_id on wf_runtime_variable(task_id);
create index wf_idx_athrz_procedef on wf_runtime_identitylink(proc_def_id);
create index wf_idx_execution_proc on wf_runtime_execution(proc_def_id);
create index wf_idx_execution_parent on wf_runtime_execution(parent_id);
create index wf_idx_execution_super on wf_runtime_execution(super_exec);
create index wf_idx_execution_idandrev on wf_runtime_execution(id, rev);
create index wf_idx_variable_exec on wf_runtime_variable(execution_id);
create index wf_idx_variable_procinst on wf_runtime_variable(proc_inst_id);
create index wf_idx_ident_lnk_task on wf_runtime_identitylink(task_id);
create index wf_idx_ident_lnk_procinst on wf_runtime_identitylink(proc_inst_id);
create index wf_idx_task_exec on wf_runtime_task(execution_id);
create index wf_idx_task_procinst on wf_runtime_task(proc_inst_id);
create index wf_idx_exec_proc_inst_id on wf_runtime_execution(proc_inst_id);
create index wf_idx_task_proc_def_id on wf_runtime_task(proc_def_id);
create index wf_idx_job_execution_id on wf_runtime_job(execution_id);
create index wf_idx_job_process_instance_id on wf_runtime_job(process_instance_id);
create index wf_idx_job_proc_def_id on wf_runtime_job(proc_def_id);
create index wf_idx_timer_job_execution_id on wf_runtime_timer_job(execution_id);
create index wf_idx_timer_job_process_instance_id on wf_runtime_timer_job(process_instance_id);
create index wf_idx_timer_job_proc_def_id on wf_runtime_timer_job(proc_def_id);
create index wf_idx_suspended_job_execution_id on wf_runtime_suspended_job(execution_id);
create index wf_idx_suspended_job_process_instance_id on wf_runtime_suspended_job(process_instance_id);
create index wf_idx_suspended_job_proc_def_id on wf_runtime_suspended_job(proc_def_id);
create index wf_idx_deadletter_job_execution_id on wf_runtime_deadletter_job(execution_id);
create index wf_idx_deadletter_job_process_instance_id on wf_runtime_deadletter_job(process_instance_id);
create index wf_idx_deadletter_job_proc_def_id on wf_runtime_deadletter_job(proc_def_id);
create index wf_idx_info_procdef on wf_procdef_info(proc_def_id);

create index wf_idx_runtime_wfi_start on wf_runtime_wfinst(start_time);
create index wf_idx_runtime_wfi_end on wf_runtime_wfinst(end_time);
create index wf_idx_runtime_wfi_proc on wf_runtime_wfinst(proc_inst_id);
create index wf_idx_runtime_wfi_proc_wf on wf_runtime_wfinst(proc_inst_id, wf_id);
create index wf_idx_runtime_wfi_exec on wf_runtime_wfinst(execution_id);
create index wf_idx_runtime_wfi_exec_wf on wf_runtime_wfinst(execution_id, wf_id);
insert into wf_ge_property
values ('schema.version', '6.5.0.2', 1);

insert into wf_ge_property
values ('schema.history', 'create(6.5.0.2)', 1);
