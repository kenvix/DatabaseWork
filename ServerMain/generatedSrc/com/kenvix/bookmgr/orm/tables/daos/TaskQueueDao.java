/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.daos;


import com.kenvix.bookmgr.orm.tables.TaskQueue;
import com.kenvix.bookmgr.orm.tables.records.TaskQueueRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.JSON;
import org.jooq.impl.DAOImpl;


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
public class TaskQueueDao extends DAOImpl<TaskQueueRecord, com.kenvix.bookmgr.orm.tables.pojos.TaskQueue, Long> {

    /**
     * Create a new TaskQueueDao without any configuration
     */
    public TaskQueueDao() {
        super(TaskQueue.TASK_QUEUE, com.kenvix.bookmgr.orm.tables.pojos.TaskQueue.class);
    }

    /**
     * Create a new TaskQueueDao with an attached configuration
     */
    public TaskQueueDao(Configuration configuration) {
        super(TaskQueue.TASK_QUEUE, com.kenvix.bookmgr.orm.tables.pojos.TaskQueue.class, configuration);
    }

    @Override
    public Long getId(com.kenvix.bookmgr.orm.tables.pojos.TaskQueue object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchById(Long... values) {
        return fetch(TaskQueue.TASK_QUEUE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.TaskQueue fetchOneById(Long value) {
        return fetchOne(TaskQueue.TASK_QUEUE.ID, value);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfCreatedAt(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByCreatedAt(Timestamp... values) {
        return fetch(TaskQueue.TASK_QUEUE.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>finished_at BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfFinishedAt(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.FINISHED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>finished_at IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByFinishedAt(Timestamp... values) {
        return fetch(TaskQueue.TASK_QUEUE.FINISHED_AT, values);
    }

    /**
     * Fetch records that have <code>is_finished BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfIsFinished(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.IS_FINISHED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_finished IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByIsFinished(Boolean... values) {
        return fetch(TaskQueue.TASK_QUEUE.IS_FINISHED, values);
    }

    /**
     * Fetch records that have <code>is_success BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfIsSuccess(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.IS_SUCCESS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_success IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByIsSuccess(Boolean... values) {
        return fetch(TaskQueue.TASK_QUEUE.IS_SUCCESS, values);
    }

    /**
     * Fetch records that have <code>is_doing BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfIsDoing(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.IS_DOING, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_doing IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByIsDoing(Boolean... values) {
        return fetch(TaskQueue.TASK_QUEUE.IS_DOING, values);
    }

    /**
     * Fetch records that have <code>type BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfType(Short lowerInclusive, Short upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByType(Short... values) {
        return fetch(TaskQueue.TASK_QUEUE.TYPE, values);
    }

    /**
     * Fetch records that have <code>content BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfContent(JSON lowerInclusive, JSON upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.CONTENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByContent(JSON... values) {
        return fetch(TaskQueue.TASK_QUEUE.CONTENT, values);
    }

    /**
     * Fetch records that have <code>result BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchRangeOfResult(JSON lowerInclusive, JSON upperInclusive) {
        return fetchRange(TaskQueue.TASK_QUEUE.RESULT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>result IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.TaskQueue> fetchByResult(JSON... values) {
        return fetch(TaskQueue.TASK_QUEUE.RESULT, values);
    }
}
