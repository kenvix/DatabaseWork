//--------------------------------------------------
// Class Alias
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------
@file:Suppress("unused", "MemberVisibilityCanBePrivate")
package com.kenvix.bookmgr.contacts.generic

object QuestionType {
    const val Unknown = 0
    const val Extended = 1 shl 31 // 附加题
    const val SingleSelection = 1 shl 1 // 单选
    const val MultipleSelection = 1 shl 2 // 多选
    const val TrueOrFalse = 1 shl 3 or SingleSelection // 判断
    const val FillBlank = 1 shl 4 // 填空
    const val Text = 1 shl 5 // 简答题
}

object ExamStatus {
    const val DraftOrHidden         = 0 shl 1
    const val ExamPublished         = 1 shl 1
    const val AnswerPublished       = 1 shl 2
    const val AnswerHidden          = 0 shl 2

    const val Examinable            = 1 shl 5
    const val Finished              = 0 shl 5
}

object StudentExamFlag {
    /** 已参加考试 **/
    const val Joined: Int           = 1 shl 0
    const val NotJoined: Int        = 0 shl 0

    /** 已交卷 **/
    const val Submitted: Int        = 1 shl 1
    const val NotSubmitted: Int     = 0 shl 1

    /** 已认定作弊 **/
    const val Cheated: Int          = 1 shl 2
    const val NotCheated: Int       = 0 shl 2

    /** 成绩被无效化 **/
    const val GradeRevoked: Int     = 1 shl 3
    const val GradeNotRevoked: Int  = 0 shl 3

    /** 已判卷 **/
    const val GradesGiven: Int      = 1 shl 4
    const val GradesNotGiven: Int   = 0 shl 4

    /** 强制不允许参加考试 **/
    const val PermissionRevoked: Int    = 1 shl 5
    const val PermissionNotRevoked: Int = 0 shl 5
}

object Role {
    const val Unknown: Short = 0
    const val Visitor: Short = 1
    const val Banned: Short = 2
    const val User: Short = 4
    const val Admin: Short = 8196
}

object Sex {
    const val Unknown: Byte = 0
    const val Male: Byte = 1
    const val Female: Byte = 2
    const val Other: Byte = 3
}