/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.TaskQueue;
import com.kenvix.bookmgr.orm.tables.interfaces.ITaskQueue;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.JSON;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 任务队列（程序可读）
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TaskQueueRecord extends UpdatableRecordImpl<TaskQueueRecord> implements Record9<Long, Timestamp, Timestamp, Boolean, Boolean, Boolean, Short, JSON, JSON>, ITaskQueue {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>task_queue.id</code>.
     */
    @Override
    public TaskQueueRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>task_queue.created_at</code>.
     */
    @Override
    public TaskQueueRecord setCreatedAt(Timestamp value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.created_at</code>.
     */
    @Override
    public Timestamp getCreatedAt() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>task_queue.finished_at</code>.
     */
    @Override
    public TaskQueueRecord setFinishedAt(Timestamp value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.finished_at</code>.
     */
    @Override
    public Timestamp getFinishedAt() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>task_queue.is_finished</code>.
     */
    @Override
    public TaskQueueRecord setIsFinished(Boolean value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.is_finished</code>.
     */
    @Override
    public Boolean getIsFinished() {
        return (Boolean) get(3);
    }

    /**
     * Setter for <code>task_queue.is_success</code>.
     */
    @Override
    public TaskQueueRecord setIsSuccess(Boolean value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.is_success</code>.
     */
    @Override
    public Boolean getIsSuccess() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>task_queue.is_doing</code>.
     */
    @Override
    public TaskQueueRecord setIsDoing(Boolean value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.is_doing</code>.
     */
    @Override
    public Boolean getIsDoing() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>task_queue.type</code>.
     */
    @Override
    public TaskQueueRecord setType(Short value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.type</code>.
     */
    @Override
    public Short getType() {
        return (Short) get(6);
    }

    /**
     * Setter for <code>task_queue.content</code>. 任务正文（程序可读）
     */
    @Override
    public TaskQueueRecord setContent(JSON value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.content</code>. 任务正文（程序可读）
     */
    @Override
    public JSON getContent() {
        return (JSON) get(7);
    }

    /**
     * Setter for <code>task_queue.result</code>. 任务结果（程序可读）
     */
    @Override
    public TaskQueueRecord setResult(JSON value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>task_queue.result</code>. 任务结果（程序可读）
     */
    @Override
    public JSON getResult() {
        return (JSON) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, Timestamp, Timestamp, Boolean, Boolean, Boolean, Short, JSON, JSON> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, Timestamp, Timestamp, Boolean, Boolean, Boolean, Short, JSON, JSON> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TaskQueue.TASK_QUEUE.ID;
    }

    @Override
    public Field<Timestamp> field2() {
        return TaskQueue.TASK_QUEUE.CREATED_AT;
    }

    @Override
    public Field<Timestamp> field3() {
        return TaskQueue.TASK_QUEUE.FINISHED_AT;
    }

    @Override
    public Field<Boolean> field4() {
        return TaskQueue.TASK_QUEUE.IS_FINISHED;
    }

    @Override
    public Field<Boolean> field5() {
        return TaskQueue.TASK_QUEUE.IS_SUCCESS;
    }

    @Override
    public Field<Boolean> field6() {
        return TaskQueue.TASK_QUEUE.IS_DOING;
    }

    @Override
    public Field<Short> field7() {
        return TaskQueue.TASK_QUEUE.TYPE;
    }

    @Override
    public Field<JSON> field8() {
        return TaskQueue.TASK_QUEUE.CONTENT;
    }

    @Override
    public Field<JSON> field9() {
        return TaskQueue.TASK_QUEUE.RESULT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Timestamp component2() {
        return getCreatedAt();
    }

    @Override
    public Timestamp component3() {
        return getFinishedAt();
    }

    @Override
    public Boolean component4() {
        return getIsFinished();
    }

    @Override
    public Boolean component5() {
        return getIsSuccess();
    }

    @Override
    public Boolean component6() {
        return getIsDoing();
    }

    @Override
    public Short component7() {
        return getType();
    }

    @Override
    public JSON component8() {
        return getContent();
    }

    @Override
    public JSON component9() {
        return getResult();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Timestamp value2() {
        return getCreatedAt();
    }

    @Override
    public Timestamp value3() {
        return getFinishedAt();
    }

    @Override
    public Boolean value4() {
        return getIsFinished();
    }

    @Override
    public Boolean value5() {
        return getIsSuccess();
    }

    @Override
    public Boolean value6() {
        return getIsDoing();
    }

    @Override
    public Short value7() {
        return getType();
    }

    @Override
    public JSON value8() {
        return getContent();
    }

    @Override
    public JSON value9() {
        return getResult();
    }

    @Override
    public TaskQueueRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public TaskQueueRecord value2(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public TaskQueueRecord value3(Timestamp value) {
        setFinishedAt(value);
        return this;
    }

    @Override
    public TaskQueueRecord value4(Boolean value) {
        setIsFinished(value);
        return this;
    }

    @Override
    public TaskQueueRecord value5(Boolean value) {
        setIsSuccess(value);
        return this;
    }

    @Override
    public TaskQueueRecord value6(Boolean value) {
        setIsDoing(value);
        return this;
    }

    @Override
    public TaskQueueRecord value7(Short value) {
        setType(value);
        return this;
    }

    @Override
    public TaskQueueRecord value8(JSON value) {
        setContent(value);
        return this;
    }

    @Override
    public TaskQueueRecord value9(JSON value) {
        setResult(value);
        return this;
    }

    @Override
    public TaskQueueRecord values(Long value1, Timestamp value2, Timestamp value3, Boolean value4, Boolean value5, Boolean value6, Short value7, JSON value8, JSON value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITaskQueue from) {
        setId(from.getId());
        setCreatedAt(from.getCreatedAt());
        setFinishedAt(from.getFinishedAt());
        setIsFinished(from.getIsFinished());
        setIsSuccess(from.getIsSuccess());
        setIsDoing(from.getIsDoing());
        setType(from.getType());
        setContent(from.getContent());
        setResult(from.getResult());
    }

    @Override
    public <E extends ITaskQueue> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TaskQueueRecord
     */
    public TaskQueueRecord() {
        super(TaskQueue.TASK_QUEUE);
    }

    /**
     * Create a detached, initialised TaskQueueRecord
     */
    public TaskQueueRecord(Long id, Timestamp createdAt, Timestamp finishedAt, Boolean isFinished, Boolean isSuccess, Boolean isDoing, Short type, JSON content, JSON result) {
        super(TaskQueue.TASK_QUEUE);

        setId(id);
        setCreatedAt(createdAt);
        setFinishedAt(finishedAt);
        setIsFinished(isFinished);
        setIsSuccess(isSuccess);
        setIsDoing(isDoing);
        setType(type);
        setContent(content);
        setResult(result);
    }
}
